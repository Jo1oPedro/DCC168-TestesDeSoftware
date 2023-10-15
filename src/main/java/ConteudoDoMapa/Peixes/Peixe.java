package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Jogo.Jogo;
import Mapa.IElementosDoMapa;
import Mapa.Mapa;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Peixe implements IPeixe, IElementosDoMapa {

    private Integer linhaAtual;
    private Integer colunaAtual;

    private List<String> proximidades = new ArrayList<String>();
    protected List<String> posicoesTentadas = new ArrayList<>(Arrays.asList("cima", "baixo", "esquerda", "direita"));
    private Integer numeroMovimentosValidos = 0;
    private Integer numeroMovimentosInvalidos = 0;

    public IPeixe setLinhaAtual(int linhaAtual) {
        this.linhaAtual = linhaAtual;
        return this;
    }

    public IPeixe setColunaAtual(int colunaAtual) {
        this.colunaAtual = colunaAtual;
        return this;
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
    public List<String> verificaProximidades() throws InvalidAttributeValueException {
        if(this.linhaAtual == null) {
            throw new InvalidAttributeValueException("Linha atual não pode ser nula");
        }

        if(this.colunaAtual == null) {
           throw new InvalidAttributeValueException("Coluna atual não pode ser nula");
        }
        this.verificaProximidadeAcima();
        return this.proximidades;
    }

    private void verificaProximidadeAcima() {
        if(this.podeMoverAcima()) {
            this.proximidades.add((this.linhaAtual + 1) + "," + this.colunaAtual);
        }
        verificaProximidadeAbaixo();
    }

    private void verificaProximidadeAbaixo() {
        if(this.podeMoverAbaixo()) {
            this.proximidades.add((this.linhaAtual - 1) + "," + this.colunaAtual);
        }
        verificaProximidadeEsquerda();
    }

    private void verificaProximidadeEsquerda() {
        if(this.podeMoverEsquerda()) {
            this.proximidades.add(this.linhaAtual + "," + (this.colunaAtual - 1));
        }
        verificaProximidadeDireita();
    }

    private void verificaProximidadeDireita() {
        if(this.podeMoverDireita()) {
            this.proximidades.add(this.linhaAtual + "," + (this.colunaAtual + 1));
        }
    }

    public IPeixe mover() throws InvalidAttributeValueException {
        int linhaAtual = this.linhaAtual;
        int colunaAtual = this.colunaAtual;

        String direcao = this.sorteiaPosicaoParaMovimentar();

        switch (direcao) {
            case "cima":
                this.moverCima();
                break;
            case "baixo":
                this.moverBaixo();
                break;
            case "esquerda":
                this.moverEsquerda();
                break;
            case "direita":
                this.moverDireita();
                break;
        }

        if(this.linhaAtual == linhaAtual && this.colunaAtual == colunaAtual) {
            this.numeroMovimentoInvalido();
        } else {
            this.reproduzir();
        }

        this.posicoesTentadas.clear();
        this.posicoesTentadas = new ArrayList<>(Arrays.asList("cima", "baixo", "esquerda", "direita"));

        return this;
    }

    protected IPeixe moverCima() {
        if(this.podeMoverAcima()) {
            this.linhaAtual++;
            Mapa.getInstance()
                .removePeixe(this)
                .insereNovoPeixe(this.incrementaMovimentoValido());
            return this;
        }

        String direcao = this.sorteiaPosicaoParaMovimentar();

        return switch (direcao) {
            case "baixo" -> this.moverBaixo();
            case "esquerda" -> this.moverEsquerda();
            case "direita" -> this.moverDireita();
            default -> this;
        };
    }

    protected IPeixe moverBaixo() {
        if(this.podeMoverAbaixo()) {
            this.linhaAtual--;
            Mapa.getInstance()
                .removePeixe(this)
                .insereNovoPeixe(this.incrementaMovimentoValido());
            return this;
        }

        String direcao = this.sorteiaPosicaoParaMovimentar();

        return switch (direcao) {
            case "cima" -> this.moverCima();
            case "esquerda" -> this.moverEsquerda();
            case "direita" -> this.moverDireita();
            default -> this;
        };
    }

    protected IPeixe moverEsquerda() {
        if(this.podeMoverEsquerda()) {
            this.colunaAtual--;
            Mapa.getInstance()
                .removePeixe(this)
                .insereNovoPeixe(this.incrementaMovimentoValido());
            return this;
        }

        String direcao = this.sorteiaPosicaoParaMovimentar();

        return switch (direcao) {
            case "cima" -> this.moverCima();
            case "baixo" -> this.moverBaixo();
            case "direita" -> this.moverDireita();
            default -> this;
        };
    }

    protected IPeixe moverDireita() {
        if(this.podeMoverDireita()) {
            this.colunaAtual++;
            Mapa.getInstance()
                .removePeixe(this)
                .insereNovoPeixe(this.incrementaMovimentoValido());
            return this;
        }

        String direcao = this.sorteiaPosicaoParaMovimentar();

        return switch (direcao) {
            case "cima" -> this.moverCima();
            case "baixo" -> this.moverBaixo();
            case "esquerda" -> this.moverEsquerda();
            default -> this;
        };
    }

    protected abstract String sorteiaPosicaoParaMovimentar();

    protected boolean podeMoverAcima() {
        if(this.linhaAtual + 1 < Mapa.getInstance().getMapa().length) {
            return this.regraMoverAcima();
        }
        return false;
    }

    protected boolean podeMoverAbaixo() {
        if (this.linhaAtual - 1 >= 0) {
            return this.regraMoverAbaixo();
        }
        return false;
    }

    protected boolean podeMoverEsquerda() {
        if (this.colunaAtual - 1 >= 0) {
            return this.regraMoverEsquerda();
        }
        return false;
    }

    protected boolean podeMoverDireita() {
        if (this.colunaAtual + 1 < Mapa.getInstance().getMapa()[0].length) {
            return this.regraMoverDireita();
        }
        return false;
    }

    protected abstract boolean regraMoverAcima();
    protected abstract boolean regraMoverAbaixo();
    protected abstract boolean regraMoverEsquerda();
    protected abstract boolean regraMoverDireita();

    protected IPeixe incrementaMovimentoValido() {
        this.numeroMovimentosValidos++;
        return this;
    }

    protected IPeixe numeroMovimentoInvalido() {
        this.numeroMovimentosInvalidos++;
        return this;
    }

    public int recuperaNumeroMovimentosValido() {
        return this.numeroMovimentosValidos;
    }

    public int recuperaNumeroMovimentosInvalidos() {
        return this.numeroMovimentosInvalidos;
    }

    @Override
    public abstract void reproduzir() throws InvalidAttributeValueException;

    @Override
    public abstract IPeixe come(IAlimento alimento);

    public void morre() {
        Mapa.getInstance().removePeixe(this);
    };
}
