package br.com.marvelous.marvelous.personagem;

public class LimiteDeAtaquePersonagemException extends Exception {
    public LimiteDeAtaquePersonagemException() {
        super("Um personagem pode ter até 3 ataques");
    }
}
