package Exceptions;

public class RuntimeExceptionsExample {
    public static void main(String[] args) {
                try {
            System.out.println(arithmeticExceptionExample(5, 0));
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
            System.out.println("Тестовое сообщение");
        }
        int[] c = {1, 2, 3, 4, 5};
        System.out.println(getElementByIndex(c, 10));
    }
    public static int getElementByIndex(int[] c,int i) {

        return c[i];
    }

    public static double arithmeticExceptionExample(int a, int b) {

        return a / b;
    }

}
