package com.mudigal.two.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mudigal.two.model.NameValueTO;
import com.mudigal.two.ServiceTwoApplication;
import com.mudigal.two.model.AllNameValueTO;
import com.mudigal.two.service.NameValueService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */

@RestController
public class NameValueController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private NameValueService nameValueService;

	private Logger logger = Logger.getLogger(ServiceTwoApplication.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "Get name and value", notes = "Get service name and its corresponding values for all the services", response = NameValueTO.class)
	public AllNameValueTO getAllNameValue() {
		logger.info("Inside " + applicationName + " controller's getAllNameValue() method");
		return nameValueService.getAllNameValues(applicationName);
	}

}
