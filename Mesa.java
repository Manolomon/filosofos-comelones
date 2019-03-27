// Hilo Principal de la Aplicación

public class Mesa {

    static Object tenedor1 = new Object();
    static Object tenedor2 = new Object();
    static Object tenedor3 = new Object();
    static Object tenedor4 = new Object();
    static Object tenedor5 = new Object();
    

    public static void main(String[] args) {
        // Crear los objetos
        Filosofo f1 = new Filosofo("1 -- Platón", tenedor1, tenedor2, 1);
        Filosofo f2 = new Filosofo("2 -- Descartes", tenedor2, tenedor3, 1);
        Filosofo f3 = new Filosofo("3 -- Rousseau", tenedor3, tenedor4, 1);
        Filosofo f4 = new Filosofo("4 -- Bertrand Russell", tenedor4, tenedor5, 1);
        Filosofo f5 = new Filosofo("5 -- Nietzsche", tenedor5, tenedor1, 2);
        // Crear los objetos Thread
        Thread hilo1 = new Thread(f1);
        Thread hilo2 = new Thread(f2);
        Thread hilo3 = new Thread(f3);
        Thread hilo4 = new Thread(f4);
        Thread hilo5 = new Thread(f5);
        // Iniciar los Hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}