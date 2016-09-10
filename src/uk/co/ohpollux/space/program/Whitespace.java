package uk.co.ohpollux.space.program;

public enum Whitespace {
	SPACE(0x0020),
	NO_BREAK_SPACE(0x00A0),
	EN_QUAD(0x2000),
	EM_QUAD(0x2001), 
	EN_SPACE(0x2002),
	EM_SPACE(0x2003),
	THREE_PER_EM_SPACE(0x2004),
	FOUR_PER_EM_SPACE(0x2005),
	SIX_PER_EM_SPACE(0x2006),
	FIGURE_SPACE(0x2007),
	PUNCTUATION_SPACE(0x2008),
	THIN_SPACE(0x2009),
	HAIR_SPACE(0x200A),
	NARROW_NO_BREAK_SPACE(0x202F),
	MEDIUM_MATHEMATICAL_SPACE(0x205F),
	IDEOGRAPHIC_SPACE(0x3000),
	MONGOLIAN_VOWEL_SEPARATOR(0x180E),
	ZERO_WIDTH_SPACE(0x200B),
	ZERO_WIDTH_NO_BREAK_SPACE(0xFEFF);
	
	private char spaceType;
	
	Whitespace(int value) {
		this.spaceType = (char)value;
	}
	
	char getWhitespaceChar() {
		return spaceType;
	}
}
