import ConteudoDoMapa.Peixes.Peixe;
import ConteudoDoMapa.Peixes.PeixeA;
import ConteudoDoMapa.Peixes.PeixeB;
import ConteudoDoMapa.Peixes.PeixeMortoException;
import Jogo.Jogo;
import Mapa.Mapa;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.management.InvalidAttributeValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeixeTeste {

    private Mapa mapa = null;

    @Before
    public void setUp() {
        this.mapa = Mapa.getInstance().setTamanhoMapa(5,5);
    }

    @Test
    public void deveLancarExcecaoParaLinhaAtualInvalidaNaProximidade() throws InvalidAttributeValueException {
        try {
            PeixeA peixeA = new PeixeA();
            peixeA.setColunaAtual(0);
            List<String> expected = Arrays.asList("1,0", "0,1");
            assertEquals(expected, peixeA.verificaProximidades());
        } catch (InvalidAttributeValueException exception) {
            assertEquals("Linha atual não pode ser nula", exception.getMessage());
        }
    }

    @Test
    public void verificaSeProximidadesEstaoLivresComSucesso() throws InvalidAttributeValueException {
        PeixeA peixeA = new PeixeA();
        peixeA.setLinhaAtual(0);
        peixeA.setColunaAtual(0);
        List<String> expected = Arrays.asList("1,0", "0,1");
        assertEquals(expected, peixeA.verificaProximidades());
    }

    @Test
    public void deveMovimentoPeixeComSucesso() throws InvalidAttributeValueException, PeixeMortoException {
        PeixeB peixeB = (PeixeB) new PeixeB().setLinhaAtual(1).setColunaAtual(0);
        Mapa.getInstance().insereNovoPeixe(peixeB);
        PeixeA peixeA = new PeixeA();
        peixeA.setLinhaAtual(0);
        peixeA.setColunaAtual(0);
        peixeA.mover();
        assertEquals(1, peixeA.recuperaNumeroMovimentosValido());
    }

    @Test
    public void naoDeveMovimentoPeixeComSucesso() throws InvalidAttributeValueException, PeixeMortoException {
        PeixeB peixeB = (PeixeB) new PeixeB().setLinhaAtual(1).setColunaAtual(0);
        PeixeB peixeB2 = (PeixeB) new PeixeB().setLinhaAtual(0).setColunaAtual(1);
        Mapa.getInstance().insereNovoPeixe(peixeB);
        Mapa.getInstance().insereNovoPeixe(peixeB2);
        PeixeA peixeA = new PeixeA();
        peixeA.setLinhaAtual(0);
        peixeA.setColunaAtual(0);
        peixeA.mover();
        assertEquals(0, peixeA.recuperaNumeroMovimentosValido());
    }

    @Test
    public void deveMovimentoPeixeBComSucesso() throws InvalidAttributeValueException, PeixeMortoException {
        PeixeB peixeB = (PeixeB) new PeixeB().setLinhaAtual(1).setColunaAtual(0);
        Mapa.getInstance().insereNovoPeixe(peixeB);
        PeixeA peixeA = new PeixeA();
        peixeA.setLinhaAtual(0);
        peixeA.setColunaAtual(0);
        Mapa.getInstance().insereNovoPeixe(peixeA);
        peixeB.mover();
        assertEquals(1, peixeB.recuperaNumeroMovimentosValido());
    }

    @Test
    public void peixebDeveMorrer() throws PeixeMortoException, InvalidAttributeValueException {
        PeixeB peixeB = (PeixeB) new PeixeB().setLinhaAtual(1).setColunaAtual(0);
        Jogo.getInstance().setPeixe(peixeB);
        assertEquals(1, Jogo.getInstance().getPeixes().size());
        Mapa.getInstance().insereNovoPeixe(peixeB);
        peixeB.mover().mover().mover();
        assertEquals(4, Jogo.getInstance().getPeixes().size());
    }

    public void peixebDeveReproduzirComSucesso() {
        PeixeB peixeB = (PeixeB) new PeixeB().setLinhaAtual(1).setColunaAtual(0);
    }

}
