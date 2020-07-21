package test;

public class Main {

    private final static int SIZE = 4;

    public static void main(String[] args) {
        System.out.println("Запуск программы...");

        String[][] ArrayOne = {
                {"10", "2", "3", "4"},
                {"-1", "21", "-31", "4"},
                {"1", "200", "5", "40"},
                {"1", "22", "-35", "4"}};

        String[][] ArrayTwo = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};


        try {
            System.out.println("Сумма массива 1: " + ArraySummary(ArrayOne));
        } catch (ArrayOutSize | StringNotInt e) {
            System.out.println(e);
        }

        try {
            System.out.println("Сумма массива 2: " + ArraySummary(ArrayTwo));
        } catch (ArrayOutSize | StringNotInt e) {
            System.out.println(e);
        }

        System.out.println("... конец программы");

    }

    public static int ArraySummary(String[][] arr) throws ArrayOutSize, StringNotInt {
        int res = 0;

        if (arr.length != SIZE) {
            throw new ArrayOutSize();
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new ArrayOutSize();
            }

            for (int j=0; j<arr[i].length; j++) {
                try {
                    res += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new StringNotInt(i, j, arr[i][j], ex);
                }
            }
        }

        return res;
    }

}
