package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CreateServiceThread extends Thread
{
	Socket socket=null;
	BufferedReader reader;
	PrintWriter writer;
	public CreateServiceThread(Socket socket) throws IOException 
	{
		this.socket=socket;
    	System.out.println("Client(" + getName() +") come in..."); 
    	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	writer = new PrintWriter(socket.getOutputStream(),true);
    	start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				for(int i=0;i<100;i++)
				{
					writer.println(i);
				}
				System.out.println(reader.readLine());
			} 
			catch (IOException e) 
			{
//				e.printStackTrace();
			}
		}
	}		
}
