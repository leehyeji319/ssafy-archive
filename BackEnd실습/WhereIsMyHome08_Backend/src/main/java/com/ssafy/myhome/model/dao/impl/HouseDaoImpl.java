package com.ssafy.myhome.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.myhome.model.dao.HouseDao;
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
		String sql = "select a.aptcode, dealAmount, dealYear, dealMonth, dealDay, area, floor, type, aptName, dongCode, dongname, lat, lng\r\n"
				+ "from housedeal a, houseinfo b\r\n"
				+ "where b.dongCode = ? and a.aptcode = b.aptcode;";
		
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

}
