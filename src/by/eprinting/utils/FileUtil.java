package by.eprinting.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileUtil {
	private static final String DIR_PATH = "E:\\uploader";
	
	public static String toUTF8(String text) {
		try {
			return new String(text.getBytes("ISO-8859-1"), "UTF-8");
		
		} catch (UnsupportedEncodingException ex) {
			System.out.println(ex);
			throw new RuntimeException(ex);
		}
	}
	
	public static Path saveToLocalDisk(List<FileItem> items) {	
		Path path = null;
		
		try {
			
			for (FileItem item : items) {
				if (item.getContentType() == null) continue;
				
				path = Paths.get(DIR_PATH + "\\" + (new Date().getTime()) + "_" + item.getName());
				File file = Files.createFile(path).toFile();
				
				if (file != null) item.write(file);
			}
			
		} catch (IOException e) {
			System.out.println(e);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return path;
	}
	
	public static void deleteFileFromLocalDisk(Path path) {
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}