package Jogo;

import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import Mapa.Mapa;
import com.sun.security.jgss.GSSUtil;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public List<IPeixe> getPeixes() {
        return peixes;
    }

    public Jogo setPeixe(IPeixe peixe) {
        this.peixes.add(peixe);
        return this;
    }

    public void iniciaJogo() throws InvalidAttributeValueException {
        int finalizarJogo;
        for (int i = 0; i < this.numeroPeixesA; i++) {
            Random random = new Random();
            int linha;
            int coluna;
            do {
                linha = random.nextInt(this.numeroLinhasMapa - 1);
                coluna = random.nextInt(this.numeroColunasMapa - 1);
            } while (Mapa.getInstance().getPosicaoDoMapa(linha, coluna) != null);
            IPeixe peixeA = new PeixeA().setLinhaAtual(linha).setColunaAtual(coluna);
            Mapa.getInstance().insereNovoPeixe(peixeA);
            this.setPeixe(peixeA);
        }

        for (int i = 0; i < this.numeroPeixesB; i++) {
            Random random = new Random();
            int linha;
            int coluna;
            do {
                linha = random.nextInt(this.numeroLinhasMapa);
                coluna = random.nextInt(this.numeroColunasMapa);
                System.out.println("linha: " + linha  + " coluna: " + coluna);
            } while (Mapa.getInstance().getPosicaoDoMapa(linha, coluna) != null);
            IPeixe peixeB = new PeixeB().setLinhaAtual(linha).setColunaAtual(coluna);
            Mapa.getInstance().insereNovoPeixe(peixeB);
            this.setPeixe(peixeB);
        }

        int posicao = 0;
        do {
            this.getPeixes().get(posicao).mover();
            posicao++;
            if(posicao >= this.getPeixes().size()) {
                posicao = 0;
            }
            if(this.getPeixes().isEmpty()) {
                System.out.println("Todos os peixes morreram");
                return;
            }
            //System.out.print("Digite 1 para ver a proxima interação e 0 para sair: ");
            finalizarJogo = 1;//this.scanner.nextInt();
        } while (finalizarJogo != 0);
        this.scanner.close();
    }
}
