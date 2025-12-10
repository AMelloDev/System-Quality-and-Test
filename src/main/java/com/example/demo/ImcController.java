package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService service;

    public ImcController(ImcService service) {
        this.service = service;
    }

    @GetMapping(value = "/calcular", produces = "text/plain")
    public String calcularIMC(
        @RequestParam double peso,
        @RequestParam double altura) {
    
    double imc = service.calcularIMC(peso, altura);
    return "Seu IMC é: " + String.format("%.2f", imc);
    
    }

 
    @GetMapping(value = "/tmb", produces = "text/plain")
    public String taxaMetabolicaBasal(
            @RequestParam double peso,
            @RequestParam double alturaCm,
            @RequestParam int idade,
            @RequestParam String sexo) {

        return service.taxaMetabolicaBasal(peso, alturaCm, idade, sexo);
    }

    @GetMapping(value = "/gcd", produces = "text/plain")
    public String caloriasGastasPorDia(
            @RequestParam double peso,
            @RequestParam double alturaCm,
            @RequestParam int idade,
            @RequestParam String sexo) {

        return service.caloriasGastasPorDia(peso, alturaCm, idade, sexo);
    }

    @GetMapping(value ="/meta", produces = "text/plain")
   public String metaCalorica(
        @RequestParam double gcd,
        @RequestParam String objetivo) {

    double valor = service.metaCalorica(gcd, objetivo);
    return "Meta calórica (" + objetivo + "): " + valor;
}
    }
