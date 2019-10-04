package com.codegym.testuploadfileapi;

import com.codegym.testuploadfileapi.converter.StringToLocalDateConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TestuploadfileapiApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(TestuploadfileapiApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToLocalDateConverter stringToLocalDateConverter = new
                StringToLocalDateConverter("MM/dd/yyyy");
        registry.addConverter(stringToLocalDateConverter);
    }



}
