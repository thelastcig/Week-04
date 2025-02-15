import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    ListManager listManager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);

        assertEquals(2, list.size());
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        listManager.removeElement(list, 5);

        assertEquals(1, list.size());
        assertFalse(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));

        listManager.addElement(list, 1);
        listManager.addElement(list, 2);
        assertEquals(2, listManager.getSize(list));

        listManager.removeElement(list, 1);
        assertEquals(1, listManager.getSize(list));
    }

    @Test
    void testNullListHandling() {
        List<Integer> list = null;
        listManager.addElement(list, 5);  
        listManager.removeElement(list, 5);  
        assertEquals(0, listManager.getSize(list)); 
    }
}
