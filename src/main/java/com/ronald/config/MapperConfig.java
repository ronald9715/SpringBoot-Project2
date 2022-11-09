package com.ronald.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper(){
        return new ModelMapper();
    }
    @Bean("subjectMapper")
    public ModelMapper subjectMapper(){
        return new ModelMapper();
    }
    @Bean("enrollment")
    public ModelMapper enrollmentMapper(){
        return new ModelMapper();
    }
}
