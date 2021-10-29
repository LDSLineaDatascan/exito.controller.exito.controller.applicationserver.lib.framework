package com.lds.exito.darchitecture.framework.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lds.exito.darchitecture.framework.domain.ComponentProperty;

public class ComponentPropertyRowMapper implements RowMapper<ComponentProperty> {

	@Override
	public ComponentProperty mapRow(ResultSet rs, int rowNum) throws SQLException {
		ComponentProperty cp = new ComponentProperty();

		cp.setPropertyName(rs.getString("PROPERTY_NAME"));
		cp.setPropertyValue(rs.getString("PROPERTY_VALUE"));
		cp.setId(rs.getInt("ID_PROPERTY"));

		return cp;
	}

}
