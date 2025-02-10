import java.util.*;

abstract class JobRole {
    String candidateName;
    
    JobRole(String candidateName) { this.candidateName = candidateName; }

    abstract void evaluateResume();
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(String candidateName) { super(candidateName); }
    void evaluateResume() { System.out.println(candidateName + " - Software Engineer Resume: Evaluated for coding skills."); }
}

class DataScientist extends JobRole {
    DataScientist(String candidateName) { super(candidateName); }
    void evaluateResume() { System.out.println(candidateName + " - Data Scientist Resume: Evaluated for machine learning expertise."); }
}

class ProductManager extends JobRole {
    ProductManager(String candidateName) { super(candidateName); }
    void evaluateResume() { System.out.println(candidateName + " - Product Manager Resume: Evaluated for leadership and strategy."); }
}

class Resume<T extends JobRole> {
    T jobCandidate;

    Resume(T jobCandidate) { this.jobCandidate = jobCandidate; }

    void processResume() { jobCandidate.evaluateResume(); }
}


class ResumeScreeningSystem {
    static void screenResumes(List<? extends JobRole> candidates) {
        candidates.forEach(JobRole::evaluateResume);
    }
}

public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Sonu"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Aman"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Saurabh"));

        List<JobRole> candidateList = Arrays.asList(seResume.jobCandidate, dsResume.jobCandidate, pmResume.jobCandidate);

       
        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        System.out.println("\nBatch Screening:");
        ResumeScreeningSystem.screenResumes(candidateList);
    }
}
