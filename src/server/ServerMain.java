package server;

import java.io.IOException;

public class ServerMain {
	public static void main(String[] args)
	{
		try 
		{
			Service s=Service.getService();
			Thread t=new Thread(s);
			t.start();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
