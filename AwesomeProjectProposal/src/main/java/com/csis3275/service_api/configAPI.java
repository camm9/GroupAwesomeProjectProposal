package com.csis3275.service_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;






@Component
public class configAPI {

	@Value("${fpKey}")
	private static String fpKey_API;
	
	public configAPI(@Value("${fpKey}") String key) {
		fpKey_API = key;
		System.out.println("This is printed within the configAPI class: " + key);
	}
	
	public static String getKey() {return fpKey_API;}
	
}
