package com.wangbo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangbo.entity.ProductTable;
import com.wangbo.util.IObjectMap;
import com.wangbo.util.JdbcTemplate;

public class ProductTableDao {
	public List<ProductTable> list(){
		List<ProductTable>  list = new ArrayList<>();
		
		try {
			list = JdbcTemplate.executeQuery("select s.s_id,s.s_name,a.a_nums,a.a_nums*a.a_amount AS price,a.a_unit from account a,supplier s where s.s_name = a.s_name", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new ProductTable(rs.getInt("s_id"), rs.getString("s_name"),rs.getInt("a_nums"), rs.getDouble("price"), rs.getString("a_unit"));
				}
			}, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
