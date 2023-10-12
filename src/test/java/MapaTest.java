import ConteudoDoMapa.Alimentos.Plancton;
import ConteudoDoMapa.CelulaVazia;
import ConteudoDoMapa.Peixes.Peixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import Mapa.Mapa;
import Mapa.IElementosDoMapa;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapaTest {

    @Test
    public void deveRetornarTamanhoDoMapaComSucesso() {
        Mapa mapa = Mapa.getInstance().setTamanhoMapa(3, 4);
        assertEquals(3, mapa.getMapa().length);
        assertEquals(4, mapa.getMapa()[0].length);
    }

    @Test
    public void devePermitirInserirQualquerTipoDeElementoDoMapaNaMatrizMapa()
    {
        Mapa mapa = Mapa.getInstance().setTamanhoMapa(3, 3);
        mapa.insereNovoElemento(0, 0, new PeixeA());
        mapa.insereNovoElemento(0, 1, new PeixeB());
        mapa.insereNovoElemento(0, 2, new CelulaVazia());
        mapa.insereNovoElemento(1, 0, new Plancton());
        assertTrue(mapa.getPosicaoDoMapa(0, 0) instanceof PeixeA);
        assertTrue(mapa.getPosicaoDoMapa(0, 1) instanceof PeixeB);
        assertTrue(mapa.getPosicaoDoMapa(0, 2) instanceof CelulaVazia);
        assertTrue(mapa.getPosicaoDoMapa(1, 0) instanceof Plancton);
    }
}
