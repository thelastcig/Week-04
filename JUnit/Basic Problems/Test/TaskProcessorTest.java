import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TaskProcessorTest {

    TaskProcessor taskProcessor = new TaskProcessor();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        assertEquals("Task Completed", taskProcessor.longRunningTask());
    }
}
