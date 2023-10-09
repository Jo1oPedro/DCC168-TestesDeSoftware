package Peixes;

import Alimentos.IAlimento;

public interface IPeixe {
    public void moverCima();
    public void moverBaixo();
    public void moverEsquerda();
    public void moverDireita();
    public Integer getLinha();
    public Integer getColuna();
    public IPeixe reproduzir();
    public void Come(IAlimento alimento);
}
