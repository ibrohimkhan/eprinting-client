package by.eprinting.services.db;

import by.eprinting.beans.Document;
import by.eprinting.dao.BaseDAO;
import by.eprinting.dao.DocumentJdbcImpl;

public class DocumentDBService {
	private static BaseDAO document = new DocumentJdbcImpl();
	
	public static long creatDocument(Document doc) {
		return document.insert(doc);
	}
	
	public static Document findDocumentById(long id) {
		return document.selectById(id);
	}
	
	public static void deleteDocument(Document doc) {
		document.delete(doc);
	}
}
