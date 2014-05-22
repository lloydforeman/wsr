package wsr;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class PDFViewer {

	public static void main(String[] args) {
		String path = "/Users/lloydforeman/Downloads/WSR Feb 24 Updates/WSR Client File 2014/pdfs/panel 1/1-Screening & Client Information.pdf";
        openViewer(path);
		
	}
	
	public static void openViewer(String path) {
		
		//if (!Desktop.isDesktopSupported())
		
		File myFile = new File(path);
        try {
			Desktop.getDesktop().open(myFile);
		} catch (IOException e) {
			e.printStackTrace();
	
		}
	}

}
