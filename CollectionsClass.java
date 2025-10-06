import java.util.ArrayList;
import java.util.Collections;

class Student {
    int id;

    Student(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return id == student.id;

    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

}



class StudentC implements Comparable<StudentC> {
    int id;

    @Override
    public int compareTo(StudentC s) {
        return this.id - s.id; // NOTE -> Ascending Order
        // return s.id - this.id; // NOTE -> Descending Order
    }   

    StudentC(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return id == student.id;

    }

    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

}

public class CollectionsClass {
    public static void main(String args[]) {
        System.out.println("Collections Class");
        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(2);
        al.add(23);
        al.add(42);
        al.add(29);

        System.out.println(Collections.max(al)); // NOTE -> 42
        System.out.println(Collections.min(al)); // NOTE -> 1

        Collections.sort(al); // NOTE -> Sorts the arraylist
        System.out.println(al); // NOTE -> [1, 2, 23, 29, 42]
        Collections.sort(al,Collections.reverseOrder()); // NOTE -> Sorts in reverse order
        System.out.println(al); // NOTE -> [42, 29, 23, 2, 1]

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1));
        students.add(new Student(3));
        students.add(new Student(2));
        Collections.sort(students,(s1,s2) -> s2.id - s1.id); // NOTE -> Sorts using comparator
        System.out.println(students);



         ArrayList<StudentC> studentsC = new ArrayList<>();
        studentsC.add(new StudentC(1));
        studentsC.add(new StudentC(3));
        studentsC.add(new StudentC(2));
         Collections.sort(studentsC,(s1,s2) -> s2.id - s1.id  ); // NOTE -> Sorts using comparator
        System.out.println(studentsC);
    }
}
