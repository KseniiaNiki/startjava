public class StaticMethod {
    public static String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 1) {
            return stackTrace[2].getMethodName();
        }
        return null;
    }
}