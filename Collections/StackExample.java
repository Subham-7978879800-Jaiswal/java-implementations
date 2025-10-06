package Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

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

}

class StackExample {
    public static void main(String args[]) throws InterruptedException {
        Stack<Integer> st = new Stack<Integer>();
        // NOTE || PUSH || POP || EMPTY || SEARCH || PEEK

        // PUSH = Push on a Full stack = Nothing happens = Vector has variable size
        st.push(1);
        st.push(4);
        st.push(7);
        st.push(8);
        System.out.println(st); // NOTE -> [1, 4, 7, 8]

        // POP = Removes from a empty stack = EmptyStackException
        // Removes Top element and give the removed element
        System.out.println(st.pop()); // NOTE -> 8
        st.pop();
        st.pop();
        st.pop();
        // st.pop(); = Empty so Empty Stack exception will be raised

        // Empty = Return True or return false if stack is empty or not
        System.out.println(st.empty()); // NOTE -> true

        // Search = Search the given element from top of stack = Uses Equals Method In
        // Case of objects
        // Gives Top based position // Starts with 1
        /// Throws Empty Stack Exception if Search done on Empty stack Exception
        st.push(1);
        st.push(4);
        st.push(7);
        st.push(8);

        System.out.println(st.search(7)); // NOTE -> 2

        // PEEK = Gives Top Element
        // Throws Empty Stack Exception if PEEK done on Empty stack Exception
        System.out.println(st.peek()); // NOTE -> 8

        // IDEA Iterating via a enhanced for loop || or Iterators is problematic -> It
        // considers it as a vector
        for (int x : st) {
            System.out.println(x); // NOTE -> 1 4 7 8
        } // NOTE -> BUT STACK WILL BE => 8 7 4 1

        // Normal Iteration
        Iterator<Integer> itr = st.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next()); // NOTE -> 1 4 7 8
        } // NOTE -> BUT STACK WILL BE => 8 7 4 1

        ListIterator<Integer> sitr = st.listIterator();

        while (sitr.hasNext()) {
            System.out.println(sitr.next()); // NOTE -> 1 4 7 8
        } // NOTE -> BUT STACK WILL BE => 8 7 4 1

        // IDEA for Proper Iteration do reverse order

        // IDEA = Adding object into stack and finding it using search method
        Stack<Student> studentStack = new Stack<>();
        studentStack.push(new Student(1));
        studentStack.push(new Student(2));
        System.out.println(studentStack.search(new Student(1))); // NOTE -> 2
        // if remove method removed from Student class then it will return -1 as it will
        // not find the object

        // IDEA Stacks are synchronized
        // Two Thread will change same stack at same time still no Data Corruption


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                studentStack.push(new Student(i));
            }
        });

        Thread t2 =  new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                studentStack.push(new Student(i));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(studentStack.size()); // NOTE -> 2002

    }
}