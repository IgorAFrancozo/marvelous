package br.com.marvelous.marvelous.ataque;

import org.junit.jupiter.api.Test;
import br.com.marvelous.marvelous.tipo.*;

public class Ataque {

  @Test
  public void deve_criar_um_ataque() {
    String nome = "Optic Glass";
    int forca = 45;
    String descricao = "Dispara laser dos olhos em direção ao oponente";
    int precisao = 90;
    Tipo tipoEsperado = new Tipo("Mutante");
    
    Ataque ataque = new Ataque(nome, forca, descricao, precisao);

  }
}
