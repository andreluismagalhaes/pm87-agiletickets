package br.com.caelum.agiletickets.models;

import static br.com.caelum.agiletickets.models.Constantes.CINCO_POR_CENTO;
import static br.com.caelum.agiletickets.models.Constantes.CINQUENTA_POR_CENTO;
import static br.com.caelum.agiletickets.models.Constantes.DEZ_POR_CENTO;
import static br.com.caelum.agiletickets.models.Constantes.VINTE_POR_CENTO;
import static br.com.caelum.agiletickets.models.Constantes.ZERO;
import static br.com.caelum.agiletickets.models.Constantes.ZERO_POR_CENTO;

public enum TipoDeEspetaculo {
	
	CINEMA(CINCO_POR_CENTO,DEZ_POR_CENTO,ZERO_POR_CENTO,ZERO),
	SHOW(CINCO_POR_CENTO,DEZ_POR_CENTO,ZERO_POR_CENTO,ZERO),
	TEATRO(ZERO_POR_CENTO,ZERO_POR_CENTO,ZERO_POR_CENTO,ZERO),
	BALLET(CINQUENTA_POR_CENTO,VINTE_POR_CENTO,DEZ_POR_CENTO,60),	
	ORQUESTRA(CINQUENTA_POR_CENTO,VINTE_POR_CENTO,DEZ_POR_CENTO,60);
	
	
	private double indiceLotacaoSobrepreco = 0;
	private double taxaSobrepreco = 0;
	private double taxaSobreprecoPorDuracao = 0;
	private int duracaoParaSobrePreco = 0;	
	
	private TipoDeEspetaculo(
			double indiceLotacaoSobrepreco,
			double taxaSobrepreco, 
			double taxaSobreprecoPorDuracao,
			int duracaoParaSobrePreco) {
		this.indiceLotacaoSobrepreco = indiceLotacaoSobrepreco;
		this.taxaSobrepreco = taxaSobrepreco;
		this.taxaSobreprecoPorDuracao = taxaSobreprecoPorDuracao;
		this.duracaoParaSobrePreco = duracaoParaSobrePreco;
	}


	public double getIndiceLotacaoSobrepreco() {
		return indiceLotacaoSobrepreco;
	}
	public double getTaxaSobrepreco() {
		return taxaSobrepreco;
	}
	
	public double getTaxaSobreprecoPorDuracao() {
		return taxaSobreprecoPorDuracao;
	}

	public int getDuracaoParaSobrePreco() {
		return duracaoParaSobrePreco;
	}
	
	
}class Constantes{
	
	public static final int ZERO = 0;
	public static final double ZERO_POR_CENTO = 0.0;
	public static final double CINCO_POR_CENTO = 0.05;
	public static final double DEZ_POR_CENTO = 0.10;
	public static final double VINTE_POR_CENTO = 0.20;
	public static final double CINQUENTA_POR_CENTO = 0.50;

}
