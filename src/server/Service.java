package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Service extends ServerSocket implements Runnable
{
	private static Service instance=null;
	public static Service getService() throws IOException
	{
		if(instance==null)
		{
			instance=new Service(2016,7);
		}
		return instance;
	}
	int max_connect_number=7;
	int cnt_connect_number=0;
	private Service(int port, int backlog) throws IOException 
	{
		super(port, backlog);
	}

	@Override
	public void run() 
	{
		try
        {
            while (true)
            {
            	if(cnt_connect_number<max_connect_number)
            	{
            		Socket socket = accept();
            		cnt_connect_number++;
            		System.out.println("a user has connected.");
            		new CreateServiceThread(socket);//当有请求时，启一个线程处理
            	}
            	else
            	{
            		System.out.println("there is too much user.please wait a mainute.");
            	}
            }
         }
         catch (IOException e)
         {
         	e.printStackTrace();
         }
         finally 
         {
             try 
             {
				close();
             }
             catch (IOException e) 
             {
				e.printStackTrace();
             }
         }
	}
}
