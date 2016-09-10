package uk.co.ohpollux.space.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;

public class IO {
    @SuppressWarnings("deprecation")
    public static String getFileAsString(String path) throws IOException {
	String result = "";
	File file = new File(path);

	if (file.exists()) {
	    result = FileUtils.readFileToString(file);
	} else {
	    result = null;
	}

	return result;
    }

    public static boolean saveStringAsFile(String text, String path) {
	boolean success = false;
	PrintWriter out = null;
	try {
	    File file = new File(path);

	    if (!file.exists()) {
		success = file.mkdirs();
	    } else {
		file.delete();
		file.mkdirs();
	    }

	    out = new PrintWriter(path);
	    out.println(text);

	} catch (FileNotFoundException e) {
	    success = false;
	} finally {
	    if (out != null) {
		out.close();
	    }
	}

	return success;
    }
}
