package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("age")
public class AgeGenerator  implements FieldGeneratorStrategy{

    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        return faker.number().numberBetween(1, 80);
    }

}
