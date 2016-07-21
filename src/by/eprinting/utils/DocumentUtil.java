package by.eprinting.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.lizardtech.djvu.Document;

public class DocumentUtil {
	private static final int NEXT_POSITION = 1;
	
	private static final String PDF = "pdf";
	private static final String DJVU = "djvu";
	private static final String DOCX = "docx";
	private static final String DOC = "doc";
	private static final String PPT = "ppt";
	private static final String PPTX = "pptx";

	public static String getExtension(String name) {
		int index = name.lastIndexOf(".") + NEXT_POSITION;
		return name.substring(index, name.length());
	}

	public static String getName(Path path) {
		String name = path.getFileName().toString();
		int index = name.indexOf("_") + NEXT_POSITION;
		return name.substring(index);
	}

	public static int getTotalPage(Path path, String ext) {
		int total = 0;
		
		PDDocument pdfDocument 	= null;
		XWPFDocument docx 		= null;
		XMLSlideShow pptxDoc 	= null;
		InputStream ins			= null;
		
		try {
			switch (ext) {
				case PDF:
					pdfDocument = PDDocument.load(path.toFile());
					total = pdfDocument.getNumberOfPages();
					break;
					
				case DJVU:
					Document doc = new Document();
					ins = new FileInputStream(path.toFile());
					doc.read(ins);
					total = doc.size();
					break;
					
				case DOCX:
					docx = new XWPFDocument(new FileInputStream(path.toFile()));
					total = docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
					break;
					
				case DOC:
					ins = new FileInputStream(path.toFile());
					HWPFDocument wordDoc = new HWPFDocument(ins);
					total = wordDoc.getSummaryInformation().getPageCount();
					break;
					
				case PPT:
					ins = new FileInputStream(path.toFile());
					HSLFSlideShow pptDoc = new HSLFSlideShow(new HSLFSlideShowImpl(ins));
					total = pptDoc.getSlides().size();
					break;
					
				case PPTX:
					pptxDoc = new XMLSlideShow(new FileInputStream(path.toFile()));
					total = pptxDoc.getSlides().size();
					break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (pdfDocument != null) pdfDocument.close();
				if (docx != null) docx.close();
				if (pptxDoc != null) pptxDoc.close();
				if (ins != null) ins.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return total;
	}
}