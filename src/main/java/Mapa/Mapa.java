package Mapa;

import ConteudoDoMapa.CelulaVazia;
import ConteudoDoMapa.Peixes.IPeixe;

public class Mapa {
    private static Mapa mapa = null;
    private IElementosDoMapa[][] matriz_mapa;


    private Mapa() {}

    public static Mapa getInstance()
    {
        if(mapa == null) {
            mapa = new Mapa();
        }
        return mapa;
    }

    public Mapa setTamanhoMapa(int linhas, int colunas) {
        this.matriz_mapa = new IElementosDoMapa[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                this.matriz_mapa[i][j] = new CelulaVazia();
            }
        }
        return this;
    }

    public IElementosDoMapa[][] getMapa() {
        return this.matriz_mapa;
    }

    public IElementosDoMapa getPosicaoDoMapa(int linha, int coluna) {
        return this.matriz_mapa[linha][coluna];
    }

    public boolean verificaProximidades(int linha, int coluna) {
        return true;
    }

    public Mapa insereNovoElemento(int linha, int coluna, IElementosDoMapa elemento) {
        this.matriz_mapa[linha][coluna] = elemento;
        return this;
    }
}
