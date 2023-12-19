package Jogo;

import javax.management.InvalidAttributeValueException;

public class Main {
	public static void main(String[] args) throws InvalidAttributeValueException {
		Jogo.getInstance().defineParametros().iniciaJogo();
	}
}
