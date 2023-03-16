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
import org.junit.jupiter.api.Test;

class LocacaoServiceTest {
	@Test
	public void test_valida_valor_e_data_locacao() {
		//Cenario
		LocacaoService service = new LocacaoService();
		Usuario usuarioteste = new Usuario("Usuario 1");
		Filme filmeTeste = new Filme("Filme1", 2, 5.0);
		
		//Acao
		Locacao locacao = service.alugarFilme(usuarioteste, filmeTeste);
		
		//Verificacao
//		Assert.assertEquals(5.0,locacao.getValor(), 0.01);

//		Assert.assertThat(locacao.getValor(),CoreMatchers.is(CoreMatchers.equalTo(5.0)));
		Assert.assertThat(locacao.getValor(), is(equalTo(5.0)));
//		Assert.assertThat(locacao.getValor(), is(not(6.0)));

//		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
//		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		assertThat(isMesmaData(locacao.getDataLocacao(),new Date()),is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1)),is(true));

				
		
	}
}