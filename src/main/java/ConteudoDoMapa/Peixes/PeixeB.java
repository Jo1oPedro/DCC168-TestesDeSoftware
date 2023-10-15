package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Jogo.Jogo;
import Mapa.Mapa;

import java.util.Random;

public class PeixeB extends Peixe {

    @Override
    protected boolean regraMoverAcima() {
        IPeixe peixe = Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual() + 1, this.getColunaAtual());
        return peixe == null || peixe instanceof PeixeA;
    }

    @Override
    protected boolean regraMoverAbaixo() {
        IPeixe peixe = Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual() - 1, this.getColunaAtual());
        return peixe == null || peixe instanceof PeixeA;
    }

    @Override
    protected boolean regraMoverEsquerda() {
        IPeixe peixe = Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual(), this.getColunaAtual() - 1);
        return peixe == null || peixe instanceof PeixeA;
    }

    @Override
    protected boolean regraMoverDireita() {
        IPeixe peixe = Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual(), this.getColunaAtual() + 1);
        return peixe == null || peixe instanceof PeixeA;
    }

    @Override
    protected String sorteiaPosicaoParaMovimentar() {
        Random random = new Random();
        if(this.posicoesTentadas.size() - 1 > 0) {
            int direcao_indice = random.nextInt(this.posicoesTentadas.size() - 1);
            String direcao = this.posicoesTentadas.get(direcao_indice);
            this.posicoesTentadas.remove(direcao_indice);
            return direcao;
        }
        return "";
    }

    @Override
    public void reproduzir() {
        new PeixeB();
    }

    @Override
    public IPeixe come(IAlimento peixeA) {
        return this;
    }
}
