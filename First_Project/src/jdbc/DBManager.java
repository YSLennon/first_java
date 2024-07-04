package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class DBManager {
	 //TODO: 패러미터로 where 값 같은것을 추가로 받아 분할해서 양식에 맞는 데이터로 뽑는 알고리즘 만들기!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBManager db = new DBManager();
		ArrayList <String> selectList;
		
		Connection conn;
		Statement stmt = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 해당 db의 ip ; 1521 = portNumber
																	// xe = version
			String db_id = "SYSTEM";
			String db_pw = "test1234";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
			stmt = conn.createStatement();
			while (true) {
				System.out.println("1. 테이블 생성 및 업데이트 2. 조회하기 etc. 종료");
				String input = scan.nextLine();
				if (input.equals("1")) {
					System.out.println("Table 업데이트 문구를 입력해주세요: ");
					input = scan.nextLine();
					stmt.executeUpdate(input);
					continue;

				} else if (input.equals("2")) {
					System.out.println("Table 조회 문구를 입력해주세요: ");
					input = scan.nextLine();
					ResultSet rs = stmt.executeQuery(input);
					db.printData(rs);
					continue;

				} else {
					System.out.println("시스템이 종료되었습니다.");
					break;
				}

			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}

	}
	
	private void printData(ResultSet rs) throws SQLException {
		while(rs.next()) {
			System.out.println(rs.getString("stu_name")); 
		}
	}

}