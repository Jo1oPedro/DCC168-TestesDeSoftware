import ConteudoDoMapa.Peixes.IPeixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import Mapa.Mapa;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapaTest {

    @Test
    public void deveGarantirQueInstanciasDosMapasSaoSempreIguais() {
        Mapa mapa = Mapa.getInstance();
        Mapa mapa2 = Mapa.getInstance();
        assertEquals(mapa, mapa2);
    }

    @Test
    public void deveRetornarTamanhoDoMapaComSucesso() {
        Mapa mapa = Mapa.getInstance().setTamanhoMapa(3, 4);
        assertEquals(3, mapa.getMapa().length);
        assertEquals(4, mapa.getMapa()[0].length);
    }

    @Test
    public void devePermitirInserirQualquerTipoDeElementoDoMapaNaMatrizMapa() {
        Mapa mapa = Mapa.getInstance().setTamanhoMapa(3, 3);
        mapa.insereNovoPeixe(new PeixeA().setLinhaAtual(0).setColunaAtual(0));
        mapa.insereNovoPeixe(new PeixeB().setLinhaAtual(0).setColunaAtual(1));
        assertTrue(mapa.getPosicaoDoMapa(0, 0) instanceof PeixeA);
        assertTrue(mapa.getPosicaoDoMapa(0, 1) instanceof PeixeB);
    }

    @Test
    public void deveRemoverUmElementoDoMapaComSucesso() {
        Mapa mapa = Mapa.getInstance().setTamanhoMapa(3, 3);
        IPeixe peixeA = new PeixeA().setLinhaAtual(0).setColunaAtual(0);
        mapa.insereNovoPeixe(peixeA);
        mapa.insereNovoPeixe(new PeixeB().setLinhaAtual(0).setColunaAtual(1));
        assertTrue(mapa.getPosicaoDoMapa(0, 0) instanceof PeixeA);
        assertTrue(mapa.getPosicaoDoMapa(0, 1) instanceof PeixeB);

        Mapa.getInstance().removePeixe(peixeA);

        assertNull(mapa.getPosicaoDoMapa(0, 0));
        assertTrue(mapa.getPosicaoDoMapa(0, 1) instanceof PeixeB);
    }
}
