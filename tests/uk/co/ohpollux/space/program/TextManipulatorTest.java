package uk.co.ohpollux.space.program;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TextManipulatorTest {
    String textWithDefaultSpaces = "This is text with default spaces";
    String textWithNonDefaultSpaces = "This is text with default spaces";
    String textNoSpaces = "Thisistextwithnospaces";

    @Test
    public void makeSureTextsDontMatch() {
	assertFalse(textWithDefaultSpaces.equals(textWithNonDefaultSpaces));
    }

    @Test
    public void replaceDefaultSpacesTestTextWithSpaces() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceDefaultSpaces(textWithDefaultSpaces);

	assertTrue(!result.equals(textWithDefaultSpaces));
    }

    @Test
    public void replaceDefaultSpacesTestTextWithNoSpaces() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceDefaultSpaces(textNoSpaces);

	assertTrue(result.equals(textNoSpaces));
    }

    @Test
    public void replaceDefaultSpacesTestTextNull() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceDefaultSpaces(null);

	assertTrue(result == null);
    }

    @Test
    public void replaceNonDefaultSpacesTestTextNull() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceNonDefaultSpaces(null);

	assertTrue(result == null);
    }

    @Test
    public void replaceNonDefaultSpacesTestTextWithNonDefaults() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceNonDefaultSpaces(textWithNonDefaultSpaces);

	assertTrue(!textWithNonDefaultSpaces.equals(textWithDefaultSpaces));
	assertTrue(result.equals(textWithDefaultSpaces));
    }

    @Test
    public void replaceNonDefaultSpacesTestTextWithDefaults() {
	String result = "";

	TextManipulator manipulator = new TextManipulator();
	result = manipulator.replaceNonDefaultSpaces(textWithDefaultSpaces);

	assertTrue(result.equals(textWithDefaultSpaces));
    }
}
