package com.app.miaaw.managers;

import com.app.miaaw.Domain.Videoopties;
import com.app.miaaw.repos.VideooptiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Component
public class VideooptiesManager {

	private VideooptiesRepository videooptiesRepository;

	@Autowired
	public VideooptiesManager(VideooptiesRepository videooptiesRepository) {
		this.videooptiesRepository = videooptiesRepository;
	}

}
