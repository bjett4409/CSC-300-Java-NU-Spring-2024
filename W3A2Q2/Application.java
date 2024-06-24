package W3A2Q2;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Application has started");

        logger.log("Operation 1 is completed");

        logger.log("Operation 2 has encountered an error");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("Application has now ended");

        System.out.println(logger == anotherLogger); // Output: true
    }
}