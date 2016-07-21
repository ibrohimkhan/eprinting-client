package by.eprinting.beans;

import java.nio.file.Path;

public class Document {
	private long id;
	private String name;
	private Path path;
	private String format;
	private int totalPage;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Path getPath() {
		return path;
	}
	
	public void setPath(Path path) {
		this.path = path;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
