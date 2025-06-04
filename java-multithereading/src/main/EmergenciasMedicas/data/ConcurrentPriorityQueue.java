package EmergenciasMedicas.data;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPriorityQueue<T extends Comparable<T>> {

    private final PriorityQueue<T> queue = new PriorityQueue<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void enqueue(T item) {
        lock.lock();
        try {
            queue.offer(item);
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() {
        lock.lock();
        try {
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public List<T> getAll() {
        lock.lock();
        try {
            return new ArrayList<>(queue);
        } finally {
            lock.unlock();
        }
    }
}