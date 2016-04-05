package client;

import java.net.Socket;

public class Client 
{
	private Socket socket;
	public Client()
	{
		try
        {
            socket =new Socket("127.0.0.1",2016);
            socket.setSoTimeout(60000); 
        }
        catch (Exception e) 
        {
            System.out.println("Exception:" + e);
        }
	}

}
