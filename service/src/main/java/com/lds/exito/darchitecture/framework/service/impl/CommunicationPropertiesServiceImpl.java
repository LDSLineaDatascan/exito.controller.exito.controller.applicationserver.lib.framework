package com.lds.exito.darchitecture.framework.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lds.exito.darchitecture.framework.domain.Component;
import com.lds.exito.darchitecture.framework.repository.ComponentRepository;
import com.lds.exito.darchitecture.framework.service.CommunicationPropertiesService;

@Service
public class CommunicationPropertiesServiceImpl implements CommunicationPropertiesService {

	private final ComponentRepository componentRepository;

	public CommunicationPropertiesServiceImpl(ComponentRepository componentRepository) {
		this.componentRepository = componentRepository;
	}

	@Override
	public Map<String, Component> getCommunicationPropsByComponentNames(String tokenAuthorizer, String authorizer) {

		Map<String, Component> properties = new HashMap<>();

		Optional<Component> optionalComponentTokenAuthorizer = componentRepository
				.findComponentAndAuthorizerByName(tokenAuthorizer);
		if (optionalComponentTokenAuthorizer.isPresent()) {
			properties.put(tokenAuthorizer, optionalComponentTokenAuthorizer.get());
			Optional<Component> optionalAuthorizer = componentRepository.findComponentAndAuthorizerByName(authorizer);
			if (optionalAuthorizer.isPresent()) {
				properties.put(authorizer, optionalAuthorizer.get());
			}
		}
		return properties;
	}
}
