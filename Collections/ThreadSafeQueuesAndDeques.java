package Collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadSafeQueuesAndDeques {

    public static void main(String[] args) throws InterruptedException {

        PriorityQueue<Integer> pq = new PriorityQueue(); // IDEA -> Not Thread safe
        Queue q = new LinkedList<>(); // IDEA -> Not Thread safe
        Queue qq = new ArrayDeque<>(); // IDEA -> Not Thread safe

        Queue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2000);// IDEA -> Thread safe
        PriorityBlockingQueue<Integer> pqb = new PriorityBlockingQueue(10); // IDEA -> Thread safe

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // Add elements at the end
        deque.add(10);
        deque.addLast(20);

        // Add elements at the front
        deque.addFirst(5);

        // Peek at the first and last elements
        System.out.println("First: " + deque.getFirst()); // 5
        System.out.println("Last: " + deque.getLast()); // 20

        // Remove elements from both ends
        System.out.println("Removed First: " + deque.removeFirst()); // 5
        System.out.println("Removed Last: " + deque.removeLast()); // 20

        // Check remaining elements
        System.out.println("Deque: " + deque); // [10]

    }

}
