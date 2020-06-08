package Exceptions;

public class StringIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        try {
            char a = getByIndex(12);
        } catch (StringIndexOutOfBoundsException exception) {
            exception.printStackTrace();
        }
    }
        public static char getByIndex(int index) throws StringIndexOutOfBoundsException {
            return "Бармаглот".charAt(index) ;
        }
    }
