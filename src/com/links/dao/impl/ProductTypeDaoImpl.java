package com.links.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.links.bean.ProductType;
import com.links.dao.ProductTypeDao;
import com.links.util.JDBCUtil;

public class ProductTypeDaoImpl implements ProductTypeDao{
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pstate = null;
	private ResultSet rs = null;
	private int rows = 0;
	@Override
	public boolean createProductType(ProductType productType) {
		conn = JDBCUtil.getConnection();
		String sql = "insert into tb_crm_prodecttype(id,typename,state) values(?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1,productType.getId());
			pstate.setString(2, productType.getTypename());
			pstate.setInt(3, productType.getState());
			rows = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean deleteProductType(String id) {
		conn = JDBCUtil.getConnection();
		String sql = "update tb_crm_prodecttype set state = 1 where id=?";
		try {
			pstate = conn.prepareStatement(sql);
	
			pstate.setString(1, id);
			rows = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductType> getProductTypeList(ProductType productType) {
		List<ProductType> productTypes = new ArrayList<ProductType>();
		conn = JDBCUtil.getConnection();
		String sql = "select id,typename,state from tb_crm_prodecttype";
		try {
			pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
			while (rs.next()) {
				
				productTypes.add(new ProductType(rs.getString("id"), rs.getString("typename"), rs.getInt("state")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return productTypes;
	}

	@Override
	public ProductType getProductTypeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
