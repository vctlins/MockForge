package br.com.mockforge.service;

import br.com.mockforge.exception.NotSupportedTypeException;
import br.com.mockforge.service.strategy.FieldGeneratorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GeneratorStrategyFactory {

    private final Map<String, FieldGeneratorStrategy> strategies = new HashMap<>();

    @Autowired
    public GeneratorStrategyFactory(List<FieldGeneratorStrategy> strategyList){

        for (FieldGeneratorStrategy strategy : strategyList){
            String type = strategy.getClass().getAnnotation(Component.class).value();
            strategies.put(type, strategy);
        }
    }

    public FieldGeneratorStrategy get(String type) {
        if(!strategies.containsKey(type)){
            throw new NotSupportedTypeException("Tipo de campo não suportado: " + type);
        }
        return strategies.get(type);
    }

}
