package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Thread
 * wait for connection
 * it is a singleton
 * @author AprilCal
 */
public class Service extends ServerSocket implements Runnable
{
	private static Service instance=null;
	int max_connect_number=7;
	int cnt_connect_number=0;
	/**Service is a singleton
	 * return a SingleInstance.lazy initialization
	 * create a singleton when it is used
	 * @return Service
	 * @throws IOException
	 */
	public static Service getService() throws IOException
	{
		if(instance==null)
		{
			instance=new Service(2016,7);
		}
		return instance;
	}
	
	private Service(int port, int backlog) throws IOException 
	{
		super(port, backlog);
	}

	/**
	 * when there comes a user then create a new thread
	 * It will also determine if the current number of 
	 * connections exceeds the maximum number of connections
	 */
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
