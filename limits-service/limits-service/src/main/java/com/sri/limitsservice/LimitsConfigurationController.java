package com.sri.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.limitsservice.bean.Configuration;
import com.sri.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retreiveLimitsfromConfiguration() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());

	}
}
