package client;


public class Main 
{
	public static void main(String[] args)
	{
		Client c=new Client();
		c.start();
		System.out.println(c.isAlive());
		System.out.println(Client.socket.isClosed());
		System.out.println(Client.socket.isConnected());
//		while(true)
//		{}
	}
}
