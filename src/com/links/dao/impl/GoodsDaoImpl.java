package com.links.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.links.bean.Goods;

import com.links.dao.GoodsDao;
import com.links.util.JDBCUtil;

public class GoodsDaoImpl implements GoodsDao {
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pstate = null;
	private ResultSet rs = null;
	private int re = 0;

	/**
	 * 根据商品名字模糊查询
	 * 
	 * @param VAGname
	 *            商品模糊名字
	 * @return list 查询到的商品列表
	 */
	@Override
	public List<Goods> findGoodsByVAGname(String VAGname) {
		// TODO Auto-generated method stub
		Goods goods = null;
		List<Goods> goodslist = new ArrayList<Goods>();
		conn = JDBCUtil.getConnection();
		String sql = "select goodsid,goodsname,goodsprice,goodsamount,goodsinfo,goodsstate from sc_goods where goodsname like '%"
				+ VAGname + "%'";
		try {
			pstate = conn.prepareStatement(sql);
			// pstate.setString(1, VAGname);
			rs = pstate.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getString("goodsid"), rs.getString("goodsname"), rs.getInt("goodsprice"),
						rs.getInt("goodsamount"), rs.getString("goodsinfo"), rs.getInt("goodsstate"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return goodslist;
	}

	/**
	 * 添加商品
	 */
	@Override
	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();
		// String sql = "insert into
		// SC_GOODS(GOODSID,GOODSNAME,GOODSPRICE,GOODSAMOUNT,GOODSINFO,GOODSSTATE)values('12223123','test',123.5,100,null,1)";
		String sql = "insert into SC_GOODS(GOODSID,GOODSNAME,GOODSPRICE,GOODSAMOUNT,GOODSINFO,GOODSSTATE)values(?,?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, goods.getGoodsID());
			pstate.setString(2, goods.getGoodsName());
			pstate.setFloat(3, goods.getGoodsPrice());
			pstate.setInt(4, goods.getGoodsAmount());
			pstate.setString(5, goods.getGoodsInfol());
			pstate.setInt(6, goods.getGoodsState());
			re = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return re > 0;
	}

	/**
	 * 通过商品名字查询商品，用于检验增加商品时商品是否存在
	 */
	@Override
	public Goods findGoodsByName(String name) {
		// TODO Auto-generated method stub
		Goods goods = null;
		conn = JDBCUtil.getConnection();
		String sql = "select goodsid,goodsname,goodsprice,goodsamount,goodsinfo,goodsstate from sc_goods where goodsname =?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, name);
			rs = pstate.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getString("goodsid"), rs.getString("goodsname"), rs.getInt("goodsprice"),
						rs.getInt("goodsamount"), rs.getString("goodsinfo"), rs.getInt("goodsstate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return goods;
	}

	/**
	 * 修改商品的上架，下架状态
	 * 
	 */
	@Override
	public boolean changeGoodsStat(String id, int state) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();
		String sql = "update sc_goods set goodsstate = ? where goodsid=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, state);
			pstate.setString(2, id);
			re = pstate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return re > 0;
	}

	@Override
	public List<Goods> listAllGoods() {
		// TODO Auto-generated method stub
		Goods goods = null;
		List<Goods> goodslist = new ArrayList<Goods>();
		conn = JDBCUtil.getConnection();
		String sql = "select goodsid,goodsname,goodsprice,goodsamount,goodsinfo,goodsstate from sc_goods";
		try {
			pstate = conn.prepareStatement(sql);
			rs = pstate.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getString("goodsid"), rs.getString("goodsname"), rs.getInt("goodsprice"),
						rs.getInt("goodsamount"), rs.getString("goodsinfo"), rs.getInt("goodsstate"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return goodslist;
	}

	/**
	 * 修改商品
	 */
	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();
		String sql = "update sc_goods set goodsname = ?,goodsprice=?,goodsamount=?,goodsstate=? where goodsid=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, goods.getGoodsName());
			pstate.setFloat(2, goods.getGoodsPrice());
			pstate.setInt(3, goods.getGoodsAmount());
			pstate.setInt(4, goods.getGoodsState());
			pstate.setString(5, goods.getGoodsID());

			re = pstate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return re > 0;
	}

	@Override
	public Goods findGoodsById(String id) {
		Goods goods = null;
		conn = JDBCUtil.getConnection();
		String sql = "select goodsid,goodsname,goodsprice,goodsamount,goodsinfo,goodsstate from sc_goods where goodsid =?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, id);
			rs = pstate.executeQuery();
			while (rs.next()) {
				goods = new Goods(rs.getString("goodsid"), rs.getString("goodsname"), rs.getInt("goodsprice"),
						rs.getInt("goodsamount"), rs.getString("goodsinfo"), rs.getInt("goodsstate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return goods;
	}

}
