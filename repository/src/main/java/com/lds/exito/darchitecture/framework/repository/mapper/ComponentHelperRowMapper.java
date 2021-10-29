package com.lds.exito.darchitecture.framework.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lds.exito.darchitecture.framework.domain.CommunicationProperty;
import com.lds.exito.darchitecture.framework.domain.ComponentProperty;
import com.lds.exito.darchitecture.framework.domain.helper.ComponentHelper;

public class ComponentHelperRowMapper implements RowMapper<ComponentHelper> {

	@Override
	public ComponentHelper mapRow(ResultSet rs, int rowNum) throws SQLException {

		ComponentHelper c = new ComponentHelper();
		c.setId(rs.getInt("ID_COMPONENT"));
		c.setComponentName(rs.getString("COMPONENT_NAME"));
		c.setAlias(rs.getString("ALIAS"));

		CommunicationProperty cmp = new CommunicationProperty();
		cmp.setIdCommunicationProperty(rs.getInt("ID_COMMUNICATION"));
		cmp.setPropertyName(rs.getString("PROPERTY_NAME"));
		cmp.setHostname(rs.getString("HOSTNAME"));
		cmp.setNumberMaxRetry(rs.getInt("MAX_RETRY"));
		cmp.setMethod(rs.getString("VERBO"));
		cmp.setProtocol(rs.getString("PROTOCOL"));
		cmp.setHostname(rs.getString("HOSTNAME"));
		cmp.setPort(rs.getInt("PORT"));
		cmp.setUri(rs.getString("URI"));
		cmp.setTimeOut(rs.getInt("TIME_OUT"));

		c.setCommunicationProperty(cmp);

		ComponentProperty cp = new ComponentProperty();

		cp.setPropertyName(rs.getString("KEY"));
		cp.setPropertyValue(rs.getString("VALUE"));
		cp.setId(rs.getInt("ID_PROPERTY"));
		c.setComponentProperty(cp);

		return c;
	}

}
