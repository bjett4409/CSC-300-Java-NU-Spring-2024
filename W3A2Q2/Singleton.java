package W3A2Q2;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        this.data = "Singleton Data";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    private String data;

    public void showData() {
        System.out.println(data);
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        singleton1.showData();

        System.out.println(singleton1);
    }
}