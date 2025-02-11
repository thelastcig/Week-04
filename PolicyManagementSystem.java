import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount + '}';
    }
}

public class PolicyManagementSystem {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<InsurancePolicy> getAllPolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    public Set<InsurancePolicy> getPoliciesExpiringSoon() {
        Set<InsurancePolicy> expiringSoon = new HashSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = calendar.getTime();

        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getExpiryDate().before(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePolicy> filteredPolicies = new HashSet<>();
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    public Set<InsurancePolicy> getDuplicatePolicies() {
        Set<String> seenNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();

        for (InsurancePolicy policy : hashSetPolicies) {
            if (!seenNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public void performanceComparison() {
        int testSize = 10000;
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>();
        Date expiry = new Date();

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            hashSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Health", 500.0));
        }
        end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            linkedHashSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Health", 500.0));
        }
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            treeSet.add(new InsurancePolicy("P" + i, "Holder" + i, expiry, "Health", 500.0));
        }
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();
        Calendar cal = Calendar.getInstance();
        
        cal.set(2025, Calendar.MARCH, 10);
        InsurancePolicy p1 = new InsurancePolicy("P123", "Alice", cal.getTime(), "Health", 1000);

        cal.set(2024, Calendar.FEBRUARY, 20);
        InsurancePolicy p2 = new InsurancePolicy("P124", "Bob", cal.getTime(), "Auto", 1500);

        cal.set(2024, Calendar.FEBRUARY, 25);
        InsurancePolicy p3 = new InsurancePolicy("P125", "Charlie", cal.getTime(), "Home", 2000);

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);

        System.out.println("All Policies: " + system.getAllPolicies());
        System.out.println("Expiring Soon: " + system.getPoliciesExpiringSoon());
        System.out.println("Health Policies: " + system.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + system.getDuplicatePolicies());

        system.performanceComparison();
    }
}
