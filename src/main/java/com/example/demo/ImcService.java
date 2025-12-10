package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ImcService {

    public double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    public String taxaMetabolicaBasal(double peso, double alturaCm, int idade, String sexo) {
    double tmb;

    if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
        tmb = (10 * peso) + (6.25 * alturaCm) - (5 * idade) + 5;
    } else {
        tmb = (10 * peso) + (6.25 * alturaCm) - (5 * idade) - 161;
    }

    return "TMB:" + String.format("%.2f", tmb) + " kcal/dia";
    }
    //Fórmula de Harris-Benedict (mais usada):
    //Homens: 66 + (13,7 x Peso em kg) + (5 x Altura em cm) - (6,8 x Idade em anos)
    //Mulheres: 655 + (9,6 x Peso em kg) + (1,8 x Altura em cm) - (4,7 x Idade em anos)
    public String caloriasGastasPorDia(double peso, double alturaCm, int idade, String sexo) {
    double calorias;

    if (sexo.equalsIgnoreCase("masculino") || sexo.equalsIgnoreCase("m")) {
        calorias = 66 + (13.7 * peso) + (5 * alturaCm) - (6.8 * idade);
    } else {
        calorias = 655 + (9.6 * peso) + (1.8 * alturaCm) - (4.7 * idade);
    }

    return "Calorias gastas por dia: " + String.format("%.2f", calorias);
    }


    //calcular Meta calórica para emagrecer/ganhar peso
    public double metaCalorica(double gcd, String objetivo) {

    switch (objetivo.toLowerCase()) {
        case "emagrecer":
            return gcd - 500;
        case "ganhar":
            return gcd + 400;
        case "manter":
            return gcd;
        default:
            throw new IllegalArgumentException("Objetivo inválido. Use: emagrecer, ganhar ou manter.");
    }
}
}