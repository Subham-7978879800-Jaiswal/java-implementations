package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListExample {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> k = new ArrayList<>();
        k.add(1);
        k.add(2);
        k.add(6); // IDEA Creating Elements

        System.out.println(k); // TODO -> List -> [1,2,6]

        System.out.println(k.get(1)); // TODO -> 2

        System.out.println(k); // TODO -> List -> [1,2,6]

        k.set(2, 60); // IDEA Update Elements

        System.out.println(k); // TODO -> List -> [1,2,60]

        k.remove(1); // IDEA Removes via a Index
        System.out.println(k);// TODO -> List -> [1,60]
        k.remove(Integer.valueOf(60)); // IDEA Removes via a Value

        System.out.println(k);// TODO -> List -> [1]

        System.out.println(k.contains(1)); // TODO -> true

        // NOT THREAD SAFE
        ArrayList<Integer> nthsf = new ArrayList<>();
        nthsf.addAll(k); // IDEA Bulk Addition
        System.out.println(nthsf); // TODO -> List -> [1]

        // IDEA -> ArrayList is not thread safe and when two threads try to add elements
        // IDEA -> few of the operation will fail
        // IDEA -> Hence size less than 2000
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                nthsf.add(i);
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; ++i) {
                nthsf.add(i);
            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(nthsf.size()); // TODO -> NOT 2000

        // Iterating

        k.add(1);
        k.add(2);
        k.add(6);

        // IDEA ITERATION
        for (int i = 0; i < k.size(); ++i) {
            System.out.println(k.get(i));
        }

        System.out.println();
        System.out.println();

        for (int element : k) {
            System.out.println(element);
        }

        System.out.println();
        System.out.println();

        Iterator<Integer> itr = k.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println();
        System.out.println();

        k.forEach(re -> System.out.println(re));

        // IDEA Opposite side Iteration by virtue of listIterator(k.size()) the pointer
        // is now at end
        ListIterator<Integer> lis = k.listIterator(k.size());
        while (lis.hasPrevious()) {
            System.out.println(lis.previous());
        }

        System.out.println();
        System.out.println();

        // IDEA -> sort by natural order
        k.sort(null);

        // IDEA -> Can be sorted by giving a comparator
        k.sort((a,b) -> b-a);



        // Array to ArrayList
        // ArrayList to Array
        // List.of

        Integer arr[] = { 1, 8, 9, 0 }; // IDEA -> ARRAY

        List<Integer> arrayToList = Arrays.asList(arr); // IDEA -> ARRAY to LIST -> Modifiable Fixed size -> SET is allowed -> ADD REMOVE -> not allowed
        Integer arrConverted[] = arrayToList.toArray(new Integer[0]);// IDEA -> ARRAYLIST to ARRAY

        List<Integer> lof = List.of(1, 2, 4, 6);// IDEA -> LIST  -> UnModifiable Fixed size -> SET ADD REMOVE -> not allowed
    }

}
