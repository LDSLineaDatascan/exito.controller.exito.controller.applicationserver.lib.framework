package com.lds.exito.darchitecture.framework.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.Dao;
import com.lds.exito.darchitecture.framework.domain.ComponentProperty;
import com.lds.exito.darchitecture.framework.repository.ComponentPropertyRepository;
import com.lds.exito.darchitecture.framework.repository.mapper.ComponentPropertyRowMapper;

@Repository
public class ComponentPropertyRepositoryImpl extends Dao implements ComponentPropertyRepository {

	@Override
	public ComponentProperty findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ComponentProperty> getPropertyByPropertyName(String propertyName) {
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("PROPERTY_NAME", propertyName);
		
		List<ComponentProperty> componentProperty = getNamedParameterJdbcTemplate().query(
				"SELECT ID_PROPERTY, ID_COMPONENT, PROPERTY_NAME, PROPERTY_VALUE, IS_ENCRYPT, IS_ACTIVE, IS_ALLOWED_QUERY, IS_ALLOWED_UPDATE"
						+ " FROM COMPONENT_PROPERTIES CP WHERE CP.PROPERTY_NAME = :PROPERTY_NAME",
						params , new ComponentPropertyRowMapper());
		
		return componentProperty.stream().findFirst();
	}

	@Override
	public ComponentProperty save(ComponentProperty domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
