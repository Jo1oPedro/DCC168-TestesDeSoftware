package Peixes;

import Alimentos.IAlimento;

public abstract class Peixe implements IPeixe{

    private Integer linha;
    private Integer coluna;

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
    public Integer getLinha() {
        return linha;
    }

    @Override
    public Integer getColuna() {
        return coluna;
    }

    @Override
    public abstract IPeixe reproduzir();

    @Override
    public abstract void Come(IAlimento alimento);
}
