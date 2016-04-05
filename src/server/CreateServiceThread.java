package server;

import java.io.IOException;
import java.net.Socket;

public class CreateServiceThread extends Thread
{
	Socket socket=null;
	public CreateServiceThread(Socket socket) throws IOException 
	{
		this.socket=socket;
    	System.out.println("Client(" + getName() +") come in...");             
    	start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			
		}
	}		
}
