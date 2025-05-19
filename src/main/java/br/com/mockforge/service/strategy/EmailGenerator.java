package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("email")
public class EmailGenerator implements FieldGeneratorStrategy {

    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        String nome = (String) context.get("name");
        String base = nome.toLowerCase().replace(" ", ".").replaceAll("[^a-zA-Z.]", "");
        return base + "@email.com";
    }
}
