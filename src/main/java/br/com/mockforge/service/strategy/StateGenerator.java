package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.mockforge.util.LocationData.statesAndCities;

@Component("state")
public class StateGenerator implements FieldGeneratorStrategy{

    @Override
    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        List<String> states = new ArrayList<>(statesAndCities.keySet());
        String state = faker.options().nextElement(states);
        context.put("state", state);
        return state;
    }
}
