package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exception.FilmeSemEstoqueException;
import br.ce.wcaquino.exception.LocadoraExpection;
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
	@Test(expected= FilmeSemEstoqueException.class)
	public void teste_deve_retornar_exception_elegante() throws Exception {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 0, 5.0);

		//Acao
		service.alugarFilme(usuarioteste, filmeTeste);

		// Forma Elegante = passa na Annotation que é esperado uma Exception.class
	}

	@Test
	public void teste_usuario_vazio() throws FilmeSemEstoqueException {
		//cenario
		LocacaoService service = new LocacaoService();
		Filme filmeTeste = new Filme("Filme1", 2, 5.0);

		//acao
		try {
			service.alugarFilme(null, filmeTeste);
			Assert.fail();
		}
		 catch (LocadoraExpection e) {
			Assert.assertThat(e.getMessage(),is("Usuario Vazio"));
		}
		// Forma Robusta
	}

	@Test
	public void teste_filme_vazio() throws LocadoraExpection, FilmeSemEstoqueException {
		//cenario
 		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");

		expectedException.expect(LocadoraExpection.class);
		expectedException.expectMessage("Filme Vazio");

		//acao
		service.alugarFilme(usuarioteste, null);
	}
	// Forma Nova
}