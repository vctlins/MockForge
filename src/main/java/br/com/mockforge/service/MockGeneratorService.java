package br.com.mockforge.service;

import br.com.mockforge.dto.FieldDTO;
import br.com.mockforge.dto.RequestGeneration;
import br.com.mockforge.service.strategy.FieldGeneratorStrategy;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MockGeneratorService {
    private final GeneratorStrategyFactory factory;
    private final Faker faker = new Faker(new Locale("pt-BR"));

    public MockGeneratorService(GeneratorStrategyFactory factory){
        this.factory = factory;
    }

    public List<Map<String, Object>> generate(RequestGeneration request) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (int i = 0; i < request.getAmount(); i++) {
            Map<String, Object> profile = new LinkedHashMap<>();

            for (FieldDTO field : request.getField()) {
               String type = field.getType();
               FieldGeneratorStrategy strategy = factory.get(type);
               Object value = strategy.generate(faker, profile, field.getOptions());
               profile.put(type, value);
            }

            result.add(profile);
        }

        return result;
    }


}
