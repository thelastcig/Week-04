import java.util.*;

public class RotateList {
    public static <T> List<T> rotateList(List<T> list, int rotateBy) {
        int size = list.size();
        if (size == 0) return list;
        
        rotateBy = rotateBy % size;
        if (rotateBy == 0) return list;

        List<T> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(rotateBy, size));
        rotatedList.addAll(list.subList(0, rotateBy));

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        
        List<Integer> rotatedList = rotateList(inputList, rotateBy);
        System.out.println(inputList);
        System.out.println(rotatedList);
    }
}
