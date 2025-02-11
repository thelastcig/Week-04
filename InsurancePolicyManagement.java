import java.util.*;
import java.time.LocalDate;

class InsurancePolicy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Policyholder: " + policyholderName + ", ExpiryDate: " + expiryDate;
    }
}

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> policyInsertionOrder = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> policyExpiryMap = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        policyInsertionOrder.put(policy.policyNumber, policy);
        policyExpiryMap.put(policy.expiryDate, policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate now = LocalDate.now();
        LocalDate thresholdDate = now.plusDays(days);
        return new ArrayList<>(policyExpiryMap.subMap(now, thresholdDate).values());
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, InsurancePolicy>> iterator = policyExpiryMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                InsurancePolicy policy = entry.getValue();
                policyMap.remove(policy.policyNumber);
                policyInsertionOrder.remove(policy.policyNumber);
                iterator.remove(); 
            } else {
                break; 
            }
        }
    }

    public void printAllPolicies() {
        for (InsurancePolicy policy : policyInsertionOrder.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        
        manager.addPolicy(new InsurancePolicy("P1001", "Sonu", LocalDate.of(2025, 5, 10)));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 3, 15))); // Expiring soon
        manager.addPolicy(new InsurancePolicy("P1003", "Sonu", LocalDate.of(2023, 12, 5))); // Expired
        manager.addPolicy(new InsurancePolicy("P1004", "Charlie", LocalDate.of(2024, 4, 20)));

        
        System.out.println("Policy P1001: " + manager.getPolicyByNumber("P1001"));

        
        System.out.println("\nPolicies expiring soon:");
        for (InsurancePolicy policy : manager.getPoliciesExpiringSoon(30)) {
            System.out.println(policy);
        }

       
        System.out.println("\nPolicies for Sonu:");
        for (InsurancePolicy policy : manager.getPoliciesByHolder("Sonu")) {
            System.out.println(policy);
        }

    
        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();
        System.out.println("Updated policy list:");
        manager.printAllPolicies();
    }
}
