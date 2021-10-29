package com.lds.exito.darchitecture.framework.service.impl;

import org.springframework.stereotype.Service;

import com.lds.exito.darchitecture.framework.domain.ProductRule;
import com.lds.exito.darchitecture.framework.repository.ParametersConfigRepository;
import com.lds.exito.darchitecture.framework.repository.ProductRuleRepository;
import com.lds.exito.darchitecture.framework.service.ProductRuleService;

@Service
public class RuleServiceImpl implements ProductRuleService {

	private ParametersConfigRepository parametersConfigRepository;

	private ProductRuleRepository productRuleRepository;

	public RuleServiceImpl(ParametersConfigRepository parametersConfigRepository,
			ProductRuleRepository productRuleRepository) {
		this.parametersConfigRepository = parametersConfigRepository;
		this.productRuleRepository = productRuleRepository;
	}

	@Override
	public ProductRule save(ProductRule productRule) {

		productRule
				.setRuleType(parametersConfigRepository.findByRuleName(productRule.getRuleType().getParameterName()));

		productRule.setOperationType(
				parametersConfigRepository.findByRuleName(productRule.getOperationType().getParameterName()));

		productRule.setValidationType(
				parametersConfigRepository.findByRuleName(productRule.getValidationType().getParameterName()));

		return productRuleRepository.save(productRule);
	}

}
