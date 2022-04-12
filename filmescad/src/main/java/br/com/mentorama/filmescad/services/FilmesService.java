package br.com.mentorama.filmescad.services;

import br.com.mentorama.filmescad.entities.Filmes;
import br.com.mentorama.filmescad.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    private Filmes filmes;

    //1) Listar todos:
    public List<Filmes> findAll() {
        return filmesRepository.findAll();
    }

    //2) Buscar por id:
    public Filmes findById(Integer id) {
        return filmesRepository.findById(id);
    }

   //3) Cadastrar um novo filme:
    public Integer post(Filmes filmes) {
        if (filmes.getId() == null) {
            filmes.setId(filmesRepository.count() + 1);
        }

        filmesRepository.post(filmes);
        return filmes.getId();
    }
}
