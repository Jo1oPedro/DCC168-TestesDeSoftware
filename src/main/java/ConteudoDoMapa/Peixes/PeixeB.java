package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Jogo.Jogo;
import Mapa.Mapa;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PeixeB extends Peixe {

    private int peixesComidos = 0;

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
    protected String[] sorteiaPosicaoParaMovimentar() throws InvalidAttributeValueException, PeixeMortoException {
        Random random = new Random();
        List<String> proximidades = this.verificaProximidades();
        List<String> proximidadesPeixeA = new ArrayList<String>();
        List<String> proximidadesVazias = new ArrayList<String>();

        if(proximidades.size() - 1 > 0) {
            for(String posicao : proximidades) {
                String[] posicoes = posicao.split(",");
                IPeixe posicaoDoMapa = Mapa.getInstance().getPosicaoDoMapa(Integer.parseInt(posicoes[0]), Integer.parseInt(posicoes[1]));
                if(posicaoDoMapa == null) {
                    proximidadesVazias.add(posicao);
                } else if(posicaoDoMapa instanceof PeixeA) {
                    proximidadesPeixeA.add(posicao);
                }
            }

            String[] direcoes;

            if(!proximidadesPeixeA.isEmpty()) {
                if(proximidadesPeixeA.size() == 1) {
                    return proximidadesPeixeA.get(0).split(",");
                } else if(proximidadesPeixeA.size() > 1) {
                    int indice = random.nextInt(proximidadesPeixeA.size() - 1);
                    return proximidadesPeixeA.get(indice).split(",");
                }
            }

            if(!proximidadesVazias.isEmpty()) {
                if(proximidadesVazias.size() == 1) {
                    this.incrementaMovimentoInvalido();
                    return proximidadesVazias.get(0).split(",");
                } else if(proximidadesVazias.size() > 1) {
                    this.incrementaMovimentoInvalido();
                    int indice = random.nextInt(proximidadesVazias.size() - 1);
                    return proximidadesVazias.get(indice).split(",");
                }
            }
        }
        return new String[]{"", ""};
    }

    @Override
    public void reproduzir() throws InvalidAttributeValueException {
        if(this.peixesComidos == Jogo.getInstance().getMovimentacaoReproducaoPeixeB()) {
            this.resetaMovimentoValido().resetaMovimentoInvalido();
            this.peixesComidos = 0;
            Random random = new Random();
            PeixeB peixeB = new PeixeB();
            List<String> proximidades = this.verificaProximidades();
            int direcao_indice;
            if(proximidades.size() - 1 >= 0) {
                if(proximidades.size() - 1 >= 0) {
                    direcao_indice = 0;
                } else {
                    direcao_indice = random.nextInt(proximidades.size() - 1);
                }
                String[] valores = proximidades.get(direcao_indice).split(",");
                peixeB.setLinhaAtual(Integer.parseInt(valores[0])).setColunaAtual(Integer.parseInt(valores[1]));
                Mapa.getInstance().insereNovoPeixe(peixeB);
                Jogo.getInstance().setPeixe(peixeB);
            }
        }
    }

    @Override
    protected Peixe movimentoInvalido() throws PeixeMortoException, InvalidAttributeValueException {
        if(this.recuperaNumeroMovimentosInvalidos() == Jogo.getInstance().getMovimentacaoMortePeixeB()) {
            this.morre();
        }
        return this;
    }
    @Override
    public IPeixe come(IAlimento peixeA) throws InvalidAttributeValueException {
        this.resetaMovimentoInvalido().resetaMovimentoValido();
        this.incrementaPeixesComidos();
        return this;
    }

    private void incrementaPeixesComidos() throws InvalidAttributeValueException {
        this.peixesComidos++;
        this.reproduzir();
    }
}
