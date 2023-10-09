package Mapa;

import Peixes.IPeixe;
import Peixes.Peixe;

public class Mapa {
    private static Mapa mapa = null;
    private int[][] matriz_mapa;

    private final int CELULA_LIVRE = 0;

    private Mapa() {}

    public static Mapa getInstance()
    {
        if(mapa == null) {
            mapa = new Mapa();
        }
        return mapa;
    }

    public Mapa setTamanhoMapa(int linhas, int colunas) {
        this.matriz_mapa = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                this.matriz_mapa[i][j] = CELULA_LIVRE;
            }
        }
        return this;
    }

    public int[][] getMapa() {
        return this.matriz_mapa;
    }

    public int getPosicaoDoMapa(int linha, int coluna) {
        return this.matriz_mapa[linha][coluna];
    }

    public boolean verificaProximidades(int linha, int coluna)

    public Mapa insereNovoPeixe(IPeixe peixe) {

    }
}
