package com.yicao.pmiapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime处理
 *
 * @author: yicao
 * @create: 2021-05-11 23:40
 */
@Configuration
public class LocalDateTimeConfig {

    @Bean
    public Converter<String, LocalDateTime> localDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = null;
                try {
                    //2020-01-01 00:00:00
                    switch (source.length()){
                        case 10:
                            source=source+" 00:00:00";
                            break;
                        case 13:
                            source=source+":00:00";
                            break;
                        case 16:
                            source=source+":00";
                            break;
                    }
                    dateTime = LocalDateTime.parse(source, df);
                } catch (Exception e) {
                }
                return dateTime;
            }
        };
    }

}
