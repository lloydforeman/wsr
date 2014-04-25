package wsr;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.NativeSwing;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

public class viewer3 {

	public static void main(String[] args) {
		
		NativeSwing.initialize();
		NativeInterface.open();
	    Runnable runnable = new Runnable() {
	        public void run() {
	            JFrame frame = new JFrame();
	            JPanel panel = new JPanel();
	            frame.setContentPane(panel);
	            JWebBrowser browser = new JWebBrowser();
	            browser.setBarsVisible(false);
	            browser.setStatusBarVisible(false);
	            browser.setPreferredSize(new Dimension(800,600));
	            panel.add(browser);
	            browser.navigate("http://google.com");
	            frame.pack();
	            frame.setVisible(true);
	        }
	    };
	    try {
			SwingUtilities.invokeAndWait(runnable);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
