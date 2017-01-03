package pack21;
import static pack2.Connector.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pack2.Connector;
public class QueriesQ {
		PreparedStatement pst;
		public static int lid;
	 public QueriesQ()  {
			new Connector();
			
			
		}
	 public void ref() throws SQLException {
		 Statement st= con.createStatement();
		 ResultSet rs=  st.executeQuery("select count(*) from ques;");
		 rs.next();
		 lid=rs.getInt(1);
	}
	public boolean insert(String ques,String author) throws SQLException
	 {
		 pst=con.prepareStatement("insert into ques (ques,qauthor,status) values (?,?,?)");
		 pst.setString(1, ques);
		 pst.setString(2,author);
		 pst.setString(3,"Active");
		 int re =  pst.executeUpdate();
		 System.out.println("Rows Effected : " + re);
		 ref();
		 return re==1;

	 }
	 public boolean delete(int id) throws SQLException
	 {
		 pst=con.prepareStatement("delete from employee where id = ?;");
		 pst.setInt(1, id);
		 int re=  pst.executeUpdate();
		 System.out.println("Rows Deleted : " + re);
		 ref();
		 return re==1;
	 }
	 public boolean updateAll(int id,String name,float sal) throws SQLException
	 {
		 pst=con.prepareStatement("update employee set name=?,sal=? where id=? ;");
		 pst.setInt(3, id);
		 pst.setString(1, name);
		 pst.setFloat(2, sal);
		 int re=  pst.executeUpdate();
		 System.out.println("Rows Effected : " + re);
		 ref();
		 return re==1;
	 }
	 public String[] search(int id) throws SQLException
	 {
		 pst=con.prepareStatement("select * from ques where qid =?;");
		 System.out.println(id);
		 pst.setInt(1, id);
		 ResultSet rs=  pst.executeQuery();
		 String[] an =null	;
		 //System.out.println("Id\t|\tName\t|\tSalary");
		 if(rs.next())
		 {
			
			 an =new String[3];
			 an[0]=rs.getString(1);
			 an[1]=rs.getString(2);
			 an[2]=rs.getString(3);
		 }
		 ref();
		 return an;
	 }
	 public String[][] search(String det) throws SQLException
	 {
		 pst=con.prepareStatement("select count(*) from ques where ques LIKE ?;");
		 pst.setString(1, '%'+det+'%');
		 ResultSet rs= pst.executeQuery();
		 rs.next();
		 String[][] an=null;
		 if(rs.getInt(1)!=0)
		 {	 
			 an = new String[rs.getInt(1)][4];
		 }
		 pst=con.prepareStatement("select * from ques where ques LIKE ?;");
		 pst.setString(1, '%'+det+'%');
		 rs= pst.executeQuery();
		 int i=0;
		 //System.out.println("Id\t|\tName\t|\tSalary");
		 while(rs.next())
		 {
			
			 an[i][0]=rs.getString(1);
			 an[i][1]=rs.getString(2);
			 an[i][2]=rs.getString(3);
			 an[i][3]=rs.getString(4);
			 System.out.println(an[i][0]+"\t" +an[i][1]+"\t"+an[i][2]+"\t"+an[i][3]);
			 i++;
		 }
		 ref();
		 return an;
	 }
	 public String[][] viewAll() throws SQLException
	 {
		 Statement st= con.createStatement();
		 ResultSet rs=  st.executeQuery("select count(*) from ques;");
		 rs.next();
		 String[][] an = new String[rs.getInt(1)][4];
		 rs=  st.executeQuery("select * from ques;");
		 System.out.println("Id\t|\tName\t|\tSalary");
		 int i=0;
		 while(rs.next())
		 {
			 an[i][0]=rs.getString(1);
			 an[i][1]=rs.getString(2);
			 an[i][2]=rs.getString(3);
			 an[i++][3]=rs.getString(4);
		 }
		 ref();
		 return an;
	 }
	 public boolean check(String id,String pwd) throws SQLException
	 {
		 
		 pst=con.prepareStatement("select * from login where user =?;");
		 pst.setString(1, id);
		 ResultSet rs=  pst.executeQuery();
		 while(rs.next())
		 {
			 if(rs.getString(3).equals(pwd))
			  return true;
		 }
		 ref();
		 return false;
	 }
}
