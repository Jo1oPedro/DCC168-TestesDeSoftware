package Peixes;

import Alimentos.IAlimento;

public class PeixeA extends Peixe implements IAlimento {
    @Override
    public IPeixe reproduzir() {
        return null;
    }

    @Override
    public void Come(IAlimento plancton) {

    }
}
