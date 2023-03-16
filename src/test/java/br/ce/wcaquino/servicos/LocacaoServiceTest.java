package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;

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
		Assert.assertTrue(locacao.getValor() == 5);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(),new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
				
		
	}
}