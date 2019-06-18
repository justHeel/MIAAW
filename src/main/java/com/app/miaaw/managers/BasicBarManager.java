package com.app.miaaw.managers;

import com.app.miaaw.Domain.BasicBar;
import com.app.miaaw.repos.BasicBarRepository;
import com.app.miaaw.requests.UpdateCodeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Component
@RestController
@RequestMapping("/basicbar")
public class BasicBarManager {

	private BasicBarRepository basicBarRepository;

	@Autowired
	public BasicBarManager(BasicBarRepository basicBarRepository) {
		this.basicBarRepository = basicBarRepository;
	}
	
	@GetMapping()
	public String getBasicBarTemplate() {
		long id = 7;
		return basicBarRepository.findById(id).get().getBasicBarCode();
	}
	
	@PostMapping()
	public void updateBasicBarCode(@RequestBody UpdateCodeRequest request) {
		long id = 7;
		BasicBar bar = basicBarRepository.findById(id).get();
		bar.setBasicBarCode(request.getCode());
		basicBarRepository.save(bar);
		System.out.println(request.getCode());
	}

}
