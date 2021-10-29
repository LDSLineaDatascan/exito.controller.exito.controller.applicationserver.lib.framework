package com.lds.exito.darchitecture.framework.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lds.exito.darchitecture.framework.domain.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product p = new Product();
		p.setId(rs.getLong("ID_PRODUCT"));
		p.setEnable(rs.getBoolean("ENABLE"));
		p.setPluVariety(rs.getString("PLU_VARIETY"));
		p.setProductName(rs.getString("PRODUCT_NAME"));
		p.setProductType(rs.getString("PRODUCT_TYPE"));
		return p;
	}

}
