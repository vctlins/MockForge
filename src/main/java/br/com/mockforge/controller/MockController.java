package br.com.mockforge.controller;

import br.com.mockforge.dto.RequestGeneration;
import br.com.mockforge.service.MockGeneratorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockController {

    private final MockGeneratorService service;

    public MockController(MockGeneratorService service){
        this.service = service;
    }

    @PostMapping("/gerar-json")
    public ResponseEntity<?> generate(@RequestBody @Valid RequestGeneration request) {
        if (request.getAmount() == null || request.getAmount() <= 0){
            return ResponseEntity.badRequest().body("Quantidade deve ser maior que 1");
        }
        return ResponseEntity.ok(service.generate(request));

    }


}
