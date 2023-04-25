package br.ce.wcaquino.servicos;

import br.ce.wcaquino.exception.NaoPodeDividirPorZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

    private Calculadora calc;

    @Before
    public void setup(){
        calc = new Calculadora();
    }

    @Test
    public void test_deve_somar_dois_valores(){
        // cenario
        int a = 5;
        int b = 3;

        // ação
        int resultado = calc.somar(a,b);

        // verificação
        Assert.assertEquals(8,resultado);
    }

    @Test
    public void test_deve_subtrair_dois_valores(){
        // cenario
        int a = 5;
        int b = 3;

        // ação
        int resultado = calc.subtrair(a,b);

        // Verificação
        Assert.assertEquals(2,resultado);
    }

    @Test
    public void test_deve_divir_dois_valores() throws NaoPodeDividirPorZeroException{
        // cenario
        int a = 6;
        int b = 2;

        // ação
        int resultado = calc.dividir(a,b);

        // Verificação
        Assert.assertEquals(3,resultado);
    }

    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void test_deve_lancar_excecao_ao_dividir_por_zero() throws NaoPodeDividirPorZeroException {
        // cenario
        int a = 10;
        int b = 0;

        // ação
        int resultado = calc.dividir(a,b);

        // Verificação
//        Assert.assertEquals(3,resultado);
    }
}
