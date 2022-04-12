package br.com.mentorama.filmescad.repositories;

import br.com.mentorama.filmescad.entities.Filmes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmesRepository {


    private Filmes filmes;

    private List<Filmes> filmeslst;

    public FilmesRepository (){
        this.filmeslst = new ArrayList<>();

        Filmes filme1 = new Filmes(1, "Duuna", "Denny V",
                "2020", 5, "DuunaDenny V2020");

        filmeslst.add(filme1);
    }

    //1)Listar todos:
    public List<Filmes> findAll(){
        return filmeslst;
    }

    //2) Buscar por id:
    public Filmes findById(Integer id) {
        return filmeslst.stream()
                .filter(fil -> fil.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //3) Cadastrar um novo filme:
    public void post(Filmes filmes){
        this.filmeslst.add(filmes);
    }
    public Integer count(){
        return filmeslst.size();
    }

}


