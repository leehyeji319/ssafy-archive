package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.model.dto.Product;
import com.ssafy.sample.util.DBUtil;

public class ProductDAO {

	private DBUtil dbUtil = DBUtil.getInstance();

	public int insertProduct(Product product) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into product(code,model,price) values(?,?,?)";

		try {
			conn = dbUtil.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			int res = pstmt.executeUpdate();

			return res;

		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public List<Product> getProductList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		ArrayList<Product> productList = new ArrayList<>();

		String sql = "select code,model,price from product";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				productList.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return productList;
	}

	public Product getProduct(String code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Product product = null;

		String sql = "select code, model, price from product where code=?";
		System.out.println(code);
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
			return product;

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

	public int removeProduct(String code) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from product where code=?";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, code);
			System.out.println(code);

			int rowCnt = pstmt.executeUpdate();

			System.out.println(rowCnt + "이/가 삭제되었습니다.");

			return rowCnt;
		} finally {
			dbUtil.close(pstmt, conn);
		}

	}
}
