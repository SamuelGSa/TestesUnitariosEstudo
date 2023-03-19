package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;

class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Test
	public void test_valida_valor_e_data_locacao() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 2, 5.0);
		
		//Acao
		Locacao locacao = service.alugarFilme(usuarioteste, filmeTeste);
		
		//Verificacao

//		Assert.assertThat(locacao.getValor(), is(equalTo(5.0)));
//		assertThat(isMesmaData(locacao.getDataLocacao(),new Date()),is(true));
//		assertThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1)),is(true));

		// Dessa forma é especificado a quantidade de  erros ao executar o teste.
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(),new Date()),is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1)),is(true));

				
		
	}
}