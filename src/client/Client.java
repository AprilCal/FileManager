package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread
{
	public static Socket socket;
	PrintWriter writer;
	BufferedReader reader;
	public Client()
	{
		try
        {
            socket =new Socket("127.0.0.1",2016);
//            socket.setSoTimeout(60000);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (Exception e) 
        {
            System.out.println("Exception:" + e);
        }
	}
	
	@Override
	public void run()
	{
		 writer.println("123456");
		 writer.println("123456");
		 writer.println("123456");
		 while(true)
		 {
			 try 
			 {
				System.out.println(reader.readLine());
			 } 
			 catch (IOException e) 
			 {
//				 e.printStackTrace();
			 }
		 }
	}
}
