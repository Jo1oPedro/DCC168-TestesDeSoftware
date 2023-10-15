package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Jogo.Jogo;
import Mapa.Mapa;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PeixeA extends Peixe implements IAlimento {

    @Override
    protected boolean regraMoverAcima() {
        return Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual() + 1, this.getColunaAtual()) == null;
    }

    @Override
    protected boolean regraMoverAbaixo() {
        return Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual() - 1, this.getColunaAtual()) == null;
    }

    @Override
    protected boolean regraMoverEsquerda() {
        return Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual(), this.getColunaAtual() - 1) == null;
    }

    @Override
    protected boolean regraMoverDireita() {
        return Mapa.getInstance().getPosicaoDoMapa(this.getLinhaAtual(), this.getColunaAtual() + 1) == null;
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
    public void reproduzir() throws InvalidAttributeValueException {
        if(this.recuperaNumeroMovimentosValido() == Jogo.getInstance().getMovimentacaoReproducaoPeixeA()) {
            Random random = new Random();
            PeixeA peixeA = new PeixeA();
            List<String> proximidades = this.verificaProximidades();
            if(proximidades.size() - 1 > 0) {
                int direcao_indice = random.nextInt(proximidades.size() - 1);
                String[] valores = proximidades.get(direcao_indice).split(",");
                peixeA.setLinhaAtual(Integer.parseInt(valores[0])).setColunaAtual(Integer.parseInt(valores[1]));
                Mapa.getInstance().insereNovoPeixe(peixeA);
            }
        }
    }

    @Override
    public IPeixe come(IAlimento plancton) {
        return null;
    }


}
