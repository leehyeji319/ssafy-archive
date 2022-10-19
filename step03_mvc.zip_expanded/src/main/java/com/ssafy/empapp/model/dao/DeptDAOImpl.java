package com.ssafy.empapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.util.DBUtil;

@Repository("deptDao")
public class DeptDAOImpl implements DeptDAO {
	
	@Override
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
			
			return rowCnt;
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public List<Dept> selectDepts() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept> list = new ArrayList<>();
		
		String sql = "select deptno, dname, loc from dept";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			rs = pstmt.executeQuery();
			
			// step5
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		
		return list;
	}

		@Override
		public Dept selectDept(int deptNo) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Dept dept = null;
			
			String sql = "select deptno, dname, loc from dept where deptno = ?";
			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptNo);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
			} finally {
				DBUtil.close(rs, pstmt, conn);
			}
			
			return dept;
		}
		
		@Override
		public int deleteDept(int deptNo) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "delete from dept where deptno = ?";
			
			try {
				conn = DBUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deptNo);
				int rowCnt = pstmt.executeUpdate();
				
				return rowCnt;
			} finally {
				DBUtil.close(pstmt, conn);
			}
		}
		
		@Override
		public int updateDept(Dept dept) throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			try {
				// step2
				conn = DBUtil.getConnection();
				
				// step3
				pstmt = conn.prepareStatement(sql);
				
				// step4
				pstmt.setString(1, dept.getDname());
				pstmt.setString(2, dept.getLoc());
				pstmt.setInt(3, dept.getDeptNo());
				int rowCnt = pstmt.executeUpdate();
				
				return rowCnt;
			} finally {
				DBUtil.close(pstmt, conn);
			}
		}
}

