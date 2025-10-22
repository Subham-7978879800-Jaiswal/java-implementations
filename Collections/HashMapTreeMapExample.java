package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTreeMapExample {
    public static void main(String[] args) {

        HashMap<Integer, String> h1 = new HashMap<Integer, String>();

        h1.put(1, "Subham"); // TODO -> CREATE
        h1.put(2, "Jaiswal");

        System.out.println(h1.containsKey(1)); // TODO -> true
        System.out.println(h1.containsKey(2)); // TODO -> true

        System.out.println(h1.containsValue("Raj")); // TODO -> false
        System.out.println(h1.containsValue("Sita")); // TODO -> false

        System.out.println(h1.get(1)); // TODO -> Subham -> READ
        System.out.println(h1.put(1, "Agarwal")); // TODO -> Previous Value -> Subham -> UPDATE
        System.out.println(h1.get(1)); // TODO -> Agarwal'

        for (Map.Entry<Integer, String> m : h1.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

        // IDEA -> For using Custom object as key we need to overwrite hashcode and
        // IDEA ->equals method in a hashmap
        // IDEA -> Hashcode so that hash generate will be same and bucket index of same
        // IDEA -> key will be same
        // IDEA -> equals so when in the Linked list keys are compared, they are
        // compared on this paramenter
        HashMap<StudentC, String> hs1 = new HashMap<StudentC, String>();
        hs1.put(new StudentC(1), "First Student");
        System.out.println(hs1);
        hs1.put(new StudentC(1), "Replaced Student");
        System.out.println(hs1);

        // IDEA -> ALL TREE MAP, LinkedHashMap RELATED CRUD AND ITERATION IS SAME
        // IDEA -> TREEMAP -> Keeps in natural sorting || LinkedHashMap -> Insertion order

        // IDEA -> TreeMap objects should be comparable implemented or at least it
        // should get a comparator

        TreeMap<StudentC, String> hst1 = new TreeMap<StudentC, String>();
        hst1.put(new StudentC(1), "First Student");
        hst1.put(new StudentC(13), "First Student");
        hst1.put(new StudentC(14), "First Student");
        hst1.put(new StudentC(51), "First Student");
        hst1.put(new StudentC(0), "First Student");
        hst1.put(new StudentC(-1), "First Student");
        System.out.println();
        System.out.println();
        System.out.println(hst1);
        System.out.println();
        System.out.println();

        // IDEA -> Comparator Precendence > comparable Precedence
        // IDEA -> StudentC getting sorted in increasing order

        TreeMap<StudentC, String> hst11 = new TreeMap<StudentC, String>((a, b) -> b.id - a.id);
        hst11.put(new StudentC(1), "First Student");
        hst11.put(new StudentC(13), "First Student");
        hst11.put(new StudentC(14), "First Student");
        hst11.put(new StudentC(51), "First Student");
        hst11.put(new StudentC(0), "First Student");
        hst11.put(new StudentC(-1), "First Student");
        System.out.println();
        System.out.println();
        System.out.println(hst11);
        System.out.println();
        System.out.println();
        // IDEA -> StudentC getting sorted in increasing order,behaviour got overwritten
        // due to comparator

        // IDEA -> TreeMap has ranged query functionality -> Like higer lower ceiling headmap tailMap
        // floor etc
        

    }
}
