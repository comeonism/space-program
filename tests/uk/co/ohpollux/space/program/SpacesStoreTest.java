package uk.co.ohpollux.space.program;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SpacesStoreTest {
    @Test
    public void getRandomWhitespaceTest() {
	SpacesStore store = new SpacesStore();
	assertTrue(store.getRandomWhitespace() instanceof Whitespace);
    }

    @Test
    public void getRandomSpaceTest() {
	Character spaceValue;
	SpacesStore store = new SpacesStore();
	spaceValue = store.getRandomSpace();
	assertTrue(spaceValue != null);
	assertTrue(!spaceValue.equals(""));
    }

    @Test
    public void getDefaultSpaceTest() {
	Character spaceValue;
	Character space = new Character(' ');
	SpacesStore store = new SpacesStore();
	spaceValue = store.getDefaultSpace();
	assertTrue(spaceValue != null);
	assertTrue(spaceValue.charValue() == space.charValue());
    }
}
