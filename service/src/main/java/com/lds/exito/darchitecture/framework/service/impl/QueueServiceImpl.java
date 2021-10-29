package com.lds.exito.darchitecture.framework.service.impl;

import org.springframework.stereotype.Service;

import com.lds.exito.darchitecture.framework.domain.QueueObject;
import com.lds.exito.darchitecture.framework.repository.QueueObjectRepository;
import com.lds.exito.darchitecture.framework.service.QueueService;
@Service
public class QueueServiceImpl implements QueueService{

	private QueueObjectRepository queueObjectRepository;
	
	public QueueServiceImpl(QueueObjectRepository queueObjectRepository) {
		this.queueObjectRepository = queueObjectRepository;
	}
	
	@Override
	public QueueObject save(QueueObject domain) {
		return queueObjectRepository.save(domain);
	}

}
