package com.app.miaaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
