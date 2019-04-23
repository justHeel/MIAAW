package com.app.miaaw.managers;

import com.app.miaaw.Domain.FontOpties;
import com.app.miaaw.repos.FontOptiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Component
public class FontOptiesManager {

	private FontOptiesRepository fontOptiesRepository;

	@Autowired
	public FontOptiesManager(FontOptiesRepository fontOptiesRepository) {
		this.fontOptiesRepository = fontOptiesRepository;
	}

}
