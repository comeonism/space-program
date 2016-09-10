package uk.co.ohpollux.space.program;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IOTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    String testText = "This is a simple test text. No longer than a line.";
    String validPath = "files/simpleTest.txt";
    String validOutputPath = "D:/out/files/simpleTest.txt";
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
    public void saveStringAsFileValid() throws IOException {
	boolean success = false;
	File file = new File(validOutputPath);

	if (file.exists()) {
	    file.delete();
	}

	success = IO.saveStringAsFile(testText, validOutputPath);
	ExpectedException.none();

	assertTrue(file.exists());
	assertTrue(success);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void saveStringAsFileTextNull() throws IOException {
	boolean success = false;
	File file = new File(validOutputPath);

	if (file.exists()) {
	    file.delete();
	}

	success = IO.saveStringAsFile(null, validOutputPath);
	ExpectedException.none();

	assertTrue(file.exists());
	assertTrue(success);
	assertTrue(FileUtils.readFileToString(file).equals(""));
    }

    @Test
    public void saveStringAsFilePathNull() throws IOException {
	boolean success = false;

	success = IO.saveStringAsFile(null, null);
	ExpectedException.none();

	assertFalse(success);
    }
}
