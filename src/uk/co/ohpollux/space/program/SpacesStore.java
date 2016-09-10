package uk.co.ohpollux.space.program;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SpacesStore {
    private Random rand = new Random();
    private Whitespace whitespace;
    private final List<Whitespace> values = Collections.unmodifiableList(Arrays.asList(Whitespace.values()));

    public Whitespace getRandomWhitespace() {
	return values.get(rand.nextInt(values.size()));
    }

    public char getRandomSpace() {
	return getRandomWhitespace().getWhitespaceChar();
    }

    public char getDefaultSpace() {
	return Whitespace.SPACE.getWhitespaceChar();
    }

    public Whitespace getWhitespace() {
	return whitespace;
    }
}
