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
}