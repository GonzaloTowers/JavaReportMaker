package informes;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser {
	
	public static void main(String [] args){

		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fc.showOpenDialog(new JFrame());
		if(result == JFileChooser.APPROVE_OPTION){
			File selectedFile = fc.getSelectedFile();
		}
	
	}
	
}
