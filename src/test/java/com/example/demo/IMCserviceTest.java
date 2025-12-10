package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IMCserviceTest {

    private ImcService imcService;

    @BeforeEach
    public void setUp() {
        imcService = new ImcService();
    }

    @Test
    public void testCalcularIMC() {
        double imc = imcService.calcularIMC(70, 1.75);
        assertEquals(22.86, Math.round(imc * 100) / 100.0);
    }

    @Test
    public void testTMBFeminino() {
        String tmb = imcService.taxaMetabolicaBasal(70, 170, 25, "feminino");
        assertTrue(tmb.contains("TMB:"));
    }

    @Test
    public void testTMBMasculino() {
        String tmb = imcService.taxaMetabolicaBasal(80, 180, 30, "masculino");
        assertTrue(tmb.contains("TMB:"));
    }


    @Test
    public void testGCD() {
        String gcd = imcService.caloriasGastasPorDia(70, 170, 25, "feminino");
        assertTrue(gcd.contains("Calorias gastas por dia: "));
    }

    @Test
    public void testMetaCaloricaEmagrecer() {
        double resultado = imcService.metaCalorica(2500, "emagrecer");
        assertEquals(2000, resultado);
    }

    @Test
    public void testMetaCaloricaGanhar() {
        double resultado = imcService.metaCalorica(2500, "ganhar");
        assertEquals(2900, resultado);
    }

    @Test
    public void testMetaCaloricaManter() {
        double resultado = imcService.metaCalorica(2500, "manter");
        assertEquals(2500, resultado);
    }

    @Test
    public void testMetaCaloricaEmagrecerCaseInsensitive() {
        double resultado = imcService.metaCalorica(2000, "EMAGRECER");
        assertEquals(1500, resultado);
    }

    @Test
    public void testMetaCaloricaObjetivoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            imcService.metaCalorica(2500, "invalido");
        });
    }


}