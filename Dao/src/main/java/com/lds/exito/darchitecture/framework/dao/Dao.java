package com.lds.exito.darchitecture.framework.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;

public class Dao extends NamedParameterJdbcDaoSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dao.class);

	@Qualifier("db1")
	@Autowired
	private DataSource dataSource;
	
	@Qualifier("jdbcTemplate1")
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Nullable
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	protected void checkDaoConfig() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("--- CheckConfigDao ---");
		}

		super.setDataSource(this.dataSource);
	}

	@Override
	protected void initDao() throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("--- initDao ---");
		}
		super.initDao();
	}
	
	@Override
	protected void initTemplateConfig() {
		if (jdbcTemplate != null) {
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		}
	}
	
	@Override
	@Nullable
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return this.namedParameterJdbcTemplate;
	}

}
