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

    private static Jogo jogo = null;
    private Jogo() {};

    public static Jogo getInstance() {
        if(jogo == null) {
            jogo = new Jogo();
        }
        return jogo;
    }

    public void defineParametros() {
        Scanner scanner = new Scanner(System.in);
        this.defineTamanhoMapa(scanner);
        scanner.close();
    }

    private void defineTamanhoMapa(Scanner scanner) {
        System.out.print("Digite a quantidade de linhas da matriz: ");
        this.numeroLinhasMapa = scanner.nextInt();

        System.out.print("Digite a quantidade de colunas da matriz: ");
        this.numeroColunasMapa = scanner.nextInt();

        Mapa.getInstance().setTamanhoMapa(this.numeroLinhasMapa, this.numeroColunasMapa);
        this.defineNumeroPeixes(scanner);
    }

    private void defineNumeroPeixes(Scanner scanner) {
        System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até " + this.numeroLinhasMapa * this.numeroColunasMapa + " peixes): ");
        this.numeroPeixesA = scanner.nextInt();
        while(this.numeroPeixesA < 0 || this.numeroPeixesA > (this.numeroLinhasMapa * this.numeroColunasMapa)) {
            System.out.print("Digite a quantidade de peixes do tipo A(É possível inserir de 0 até " + this.numeroLinhasMapa * this.numeroColunasMapa + "peixes): ");
            this.numeroPeixesA = scanner.nextInt();
        }

        System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até " + ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesA) + " peixes): ");
        this.numeroPeixesB = scanner.nextInt();
        while(this.numeroPeixesB < 0 || this.numeroPeixesB > (this.numeroLinhasMapa * this.numeroColunasMapa - this.numeroPeixesA)) {
            System.out.print("Digite a quantidade de peixes do tipo B(É possível inserir de 0 até " + ((this.numeroLinhasMapa * this.numeroColunasMapa) - this.numeroPeixesB) + " peixes): ");
            this.numeroPeixesB = scanner.nextInt();
        }
        this.defineMovimentacaoReproducao(scanner);
    }

    private void defineMovimentacaoReproducao(Scanner scanner) {
        System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
        this.movimentacaoReproducaoPeixeA = scanner.nextInt();
        while(this.movimentacaoReproducaoPeixeA < 1) {
            System.out.print("Digite a quantidade de movimentações para reprodução do peixe A: ");
            this.movimentacaoReproducaoPeixeA = scanner.nextInt();
        }

        System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
        this.movimentacaoReproducaoPeixeB = scanner.nextInt();
        while(this.movimentacaoReproducaoPeixeB < 1) {
            System.out.print("Digite a quantidade de movimentações para reprodução do peixe B: ");
            this.movimentacaoReproducaoPeixeB = scanner.nextInt();
        }
        this.defineMovimentacaoMorte(scanner);
    }

    private void defineMovimentacaoMorte(Scanner scanner) {
        System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
        this.movimentacaoMortePeixeA = scanner.nextInt();
        while(this.movimentacaoMortePeixeA < 1) {
            System.out.print("Digite a quantidade de movimentações para morte do peixe A: ");
            this.movimentacaoMortePeixeA = scanner.nextInt();
        }

        System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
        this.movimentacaoMortePeixeB = scanner.nextInt();
        while(this.movimentacaoMortePeixeB < 1) {
            System.out.print("Digite a quantidade de movimentações para morte do peixe B: ");
            this.movimentacaoMortePeixeB = scanner.nextInt();
        }
    }
}
