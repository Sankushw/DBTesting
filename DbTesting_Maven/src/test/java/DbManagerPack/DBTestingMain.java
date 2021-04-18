package DbManagerPack;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.mysql.cj.protocol.Resultset;

public class DBTestingMain {

	public static void main(String[] args) throws AddressException, ClassNotFoundException, SQLException, MessagingException {
		//String query="SELECT * FROM studentsdb.students";
		String query="SELECT url FROM studentsdb.students where student_id='120'";
		DbManager db=new DbManager();
		db.setMysqlDbConnection();
		ResultSet resultset=db.getMysqlQuery(query);
		
		ResultSetMetaData rsmd = resultset.getMetaData();
		int columnsCount = rsmd.getColumnCount();
		System.out.println("number of columns= "+columnsCount);
		
		// Iterate through the records(rows) in the result set and display it. 
		while (resultset.next())
		{
			//Print one row          
			for(int i = 1 ; i <= columnsCount; i++)
			{
				System.out.print("("+ rsmd.getColumnName(i)+")" + " " +resultset.getString(i));
				System.out.print("\t");
			}
			System.out.println();//Move to the next line to print the next row.           

		}

	}

}
