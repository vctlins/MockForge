package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;

import java.util.Map;

public interface FieldGeneratorStrategy {

    Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options);

}
