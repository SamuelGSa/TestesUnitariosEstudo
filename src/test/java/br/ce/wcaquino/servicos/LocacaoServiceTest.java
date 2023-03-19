package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test_valida_valor_e_data_locacao() throws Exception {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 2, 5.0);
		
		//Acao
		Locacao locacao = service.alugarFilme(usuarioteste, filmeTeste);
		
		//Verificacao

		Assert.assertThat(locacao.getValor(), is(equalTo(5.0)));
		assertThat(isMesmaData(locacao.getDataLocacao(),new Date()),is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1)),is(true));

		// Dessa forma é especificado a quantidade de  erros ao executar o teste.
//		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
//		error.checkThat(isMesmaData(locacao.getDataLocacao(),new Date()),is(true));
//		error.checkThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1)),is(true));
	}

// 3 formas de tratar uma exception com JUnit
// ELEGANTE = passa na Annotation que é esperado uma Exception.class
	@Test(expected=Exception.class)
	public void teste_deve_retornar_exception_elegante() throws Exception {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 0, 5.0);

		//Acao
		service.alugarFilme(usuarioteste, filmeTeste);
	}
// ROBUSTA = permite um controle melhor na tratativa
	@Test
	public void teste_deve_retornar_exception_robusta() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 0, 5.0);

		//Acao
		try {
			service.alugarFilme(usuarioteste, filmeTeste);
			Assert.fail("Deveria ter lançado uma Exceção");
		} catch (Exception e) {
			assertThat(e.getMessage(),is("Filme Sem Estoque"));
		}
	}
// FORMA NOVA = permite um controle melhor na tratativa
	@Test
	public void teste_deve_retornar_exception_nova() throws Exception {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 0, 5.0);

		expectedException.expect(Exception.class);
		expectedException.expectMessage("Filme Sem Estoque");

		//Acao
		service.alugarFilme(usuarioteste, filmeTeste);
	}
///////
}