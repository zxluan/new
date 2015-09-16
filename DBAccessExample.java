import java.sql.*;
public class DBAccessExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// 加载JDBC-ODBC桥加ODBC驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException ex1) {
			// 捕捉异常ClassNotFoundException
			// 若要加载的驱动程序没找到时，此异常被抛出
			System.out.println("加载的驱动程序没找到" + ex1.toString());
		}
		
		try {
			// 设置指定数据库的URL
			String strurl = "jdbc:odbc:zxl";
			// 不配置ODBC数据源时，去掉下面语句前的注释符，注释掉前面语句
			
			// DBQ=D:\\inoutManager\\ManagerDB.mdb";
			/*
			 * 用设定的数据库URL（即"jdbc:odbc:AccessManagerDB"） 创建数据库连接对象
			 */
			Connection conn = DriverManager.getConnection(strurl);
			// 创建指定ResultSet属性的Statement对象
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 设置要执行的SQL查询语句strsqlQuery
			String strsqlQuery = "SELECT no,name,age from  student";
			// 执行所示的SQL语句，返回结果集
			ResultSet rs = stmt.executeQuery(strsqlQuery);
			// 声明用于接收结果集中各列的值的变量
			//int i_id;
			String s_name;
			int i_age;			
			//String s_comment;
			// 移动游标直至最后一条记录，输出每行记录
			while (rs.next()) {
				// 取得游标所在行记录的列值
			//	i_id = rs.getInt("no");				
				s_name = rs.getString("name");
				i_age=rs.getInt("age");
				// 将每行的各列值取出合并为一String对象输出。并以制表符间隔
				System.out.println("\t"  + "\t"  + s_name+
						 "\t" + i_age+ "\n");
			}
			rs.close();    // 释放结果集对象
			// 设定有关删除的SQL语句；删除物品编号为0，   即的记录
			String strsqlDelete = "DELETE  FROM  student  WHERE no ='1' ";
			stmt.executeUpdate(strsqlDelete); // 向数据库提交设定的SQL语句
			/**********
			 * 设定有关插入的SQL语句；
			 **********/
			String strsqlInsert = "INSERT INTO zxl(people, data,thing) values('zxl','2015/03/25','xx')";
			stmt.executeUpdate(strsqlInsert); // 向数据库提交设定的SQL语句
			/**********
			 * 设定有关更新的SQL语句；修改物品编号为1的记录， 其它值如SQL语句所示
			 **********/
			String strsqlUpdate = "UPDATE student set name='hu' where no='1' ";
			stmt.executeUpdate(strsqlUpdate); // 向数据库提交设定的SQL语句
			stmt.close(); // 释放
			conn.close(); // 释放
		} catch (SQLException ex2) { // 捕捉异常SQLException
			System.out.println(" SQLException " + ex2.toString());

		}
	}

}
