



public class Main {



    static class MyArraySizeException extends Exception {
        public MyArraySizeException(){
            super("Ошибка размера массива");
        }
    }
    static class MyArrayDataException extends Exception {
        public MyArrayDataException(int i, int j){
            super("Ошибка данных в ячейке "+i+" "+j);
        }
    }

   /////////////////////////////////////////////////////////////////

    public static void checkArraySize(String[][] array) throws MyArraySizeException {

        boolean result = false;
        if (array.length != 4) {
            result = true;
        }
        for (String[] i : array) {
            if (i.length != 4) {
                result = true;
            }
        }
        if (result) {
            throw new MyArraySizeException();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////
    public static void arraySumm(String[][] array) throws MyArrayDataException {

        int res = 0;
        Integer value;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                try {
                    value = Integer.parseInt(array[i][j]);
                }
                catch (Exception e) {
                    System.out.println("Неконвертируемое значение - "+"\""+array[i][j]+"\" в ячейке : "+i+" "+j);
                    throw new MyArrayDataException(i,j);
                }
                res+=value;
            }
        }
        System.out.println("Сумма элементов массива = "+res);
    }

    ////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        String[][] good_array = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        String[][] good_array1 = {{"1","s","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};
        String[][] bad_array = {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16","17"}};

        try {
            checkArraySize(good_array);
        }
        catch (MyArraySizeException e) {
            System.out.println(e);
        }

        try {
            checkArraySize(bad_array);
        }
        catch (MyArraySizeException e) {
            System.out.println(e);

        }

        try {
            arraySumm(good_array);
        }
        catch (MyArrayDataException e) {
            System.out.println(e);

        }

        try {
            arraySumm(good_array1);
        }
        catch (MyArrayDataException e) {
            System.out.println(e);

        }

    }
}


