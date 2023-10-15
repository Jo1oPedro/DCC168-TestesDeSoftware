package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;

import javax.management.InvalidAttributeValueException;
import java.util.List;

public interface IPeixe {
    public IPeixe setLinhaAtual(int linhaAtual);
    public IPeixe setColunaAtual(int colunaAtual);
    public Integer getLinhaAtual();
    public Integer getColunaAtual();
    public List<String> verificaProximidades() throws InvalidAttributeValueException;
    public void reproduzir() throws InvalidAttributeValueException;
    public IPeixe come(IAlimento alimento);
    public void morre();
}
