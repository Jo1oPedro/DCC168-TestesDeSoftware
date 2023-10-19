package Mapa;

import ConteudoDoMapa.Alimentos.IAlimento;
import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.Peixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;

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

    public Mapa removePeixe(IPeixe peixe) throws InvalidAttributeValueException {
        if(this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()] instanceof PeixeA && peixe instanceof PeixeB) {
            peixe.come((IAlimento) this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()]);
        }
        this.matriz_mapa[peixe.getLinhaAtual()][peixe.getColunaAtual()] = null;
        return this;
    }

    public void imprimeMapa()
    {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body><table border='1'>");

        for (IPeixe[] iPeixes : matriz_mapa) {
            htmlBuilder.append("<tr>");
            for (IPeixe iPeixe : iPeixes) {
                if(iPeixe != null)
                    htmlBuilder.append("<td>").append(iPeixe.getClass().getSimpleName()).append("</td>");
                else
                    htmlBuilder.append("<td>").append(" ").append("</td>");
            }
            htmlBuilder.append("</tr>");
        }

        htmlBuilder.append("</table></body></html>");

        // Exiba a matriz em um JOptionPane
        JOptionPane.showMessageDialog(null, htmlBuilder.toString(), "Matriz", JOptionPane.INFORMATION_MESSAGE);
    }
}
