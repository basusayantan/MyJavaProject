package com.linkedin.challenges.oop.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileReader {
	private final Path filePath;
	
	protected AbstractFileReader(String filePath) {
		this.filePath = Path.of(filePath);
	}
	
	protected AbstractFileReader() {
		this.filePath = null;
	}
	
	public String getPath() {
		return this.filePath.toAbsolutePath().toString();
	}
	
	public List<String> readFile() throws IOException {
		return Files.lines(filePath)
				.map(this::parseLine)
				.collect(Collectors.toList());
	}
	protected abstract String parseLine(String Line);
}
