package uk.co.ohpollux.space.program;

public class TextManipulator {
    Character defaultSpace = new Character(' ');
    SpacesStore store = new SpacesStore();

    public String replaceDefaultSpaces(String text) {
	String result = "";

	if (text != null) {
	    char[] charArray = text.toCharArray();

	    for (int i = 0; i < charArray.length; i++) {
		if (defaultSpace.equals(charArray[i])) {
		    charArray[i] = store.getRandomSpace();
		}
	    }

	    result = new String(charArray);

	} else {
	    result = null;
	}

	return result;
    }

    public String replaceNonDefaultSpaces(String text) {
	String result = "";

	if (text != null) {
	    char[] charArray = text.toCharArray();

	    for (Whitespace space : Whitespace.values()) {
		for (int i = 0; i < charArray.length; i++) {
		    if (new Character(space.getWhitespaceChar()).equals(charArray[i])) {
			charArray[i] = store.getDefaultSpace();
		    }
		}
	    }

	    result = new String(charArray);
	} else {
	    result = null;
	}

	return result;
    }
}
