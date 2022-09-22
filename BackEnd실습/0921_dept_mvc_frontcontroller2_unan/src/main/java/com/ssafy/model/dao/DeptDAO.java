package com.ssafy.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.db.util.DBUtil;
import com.ssafy.model.dto.Dept;

public class DeptDAO {

	public int insertDept(Dept dept) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		try {
			// step2
			conn = DBUtil.getConnection();

			// step3
			pstmt = conn.prepareStatement(sql);

			// step4
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			int rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt+" 행이 처리되었습니다.");

			return rowCnt;
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}

	public List<Dept> selectDepts() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept> list = new ArrayList<Dept>();

		String sql = "select deptno,dname,loc from dept";
		try {
			// step2
			conn = DBUtil.getConnection();

			// step3
			pstmt = conn.prepareStatement(sql);

			// step4
			rs = pstmt.executeQuery();

			// step5

			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			return list;
		}finally {
			DBUtil.close(pstmt, conn, rs);
		}
	}

	public Dept selectDept(int deptNo) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where deptno = ?";
		Dept dept = null;
		try {
			// step2
			conn = DBUtil.getConnection();

			// step3
			pstmt = conn.prepareStatement(sql);

			// step4
			pstmt.setInt(1, deptNo);
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
			return dept;
		}finally {
			DBUtil.close(pstmt, conn, rs);
		}
	}

	public boolean deleteDept(int deptNo) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "delete from dept where deptno = ?";

		try {
			// step2
			conn = DBUtil.getConnection();

			// step3
			pstmt = conn.prepareStatement(sql);

			// step4
			pstmt.setInt(1, deptNo);
			cnt = pstmt.executeUpdate();

			return cnt > 0;
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}

	public boolean updateDept(Dept dept) throws SQLException
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "update dept set dname=?, loc=? where deptno = ?";

		try {
			// step2
			conn = DBUtil.getConnection();

			// step3
			pstmt = conn.prepareStatement(sql);

			// step4
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptNo());
			cnt = pstmt.executeUpdate();

			return cnt > 0;
		}finally {
			DBUtil.close(pstmt, conn);
		}
	}
}
