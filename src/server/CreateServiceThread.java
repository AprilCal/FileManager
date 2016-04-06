package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CreateServiceThread extends Thread
{
	Socket socket=null;
	BufferedReader reader;
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
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(reader.readLine());;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}		
}
