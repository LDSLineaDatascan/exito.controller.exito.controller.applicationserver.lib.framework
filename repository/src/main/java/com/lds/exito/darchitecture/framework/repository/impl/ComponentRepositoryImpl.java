package com.lds.exito.darchitecture.framework.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.Dao;
import com.lds.exito.darchitecture.framework.domain.Component;
import com.lds.exito.darchitecture.framework.domain.ComponentProperty;
import com.lds.exito.darchitecture.framework.domain.helper.ComponentHelper;
import com.lds.exito.darchitecture.framework.repository.ComponentRepository;
import com.lds.exito.darchitecture.framework.repository.mapper.ComponentHelperRowMapper;
import com.lds.exito.darchitecture.framework.repository.mapper.ComponentRowMapper;

@Repository
public class ComponentRepositoryImpl extends Dao implements ComponentRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentRepositoryImpl.class);

	@Override
	public Component findById(Integer id) {
		return getJdbcTemplate().queryForObject(
				"SELECT c.ID_COMPONENT AS ID_COMPONENT, c.NAME AS COMPONENT_NAME, c.ALIAS AS PROPERTY_NAME FROM COMPONENT c WHERE c.ID_COMPONENT =? ",
				new Object[] { id }, new ComponentRowMapper());
	}

	@Override
	public List<Component> findComponentByPropertiesName(String propertiesName) {
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("ALIAS", "'TokenWallet','Wallet'");

		List<ComponentHelper> componentHelperList = getNamedParameterJdbcTemplate().query(
				"SELECT " + "cp.ID_PROPERTY AS ID_PROPERTY, " + "cp.PROPERTY_NAME AS PROPERTY_NAME,"
						+ "cp.PROPERTY_VALUE AS PROPERTY_VALUE," + "c.ID_COMPONENT AS ID_COMPONENT,"
						+ "c.NAME AS COMPONENT_NAME," + "c.ALIAS AS ALIAS,"
						+ "cmp.ID_COMMUNICATION AS ID_COMMUNICATION," + "cmp.HOSTNAME AS HOSTNAME,"
						+ "cmp.METHOD AS VERBO," + "cmp.NUMBER_MAX_RETRY AS MAX_RETRY," + "cmp.PROTOCOL AS PROTOCOL,"
						+ "cmp.PORT AS PORT," + "cmp.URI AS URI" + " FROM PUBLIC.COMPONENT_PROPERTIES cp"
						+ " INNER JOIN PUBLIC.COMPONENT c ON c.ID_COMPONENT = cp.ID_COMPONENT  "
						+ " INNER JOIN PUBLIC.COMMUNICATION_PROPERTIES cmp ON CMP.ID_COMPONENT = C.ID_COMPONENT ",
				new ComponentHelperRowMapper());

		componentHelperList = componentHelperList.stream().sorted().collect(Collectors.toList());

		Map<Integer, List<ComponentHelper>> groupById = componentHelperList.stream()
				.collect(Collectors.groupingBy(ComponentHelper::getId));

		List<Component> components = new ArrayList<>();

		groupById.forEach((k, v) -> {
			ComponentHelper ch = v.stream().findFirst().get();
			Component c = new Component();

			c.setId(ch.getId());
			c.setComponentName(ch.getComponentName());
			c.setAlias(ch.getAlias());
			components.add(c);
		});

		LOGGER.debug("Components: " + components.toString());

		return components;
	}

	@Override
	public Optional<Component> findComponentAndAuthorizerByName(String alias) {

		Map<String, String> paramMap = new HashMap<>();

		paramMap.put("ALIAS", alias);

		List<ComponentHelper> componentHelperList = getNamedParameterJdbcTemplate()
				.query("SELECT " + "cp.ID_PROPERTY AS ID_PROPERTY, " + "cp.PROPERTY_NAME AS KEY,"
						+ "cp.PROPERTY_VALUE AS VALUE," + "c.ID_COMPONENT AS ID_COMPONENT,"
						+ "c.NAME AS COMPONENT_NAME," + "c.ALIAS AS ALIAS,"
						+ "cmp.ID_COMMUNICATION AS ID_COMMUNICATION," + "cmp.HOSTNAME AS HOSTNAME,"
						+ "cmp.METHOD AS VERBO," + "cmp.NUMBER_MAX_RETRY AS MAX_RETRY," + "cmp.PROTOCOL AS PROTOCOL,"
								+ "cmp.PROPERTY_NAME as PROPERTY_NAME, cmp.TIMEOUT as TIME_OUT, "
						+ "cmp.PORT AS PORT," + "cmp.URI AS URI" + " FROM PUBLIC.COMPONENT_PROPERTIES cp"
						+ " INNER JOIN PUBLIC.COMPONENT c ON c.ID_COMPONENT = cp.ID_COMPONENT  "
						+ " INNER JOIN PUBLIC.COMMUNICATION_PROPERTIES cmp ON CMP.ID_COMPONENT = C.ID_COMPONENT"
						+ " WHERE c.ALIAS =:ALIAS", paramMap, new ComponentHelperRowMapper());

		List<ComponentProperty> propertyList = componentHelperList.stream().map(ComponentHelper::getComponentProperty)
				.collect(Collectors.toList());

		return componentHelperList.stream().findFirst().map(ch -> ch.getComponent(propertyList));

	}

	@Override
	public Component save(Component domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
