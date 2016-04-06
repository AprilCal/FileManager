package server;

import java.sql.*;

/**
 * a class between JDBC&DataProcessing、Server
 * it Provide some static operations
 * For Example Server connect to DataBase by invoking 
 * DataProcessing.connectToDatabase,CreateServiceThread
 * will search for a doc by invoking DataProcessing.searchDoc
 * @author AprilCal
 *
 */
public class DataProcessing
{
	
	private static Connection connection;
	private static Statement statement;
	@SuppressWarnings("unused")
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	@SuppressWarnings("unused")
	private static ResultSetMetaData metaData;
	@SuppressWarnings("unused")
	private static int numberOfRows;
	private static boolean connectedToDatabase = false;
	
	/**
	 * connect to the database
	 * @param driverName
	 * @param url
	 * @param user
	 * @param password
	 * @throws Exception
	 */
	public static boolean connectToDatabase(String driverName, String url, String user, String password) 
			throws Exception
    {
		Class.forName(driverName);		//load database driver class
		
        connection=DriverManager.getConnection(url, user, password);   // connect to database
        connectedToDatabase = true;
        return true;
    }
	
	/**
	 * disconnect from the database
	 */
	public static void disconnectFromDatabase() 
	{   //关闭连接，释放资源
		if ( connectedToDatabase )
		{
			// close Statement and Connection
			try
			{                                            
	            resultSet.close();                        
	            statement.close();                        
	            connection.close();                       
	        }
			catch ( SQLException sqlException )
			{                                            
	            sqlException.printStackTrace();           
	        }
			finally
			{                                            
	            connectedToDatabase = false;              
	        }
		}
		//TODO add else
	}
	
	
	/**
	 * i dont konw :)
	 * @param query
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	@SuppressWarnings("unused")
	private static void setQuery(String query) 
			throws SQLException, IllegalStateException
	{

		if ( !connectedToDatabase )
			throw new IllegalStateException( "Not Connected to Database" );

		// specify query and execute it
		resultSet = statement.executeQuery( query );

		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();//获取数据库的元信息，得到结果集的结构信息，比如字段数、字段名等

		// determine number of rows in ResultSet
		resultSet.last();                   // move to last row
		numberOfRows = resultSet.getRow();  // get row number
   } 


	/**
	 * search for the doc in database
	 * it will return a string
	 * @param DocID
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public static String searchDoc(String DocID) 
			throws SQLException,IllegalStateException 
	{
		String temp=null;
		if ( !connectedToDatabase )
	        throw new IllegalStateException( "Not Connected to Database" );
		
		statement = connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_READ_ONLY );
		String sql="select * from doc where Id='"+DocID+"'";
		resultSet = statement.executeQuery(sql);
		
		if (resultSet.next()){
			String ID=resultSet.getString("Id");
			String creator=resultSet.getString("creator");
			Timestamp timestamp=resultSet.getTimestamp("timestamp");
			String description=resultSet.getString("description");
			String filename=resultSet.getString("filename");
			temp=ID+","+creator+","+timestamp+","+description+","+filename;
		}
		return temp;
	}
	
	/**
	 * 登录接口
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public static String searchUser(String name,String password) 
			throws SQLException,IllegalStateException 
	{
//		String temp=null;
		String temp=null;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		statement = connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_READ_ONLY );
		String sql="select * from user where name='"+name+"'";
		resultSet = statement.executeQuery(sql);
		if(resultSet.next())
		{
//			String Name=resultSet.getString("name");
			String Role=resultSet.getString("role");
			String Password=resultSet.getString("password");
//			System.out.println(Role+Password);
			if(Password.equals(password))
			{
				if(Role.equals("administrator"))
				{
					temp="administrator";
				}
				else if(Role.equals("operator"))
				{
					temp="operator";
				}
				else if(Role.equals("browser"))
				{
					temp="browser";				
				}
			}
		}
		return temp;
	}
	
	/**
	 * add user to the database
	 * @param name
	 * @param password
	 * @param role
	 * @return
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public static boolean insertUser(String name, String password, String role) 
			throws SQLException,IllegalStateException
	{
		Statement st;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		st= connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_UPDATABLE);
		String sql="insert into user values ('"+name+"','"+password+"','"+role+"')";
		st.execute(sql);
		return st.getUpdateCount()>0;
	}

	/**
	 * delete user from the data base
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public static boolean deleteUser(String name) 
			throws SQLException,IllegalStateException
	{
		Statement st;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		st= connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_UPDATABLE);
		String sql="delete from user where name='"+name+"'";
		st.execute(sql);
		return st.getUpdateCount()>0;
	}

	/**
	 * update user info of the data base
	 * @param name
	 * @param password
	 * @param role
	 * @return
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public static boolean updateUser(String name, String password, String role)
			throws SQLException,IllegalStateException
	{
		Statement st;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		st= connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_UPDATABLE);
		String sql="update user set password='"+password+"' where name='"+name+"'";
		st.execute(sql);
		return st.getUpdateCount()>0;
	}
	
	public static String getAllUser()
			throws SQLException,IllegalStateException
	{
		Statement st;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		st= connection.createStatement(                 //执行静态SQL语句
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    //可滚动的结果集,只读的结果集，可以调用resultSet.next();resultSet.first()等
		         ResultSet.CONCUR_UPDATABLE);
		String sql="select * from user";
		//TODO check if there is a wrong
		st.execute(sql);
		resultSet = statement.executeQuery(sql);
		String name;
		String password;
		String role;
		String alluser ="";
		while(resultSet.next())
		{
			name=resultSet.getString("name");
			password=resultSet.getString("password");
			role=resultSet.getString("role");
			alluser=alluser+name+"\t"+password+"\t"+role+",";
		}
		return alluser;
	}

	
	
	public static String getAllDocs() throws 
			SQLException,IllegalStateException
	{		
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
		
		statement = connection.createStatement( 
		         ResultSet.TYPE_SCROLL_INSENSITIVE,
		         ResultSet.CONCUR_READ_ONLY );
		String sql="select * from doc";
		resultSet = statement.executeQuery(sql);
		
		String ID;
		String creator;
		String timestamp;
		String description;
		String filename;
		String allDoc="";
		while (resultSet.next()){
			ID=resultSet.getString("Id");
			creator=resultSet.getString("creator");
			timestamp=resultSet.getString("timestamp");
			description=resultSet.getString("description");
			filename=resultSet.getString("filename");
			allDoc=allDoc+ID+"\t"+creator+"\t"+timestamp+"\t"+description+"\t"+filename+",";
		}
		return allDoc;
	} 
	
	public static boolean insertDoc(String ID, String creator, String timestamp,
			String description, String filename) 
			throws SQLException,IllegalStateException
	{
		Statement st;
		if ( !connectedToDatabase ) 
	        throw new IllegalStateException( "Not Connected to Database" );
				
		String sql="INSERT INTO doc values ('"+ID+"','"+creator+"','"+timestamp
				+"','"+description+"','"+filename+"','path')";
		st= connection.createStatement(
		         ResultSet.TYPE_SCROLL_INSENSITIVE,    
		         ResultSet.CONCUR_UPDATABLE );
		st.execute(sql);
		return st.getUpdateCount()>0;		
	}
}
	


