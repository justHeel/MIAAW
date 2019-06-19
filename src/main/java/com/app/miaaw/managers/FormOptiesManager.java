package com.app.miaaw.managers;

import com.app.miaaw.Domain.BasicBar;
import com.app.miaaw.Domain.FormOpties;
import com.app.miaaw.repos.FormOptiesRepository;
import com.app.miaaw.requests.UpdateCodeRequest;
import com.app.miaaw.requests.UpdateFormCodeRequest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Generated by Spring Data Generator on 23/04/2019
*/
@Component
@RequestMapping("/formopties")
public class FormOptiesManager {

	private FormOptiesRepository formOptiesRepository;

	@Autowired
	public FormOptiesManager(FormOptiesRepository formOptiesRepository) {
		this.formOptiesRepository = formOptiesRepository;
	}
	
	@GetMapping()
	public @ResponseBody UpdateFormCodeRequest getBasicBarTemplate() {
		long id = 2;
		UpdateFormCodeRequest response = new UpdateFormCodeRequest();
		
		response.setContrastCode(formOptiesRepository.findById(id).get().getFormContrastCode());
		response.setTtsCode(formOptiesRepository.findById(id).get().getTtsCode());
		response.setOtherCode(formOptiesRepository.findById(id).get().getOtherFormCode());
		return response;
	}
	
	@PostMapping()
	public void updateBasicBarCode(@RequestBody UpdateFormCodeRequest request) {
		long id = 2;
		FormOpties formOpties = formOptiesRepository.findById(id).get();
		formOpties.setFormContrastCode(request.getContrastCode());
		formOpties.setTtsCode(request.getTtsCode());
		formOpties.setOtherFormCode(request.getOtherCode());
		formOptiesRepository.save(formOpties);
	}
}
