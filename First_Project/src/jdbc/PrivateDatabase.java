package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

		//TODO 데이터베이스에 관리 메서드 만들기 테이블 생성 메서드, 테이블에 접근해서 칼럼을 생성, 삭제, 교체하는 메서드 만들어보기	
public class PrivateDatabase {

	public static void main(String[] args) {
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

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}

	}

	String columnName = "num_char(8)_primarykey,name_varchar(12),dept_varchar(20)";

//	 테이블만들때 필요한 조건 -> 테이블 명, 컬럼의 이름들
//	테이블의 param -> smst, tableName, columnName: String
	private void createTable(Statement stmt, String tableName, String columnName) throws SQLException {
		// columnName의 경우 name_type_primary로 만든다.
		String[] columnArr = columnName.split(",");
		String query = "create table" + tableName + "(" + columnName + ")";

		// query 내부 값 넣기

		stmt.executeUpdate("");
	}
}
