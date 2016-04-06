package streamTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest 
{
	public static void main(String[] args)
	{
		File f=new File("d:\\cloud\\123.jpeg");
		File f2=new File("d:\\local\\123.jpeg");
		System.out.println(f.getPath());
		try
		{
			if(!f2.exists())
			{
				f2.createNewFile();
			}
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f2));
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));
			
			String info ="";
			String single;
			byte[] binfo=new byte[1024];
			int len;
			while((len=bis.read(binfo))>0)
			{
				single=new String(binfo,0,len);
				info=info+single;
				
			}
			bos.write(info.getBytes());
			bos.flush();
			bos.close();
			bis.close();		
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

}
