package client;

import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread
{
	private static Socket socket;
	PrintWriter pw;
	public Client()
	{
		try
        {
            socket =new Socket("127.0.0.1",2016);
            socket.setSoTimeout(60000);
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("123456");
        }
        catch (Exception e) 
        {
            System.out.println("Exception:" + e);
        }
	}
}
