package br.com.mockforge.service.strategy;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static br.com.mockforge.util.LocationData.statesAndCities;

@Component("city")
public class CityGenerator implements FieldGeneratorStrategy {

    private final Random random = new Random();

    @Override
    public Object generate(Faker faker, Map<String, Object> context, Map<String, Object> options) {
        String state = (String) context.get("state");

        if (state != null && statesAndCities.containsKey(state)) {
            List<String> cities = statesAndCities.get(state);
            return cities.get(random.nextInt(cities.size()));
        }

        List<String> allCities = statesAndCities.values()
                .stream()
                .flatMap(List::stream)
                .toList();

        return allCities.get(random.nextInt(allCities.size()));
    }
}
