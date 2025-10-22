package Collections;

import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class VectorAndCopyOnWriteArrayList {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> v = new Vector<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                v.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                v.add(i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(v.size()); // -> TODO - 2000
        // IDEA -> So as we get 2000 here that means Vector is synchronized and all
        // multi thread operation were successful

        CopyOnWriteArrayList<Integer> cpr = new CopyOnWriteArrayList<>();

        Thread t11 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                cpr.add(i);
            }
        });

        Thread t21 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                cpr.add(i);
            }
        });

        t11.start();
        t21.start();

        t11.join();
        t21.join();

        System.out.println(cpr.size()); // TODO -> 2000
        // IDEA -> CopyOnWriteArrayList also thread safe

        // IDEA -> Concurrent Modification

        CopyOnWriteArrayList<String> cprS = new CopyOnWriteArrayList<>();

        cprS.add("Mango");
        cprS.add("Banana");
        cprS.add("Apple");
        cprS.add("Tamarind");

        for (String s : cprS) {
            if (s.equals("Apple")) {
                cprS.add("Grapes");
            }
            System.out.println(s); // TODO -> Mango || Banana || Apple || Tamarind
        }
        System.out.println(cprS); // TODO -> [Mango, Banana, Apple, Tamarind, Grapes]
        // IDEA -> CopyOnWrite Array List can handle concurrent modification but had it been arrayList it would have failed with concurrent modifcation error
    }
}
