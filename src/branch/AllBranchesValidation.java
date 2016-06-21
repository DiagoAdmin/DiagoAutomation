package branch;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import config.Reading_Properties;
import databaseConnections.SqlConnection;


public class AllBranchesValidation
{
	public String DiagoLogin() throws Exception{
		
		try
		{
			List list=null;
			Boolean flag = true;
			String columnval1 = "";
			if (flag)
			{
				Connection conn = SqlConnection.dbConnect();
				Statement statement = conn.createStatement();
				Reading_Properties rp=new Reading_Properties();
				

				String allbrnch=rp.getPropertyValue("allbranches");
		
				ResultSet rs = statement.executeQuery(allbrnch);
			
								
			
				ResultSetMetaData metadata = rs.getMetaData();
				int columnCount = metadata.getColumnCount();
				
				for (int i=0; i<=columnCount; i++)
				{
					if(i!=0)
					{
						columnval1 = ","+columnval1;
					
					}
					while(rs.next())
					{
						columnval1=rs.getString(2);
						}
				
					
					}
				
				}
			return columnval1;
			}
		catch (Exception e)
		{
			e.printStackTrace();
			return e.toString();
			}

		}
	
	}