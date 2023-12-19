package Jogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;

import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import Mapa.Mapa;

public class Jogo {
	private List<IPeixe> peixes = new ArrayList<IPeixe>();
	private int numeroLinhasMapa;
	private int numeroColunasMapa;
	private int numeroPeixesA;
	private int numeroPeixesB;
	private int movimentacaoReproducaoPeixeA;
	private int movimentacaoReproducaoPeixeB;
	private int movimentacaoMortePeixeA;
	private int movimentacaoMortePeixeB;

	private Scanner scanner = new Scanner(System.in);
	private static Jogo jogo = null;

	private Jogo() {
	};

	public static Jogo getInstance() {
		if (jogo == null) {
			jogo = new Jogo();
		}
		return jogo;
	}

	public Jogo defineParametros() {
		this.defineTamanhoMapa();
		return this;
	}

	private void defineTamanhoMapa() {
		System.out.print("Digite a quantidade de linhas da matriz: ");
		this.numeroLinhasMapa = this.scanner.nextInt();
		while (this.numeroLinhasMapa < 2 || this.numeroLinhasMapa > 30) {
			System.out.print("Digite a quantidade de linhas da matriz: ");
			this.numeroLinhasMapa = this.scanner.nextInt();
		}

		System.out.print("Digite a quantidade de colunas da matriz: ");
		this.numeroColunasMapa = this.scanner.nextInt();
		while (this.numeroColunasMapa < 2 || this.numeroColunasMapa > 30) {
			System.out.print("Digite a quantidade de colunas da matriz: ");
			this.numeroColunasMapa = this.scanner.nextInt();
		}

		Mapa.getInstance().setTamanhoMapa(this.numeroLinhasMapa, this.numeroColunasMapa);
		this.defineNumeroPeixes();
	}

