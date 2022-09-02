package br.com.marvelous.marvelous.personagem;

import br.com.marvelous.marvelous.ataque.Ataque;
import br.com.marvelous.marvelous.tipo.Tipo;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Personagem {

  private static final int LIMITE_ATAQUES = 3;

  private static final int LIMITE_TIPO = 1;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Enumerated(EnumType.STRING)
  @Column(length = 9, nullable = true)
  private Genero genero;

  @Column(length = 16, nullable = false)
  private String nome;

  @Column(nullable = false)
  private int altura;

  @Column(nullable = false)
  private int inteligencia;

  @Column(nullable = false)
  private int velocidade;

  @Column(nullable = false)
  private int habilidade;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "personagem_tipo",
    joinColumns = @JoinColumn(name = "personagem_id"),
    inverseJoinColumns = @JoinColumn(name = "tipo_id")
  )
  private Collection<Tipo> tipos;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "personagem_ataque",
    joinColumns = @JoinColumn(name = "personagem_id"),
    inverseJoinColumns = @JoinColumn(name = "tipo_id")
  )
  private Collection<Ataque> ataques;

  public Personagem(
    Genero genero,
    String nome,
    int altura,
    int inteligencia,
    int velocidade,
    int habilidade,
    Collection<Tipo> tipos,
    Collection<Ataque> ataques
  )
    throws LimiteDeAtaquePersonagemException, LimiteDeTipoPersonagemException {
    this.genero = genero;
    this.nome = nome;
    this.altura = altura;
    this.inteligencia = inteligencia;
    this.velocidade = velocidade;
    this.habilidade = habilidade;
    setTipos(tipos);
    setAtaques(ataques);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) {
    this.altura = altura;
  }

  public int getInteligencia() {
    return inteligencia;
  }

  public void setInteligencia(int inteligencia) {
    this.inteligencia = inteligencia;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  public int getHabilidade() {
    return habilidade;
  }

  public void setHabilidade(int habilidade) {
    this.habilidade = habilidade;
  }

  public Collection<Tipo> getTipos() {
    return tipos;
  }

  public void setTipos(Collection<Tipo> tipos)
    throws LimiteDeTipoPersonagemException {
    if (tipos.size() > LIMITE_TIPO) {
      throw new LimiteDeTipoPersonagemException();
    }
    this.tipos = tipos;
  }

  public Collection<Ataque> getAtaques() {
    return ataques;
  }

  public void setAtaques(Collection<Ataque> ataques)
    throws LimiteDeAtaquePersonagemException {
    if (ataques.size() > LIMITE_ATAQUES) {
      throw new LimiteDeAtaquePersonagemException();
    }
    this.ataques = ataques;
  }
}
