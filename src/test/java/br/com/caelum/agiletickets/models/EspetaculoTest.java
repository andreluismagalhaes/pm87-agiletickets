package br.com.caelum.agiletickets.models;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}
	
	@Test
	public void criarSessoesParaUmDia() {
		Espetaculo ivete = new Espetaculo();
		LocalDate diaInicial = new LocalDate();
		LocalDate diaFinal = diaInicial.plusDays(0);
		LocalTime horario = new LocalTime().plusHours(1);
		Periodicidade periodicidade = Periodicidade.DIARIA;
		List<Sessao>  sessoes=  ivete.criaSessoes(diaInicial, diaFinal, horario, periodicidade);

		assertTrue(sessoes!=null);
		assertTrue(sessoes.size()==1);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void criarSessoesParaDataInicialMenorQueDataAtual() {
		Espetaculo ivete = new Espetaculo();
		LocalDate diaInicial = new LocalDate(2014,1,1);
		LocalDate diaFinal = diaInicial.plusDays(31);
		LocalTime horario = new LocalTime(8,15);
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		 ivete.criaSessoes(diaInicial, diaFinal, horario, periodicidade);

		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void criarSessoesParaDataInicialMaiorQueDataFinal() {
		Espetaculo ivete = new Espetaculo();
		LocalDate hoje = new LocalDate();
		LocalDate diaInicial = new LocalDate(hoje.getYear()+1,1,1);
		LocalDate diaFinal = diaInicial.plusDays(-31);
		LocalTime horario = new LocalTime(8,15);
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		 ivete.criaSessoes(diaInicial, diaFinal, horario, periodicidade);

		
	}
	@Test(expected=IllegalArgumentException.class)
	public void criarSessoesParaHorarioAnteriorAoHorarioAtual() {
		Espetaculo ivete = new Espetaculo();
		LocalDate hoje = new LocalDate();
		LocalDate diaFinal = hoje.plusDays(31);
		LocalTime horario = new LocalTime().plusHours(-1);
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		 ivete.criaSessoes(hoje, diaFinal, horario, periodicidade);
		
	}
	
	@Test
	public void criarSessoesParaCincoDias() {
		Espetaculo ivete = new Espetaculo();
		LocalDate diaInicial = new LocalDate();
		LocalDate diaFinal = diaInicial.plusDays(4);
		LocalTime horario = new LocalTime().plusHours(1);
		Periodicidade periodicidade = Periodicidade.DIARIA;
		List<Sessao>  sessoes=  ivete.criaSessoes(diaInicial, diaFinal, horario, periodicidade);

		assertTrue(sessoes!=null);
		assertTrue(sessoes.size()==5);
	}
	
	@Test
	public void criarSessoesSemanaisPorUmMes() {
		Espetaculo ivete = new Espetaculo();
		LocalDate hoje = new LocalDate();
		LocalDate diaInicial = new LocalDate(hoje.getYear()+1,1,1);
		LocalDate diaFinal = diaInicial.plusDays(31);
		LocalTime horario = new LocalTime(8,15);
		Periodicidade periodicidade = Periodicidade.SEMANAL;
		List<Sessao>  sessoes=  ivete.criaSessoes(diaInicial, diaFinal, horario, periodicidade);

		
		assertTrue(sessoes!=null);
		assertTrue(sessoes.size()==5);
		assertEquals(1, sessoes.get(0).getInicio().getDayOfMonth());
		assertEquals(8, sessoes.get(1).getInicio().getDayOfMonth());
		assertEquals(15, sessoes.get(2).getInicio().getDayOfMonth());
		assertEquals(22, sessoes.get(3).getInicio().getDayOfMonth());
		assertEquals(29, sessoes.get(4).getInicio().getDayOfMonth());
		assertEquals(8, sessoes.get(0).getInicio().getHourOfDay());
		
	}
	
	

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	
}
