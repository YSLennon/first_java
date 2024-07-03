package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_3 {
	static Scanner scan = new Scanner(System.in);

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
			stmt = conn.createStatement();

			removeData(stmt);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}

	}

	private static void removeData(Statement stmt) throws SQLException {

		while (true) {

			System.out.print("학번을 입력해주세요 >>");
			int stuNo = scan.nextInt();

			ResultSet rs = stmt.executeQuery("select stu_no from student where stu_no = " + stuNo);
			if (rs.next()) {
				stmt.executeUpdate("delete from student where stu_no =" + stuNo);
				System.out.println("삭제되었습니다.");
				break;
			} else {
				System.out.println("해당 학번은 존재하지 않습니다.");
			}

		}

	}

}
