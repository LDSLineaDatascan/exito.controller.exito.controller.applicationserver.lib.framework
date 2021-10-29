package com.lds.exito.darchitecture.framework.service;

import java.util.Map;

import com.lds.exito.darchitecture.framework.domain.Component;

public interface CommunicationPropertiesService {

	Map<String, Component> getCommunicationPropsByComponentNames(String tokenAuthorizer, String authorizer);

}
