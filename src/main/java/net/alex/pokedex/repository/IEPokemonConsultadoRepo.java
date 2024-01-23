package net.alex.pokedex.repository;

import net.alex.pokedex.Model.PokemonConsultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEPokemonConsultadoRepo extends JpaRepository<PokemonConsultado, Long> {
    List<PokemonConsultado> findByNombre(String name);
    List<PokemonConsultado> findByNopokedex(int idpkdx);
}
