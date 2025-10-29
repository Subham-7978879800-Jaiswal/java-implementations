
class Printer {
        void print() {
                System.out.println("THREAD");
        }

        Printer() {
                System.out.println("Constructor THREAD");
        }

        static void printX() {
                System.out.println("THREAD Static");
        }
}

public class MethodReferencing {

        public static void main() {

                Thread t = new Thread(() -> {
                        System.out.println("THREAD");
                });

                Thread t11 = new Thread(Printer::new);
                Thread t12 = new Thread(Printer::new);
                Thread t13 = new Thread(Printer::printX);

                t.start();

                t11.start();

                t12.start();

                t13.start();

        }

}
