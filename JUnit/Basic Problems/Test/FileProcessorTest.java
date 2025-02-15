import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileProcessorTest {

    private static final String TEST_FILE = "testfile.txt";
    private final FileProcessor fileProcessor = new FileProcessor();

    @BeforeEach
    void setUp() throws IOException {

        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {

        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);


        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing.");


        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Content should match what was written.");
    }

    @Test
    void testReadFromNonExistentFile() {
        Exception exception = assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent.txt"), "Should throw IOException for missing file.");
    }
}
