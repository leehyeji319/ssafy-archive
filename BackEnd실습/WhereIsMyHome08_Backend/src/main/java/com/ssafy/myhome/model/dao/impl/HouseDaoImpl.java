package com.ssafy.myhome.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.myhome.model.dao.HouseDao;
import com.ssafy.myhome.model.dto.HouseDealDto;
import com.ssafy.myhome.model.dto.HouseInfoDto;
import com.ssafy.myhome.util.DBUtil;

public class HouseDaoImpl implements HouseDao {

	private DBUtil dbUtil = DBUtil.getInstance();
	
	private static HouseDaoImpl instance;
	
	private HouseDaoImpl() {
		
	}
	
	public static HouseDaoImpl getInstance() {
		if (instance == null) {
			instance = new HouseDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<HouseInfoDto> selectHouseList(String dongcode) throws SQLException {
		List<HouseInfoDto> houseList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *\r\n"
				+ "from (select a.aptcode, dealAmount, dealYear, dealMonth, dealDay, area, floor, type, aptName, dongCode, dongname, lat, lng, row_number() over (partition by aptCode order by dealYear desc, dealMonth desc, dealDay DESC) as n\r\n"
				+ "from housedeal a, houseinfo b\r\n"
				+ "where b.dongCode = ? and a.aptcode = b.aptcode\r\n"
				+ "order by aptName) a\r\n"
				+ "where n <= 1\r\n"
				+ "group by aptcode\r\n"
				+ "order by aptName;";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongcode);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				houseList.add(new HouseInfoDto( 
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13)
					));
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return houseList;
	}

	public List<HouseDealDto> selectHouseDeals(int aptcode) throws SQLException {
		List<HouseDealDto> houseDeals = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from housedeal where aptCode = ? order by dealYear desc, dealMonth desc, dealDay desc;";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aptcode);
			rs = pstmt.executeQuery();
			
			int no;
			int aptCode;
			String dealAmount;
			int dealYear;
			int dealMonth;
			int dealDay;
			String area;
			String floor;
			String type;
			String rentMoney;
			
			while (rs.next()) {
				houseDeals.add(new HouseDealDto( 
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10)
					));
			}
			
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return houseDeals;
	}

}
