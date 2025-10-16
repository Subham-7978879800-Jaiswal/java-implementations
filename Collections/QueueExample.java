package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Queue -> PQ , ArrayBlockingQueue, LL 
// Deque 

// poll     ||      remove   -->   IDEA ->  Removed all elements -> if empty -> poll(null) || remove(NoSuchElementException)       
// offer    ||      add      -->   IDEA ->  To add elements in the Queue  
// peek     ||      element  -->   IDEA ->  To See the head element -> if empty -> peek(NoException) ||  element (Exception) 

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.offer(2);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        // queue.remove(); // -> If Empty -> NoSuchElementException
        System.out.println(queue.poll());
        // queue.element(); // -> If Empty -> NoSuchElementException
        System.out.println(queue.peek());
        queue.add(1);
        queue.offer(2);
        queue.add(14);
        queue.offer(26);
        queue.add(11);
        queue.offer(72);
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
