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
//		//д�û���Ϣ���洢
//		
//		if (Client.updateUser(name, password, role))
//		{
//			this.password=password;
//			System.out.println("�޸ĳɹ�");
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
//		Doc doc=Client.searchDoc(ID);//����ID��Ӧ�ļ��Ƿ����
//		
//		if (doc==null)//�����ڸ��ļ�
//		{
//			System.out.println("���ļ�������");
//			return false;
//		}
//			
//		
//		File tempFile =new File(uploadpath,doc.getFilename());
		//��uploadpath��Ӧ��·���£������ļ�����tempFile���ļ���Ϊdoc.getFilename()
//		String filename = tempFile.getName();
//		
//		BufferedInputStream infile =
//				new BufferedInputStream(new FileInputStream(tempFile));
		//�����ļ��ֽ����������󣬴�Ҫ��ȡ���ݵ��ļ�tempFile                                                                                 
		//�ô򿪵��ļ��ֽ�������������Ϊ�����������ַ�����������������infile��                                                                                       
		//���򿪵�Դ�ļ����ַ�����������ϵ������ͨ����������ȡ�ļ�����
//		BufferedOutputStream targetfile = 
//				new BufferedOutputStream(new FileOutputStream(downloadpath+filename)); 
		//�����ļ��ֽ���������󣬴�Ҫд�����ݵ�Ŀ���ļ�filename                                                                                       
		//�ô򿪵��ļ��ֽ������������Ϊ�����������ַ�����������������targetfile��                                                                                   
		//���򿪵�Ŀ���ļ����ַ�����������ϵ������ͨ��������д�����ݵ�Ŀ���ļ�
//		while (true) {
//			int byteRead=infile.read(buffer); //ͨ����������ȡ�ļ����ݸ��ֽ�����
//            if (byteRead==-1) //���ļ�β�������ݿɶ�
//                break;  //�˳�ѭ��           
//            targetfile.write(buffer,0,byteRead);  //������������ͨ��������д��Ŀ���ļ�
//        }
//		infile.close();
//		targetfile.close();//�ر��ַ����������������
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