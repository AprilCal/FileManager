package client;

public abstract class User 
{
	private String name;
	private String password;
	private String role;
	private String uploadpath="d:\\file\\cloud\\";
	private String downloadpath="d:\\file\\local\\";
	
	public User(String name,String password,String role)
	{
		this.name=name;
		this.password=password;
		this.role=role;
	}
	
	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getRole() {return role;}

	public void setRole(String role) {this.role = role;}

	public String getUploadpath() {return uploadpath;}

	public void setUploadpath(String uploadpath) {this.uploadpath = uploadpath;}

	public String getDownloadpath() {return downloadpath;}

	public void setDownloadpath(String downloadpath) {this.downloadpath = downloadpath;}

	@Override
	public String toString()
	{
		return name+" "+role;
	}
	
	public abstract void showMenu();
	
	public String showFileList(){return null;}
	public String listUser() 
	{return downloadpath;}

}
	
//	public abstract void showMenu() throws IllegalStateException, SQLException;


//	
//	public boolean changeUserInfo(String password)throws SQLException,IllegalStateException
//	{
//		//写用户信息到存储
//		
//		if (Client.updateUser(name, password, role))
//		{
//			this.password=password;
//			System.out.println("修改成功");
//			return true;
//		}
//		else
//			return false;
//	}
//	
//
//	public String showFileList()
//			throws SQLException,IllegalStateException
//	{
//		String str=Client.getAllDoc();
//		return str;
//	}
//
//	
//	public boolean addUser(String name,String password,String role) 
//		{return true;}
//	public boolean delUser(String name) 
//		{return true;}
//
//	public String getName() 
//	{
//		return name;
//	}
//
//	public void setName(String name) 
//	{
//		this.name = name;
//	}
//
//	public String getPassword()
//	{
//		return password;
//	}
//
//	public void setPassword(String password) 
//	{
//		this.password = password;
//	}
//
//	public String getRole() 
//	{
//		return role;
//	}
//
//	public void setRole(String role) 
//	{
//		this.role = role;
//	}
//	
//	public boolean uploadFile(String ID,String creator,String description,String filename)
//			throws SQLException,IOException{return true;}
//	public boolean downloadFile(String ID) 
//			throws SQLException,IOException
//	{  
//		
//		byte[] buffer = new byte[1024];
//		Doc doc=Client.searchDoc(ID);//查找ID对应文件是否存在
//		
//		if (doc==null)//不存在该文件
//		{
//			System.out.println("该文件不存在");
//			return false;
//		}
//			
//		
//		File tempFile =new File(uploadpath,doc.getFilename());
		//在uploadpath对应的路径下，创建文件对象tempFile，文件名为doc.getFilename()
//		String filename = tempFile.getName();
//		
//		BufferedInputStream infile =
//				new BufferedInputStream(new FileInputStream(tempFile));
		//创建文件字节输入流对象，打开要读取数据的文件tempFile                                                                                 
		//用打开的文件字节输入流对象作为参数，创建字符缓冲区输入流对象infile，                                                                                       
		//将打开的源文件和字符缓冲区流联系起来，通过缓冲区读取文件数据
//		BufferedOutputStream targetfile = 
//				new BufferedOutputStream(new FileOutputStream(downloadpath+filename)); 
		//创建文件字节输出流对象，打开要写入数据的目标文件filename                                                                                       
		//用打开的文件字节输出流对象作为参数，创建字符缓冲区输入流对象targetfile，                                                                                   
		//将打开的目标文件和字符缓冲区流联系起来，通过缓冲区写入数据到目标文件
//		while (true) {
//			int byteRead=infile.read(buffer); //通过缓冲区读取文件数据给字节数组
//            if (byteRead==-1) //在文件尾，无数据可读
//                break;  //退出循环           
//            targetfile.write(buffer,0,byteRead);  //将读到的数据通过缓冲区写入目标文件
//        }
//		infile.close();
//		targetfile.close();//关闭字符缓冲区输入输出流
//		return true;
        //System.out.println("copy success! ");		
//	}
//
//	public boolean changeUserInfo(String trim, String trim2)
//			throws SQLException,IllegalStateException
//	{
//		return false;
//	}
//}