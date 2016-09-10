package uk.co.ohpollux.space.program;

import java.io.File;
import java.io.IOException;

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

    @SuppressWarnings("deprecation")
    public static boolean saveStringAsFile(String text, String path) {
	boolean success = false;

	if (path != null) {
	    File file = new File(path);

	    if (file.exists()) {
		file.delete();
	    }

	    try {
		FileUtils.writeStringToFile(file, text);
		success = true;
	    } catch (IOException e) {
		success = false;
	    }
	}

	return success;
    }
}
