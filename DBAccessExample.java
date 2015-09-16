import java.sql.*;
public class DBAccessExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// ����JDBC-ODBC�ż�ODBC��������
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException ex1) {
			// ��׽�쳣ClassNotFoundException
			// ��Ҫ���ص���������û�ҵ�ʱ�����쳣���׳�
			System.out.println("���ص���������û�ҵ�" + ex1.toString());
		}
		
		try {
			// ����ָ�����ݿ��URL
			String strurl = "jdbc:odbc:zxl";
			// ������ODBC����Դʱ��ȥ���������ǰ��ע�ͷ���ע�͵�ǰ�����
			
			// DBQ=D:\\inoutManager\\ManagerDB.mdb";
			/*
			 * ���趨�����ݿ�URL����"jdbc:odbc:AccessManagerDB"�� �������ݿ����Ӷ���
			 */
			Connection conn = DriverManager.getConnection(strurl);
			// ����ָ��ResultSet���Ե�Statement����
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// ����Ҫִ�е�SQL��ѯ���strsqlQuery
			String strsqlQuery = "SELECT no,name,age from  student";
			// ִ����ʾ��SQL��䣬���ؽ����
			ResultSet rs = stmt.executeQuery(strsqlQuery);
			// �������ڽ��ս�����и��е�ֵ�ı���
			//int i_id;
			String s_name;
			int i_age;			
			//String s_comment;
			// �ƶ��α�ֱ�����һ����¼�����ÿ�м�¼
			while (rs.next()) {
				// ȡ���α������м�¼����ֵ
			//	i_id = rs.getInt("no");				
				s_name = rs.getString("name");
				i_age=rs.getInt("age");
				// ��ÿ�еĸ���ֵȡ���ϲ�ΪһString��������������Ʊ�����
				System.out.println("\t"  + "\t"  + s_name+
						 "\t" + i_age+ "\n");
			}
			rs.close();    // �ͷŽ��������
			// �趨�й�ɾ����SQL��䣻ɾ����Ʒ���Ϊ0��   ���ļ�¼
			String strsqlDelete = "DELETE  FROM  student  WHERE no ='1' ";
			stmt.executeUpdate(strsqlDelete); // �����ݿ��ύ�趨��SQL���
			/**********
			 * �趨�йز����SQL��䣻
			 **********/
			String strsqlInsert = "INSERT INTO zxl(people, data,thing) values('zxl','2015/03/25','xx')";
			stmt.executeUpdate(strsqlInsert); // �����ݿ��ύ�趨��SQL���
			/**********
			 * �趨�йظ��µ�SQL��䣻�޸���Ʒ���Ϊ1�ļ�¼�� ����ֵ��SQL�����ʾ
			 **********/
			String strsqlUpdate = "UPDATE student set name='hu' where no='1' ";
			stmt.executeUpdate(strsqlUpdate); // �����ݿ��ύ�趨��SQL���
			stmt.close(); // �ͷ�
			conn.close(); // �ͷ�
		} catch (SQLException ex2) { // ��׽�쳣SQLException
			System.out.println(" SQLException " + ex2.toString());

		}
	}

}
