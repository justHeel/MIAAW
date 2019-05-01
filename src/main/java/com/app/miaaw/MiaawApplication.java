package com.app.miaaw;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.miaaw.WebpageEnhancer.Enhancer;
import com.app.miaaw.WebpageEnhancer.ImageDescriber;
import com.app.miaaw.WebpageEnhancer.SoupChef;
import com.cmeza.sdgenerator.annotation.SDGenerator;
@SDGenerator(
        entityPackage = "com.app.miaaw.Domain",
        repositoryPackage = "com.app.miaaw.repos",
        managerPackage = "com.app.miaaw.managers",
        repositoryPostfix = "Repository",
        managerPostfix = "Manager",
        onlyAnnotations = false,
        debug = false,
        overwrite = false
)
@SpringBootApplication
public class MiaawApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiaawApplication.class, args);
	}
}
