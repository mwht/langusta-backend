package ovh.spajste.langusta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TokenFilterTest {

    @Before
    public void setUp() {
        try {
            FileWriter fileWriter = new FileWriter("testCodes.txt");
            fileWriter.write("TEST123\n321TEST\n123TEST321");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void replacementTest() {
        assertEquals("This is a test string TEST123 hi mom", TokenFilter.processText("This is a test string {{file testCodes.txt}} hi mom"));
        assertEquals("here ur code: 321TEST", TokenFilter.processText("here ur code: {{file testCodes.txt}}"));
        assertEquals("this is casual message", TokenFilter.processText("this is casual message"));
    }

    @After
    public void tearDown() {
        try {
            File testFile = new File("testCodes.txt");
            if(!testFile.delete()) fail();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
