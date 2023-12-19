package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import Jogo.Jogo;

public class JogoTest {

	private Jogo jogo;

	@Before
	public void setUp() {
		this.jogo = Jogo.getInstance();
	}
	
	@After
	public void tearDown() {
		this.jogo = null;
	}
	
	
	/*
	Todos os caminhos simples
	@Test
	public void testCaminhos() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(8);
		jogo.setNumeroColunasMapa(8);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(1);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(1);

		// Assertions
		assertEquals(8, jogo.getNumeroLinhasMapa());
		assertEquals(8, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(1, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(1, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}

	@Test
	public void testDe() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(1);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(1);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(1);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(1, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(1, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(1, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testDefine() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(10);
		jogo.setNumeroPeixesB(5);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(1);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(1);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(10, jogo.getNumeroPeixesA());
		assertEquals(5, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(1, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(1, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	/*
	
	@Test
	public void testDefine() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	/*
	@Test
	public void testCaminhos1() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testCaminhos2() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(1);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(1, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	
	@Test
	public void testCaminhos3() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(1);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(1, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testCaminhos4() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(8);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(8, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testCaminhos5() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(1);
		jogo.setNumeroPeixesB(1);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(1, jogo.getNumeroPeixesA());
		assertEquals(1, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testCaminhos6() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(10);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(10, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
	@Test
	public void testCaminhos7() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(1);
		jogo.setMovimentacaoReproducaoPeixeA(4);
		jogo.setMovimentacaoReproducaoPeixeB(6);
		jogo.setMovimentacaoMortePeixeA(7);
		jogo.setMovimentacaoMortePeixeB(2);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(1, jogo.getNumeroPeixesB());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(6, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(7, jogo.getMovimentacaoMortePeixeA());
		assertEquals(2, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	/*
	@Test
	public void testDefineParametros() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(0);
		jogo.setNumeroColunasMapa(0);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(-20);
		jogo.setNumeroPeixesB(-30);
		jogo.setMovimentacaoReproducaoPeixeA(0);
		jogo.setMovimentacaoReproducaoPeixeB(-8);
		jogo.setMovimentacaoMortePeixeA(0);
		jogo.setMovimentacaoMortePeixeB(-50);

		// Assertions
		assertEquals(0, jogo.getNumeroLinhasMapa());
		assertEquals(0, jogo.getNumeroColunasMapa());
		assertEquals(-20, jogo.getNumeroPeixesA());
		assertEquals(-30, jogo.getNumeroPeixesB());
		assertEquals(0, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(-8, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(0, jogo.getMovimentacaoMortePeixeA());
		assertEquals(-50, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	
	/*
	@Test
	public void testDefineParametros() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(5);
		jogo.setNumeroColunasMapa(5);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(1);
		jogo.setNumeroPeixesB(1);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(2);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(4);

		// Assertions
		assertEquals(5, jogo.getNumeroLinhasMapa());
		assertEquals(5, jogo.getNumeroColunasMapa());
		assertEquals(1, jogo.getNumeroPeixesA());
		assertEquals(1, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(4, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	/*
	@Test
	public void testDefineParametros() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(12);
		jogo.setNumeroColunasMapa(12);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(20);
		jogo.setNumeroPeixesB(0);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(2);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(4);

		// Assertions
		assertEquals(12, jogo.getNumeroLinhasMapa());
		assertEquals(12, jogo.getNumeroColunasMapa());
		assertEquals(20, jogo.getNumeroPeixesA());
		assertEquals(0, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(4, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	/*
	@Test
	public void testDefineParametros() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(12);
		jogo.setNumeroColunasMapa(12);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(4);
		jogo.setNumeroPeixesB(4);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(2);
		jogo.setMovimentacaoMortePeixeA(1);
		jogo.setMovimentacaoMortePeixeB(4);

		// Assertions
		assertEquals(12, jogo.getNumeroLinhasMapa());
		assertEquals(12, jogo.getNumeroColunasMapa());
		assertEquals(4, jogo.getNumeroPeixesA());
		assertEquals(4, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(1, jogo.getMovimentacaoMortePeixeA());
		assertEquals(4, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	*/
	
	
	@Test
	public void testDefineParametros() throws InvalidAttributeValueException {
		jogo.setNumeroLinhasMapa(4);
		jogo.setNumeroColunasMapa(4);
		Mapa.Mapa.getInstance().setTamanhoMapa(jogo.getNumeroLinhasMapa(), jogo.getNumeroColunasMapa());
		jogo.setNumeroPeixesA(0);
		jogo.setNumeroPeixesB(1);
		jogo.setMovimentacaoReproducaoPeixeA(2);
		jogo.setMovimentacaoReproducaoPeixeB(4);
		jogo.setMovimentacaoMortePeixeA(3);
		jogo.setMovimentacaoMortePeixeB(1);

		// Assertions
		assertEquals(4, jogo.getNumeroLinhasMapa());
		assertEquals(4, jogo.getNumeroColunasMapa());
		assertEquals(0, jogo.getNumeroPeixesA());
		assertEquals(1, jogo.getNumeroPeixesB());
		assertEquals(2, jogo.getMovimentacaoReproducaoPeixeA());
		assertEquals(4, jogo.getMovimentacaoReproducaoPeixeB());
		assertEquals(3, jogo.getMovimentacaoMortePeixeA());
		assertEquals(1, jogo.getMovimentacaoMortePeixeB());

		jogo.iniciaJogo();
	}
	
}