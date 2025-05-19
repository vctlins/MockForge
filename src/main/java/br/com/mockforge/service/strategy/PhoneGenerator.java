package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("phone")
public class PhoneGenerator implements FieldGeneratorStrategy {

    @Override
    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        String ddd = faker.numerify("##");
        String prefix = "9" + faker.numerify("####");
        String suffix = faker.numerify("####");

        return String.format("(%s) %s-%s", ddd, prefix, suffix);
    }
}
