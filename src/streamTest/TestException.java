package streamTest;

public class TestException
{
	public TestException() {}


	@SuppressWarnings("finally")
	boolean testEx() throws Exception 
	{
		boolean ret = true;
		try 
		{
			ret = testEx1();
		} 
		catch (Exception e) 
		{
			System.out.println("testEx, catch exception");
			ret = false;
			throw e;
		} 
		finally 
		{
			System.out.println("testEx, finally; return value=" + ret);
			return ret;
		}
	}


	@SuppressWarnings("finally")
	boolean testEx1() throws Exception 
	{
		boolean ret = true;
		try 
		{
			System.out.println("ex1");
			ret = testEx2();
			System.out.println("invoked");
			if (!ret) 
			{
				return false;
			}
			System.out.println("testEx1, at the end of try");
			return ret;
		} 
		catch (Exception e) 
		{
			System.out.println("testEx1, catch exception");
//			ret = false;
//			e.printStackTrace();
			throw e;
		} 
		finally 
		{
			System.out.println("testEx1, finally; return value=" + ret);
			return ret;
		}
	}


	@SuppressWarnings("finally")
	boolean testEx2() throws Exception {
		boolean ret = true;
		try 
		{
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) 
			{
				c = b / i;
				System.out.println("i=" + i);
			}
			System.out.println("i am returning true");
			return true;
		} 
		catch (Exception e) 
		{
			
			System.out.println("testEx2, catch exception");
//			ret = false;
//			e.printStackTrace();
			throw e;
		} 
//		finally 
//		{
//			System.out.println("testEx2, finally; return value=" + ret);
//			return ret;
//		}
	}


	public static void main(String[] args) {
		TestException testException1 = new TestException();
		try 
		{
			testException1.testEx();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}