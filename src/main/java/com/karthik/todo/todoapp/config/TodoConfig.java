package com.karthik.todo.todoapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TodoConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
