package com.lds.exito.darchitecture.framework.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoTerminalConfiguration;
import com.lds.exito.darchitecture.framework.domain.ParametersConfig;
import com.lds.exito.darchitecture.framework.repository.ParametersConfigRepository;
import com.lds.exito.darchitecture.framework.repository.mapper.ParametersConfigRowMapper;

@Repository
public class ParametersConfigRepositoryImpl extends DaoTerminalConfiguration implements ParametersConfigRepository {

	@Override
	public ParametersConfig findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParametersConfig save(ParametersConfig domain) {
		return null;
	}

	@Override
	public ParametersConfig findByRuleName(String parameterName) {
		try {

			final String sql = "SELECT ID_PARAMETER, DESCRIPTION_GROUP, ID_GROUP, PARAMETER_NAME, PARAMETER_VALUE, "
					+ "DESCRIPTION_PARAMETER FROM PARAMETER_CONFIGURATION WHERE PARAMETER_NAME =:parameterName ";

			Map<String, Object> paramMap = new HashMap<>();

			paramMap.put("parameterName", parameterName);

			return getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, new ParametersConfigRowMapper());
		} catch (Exception e) {
			return null;
		}

	}

}