	private void defineNumeroPeixes() {
		System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até "
				+ this.numeroLinhasMapa * this.numeroColunasMapa + " peixes): ");
		this.numeroPeixesA = this.scanner.nextInt();
		while (this.numeroPeixesA < 0 || this.numeroPeixesA > (this.numeroLinhasMapa * this.numeroColunasMapa)) {
			System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até "
					+ this.numeroLinhasMapa * this.numeroColunasMapa + "peixes): ");
			this.numeroPeixesA = this.scanner.nextInt();
		}

		System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até "
				+ ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesA) + " peixes): ");
		this.numeroPeixesB = this.scanner.nextInt();
		while (this.numeroPeixesB < 0
				|| this.numeroPeixesB > (this.numeroLinhasMapa * this.numeroColunasMapa - this.numeroPeixesA)) {
			System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até "
					+ ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesB) + " peixes): ");
			this.numeroPeixesB = this.scanner.nextInt();
		}
		this.defineMovimentacaoReproducao();
	}

	private void defineMovimentacaoReproducao() {
		System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
		this.movimentacaoReproducaoPeixeA = this.scanner.nextInt();
		while (this.movimentacaoReproducaoPeixeA < 1) {
			System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
			this.movimentacaoReproducaoPeixeA = this.scanner.nextInt();
		}

		System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
		this.movimentacaoReproducaoPeixeB = this.scanner.nextInt();
		while (this.movimentacaoReproducaoPeixeB < 1) {
			System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
			this.movimentacaoReproducaoPeixeB = this.scanner.nextInt();
		}
		this.defineMovimentacaoMorte();
	}

	private void defineMovimentacaoMorte() {
		System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
		this.movimentacaoMortePeixeA = this.scanner.nextInt();
		while (this.movimentacaoMortePeixeA < 1) {
			System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
			this.movimentacaoMortePeixeA = this.scanner.nextInt();
		}

		System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
		this.movimentacaoMortePeixeB = this.scanner.nextInt();
		while (this.movimentacaoMortePeixeB < 1) {
			System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
			this.movimentacaoMortePeixeB = this.scanner.nextInt();
		}
	}

	private int respostaJanela() {
		int resposta = -1;
		while (resposta != 0 && resposta != 1) {
			String input = JOptionPane.showInputDialog(null, "Digite 1 para ver a próxima interação e 0 para sair",
					"Interação", JOptionPane.QUESTION_MESSAGE);

			if (input == null) {
				// O usuário clicou no botão Fechar ou Cancelar
				resposta = 0;
			} else {
				try {
					resposta = Integer.parseInt(input);

					if (resposta != 0 && resposta != 1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite 1 ou 0", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, digite 1 ou 0", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return resposta;
	}

	public int getNumeroLinhasMapa() {
		return numeroLinhasMapa;
	}

	public void setNumeroLinhasMapa(int numeroLinhasMapa) {
		this.numeroLinhasMapa = numeroLinhasMapa;
	}

	public int getNumeroColunasMapa() {
		return numeroColunasMapa;
	}

	public void setNumeroColunasMapa(int numeroColunasMapa) {
		this.numeroColunasMapa = numeroColunasMapa;
	}

	public int getNumeroPeixesA() {
		return numeroPeixesA;
	}

	public void setNumeroPeixesA(int numeroPeixesA) {
		this.numeroPeixesA = numeroPeixesA;
	}

	public int getNumeroPeixesB() {
		return numeroPeixesB;
	}

	public void setNumeroPeixesB(int numeroPeixesB) {
		this.numeroPeixesB = numeroPeixesB;
	}

	public int getMovimentacaoReproducaoPeixeA() {
		return movimentacaoReproducaoPeixeA;
	}

	public void setMovimentacaoReproducaoPeixeA(int movimentacaoReproducaoPeixeA) {
		this.movimentacaoReproducaoPeixeA = movimentacaoReproducaoPeixeA;
	}

	public int getMovimentacaoReproducaoPeixeB() {
		return movimentacaoReproducaoPeixeB;
	}

	public void setMovimentacaoReproducaoPeixeB(int movimentacaoReproducaoPeixeB) {
		this.movimentacaoReproducaoPeixeB = movimentacaoReproducaoPeixeB;
	}

	public int getMovimentacaoMortePeixeA() {
		return movimentacaoMortePeixeA;
	}

	public void setMovimentacaoMortePeixeA(int movimentacaoMortePeixeA) {
		this.movimentacaoMortePeixeA = movimentacaoMortePeixeA;
	}

	public int getMovimentacaoMortePeixeB() {
		return movimentacaoMortePeixeB;
	}

	public void setMovimentacaoMortePeixeB(int movimentacaoMortePeixeB) {
		this.movimentacaoMortePeixeB = movimentacaoMortePeixeB;
	}

	public List<IPeixe> getPeixes() {
		return peixes;
	}

	public Jogo setPeixe(IPeixe peixe) {
		this.peixes.add(peixe);
		return this;
	}
	
	/*1*/public void iniciaJogo() throws InvalidAttributeValueException {
	/*1*/	int finalizarJogo;
	/*1*/	System.out.println("Aguarde! Será aberto uma janela gráfica!");
	/*2*/	for (int i = 0; i < this.numeroPeixesA; i++) {
	/*3*/		Random random = new Random();
	/*3*/		int linha;
	/*3*/		int coluna;
	/*4*/		do {
	/*4*/			linha = random.nextInt(this.numeroLinhasMapa);
	/*4*/			coluna = random.nextInt(this.numeroColunasMapa);
	/*5*/		} while (Mapa.getInstance().getPosicaoDoMapa(linha, coluna) != null);
	/*6*/		IPeixe peixeA = new PeixeA().setLinhaAtual(linha).setColunaAtual(coluna);
	/*6*/		Mapa.getInstance().insereNovoPeixe(peixeA);
	/*6*/		this.setPeixe(peixeA);
	/*6*/	}

	/*7*/	for (int i = 0; i < this.numeroPeixesB; i++) {
	/*8*/		Random random = new Random();
	/*8*/		int linha;
	/*8*/		int coluna;
	/*9*/		do {
	/*9*/			linha = random.nextInt(this.numeroLinhasMapa);
	/*9*/			coluna = random.nextInt(this.numeroColunasMapa);
	/*10*/		} while (Mapa.getInstance().getPosicaoDoMapa(linha, coluna) != null);
	/*11*/		IPeixe peixeB = new PeixeB().setLinhaAtual(linha).setColunaAtual(coluna);
	/*11*/		Mapa.getInstance().insereNovoPeixe(peixeB);
	/*11*/		this.setPeixe(peixeB);
	/*11*/	}
	
	/*12*/	if(!this.getPeixes().isEmpty()){
	/*13*/		int posicao = 0;
	/*14*/		do {		
	/*14*/			this.getPeixes().get(posicao).mover();
	/*14*/			posicao++;
	/*14*/			Mapa.getInstance().imprimeMapa();
					System.out.println("Tamanho: " +this.getPeixes().size());
	/*14*/			if (posicao >= this.getPeixes().size()) {
	/*15*/				posicao = 0;
	/*16*/			}
	/*16*/			if (this.getPeixes().stream().noneMatch(peixe -> peixe instanceof PeixeB)) {
	/*17*/				JOptionPane.showMessageDialog(null, "Todos os peixes do tipo B morreram", "Informação",
	/*17*/						JOptionPane.INFORMATION_MESSAGE, null);
	/*17*/				break;
	/*18*/			}
	/*18*/			finalizarJogo = respostaJanela();
	/*19*/		} while (finalizarJogo != 0);
	/*20*/		this.scanner.close();
	/*20*/		}
	/*21*/		else
	/*21*/			JOptionPane.showMessageDialog(null, "Não há peixes!", "Erro!", JOptionPane.ERROR_MESSAGE);
	/*22*/}
}
