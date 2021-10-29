package com.lds.exito.darchitecture.framework.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lds.exito.darchitecture.framework.domain.Product;
import com.lds.exito.darchitecture.framework.domain.ProductRule;
import com.lds.exito.darchitecture.framework.repository.ProductFlowRepository;
import com.lds.exito.darchitecture.framework.repository.ProductRepository;
import com.lds.exito.darchitecture.framework.service.ProductRuleService;
import com.lds.exito.darchitecture.framework.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;

	private final ProductFlowRepository flowRepository;

	private final ProductRuleService productRuleService;

	public ProductServiceImpl(ProductRepository productRepository, ProductFlowRepository flowRepository,
			ProductRuleService productRuleService) {
		this.productRepository = productRepository;
		this.flowRepository = flowRepository;
		this.productRuleService = productRuleService;
	}

	@Override
	public Optional<Product> save(Product domain) {
		Optional<Product> optionalProduct = productRepository.findByProductCode(domain.getProductCode(),
				domain.getProductType());
		if (!optionalProduct.isPresent()) {
			return Optional.ofNullable(productRepository.save(domain));
		}
		return optionalProduct;
	}

	@Override
	public Set<Product> saveList(Set<Product> productList) {
		logger.debug("Init save product list");

		Set<Product> products = new HashSet<>();

		productList.forEach(p -> {
			Optional<Product> optionalProduct = productRepository.findByProductCode(p.getProductCode(),
					p.getProductType());
			if (!optionalProduct.isPresent()) {
				logger.debug("product not in database {}", p);
				Product newProduct = productRepository.save(p);
				p.getFlow().setProduct(newProduct);
				flowRepository.save(p.getFlow());
				saveRules(p.getRules(), newProduct);
				products.add(newProduct);
			}
		});
		return products;
	}

	private void saveRules(Set<ProductRule> rules, Product product) {
		rules.forEach(rule -> {
			rule.setProduct(product);
			productRuleService.save(rule);
		});
	}

}
