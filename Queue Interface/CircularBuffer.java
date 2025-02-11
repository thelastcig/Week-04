import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int head = 0, tail = 0, size = 0, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; 
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(buffer[(head + i) % capacity]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + cb.getBuffer()); // Output: [1, 2, 3]
        
        cb.insert(4);
        System.out.println("Buffer after inserting 4: " + cb.getBuffer()); // Output: [2, 3, 4]
        
        cb.insert(5);
        System.out.println("Buffer after inserting 5: " + cb.getBuffer()); // Output: [3, 4, 5]
    }
}
