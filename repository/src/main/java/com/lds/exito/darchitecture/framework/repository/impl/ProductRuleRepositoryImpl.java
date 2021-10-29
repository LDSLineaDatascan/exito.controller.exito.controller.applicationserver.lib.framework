package com.lds.exito.darchitecture.framework.repository.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoTerminalConfiguration;
import com.lds.exito.darchitecture.framework.domain.ProductRule;
import com.lds.exito.darchitecture.framework.repository.ProductRuleRepository;

@Repository
public class ProductRuleRepositoryImpl extends DaoTerminalConfiguration implements ProductRuleRepository {

	@Override
	public ProductRule findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductRule save(ProductRule domain) {
		String sql = "INSERT INTO PRODUCT_RULE "
				+ "(ID_PRODUCT, OPERATION_TYPE, VALIDATION_TYPE, RULE_TYPE, VALUE_RULE) "
				+ "VALUES(:ID_PRODUCT, :OPERATION_TYPE, :VALIDATION_TYPE, :RULE_TYPE, :VALUE_RULE)";

		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("ID_PRODUCT", domain.getProduct().getId())
				.addValue("OPERATION_TYPE", domain.getOperationType().getId())
				.addValue("VALIDATION_TYPE", domain.getValidationType().getId())
				.addValue("RULE_TYPE", domain.getRuleType().getId()).addValue("VALUE_RULE", domain.getRuleValue());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder);

		domain.setId(keyHolder.getKey().longValue());
		
		return domain;
	}

}
