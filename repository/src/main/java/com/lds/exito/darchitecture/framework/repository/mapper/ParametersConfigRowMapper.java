package com.lds.exito.darchitecture.framework.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lds.exito.darchitecture.framework.domain.ParametersConfig;

public class ParametersConfigRowMapper implements RowMapper<ParametersConfig>{

	@Override
	public ParametersConfig mapRow(ResultSet rs, int rowNum) throws SQLException {
		ParametersConfig pc = new ParametersConfig();
		
		pc.setId(rs.getLong("ID_PARAMETER"));
		pc.setDescripcionGroup(rs.getString("DESCRIPTION_GROUP"));
		pc.setDescripcionParameter(rs.getString("DESCRIPTION_PARAMETER"));
		pc.setGroupId(rs.getString("ID_GROUP"));
		pc.setParameterName(rs.getString("PARAMETER_NAME"));
		pc.setParameterValue(rs.getString("PARAMETER_VALUE"));
		
		return pc;
	}

}
