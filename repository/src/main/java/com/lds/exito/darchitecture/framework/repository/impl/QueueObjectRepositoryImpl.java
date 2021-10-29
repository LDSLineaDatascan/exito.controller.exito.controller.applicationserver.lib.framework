package com.lds.exito.darchitecture.framework.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoDomain;
import com.lds.exito.darchitecture.framework.domain.QueueObject;
import com.lds.exito.darchitecture.framework.repository.QueueObjectRepository;

@Repository
public class QueueObjectRepositoryImpl extends DaoDomain implements QueueObjectRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(QueueObjectRepositoryImpl.class);

	@Override
	public QueueObject findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueObject save(QueueObject domain) {
		try {
			String sql = "INSERT INTO QUEUE_OBJECT "
					+ "(ID_QUEUE_OBJECT,COMPONENT_NAME, PROPERTY_NAME, MESSAGE, RETRY) "
					+ "VALUES(:ID_QUEUE_OBJECT,:COMPONENT_NAME, :PROPERTY_NAME, :MESSAGE, :RETRY)";

			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("ID_QUEUE_OBJECT", domain.getId()).addValue("COMPONENT_NAME", domain.getComponentName())
					.addValue("PROPERTY_NAME", domain.getPropertyName()).addValue("MESSAGE", domain.getMessage())
					.addValue("RETRY", domain.getRetry());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder);

			domain.setId(keyHolder.getKey().longValue());
			return domain;
		} catch (Exception e) {
			logger.error("Error al guardar las operaciones del producto", e);
			return null;
		}
	}

}
