package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		TipoDeEspetaculo tipo = sessao.getEspetaculo().getTipo(); 
		if(sessao.estaQuaseLotada()) { 
			preco = sessao.getPreco().add(calculaSobrepreco(sessao.getPreco(), tipo.getTaxaSobrepreco()));
		} else {
			preco = sessao.getPreco();
		}

		if(deveAplicarSobreprecoDuracao(sessao, tipo)){
			preco = preco.add(calculaSobrepreco(sessao.getPreco(), tipo.getTaxaSobreprecoPorDuracao()));
		}

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static boolean deveAplicarSobreprecoDuracao(Sessao sessao,
			TipoDeEspetaculo tipo) {
		return tipo.getDuracaoParaSobrePreco()>0 && sessao.getDuracaoEmMinutos() > tipo.getDuracaoParaSobrePreco();
	}
	
	private static BigDecimal calculaSobrepreco(BigDecimal preco, double taxa) {
		return preco.multiply(BigDecimal.valueOf(taxa));
	}

}