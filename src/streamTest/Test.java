package streamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) throws Exception {
		File f1=new File("d://cloud//123.jpeg");
		File f2=new File("d://local//123.jpeg");
		f2.createNewFile();
		FileInputStream oldFile = new FileInputStream(f1); 
		FileOutputStream newFile = new FileOutputStream(f2);
		
		
		
		byte[] ary = new byte[1024];
		int byteRead = -1;
		do
		{
			byteRead = oldFile.read(ary);
			newFile.write(ary);
//			newFile.flush();
		}while(byteRead != -1);
		oldFile.close();
		newFile.close();
}

}
