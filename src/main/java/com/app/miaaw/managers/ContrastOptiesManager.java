package com.app.miaaw.managers;

import com.app.miaaw.Domain.ContrastOpties;
import com.app.miaaw.repos.ContrastOptiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Component
public class ContrastOptiesManager {

	private ContrastOptiesRepository contrastOptiesRepository;

	@Autowired
	public ContrastOptiesManager(ContrastOptiesRepository contrastOptiesRepository) {
		this.contrastOptiesRepository = contrastOptiesRepository;
	}

}
