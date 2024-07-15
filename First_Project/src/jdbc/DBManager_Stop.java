package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 재미로 만들어보려 했으나 실용성이 너무 없어서 기각하기로 함
// 더 의미있는 DB 관련 코드로 다음에 다시 짜보자

// 제대로 설계 먼저 해보자
public class DBManager_Stop {
	// TODO: 패러미터로 where 값 같은것을 추가로 받아 분할해서 양식에 맞는 데이터로 뽑는 알고리즘 만들기!
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DBManager_Stop db = new DBManager_Stop();
		ArrayList<HashMap<String, String>> selectList = new ArrayList<>();

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
//					db.createTable(stmt, input);

					continue;

				} else if (input.equals("2")) {
					System.out.println("Table 조회 문구를 입력해주세요: ");

					input = scan.nextLine();

					db.printData(stmt, input);

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
// 검증 코드 : select stu_name, stu_dept from student
//	create table student(a, b, c, d, ) 
// TODO 새로 만든 Table은 HashMap 형태로 담아서 리스트에 추가하기! 이름 - 타입으로 정리

	private void createTable(Statement stmt, String input) throws SQLException {
		HashMap<String, String> map = new HashMap<>();
		stmt.executeUpdate(input);

		System.out.println("Table 업데이트 문구를 입력해주세요: ");
		String[] seprateTableName = input.split("(");
		String tableName = seprateTableName[0].substring(seprateTableName[0].trim().lastIndexOf(" ") + 1);
		map.put("tableName", tableName);

		String columnString = seprateTableName[1];
		columnString = columnString.substring(0, columnString.length() - 1);

		String[] columnArr = columnString.split(",");
		for (String column : columnArr) {
			String[] arr = column.split(" ");
			map.put(arr[0], arr[1]);
		}

//		 create table student ( a char primarykey, a number , dddd etc ,  )

		if (columnArr.length <= 10) {
			String query = "insert into adbmanager values( tableName " + tableName;
			for (int i = 0; i < columnArr.length; i++) {
				query = "value" + columnArr[i];

			}
			stmt.executeUpdate(query);

		} else {
			System.out.println("업데이트 할 수 없습니다.");
		}

	}

	private void printData(Statement stmt, String input) throws SQLException {
		String query;

		ResultSet rs = stmt.executeQuery(input);

		int selectIndex = input.indexOf("select");
		int fromIndex = input.indexOf("from");

		String[] strArr = input.substring(selectIndex + 6, fromIndex).split(",");
		System.out.println(Arrays.toString(strArr));
		while (rs.next()) {
			for (String column : strArr) {
				column.trim();
				System.out.println(rs.getString("stu_name"));
//				System.out.print("\t" + rs.getString(column));
			}
			System.out.println();

		}
	}

}