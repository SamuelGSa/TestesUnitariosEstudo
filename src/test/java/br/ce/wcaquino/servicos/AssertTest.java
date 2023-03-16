package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class AssertTest {

    @Test
    void test(){
        Assert.assertTrue(true);
        Assert.assertTrue(!false); // Fazer a negação o mínimo possível

        Assert.assertFalse(false);

        int numeroTest = 1;
        Assert.assertEquals(1,numeroTest);

        // No caso do Double, o Assert pede um 'delta'. O delta é a margem de erro. No caso, dando uma margem de erro de 0.001(pegando até 0.512)
        Assert.assertEquals(0.51235,0.51234, 0.001);


        //Nos testes não é possível fazer o unboxing, autoboxing é necessário converter um dos valores para igualar o Tipo

        // ps: Autoboxing é a conversão automática que o compilador Java faz entre os tipos primitivos e suas classes wrapper de objeto correspondentes
        // ps2: Wrapper são um nome adicional ao padrão de projeto Decorator. Exemplo: Integer, que é o Wrapper do tipo primitivo int.
        int i = 5;
        Integer i2 = 5;
        Assert.assertEquals(Integer.valueOf(i),i2);
        Assert.assertEquals(i,i2.intValue());

        Assert.assertEquals("Bola","Bola");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));


        // o Assert irá procurar o método equals do Objeto 'Usuario'. Se estiver implementado, ele irá escalar até a superClasse de todas as classes OBJECT
        // a validacao aqui é se os objetos são (tipo Usuario)
        Usuario user1 = new Usuario("Usuario 1");
        Usuario user2 = new Usuario("Usuario 1");
        Usuario user3 = user2;
        Usuario user4 = null;
        Assert.assertEquals(user1,user2);

        // Dessa forma é possivel validar se são da mesma instancia.
        Assert.assertSame(user2,user3);

        Assert.assertNull(user4);
    }
}
