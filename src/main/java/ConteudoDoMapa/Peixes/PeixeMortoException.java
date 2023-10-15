package ConteudoDoMapa.Peixes;

public class PeixeMortoException extends Exception{
    public PeixeMortoException() {
        super("O peixe atual está morto");
    }

    public PeixeMortoException(String mensagem) {
        super(mensagem);
    }
}
