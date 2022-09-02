package br.com.marvelous.marvelous.personagem;

public class LimiteDeTipoPersonagemException extends Exception{
    public LimiteDeTipoPersonagemException(){
        super("Um personagem só pode ter 1 tipo");
    }
}
