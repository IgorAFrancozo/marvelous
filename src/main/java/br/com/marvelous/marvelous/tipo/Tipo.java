package br.com.marvelous.marvelous.tipo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.marvelous.marvelous.personagem.Personagem;

@Entity
public class Tipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 7)
    private String nome;

    @OneToMany(mappedBy = "tipos")
    private Collection<Personagem> personagens;

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

    public Collection<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Collection<Personagem> personagens) {
        this.personagens = personagens;
    }

    
}
