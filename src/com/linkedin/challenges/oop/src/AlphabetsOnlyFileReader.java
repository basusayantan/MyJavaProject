package com.linkedin.challenges.oop.src;

public class AlphabetsOnlyFileReader extends AbstractFileReader {

	public AlphabetsOnlyFileReader(String filePath) {
		super(filePath);
	}

	@Override
	protected String parseLine(String Line) {
		return Line.replaceAll("[^A-Za-z]", "");
	}
}
