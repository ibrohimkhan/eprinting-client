package by.eprinting.services;

import java.nio.file.Path;

import by.eprinting.beans.Document;
import by.eprinting.utils.DocumentUtil;

public class DocumentService {
	public static Document createDocument(Path path) {
		Document document = new Document();
		
		String ext 		= DocumentUtil.getExtension(path.getFileName().toString());
		String name 	= DocumentUtil.getName(path);
		int totalPage 	= DocumentUtil.getTotalPage(path, ext);
		
		document.setPath(path);
		document.setName(name);
		document.setFormat(ext);
		document.setTotalPage(totalPage);
		
		return document;
	}
	
}
