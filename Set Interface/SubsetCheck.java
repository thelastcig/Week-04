    import java.util.*;

    public class SubsetCheck {
        public static <T> boolean isSubset(Set<T> subset, Set<T> mainSet) {
            return mainSet.containsAll(subset);
        }

        public static void main(String[] args) {
            Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

            System.out.println(isSubset(set1, set2));
        }
    }
