package W3A2Q2;

public class Logger {
    private static Logger instance = null;

    // Private constructor to prevent direct instantiation
    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private String data = "Singleton Data";

    public void log(String message) {
        data = message;
        System.out.println("Log: " + data);
    }
}