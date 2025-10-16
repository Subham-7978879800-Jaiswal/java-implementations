package Collections;

import java.util.PriorityQueue;
import java.util.Queue;

// poll     ||      remove   -->   IDEA ->  Removed all elements -> if empty -> poll(null) || remove(NoSuchElementException)       
// offer    ||      add      -->   IDEA ->  To add elements in the Queue  
// peek     ||      element  -->   IDEA ->  To See the head element -> if empty -> peek(NoException) ||  element (Exception) 
public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(1);
        queue.offer(2);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        // queue.remove(); // -> If Empty -> NoSuchElementException
        System.out.println(queue.poll());
        // queue.element(); // -> If Empty -> NoSuchElementException
        System.out.println(queue.peek());

        // Priority Queue can be used to solve n max problems or problems which need
        // elements to be in a certain order
        // Elements will be stored in a Natural Sorting order
        queue.add(1);
        queue.offer(2);
        queue.add(11);
        queue.offer(42);
        queue.add(17);
        queue.offer(290);
        System.out.println(queue); // IDEA -> [1, 2, 11, 42, 17, 290] // Elements in sorted order

        // For Objects -> it shoud either have comparable, comparator

        // IDEA -> Either comparable
        Queue<StudentTEST> stTQ = new PriorityQueue<>();
        stTQ.add(new StudentTEST(1));
        stTQ.add(new StudentTEST(13));
        stTQ.add(new StudentTEST(12));

        stTQ.add(new StudentTEST(11));
        stTQ.add(new StudentTEST(197));
        stTQ.add(new StudentTEST(107));
        stTQ.add(new StudentTEST(1213));

        System.out.println(stTQ);
        // IDEA -> Either comparator
        Queue<Student> stQ = new PriorityQueue<>((a, b) -> a.id - b.id);
        stQ.add(new Student(1));
        stQ.add(new Student(13));
        stQ.add(new Student(12));

        stQ.add(new Student(11));
        stQ.add(new Student(197));
        stQ.add(new Student(107));
        stQ.add(new Student(1213));

        System.out.println(stQ);
    }
}
