package com.lds.exito.darchitecture.framework.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoTerminalConfiguration;
import com.lds.exito.darchitecture.framework.domain.ProductFlow;
import com.lds.exito.darchitecture.framework.repository.ProductFlowRepository;

@Repository
public class ProductFlowRepositoryImpl extends DaoTerminalConfiguration implements ProductFlowRepository {

	private static final Logger log = LoggerFactory.getLogger(ProductFlowRepositoryImpl.class);

	@Override
	public ProductFlow findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFlow save(ProductFlow domain) {
		try {
			String sql = "INSERT INTO PRODUCT_FLOW (FLOW_IDENTIFIER, ID_PRODUCT, FLOW_CONNECTOR) "
					+ "VALUES(:FLOW_IDENTIFIER, :ID_PRODUCT, :FLOW_CONNECTOR)";

			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("FLOW_IDENTIFIER", domain.getFlowIdentifier())
					.addValue("ID_PRODUCT", domain.getProduct().getId())
					.addValue("FLOW_CONNECTOR", domain.getFlowConnector());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder);

			domain.setId(keyHolder.getKey().longValue());
		} catch (Exception e) {
			log.error("Error al guardar las operaciones del producto", e);
		}
		return domain;
	}

}
