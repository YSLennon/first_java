package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_4 {
	Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Jdbc_4 jd = new Jdbc_4();

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
			jd.menu(stmt);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}

	}

	private void menu(Statement stmt) throws SQLException {
		Jdbc_4 jd = new Jdbc_4();

		while (true) {
			System.out.print("추가(1), 삭제(2), 수정(3), 확인(4), 끝내기(5)>>");
			int input = jd.scan.nextInt();
			try {
				if (input == 1) {
					jd.insertTable(stmt);
				} else if (input == 2) {
					jd.deleteData(stmt);

				} else if (input == 3) {
					jd.changeData(stmt);

				} else if (input == 4) {
					jd.printData(stmt);
				} else if (input == 5) {
					System.out.println("종료되었습니다.");
					break;
				}

			} catch (IllegalArgumentException e) {
				System.out.println("숫자를 입력해주세요");
			}

		}
	}

	private String inputData(String str) {
		Jdbc_4 jd = new Jdbc_4();
		System.out.print(str + " 입력 : ");

		return jd.scan.nextLine();
	}

	private boolean existId(Statement stmt, String id) throws SQLException {

		ResultSet rs = stmt.executeQuery("select ID from tbl_student where id = '" + id + "'");
		if (rs.next())
			return true;
		else {
			return false;
		}

	}

	private void insertTable(Statement stmt) throws SQLException {
		Jdbc_4 jd = new Jdbc_4();

		String id = jd.inputData("아이디");
		if (jd.existId(stmt, id)) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else {
			String name = jd.inputData("이름");
			String dept = jd.inputData("학번");

			String query = "insert into TBL_STUDENT values ('" + id + "','" + name + "','" + dept + "')";

			stmt.executeUpdate(query);
			System.out.println("추가되었습니다.");
		}
	}

	private void deleteData(Statement stmt) throws SQLException {
		Jdbc_4 jd = new Jdbc_4();

		String id = jd.inputData("아이디");
		if (jd.existId(stmt, id)) {
			String query = "delete from TBL_STUDENT where ID = '" + id + "'";
			stmt.executeUpdate(query);
		} else
			System.out.println("존재하지 않는 아이디입니다.");

	}

	private void changeData(Statement stmt) throws SQLException {
		Jdbc_4 jd = new Jdbc_4();

		String id = jd.inputData("아이디");
		if (jd.existId(stmt, id)) {
			String dept = jd.inputData("수정할 학과");
			String query = "update TBL_STUDENT set DEPT = '" + dept + "' where ID = '" + id + "'";
			stmt.executeUpdate(query);
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	private static void printData(Statement stmt) throws SQLException {
		Jdbc_4 jd = new Jdbc_4();
		ResultSet rs = stmt.executeQuery("select * from TBL_STUDENT");

		while (rs.next()) {
			System.out.println(rs.getString("ID") + " |\t" + rs.getString("NAME") + "\t|\t" + rs.getString("DEPT"));
		}

	}
//\"SYSTEM\".
}
