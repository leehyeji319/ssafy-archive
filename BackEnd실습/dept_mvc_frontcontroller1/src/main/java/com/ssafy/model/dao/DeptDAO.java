package com.ssafy.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

//Model: DAO(Data Access Login)
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
		} finally {
			
			DBUtil.close(pstmt);
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
			
		} finally {
			DBUtil.close(rs, pstmt, conn);
			
		}
		return list;
		
		
	}
	
	
	//부서번호에 해당하는 부서 가져오기
	public Dept selectDept(int deptno) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Dept dept = null;

        String sql = "select deptno,dname,loc from dept where deptno = ?";
        try {
            // step2
        	conn = DBUtil.getConnection();
            // step3
            pstmt = conn.prepareStatement(sql);

            // step4
            pstmt.setInt(1, deptno);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            // step5
        } finally {
        	DBUtil.close(rs, pstmt, conn);
            
        }

        return dept;


    }		
		//부서번호 주면 삭제하기
		public int deleteDept(int deptNo) throws SQLException{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "delete from dept where deptno = ?";
			
			try {
				// step2
				conn = DBUtil.getConnection();			
				// step3
				pstmt = conn.prepareStatement(sql);
				
				//step4
				pstmt.setInt(1, deptNo);
				int rowCnt = pstmt.executeUpdate();
				System.out.println(deptNo + " 삭제하였습니다.");
				
				return rowCnt;
							
			} finally {
				DBUtil.close(pstmt, conn);
			}
		}
		
		public int updateDept(Dept dept) throws SQLException{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update dept set dname = ? ,loc = ? where deptno = ?";
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
				System.out.println(rowCnt + "행이 처리되었습니다.");
				return rowCnt;
				
				
			} finally {
				DBUtil.close(pstmt, conn);
				
			}
		}
		
}
