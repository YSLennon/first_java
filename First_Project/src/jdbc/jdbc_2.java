package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_2 {
	
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 해당 db의 ip ; 1521 = portNumber ; xe =
																	// version
			String db_id = "SYSTEM";
			String db_pw = "test1234";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
//			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();

			insertQuery(stmt);
//			String query = "insert into student(stu_no, stu_name) values(12345678, '홍길동')";
//			stmt.executeUpdate(query);

			ResultSet rs = stmt.executeQuery("select * from student");
			printData(rs);
			System.out.println("\"안녕\"\n하세요");

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}

	}
	
	private static void printData(ResultSet srs) throws SQLException {
		while (srs.next()) {
			System.out.print(srs.getString("stu_name"));
			System.out.print("\t|\t" + srs.getString("stu_no"));
			System.out.println("\t|\t" + srs.getString("stu_dept"));
		}
	}

	private static void insertQuery(Statement stmt) throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.print("이름을 입력하세요 >> ");
		String name = scan.next();

//		String query = "insert into student(stu_name, stu_no) values(" + name + ", " + no + ")";
//		stmt.executeUpdate(query);
		while (true) {
			System.out.print("학번을 입력하세요 >> ");
			int stu_no = scan.nextInt();

			ResultSet rs = stmt.executeQuery("select stu_no from student where stu_no =" + stu_no);

			if (rs.next()) {
				System.out.println("이미 있는 학번입니다.");
			} else {

				System.out.println("가입되었습니다!");
				String query = "insert into student(stu_name, stu_no) values('" + name + "', " + stu_no + ")";
				stmt.executeUpdate(query);
				break;
			}

		}

	}


}
