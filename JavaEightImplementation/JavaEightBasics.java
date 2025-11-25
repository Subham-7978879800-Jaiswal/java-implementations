
// IDEA -> Interface with Default and Abstract method
@FunctionalInterface
interface A {
    default void getMoney() {
        System.out.println("A Get Money");
    }

    void a();
}

// IDEA -> Interface with Default and Abstract method
@FunctionalInterface
interface B {
    default void getMoney() {
        System.out.println("B Get Money");
    }

    void a();
}

class JavaEightBasics implements A, B {

    // IDEA -> Abstract method implementation
    public void a() {
        System.out.println("JavaEightBasics");
    }

    // IDEA -> Resolving Diamond Problem Ambiguity
    public void getMoney() {
        A.super.getMoney();
    }

    public static void main(String[] args) {
        JavaEightBasics j = new JavaEightBasics();
        j.getMoney();

        // IDEA -> Lambda method Implementations
        B b = () -> {
            System.out.println("JavaEightBasics");
        };
        b.a();
    }
}
