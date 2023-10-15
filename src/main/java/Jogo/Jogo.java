package Jogo;

import Mapa.Mapa;

import java.util.Scanner;

public class Jogo {
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
    private Jogo() {};

    public static Jogo getInstance() {
        if(jogo == null) {
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

        System.out.print("Digite a quantidade de colunas da matriz: ");
        this.numeroColunasMapa = this.scanner.nextInt();

        Mapa.getInstance().setTamanhoMapa(this.numeroLinhasMapa, this.numeroColunasMapa);
        this.defineNumeroPeixes();
    }

    private void defineNumeroPeixes() {
        System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até " + this.numeroLinhasMapa * this.numeroColunasMapa + " peixes): ");
        this.numeroPeixesA = this.scanner.nextInt();
        while(this.numeroPeixesA < 0 || this.numeroPeixesA > (this.numeroLinhasMapa * this.numeroColunasMapa)) {
            System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até " + this.numeroLinhasMapa * this.numeroColunasMapa + "peixes): ");
            this.numeroPeixesA = this.scanner.nextInt();
        }

        System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até " + ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesA) + " peixes): ");
        this.numeroPeixesB = this.scanner.nextInt();
        while(this.numeroPeixesB < 0 || this.numeroPeixesB > (this.numeroLinhasMapa * this.numeroColunasMapa - this.numeroPeixesA)) {
            System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até " + ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesB) + " peixes): ");
            this.numeroPeixesB = this.scanner.nextInt();
        }
        this.defineMovimentacaoReproducao();
    }

    private void defineMovimentacaoReproducao() {
        System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
        this.movimentacaoReproducaoPeixeA = this.scanner.nextInt();
        while(this.movimentacaoReproducaoPeixeA < 1) {
            System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
            this.movimentacaoReproducaoPeixeA = this.scanner.nextInt();
        }

        System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
        this.movimentacaoReproducaoPeixeB = this.scanner.nextInt();
        while(this.movimentacaoReproducaoPeixeB < 1) {
            System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
            this.movimentacaoReproducaoPeixeB = this.scanner.nextInt();
        }
        this.defineMovimentacaoMorte();
    }

    private void defineMovimentacaoMorte() {
        System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
        this.movimentacaoMortePeixeA = this.scanner.nextInt();
        while(this.movimentacaoMortePeixeA < 1) {
            System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
            this.movimentacaoMortePeixeA = this.scanner.nextInt();
        }

        System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
        this.movimentacaoMortePeixeB = this.scanner.nextInt();
        while(this.movimentacaoMortePeixeB < 1) {
            System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
            this.movimentacaoMortePeixeB = this.scanner.nextInt();
        }
    }

    public int getNumeroLinhasMapa() {
        return numeroLinhasMapa;
    }

    public int getNumeroColunasMapa() {
        return numeroColunasMapa;
    }

    public int getNumeroPeixesA() {
        return numeroPeixesA;
    }

    public int getNumeroPeixesB() {
        return numeroPeixesB;
    }

    public int getMovimentacaoReproducaoPeixeA() {
        return movimentacaoReproducaoPeixeA;
    }

    public int getMovimentacaoReproducaoPeixeB() {
        return movimentacaoReproducaoPeixeB;
    }

    public int getMovimentacaoMortePeixeA() {
        return movimentacaoMortePeixeA;
    }

    public int getMovimentacaoMortePeixeB() {
        return movimentacaoMortePeixeB;
    }

    public void iniciaJogo() {
        int finalizarJogo;
        do {

            System.out.print("Digite 1 para ver a proximo interação e 0 para sair: ");
            finalizarJogo = this.scanner.nextInt();
        } while (finalizarJogo != 0);
        this.scanner.close();
    }
}
