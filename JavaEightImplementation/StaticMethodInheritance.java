// IDEA -> Methods are not overriden,instead they are hidden from child
// IDEA -> Static methods like data members doesnt have polymorphic behaviour -> Depends on reference instead of object

class A177 {
    static void test() {
        System.out.println("HELLO from static A177");
    }

    void xyz() {
        System.out.println("HELLO from xyz A177");
    }
}

class B1777 extends A177 {
    static void test() {
        System.out.println("HELLO from static B177");
    }

    void xyz() {
        System.out.println("HELLO from xyz B177");
    }
}

public class StaticMethodInheritance {
    public static void main(String[] args) {
        B1777.test(); // HELLO from static B177
        A177 a = new A177();
        B1777 b = new B1777();
        A177 a1 = new B1777();
        a.test();   // IDEA -> HELLO from static A177
        b.test();   // IDEA -> HELLO from static B177
        a1.test();  // IDEA -> HELLO from static A177 // Static methods are non polymorphic
        a.xyz();    // IDEA -> HELLO from xyz A177
        b.xyz();    // IDEA -> HELLO from xyz B177
        a1.xyz();   // IDEA -> HELLO from xyz B177 // normal methods are  polymorphic

    }
}
