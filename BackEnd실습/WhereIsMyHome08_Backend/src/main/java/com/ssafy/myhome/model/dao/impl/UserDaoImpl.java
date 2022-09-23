package com.ssafy.myhome.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.myhome.model.dao.UserDao;
import com.ssafy.myhome.model.dto.UserDto;
import com.ssafy.myhome.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	private DBUtil dbUtil = DBUtil.getInstance();

	private static UserDaoImpl instance;
	
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	@Override
	public void registerUser(UserDto userDto) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into userinfo(userid, password, name, address, phone) \n";
		sql += "values(?,?,?,?,?)";
		
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getUserId());
			pstmt.setString(2, userDto.getUserPwd());
			pstmt.setString(3, userDto.getUserName());
			pstmt.setString(4, userDto.getAddress());
			pstmt.setString(5, userDto.getPhone());
			
			pstmt.execute();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public UserDto login(String userId, String userPwd) throws SQLException {
		
		UserDto userDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select name from userinfo where userid =? and password =?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDto = new UserDto();
				userDto.setUserId(userId);
				userDto.setUserName(rs.getString("name"));
//				System.out.println(rs.getString("name"));
				return userDto;
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return null;
	}

	@Override
	public UserDto getUser(String userId) throws SQLException {
		
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select password, name, address, phone from userinfo \n";
		sql += "where userid = ? ";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDto = new UserDto();
				userDto.setUserId(userId);
				userDto.setUserName(rs.getString("name"));
				userDto.setUserPwd(rs.getString("password"));
				userDto.setAddress(rs.getString("address"));
				userDto.setPhone(rs.getString("phone"));
				return userDto;
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return userDto;
	}

	@Override
	public void updateUser(UserDto userDto) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update userinfo set password = ?, name = ?, address = ?, phone =? \n";
		sql += "where userid = ?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getUserPwd());
			pstmt.setString(2, userDto.getUserName());
			pstmt.setString(3, userDto.getAddress());
			pstmt.setString(4, userDto.getPhone());
			pstmt.setString(5, userDto.getUserId());
			
			pstmt.execute();
			
		} finally {
			
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from userinfo where userid =?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			pstmt.execute();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	
}
