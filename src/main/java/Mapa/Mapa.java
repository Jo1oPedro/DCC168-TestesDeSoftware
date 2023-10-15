package Mapa;

import ConteudoDoMapa.Alimentos.IAlimento;
import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.Peixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;

public class Mapa {
    private static Mapa mapa = null;
    private IPeixe[][] matriz_mapa;

    private Mapa() {}

    public static Mapa getInstance()
    {
        if(mapa == null) {
            mapa = new Mapa();
        }
        return mapa;
    }

    public Mapa setTamanhoMapa(int linhas, int colunas) {
        this.matriz_mapa = new IPeixe[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                this.matriz_mapa[i][j] = null;
            }
        }
        return this;
    }

    public IPeixe[][] getMapa() {
        return this.matriz_mapa;
    }

    public IPeixe getPosicaoDoMapa(int linha, int coluna) {
        return this.matriz_mapa[linha][coluna];
    }

    public Mapa insereNovoPeixe(IPeixe peixe) {
        this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()] = peixe;
        return this;
    }

    public Mapa removePeixe(IPeixe peixe) {
        if(this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()] instanceof PeixeA && peixe instanceof PeixeB) {
            peixe.come((IAlimento) this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()]);
        }
        this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()] = null;
        return this;
    }
}
