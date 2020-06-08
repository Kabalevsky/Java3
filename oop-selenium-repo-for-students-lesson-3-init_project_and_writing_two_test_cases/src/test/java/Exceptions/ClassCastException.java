package Exceptions;
// Ошибка приведения типов
public class ClassCastException {
    public static void main(String[] args) {
        Object object = 1;
        System.out.println((String) object);
        Object o = null;
        System.out.println(o.hashCode());
   }
}
