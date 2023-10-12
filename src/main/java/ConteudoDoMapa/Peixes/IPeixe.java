package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;

public interface IPeixe {
    public void moverCima();
    public void moverBaixo();
    public void moverEsquerda();
    public void moverDireita();
    public Integer getLinhaAtual();
    public Integer getColunaAtual();
    public IPeixe reproduzir();
    public void Come(IAlimento alimento);
}
