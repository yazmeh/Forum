package pack21;
import static pack2.Connector.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pack2.Connector;
public class QueriesA {
		PreparedStatement pst;
		
	 public QueriesA() {
			new Connector();
		}
	public boolean insert(int qid,String ans,String author) throws SQLException
	 {
		 pst=con.prepareStatement("insert into ans (ansname,qid,aauthor) values (?,?,?)");
		 pst.setString(1, ans);
		 pst.setInt(2,qid);
		 pst.setString(3,author);
		 int re =  pst.executeUpdate();
		 System.out.println("Rows Effected : " + re);
		 return re==1;
	 }
	 public boolean delete(int id) throws SQLException
	 {
		 pst=con.prepareStatement("delete from employee where id = ?;");
		 pst.setInt(1, id);
		 int re=  pst.executeUpdate();
		 System.out.println("Rows Deleted : " + re);
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
		 return re==1;
	 }
	 public String[] search(int id) throws SQLException
	 {
		 pst=con.prepareStatement("select * from employee where id =?;");
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
		 return an;
	 }
	 public String[][] viewAll(int qid) throws SQLException
	 {
		 PreparedStatement pst= con.prepareStatement("select count(*) from ans where qid=?;");
		 pst.setInt(1, qid);
		 ResultSet rs=  pst.executeQuery();
		 rs.next();
		 String[][] an;
		 if(rs.getInt(1)>0)
		 {
			 an = new String[rs.getInt(1)][3];
			 pst=con.prepareStatement("select * from ans where qid=?;");
			 pst.setInt(1, qid);
			 rs=  pst.executeQuery();
			 System.out.println("Id\t|\tName\t|\tSalary");
			 int i=0;
			 while(rs.next())
			 {
				 an[i][0]=rs.getString(1);
				 an[i][1]=rs.getString(3);
				 an[i][2]=rs.getString(4);
				 i++;
			 }
		 }
		 else
		 {
			 an=null;
		 }
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
		 return false;
	 }
}
