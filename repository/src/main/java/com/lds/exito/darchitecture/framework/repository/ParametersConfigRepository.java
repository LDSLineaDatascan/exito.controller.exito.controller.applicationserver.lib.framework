package com.lds.exito.darchitecture.framework.repository;

import com.lds.exito.darchitecture.framework.domain.ParametersConfig;

public interface ParametersConfigRepository extends CrudRepository<ParametersConfig>{
	
	public ParametersConfig findByRuleName(String ruleName);

}
