package ConteudoDoMapa.Peixes;

import ConteudoDoMapa.Alimentos.IAlimento;
import Jogo.Jogo;
import Mapa.Mapa;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Peixe implements IPeixe {

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
		if (this.linhaAtual == null) {
			throw new InvalidAttributeValueException("Linha atual não pode ser nula");
		}

		if (this.colunaAtual == null) {
			throw new InvalidAttributeValueException("Coluna atual não pode ser nula");
		}
		this.verificaProximidadeAcima();
		return this.proximidades;
	}

	private void verificaProximidadeAcima() {
		if (this.podeMoverAcima()) {
			this.proximidades.add((this.linhaAtual + 1) + "," + this.colunaAtual);
		}
		verificaProximidadeAbaixo();
	}

	private void verificaProximidadeAbaixo() {
		if (this.podeMoverAbaixo()) {
			this.proximidades.add((this.linhaAtual - 1) + "," + this.colunaAtual);
		}
		verificaProximidadeEsquerda();
	}

	private void verificaProximidadeEsquerda() {
		if (this.podeMoverEsquerda()) {
			this.proximidades.add(this.linhaAtual + "," + (this.colunaAtual - 1));
		}
		verificaProximidadeDireita();
	}

	private void verificaProximidadeDireita() {
		if (this.podeMoverDireita()) {
			this.proximidades.add(this.linhaAtual + "," + (this.colunaAtual + 1));
		}
	}

	public IPeixe mover() throws InvalidAttributeValueException {
		try {
			String[] posicoes = this.sorteiaPosicaoParaMovimentar();

			if (posicoes[0].isEmpty() && posicoes[1].isEmpty()) {
				this.incrementaMovimentoInvalido();
			} else {
				this.linhaAtual = Integer.valueOf(posicoes[0]);
				this.colunaAtual = Integer.valueOf(posicoes[1]);

				Mapa.getInstance().removePeixe(this).insereNovoPeixe(this.incrementaMovimentoValido());
				this.reproduzir();
			}
		} catch (PeixeMortoException exception) {
			return this;
		}

		return this;
	}

	protected abstract String[] sorteiaPosicaoParaMovimentar()
			throws InvalidAttributeValueException, PeixeMortoException;

	protected boolean podeMoverAcima() {
		if (this.linhaAtual + 1 < Mapa.getInstance().getMapa().length) {
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

	protected Peixe resetaMovimentoValido() {
		this.numeroMovimentosValidos = 0;
		return this;
	}

	protected Peixe resetaMovimentoInvalido() {
		this.numeroMovimentosInvalidos = 0;
		return this;
	}

	protected Peixe incrementaMovimentoValido() {
		this.numeroMovimentosValidos++;
		return this;
	}

	protected Peixe incrementaMovimentoInvalido() throws PeixeMortoException, InvalidAttributeValueException {
		this.numeroMovimentosInvalidos++;
		this.movimentoInvalido();
		return this;
	}

	protected abstract Peixe movimentoInvalido() throws PeixeMortoException, InvalidAttributeValueException;

	public int recuperaNumeroMovimentosValido() {
		return this.numeroMovimentosValidos;
	}

	public int recuperaNumeroMovimentosInvalidos() {
		return this.numeroMovimentosInvalidos;
	}

	@Override
	public abstract void reproduzir() throws InvalidAttributeValueException;

	@Override
	public abstract IPeixe come(IAlimento alimento) throws InvalidAttributeValueException;

	public void morre() throws InvalidAttributeValueException, PeixeMortoException {
		Mapa.getInstance().removePeixe(this);
		Jogo.getInstance().getPeixes().remove(this);
		throw new PeixeMortoException();
	};
}
