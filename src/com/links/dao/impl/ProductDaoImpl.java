package com.links.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.links.bean.Product;
import com.links.bean.ProductType;
import com.links.dao.ProductDao;
import com.links.util.JDBCUtil;

public class ProductDaoImpl implements ProductDao{
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pstate = null;
	private ResultSet rs = null;
	private int rows = 0;
	@Override
	public List<Product> findProductByVAGname(String VAGname) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加商品
	 */
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();//        1    2        3          4     5      6      7      8       9
		String sql = "insert into "
				+"tb_crm_prodect(id,pro_name,pro_code,pro_size,price,pro_use,remark,type_id,state) "
				+"values(?,?,?,?,?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1,product.getId());
			pstate.setString(2, product.getProName());
			pstate.setString(3, product.getProCode());
			pstate.setString(4, product.getProSize());
			pstate.setFloat(5, product.getPrice());
			pstate.setString(6, product.getProUse());
			pstate.setString(7, product.getRemark());
			pstate.setString(8, product.getTypeId());
			pstate.setInt(9, product.getState());
			rows = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return rows > 0;
	}

	@Override
	public Product findProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeProductStat(String id, int state) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();
		String sql = "update TB_CRM_PRODeCT set state = ? where id=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setInt(1, state);
			pstate.setString(2, id);
			rows = pstate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return rows > 0;
	}

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		List<Product> allproducts=new ArrayList<>();
		conn = JDBCUtil.getConnection();
		String sql = "select id,pro_name,pro_code,pro_size,price,pro_use,remark,type_id,state "
					+"from tb_crm_prodect ";

		try {
			pstate = conn.prepareStatement(sql);
			rs=pstate.executeQuery();
			while (rs.next()) {
				 allproducts.add(new Product(rs.getString("id"), rs.getString("pro_name"), rs.getString("pro_code"), rs.getString("pro_size"), rs.getFloat("price"), rs.getString("pro_use"), rs.getString("remark"), rs.getString("type_id"), rs.getInt("state")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return allproducts;
	}
@Test
public void test2(){
	Product product=new Product();
	product.setId("B003");
	product.setProName("被子");
	product.setProCode("156731313464");
	product.setProSize("101");
	product.setPrice((float) 500.0);
	product.setProUse("testtest");
	product.setRemark("test2");
	product.setTypeId("T004");
	System.out.println(updateProduct(product));
}
	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		conn = JDBCUtil.getConnection();
		String sql = "update TB_CRM_PRODECT set pro_name=?,pro_code=?,pro_size=?,price=?,pro_use=?,remark=?,type_id=? where id=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, product.getProName());
			pstate.setString(2, product.getProCode());
			pstate.setString(3, product.getProSize());
			pstate.setFloat(4, product.getPrice());
			pstate.setString(5, product.getProUse());
			pstate.setString(6, product.getRemark());
			pstate.setString(7, product.getTypeId());
			pstate.setString(8, product.getId());
			rows = pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return rows > 0;
	}
	
	@Override
	public Product findProductById(String id) {
		// TODO Auto-generated method stub
		Product product=null;
		conn = JDBCUtil.getConnection();
		String sql = "select a.id pro_id,a.pro_name ,a.pro_code ,a.pro_size,a.price,a.pro_use,a.remark,a.type_id,a.state, "
					+"b.id,b.typename,b.state"
					+" from tb_crm_prodect a "
					+"left join tb_crm_prodecttype b on a.type_id=b.id "
					+"where 1=1 and a.state=1 and a.id =?";

		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, id);
			rs=pstate.executeQuery();
			while (rs.next()) {
				ProductType productType=new ProductType(rs.getString("id"), rs.getString("typename"),rs.getInt("state"));
				product = new Product(rs.getString("pro_id"), rs.getString("pro_name"), rs.getString("pro_code"), rs.getString("pro_size"), rs.getFloat("price"), rs.getString("pro_use"), rs.getString("remark"), rs.getString("type_id"), rs.getInt("state"));
				product.setProductType(productType);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return product;
	}
	
	
	@Override
	public List<Product> findProductAVG(Product product) {
		// TODO Auto-generated method stubGoods goods = null;
		List<Product> products = new ArrayList<Product>();
		try {
		conn = JDBCUtil.getConnection();
		String sql = "select a.id pro_id,a.pro_name ,a.pro_code ,a.pro_size,a.price,a.pro_use,a.remark,a.type_id,a.state, "
							+"b.id,b.typename,b.state "
							+"from tb_crm_prodect a "
							+"left join tb_crm_prodecttype b on a.type_id=b.id "
							+"where 1=1 and a.state=1";
			if (product!=null&&product.getMinPrice()!=0) {
				sql+=" and price >= ?";
			}
			if (product!=null&&product.getMaxPrice()!=0) {
				sql+=" and price <= ?";
			}
			if (product!=null&&product.getTypeId()!=null) {
				sql+="  and a.type_id= ?";
			}
			if (product!=null&&product.getProName()!=null) {
				sql+="  and a.pro_name like ?";
			}
			if (product!=null&&product.getTypeId()!=null) {
				sql+="  and a.type_id = ?";
			}if (product!=null&&product.getProCode()!=null) {
				sql+="  and a.pro_code = ?";
			}
			pstate = conn.prepareStatement(sql);
			int index=1;
			if (product!=null&&product.getMinPrice()!=0) {
				pstate.setFloat(index, product.getMinPrice());
				index++;
			}
			if (product!=null&&product.getMaxPrice()!=0) {
				pstate.setFloat(index, product.getMaxPrice());
				index++;
			}
			if (product!=null&&product.getTypeId()!=null&&product.getTypeId().length()>0) {
				pstate.setString(index, product.getTypeId());
				index++;
			}
			if (product!=null&&product.getProName()!=null) {
				pstate.setString(index, "%"+product.getProName()+"%");
				index++;
			}
			if (product!=null&&product.getTypeId()!=null) {
				pstate.setString(index, product.getTypeId());
				index++;
			}if (product!=null&&product.getProCode()!=null) {
				pstate.setString(index, product.getProCode());
			}
			rs = pstate.executeQuery();
			while (rs.next()) {
				ProductType productType=new ProductType(rs.getString("id"), rs.getString("typename"),rs.getInt("state"));
				Product p = new Product(rs.getString("pro_id"), rs.getString("pro_name"), rs.getString("pro_code"), rs.getString("pro_size"), rs.getFloat("price"), rs.getString("type_id"), rs.getInt("state"), productType);
				p.setProUse(rs.getString("pro_use"));
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return products;
	}
	@Override
	public boolean checkCodeRe(String proCode) {
		// TODO Auto-generated method stub
		String recode=null;
		conn = JDBCUtil.getConnection();
		String sql = "select pro_code  "
					+" from tb_crm_prodect  "
					+"where pro_code=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, proCode);
			rs=pstate.executeQuery();
			while (rs.next()) {
				recode=rs.getString("pro_code");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		if (recode!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
