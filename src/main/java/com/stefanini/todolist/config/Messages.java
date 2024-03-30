package com.stefanini.todolist.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class Messages {

    private final MessageSource messageSource;

    public String get(String code) {
        return messageSource.getMessage(code, null, new Locale("pt BR"));
    }

}
