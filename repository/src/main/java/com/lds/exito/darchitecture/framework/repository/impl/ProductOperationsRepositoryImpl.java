package com.lds.exito.darchitecture.framework.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoTerminalConfiguration;
import com.lds.exito.darchitecture.framework.domain.ProductOperations;
import com.lds.exito.darchitecture.framework.repository.ProductOperationsRepository;

@Repository
public class ProductOperationsRepositoryImpl extends DaoTerminalConfiguration implements ProductOperationsRepository {

	private static final Logger log =  LoggerFactory.getLogger(ProductOperationsRepositoryImpl.class);
	
	@Override
	public ProductOperations findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductOperations save(ProductOperations domain) {

		try {
			String sql = "INSERT INTO PRODUCT_OPERATIONS (ENABLE_CASHOUT, ENABLE_CASHIN, ENABLE_PAYMENT) "
					+ "VALUES(:ENABLE_CASHOUT, :ENABLE_CASHIN, :ENABLE_PAYMENT)";

			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("ENABLE_CASHOUT", domain.getEnableCashout())
					.addValue("ENABLE_CASHIN", domain.getEnableCashin())
					.addValue("ENABLE_PAYMENT", domain.getEnablePayment());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder);

			domain.setId(keyHolder.getKey().longValue());
		}catch(Exception e) {
			log.error("Error al guardar las operaciones del producto", e);
		}

		return domain;
	}

}
