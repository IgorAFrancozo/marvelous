package br.com.marvelous.marvelous.ataque;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.marvelous.marvelous.personagem.Personagem;
import br.com.marvelous.marvelous.tipo.Tipo;

@Entity
public class Ataque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;    

    @Column(nullable = false)
    private int forca;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private int precisao;
    
    @OneToMany
    private Collection<Tipo> tipos;

    @ManyToOne
    private Collection<Personagem> personagens;

    public Ataque(String nome, int forca, String descricao, int precisao, Collection<Tipo> tipos) {
        this.nome = nome;
        this.forca = forca;
        this.descricao = descricao;
        this.precisao = precisao;
        this.tipos = tipos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
    }

    public Collection<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Collection<Tipo> tipos) {
        this.tipos = tipos;
    }

    public Collection<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Collection<Personagem> personagens) {
        this.personagens = personagens;
    }

    
}
