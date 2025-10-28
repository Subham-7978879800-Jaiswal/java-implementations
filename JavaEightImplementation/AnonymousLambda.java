
@FunctionalInterface
interface Aa {
    void show();
}

interface Bb {
    void run();

    void sleep();
}

public class AnonymousLambda {

    int b = 10;

    void impl() {

        int x = 10;
        // x = 5; // IDEA -> Effective final error will come same for both lambda and
        // Anonymous
        // but not for modifiable collection because there we are not changing
        // references

        // IDEA -> Only Functional Interface can be replaced by Lambda
        Aa aa = () -> {
            System.out.println("AA SHOW");
            System.out.println(this.b); // IDEA -> Here this keyword points to new AnonymousLambda() because method is
                                        // called by that only
            System.out.println(x); // IDEA -> If lambda or even anonymous inner class uses something from outer
                                   // scope it should be effective final
            // IDEA -> for modifiable collection it is ok because we are not changing
            // references
        };
        Bb bb = new Bb() {
            int x = 10;

            public void run() {
                System.out.println("RUN");
                System.out.println(this.x); // HERE this points to inner class itself
            }

            public void sleep() {
                System.out.println("SLEEP");
            }
        };
        aa.show();
        bb.run();
        bb.sleep();

    }

    public static void main(String[] args) {
        new AnonymousLambda().impl();
    }

}
