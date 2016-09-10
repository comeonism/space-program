package uk.co.ohpollux.space.program;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IOTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    String testText = "This is a simple test text. No longer than a line.";
    String validPath = "files/simpleTest.txt";
    String validOutputPath = "out/files/simpleTest.txt";
    String nonExistentPath = "this/path/does/not/exist/test.txt";

    @Test
    public void getFileAsStringWorks() throws IOException {
	String result = IO.getFileAsString(validPath);

	ExpectedException.none();

	assertTrue(result.equals(testText));
    }

    @Test
    public void getFileAsStringNull() throws IOException {
	String result = IO.getFileAsString(nonExistentPath);

	ExpectedException.none();

	assertNull(result);
    }

    @Test
    public void saveStringAsFile() throws IOException {
	File file = new File(validOutputPath);

	if (file.exists()) {
	    file.delete();
	}

	IO.saveStringAsFile(testText, validPath);
	ExpectedException.none();

	assertTrue(file.exists());
    }
}
