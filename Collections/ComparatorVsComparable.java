package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

class StudentTEST implements Comparable<StudentTEST> {
    int id;

    StudentTEST(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(StudentTEST s1) {
        return Integer.compare(this.id, s1.id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + '}';
    }

}

public class ComparatorVsComparable {

    public static void main(String[] args) {
        
        System.out.println("Comparator Vs Comparable");

       
        ArrayList<StudentTEST> ar = new ArrayList<StudentTEST>();

       
        ar.add(new StudentTEST(1));
        ar.add(new StudentTEST(4));
        ar.add(new StudentTEST(5));
        ar.add(new StudentTEST(2));
        ar.add(new StudentTEST(11));
        ar.add(new StudentTEST(11));

        // IDEA Sort using Comparable -> Natural Order
        Collections.sort(ar);

        // Print the sorted list (ascending)
        System.out.println("\nSorted using Comparable (ascending): " + ar);

        // IDEA Sort using External Comparator -> Comparator is a functional Interface and a instance of comparator can be replaced by a Lambda
        Collections.sort(ar, (a, b) -> { return b.id - a.id; });

        // Print the sorted list (descending)
        System.out.println("Sorted using Comparator (descending): " + ar);
    }

}
