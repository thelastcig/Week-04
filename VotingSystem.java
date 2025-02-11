import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCountMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();
    private TreeMap<Integer, List<String>> sortedResultsMap = new TreeMap<>(Collections.reverseOrder()); 

    public void castVote(String candidate) {
      
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        
        
        voteOrderMap.put(candidate, voteCountMap.get(candidate));

        
        updateSortedResults(candidate);
    }

    private void updateSortedResults(String candidate) {
        
        sortedResultsMap.values().forEach(list -> list.remove(candidate));

        
        int votes = voteCountMap.get(candidate);

    
        sortedResultsMap.putIfAbsent(votes, new ArrayList<>());
        sortedResultsMap.get(votes).add(candidate);
    }

    public void displayVoteCountInOrder() {
        System.out.println("Votes in the order they were cast:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displaySortedResults() {
        System.out.println("Sorted Voting Results:");
        for (Map.Entry<Integer, List<String>> entry : sortedResultsMap.entrySet()) {
            for (String candidate : entry.getValue()) {
                System.out.println(candidate + ": " + entry.getKey() + " votes");
            }
        }
    }

    public String getWinner() {
        return sortedResultsMap.isEmpty() ? "No votes cast" : sortedResultsMap.firstEntry().getValue().get(0);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        
        system.castVote("Sonu");
        system.castVote("Aman");
        system.castVote("Sonu");
        system.castVote("Saurabh");
        system.castVote("Aman");
        system.castVote("Sonu");

        system.displayVoteCountInOrder();
        System.out.println();
        
        system.displaySortedResults();
        System.out.println("\nWinner: " + system.getWinner());
    }
}
