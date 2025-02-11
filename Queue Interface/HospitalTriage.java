import java.util.*;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); 
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        triageQueue.add(new Patient("Satyam", 3));
        triageQueue.add(new Patient("Abhay", 5));
        triageQueue.add(new Patient("Anand", 2));

        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
