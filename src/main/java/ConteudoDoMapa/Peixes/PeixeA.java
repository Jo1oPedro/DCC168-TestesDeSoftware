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
	protected Peixe movimentoInvalido() throws PeixeMortoException, InvalidAttributeValueException {
		if (this.recuperaNumeroMovimentosInvalidos() == Jogo.getInstance().getMovimentacaoMortePeixeA()) {
			this.morre();
		}
		return this;
	}

	@Override
	protected String[] sorteiaPosicaoParaMovimentar() throws InvalidAttributeValueException {
		Random random = new Random();
		List<String> proximidades = this.verificaProximidades();
		int direcao_indice;
		System.out.println(proximidades);
		if (proximidades.size() - 1 >= 0) {
			if (proximidades.size() - 1 == 0) {
				direcao_indice = 0;
			} else {
				direcao_indice = random.nextInt(proximidades.size() - 1);
			}
			String[] direcoes = proximidades.get(direcao_indice).split(",");
			return direcoes;
		}
		return new String[] { "", "" };
	}

	@Override
	public void reproduzir() throws InvalidAttributeValueException {
		this.resetaMovimentoInvalido();
		if (this.recuperaNumeroMovimentosValido() == Jogo.getInstance().getMovimentacaoReproducaoPeixeA()) {
			this.resetaMovimentoValido().resetaMovimentoInvalido();
			Random random = new Random();
			PeixeA peixeA = new PeixeA();
			List<String> proximidades = this.verificaProximidades();
			int direcao_indice;
			if (proximidades.size() - 1 >= 0) {
				if (proximidades.size() - 1 >= 0) {
					direcao_indice = 0;
				} else {
					direcao_indice = random.nextInt(proximidades.size() - 1);
				}
				String[] valores = proximidades.get(direcao_indice).split(",");
				peixeA.setLinhaAtual(Integer.parseInt(valores[0])).setColunaAtual(Integer.parseInt(valores[1]));
				Mapa.getInstance().insereNovoPeixe(peixeA);
				Jogo.getInstance().setPeixe(peixeA);
			}
		}
	}

	@Override
	public IPeixe come(IAlimento plancton) {
		return this;
	}

}
