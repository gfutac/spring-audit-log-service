package com.gfutac.config.elastic.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import java.time.Instant;

public class InstantStringConversion {

    @ReadingConverter
    public static class StringToInstant implements Converter<String, Instant> {

        @Override
        public Instant convert(String value) {
            return Instant.parse(value);
        }
    }

    @WritingConverter
    public static class InstantToString implements Converter<Instant, String> {

        @Override
        public String convert(Instant value) {
            return value.toString();
        }
    }
}
