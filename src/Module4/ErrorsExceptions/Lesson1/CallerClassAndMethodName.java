package Module4.ErrorsExceptions.Lesson1;

public class CallerClassAndMethodName {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        Exception callerGetter;
        callerGetter = new Exception();
        System.out.println(callerGetter.getStackTrace()[1]);
        return "";
    }
}
