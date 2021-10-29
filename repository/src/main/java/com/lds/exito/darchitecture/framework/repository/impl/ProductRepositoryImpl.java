package com.lds.exito.darchitecture.framework.repository.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lds.exito.darchitecture.framework.dao.DaoTerminalConfiguration;
import com.lds.exito.darchitecture.framework.domain.Product;
import com.lds.exito.darchitecture.framework.repository.ProductRepository;
import com.lds.exito.darchitecture.framework.repository.mapper.ProductMapper;

@Repository
public class ProductRepositoryImpl extends DaoTerminalConfiguration implements ProductRepository {

	private static final Logger log = LoggerFactory.getLogger(ProductRepositoryImpl.class);

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> findAll() {
		return null;
	}

	@Override
	public Product save(Product domain) {
		try {
			String sql = "INSERT INTO PRODUCT_BUSINESS_RULES "
					+ "(PRODUCT_CODE, PRODUCT_NAME, PLU_VARIETY, ENABLE, PRODUCT_TYPE) "
					+ "VALUES(:PRODUCT_CODE, :PRODUCT_NAME, :PLU_VARIETY, :ENABLE, :PRODUCT_TYPE)";

			SqlParameterSource paramSource = new MapSqlParameterSource()
					.addValue("PRODUCT_CODE", domain.getProductCode()).addValue("PRODUCT_NAME", domain.getProductName())
					.addValue("PLU_VARIETY", domain.getPluVariety()).addValue("ENABLE", domain.getEnable())
					.addValue("PRODUCT_TYPE", domain.getProductType());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			getNamedParameterJdbcTemplate().update(sql, paramSource, keyHolder);

			domain.setId(keyHolder.getKey().longValue());
			return domain;
		} catch (Exception e) {
			log.error("Error al guardar las operaciones del producto", e);
			return null;
		}

	}

	@Override
	public Optional<Product> findProductByProductCodeAndInternalIdentification(String productCode,
			String internalIdentification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findProductByNameAndTypeAndVariety(String productName, String productType,
			String variety) {
		final String sql = "SELECT ID_PRODUCT, PRODUCT_CODE, PRODUCT_NAME, PLU_VARIETY, ENABLE, PRODUCT_TYPE "
				+ "FROM PRODUCT_BUSINESS_RULES WHERE PRODUCT_NAME =:productName AND PRODUCT_TYPE =:productType "
				+ "AND PLU_VARIETY=:pluVariety";
		Map<String, Object> paramMap = new HashMap<>();

		paramMap.put("productName", productName);
		paramMap.put("productType", productType);
		paramMap.put("pluVariety", variety);

		Product product = getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, new ProductMapper());

		return Optional.of(product);
	}

	@Override
	public Optional<Product> findByProductCode(String productCode, String productType) {

		try {
			final String sql = "SELECT ID_PRODUCT, PRODUCT_CODE, PRODUCT_NAME, PLU_VARIETY, ENABLE, PRODUCT_TYPE "
					+ "FROM PRODUCT_BUSINESS_RULES WHERE PRODUCT_CODE =:productCode AND PRODUCT_TYPE =:productType";

			Map<String, Object> paramMap = new HashMap<>();

			paramMap.put("productCode", productCode);
			paramMap.put("productType", productType);

			Product product = getNamedParameterJdbcTemplate().queryForObject(sql, paramMap, new ProductMapper());

			return Optional.of(product);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}
	}

}
