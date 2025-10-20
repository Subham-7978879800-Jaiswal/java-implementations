package Collections;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;

class StudentIdentity implements Comparable<StudentIdentity> {
    int id;

    StudentIdentity(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(StudentIdentity s1) {
        return Integer.compare(this.id, s1.id);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StudentIdentity))
            return false;
        StudentIdentity other = (StudentIdentity) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}

public class WeakMapVsIdentityMap {
    public static void main(String[] args) {

        // Weak Map

        WeakHashMap<Student, Integer> whm = new WeakHashMap<>();
        Student s1 = new Student(0);
        whm.put(s1, 4);
        System.out.println(whm); // TODO -> {Student{id=0}=4}
        s1 = null;
        System.gc();
        System.out.println(whm); // TODO ->{}

        HashMap<Student, Integer> hm = new HashMap<>();
        Student s1h = new Student(0);
        hm.put(s1h, 4);
        System.out.println(hm); // TODO -> {Student{id=0}=4}
        s1 = null;
        System.gc();
        System.out.println(hm); // TODO -> {Student{id=0}=4}

        // Identity Hash Map

        HashMap<StudentIdentity, Integer> Nihm = new HashMap<>();
        StudentIdentity s11 = new StudentIdentity(0);
        StudentIdentity s111 = new StudentIdentity(0);

        Nihm.put(s11, 14);
        Nihm.put(s111, 45);
        System.out.println(Nihm); // TODO -> {Student{id=0}=45} // IDEA -> StudentIdentity -> Replaces the object
                                  // using hash code and equal method

        IdentityHashMap<StudentIdentity, Integer> Nihmr = new IdentityHashMap<>();
        StudentIdentity s22 = new StudentIdentity(0);
        StudentIdentity s222 = new StudentIdentity(0);

        Nihmr.put(s22, 140);
        Nihmr.put(s222, 459);
        System.out.println(Nihmr); // TODO -> {Student{id=0}=459, Student{id=0}=140} // IDEA -> IdentityHashMap
                                   // IDEA -> uses StudentIdentity which has equals and Hashcode but it still uses
                                   // IDEA -> object class implementation
                                   // IDEA -> implementation of equals and Hashcode and hence the output

    }

}
