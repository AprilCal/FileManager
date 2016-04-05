package client;

public class Main 
{
	public static void main(String[] args)
	{
		Client c=new Client();
		Thread t=new Thread(){
			@Override
			public void run()
			{
				
			}
		};
		new Thread(new Runnable(){
			@Override
			public void run(){
				
			}
			}).start();
	}
}
