package com.lds.exito.darchitecture.framework.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lds.exito.darchitecture.framework.domain.Component;

public class ComponentRowMapper implements RowMapper<Component> {

	@Override
	public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
		Component c = new Component();
		c.setId(rs.getInt("ID_COMPONENT"));
		c.setComponentName(rs.getString("COMPONENT_NAME"));
		c.setAlias(rs.getString("PROPERTY_NAME"));
		return c;
	}

}
