package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("name")
public class NameGenerator implements FieldGeneratorStrategy{

    @Override
    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        String fullName = faker.name().fullName();
        return removeTitles(fullName);
    }

    private String removeTitles(String name) {
        String[] titles = {"Dr. ", "Dra. ", "Sr. ", "Sra. ", "Srta. "};

        for (String title : titles) {
            if (name.startsWith(title)) {
                return name.substring(title.length());
            }
        }
        return name;
    }
}
