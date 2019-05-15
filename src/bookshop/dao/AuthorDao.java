package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVo;

public class AuthorDao {
	public Boolean insert(AuthorVo vo) {

		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. statement 객체 생성
			String sql = "insert into author values(null,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 위의 ?를 받기 위한 바인딩 작업 
			pstmt.setString(1, vo.getName());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					// 연결 종료
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public List<AuthorVo> getList() {
		List<AuthorVo> result = new ArrayList<AuthorVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. statement 객체 생성
			String sql = "select ?, ? from author";
			pstmt = conn.prepareStatement(sql);

			// 4. SQL문 실행
			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			// rs 값 중 다음 값이 없다면 false이므로 while문이 멈춘다.
			while (rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);

				AuthorVo vo = new AuthorVo();
				vo.setNo(no);
				vo.setName(name);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {

				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					// 연결 종료
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	private Connection getConnection() throws SQLException {

		Connection conn = null;
		// 1. JDBC Driver(MariaDB) 로딩
		// 직접 코드로 메소드Area에 로딩할 때
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.1.21:3307/webdb";
			// DriverManager.getConnection을 하면 Connection 인터페이스의 conn이 구현된다.
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}

		return conn;
	}

}
