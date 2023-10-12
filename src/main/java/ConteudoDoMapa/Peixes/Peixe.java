package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Mapa.IElementosDoMapa;

public abstract class Peixe implements IPeixe, IElementosDoMapa {

    private Integer linhaAtual;
    private Integer colunaAtual;

    @Override
    public void moverCima() {

    }

    @Override
    public void moverBaixo() {

    }

    @Override
    public void moverEsquerda() {

    }

    @Override
    public void moverDireita() {

    }

    @Override
    public Integer getLinhaAtual() {
        return this.linhaAtual;
    }

    @Override
    public Integer getColunaAtual() {
        return this.colunaAtual;
    }

    @Override
    public abstract IPeixe reproduzir();

    @Override
    public abstract void Come(IAlimento alimento);
}
