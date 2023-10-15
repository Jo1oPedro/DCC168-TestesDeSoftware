package Jogo;

import Mapa.Mapa;

import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAttributeValueException {
        Jogo.getInstance().defineParametros().iniciaJogo();
    }
}
