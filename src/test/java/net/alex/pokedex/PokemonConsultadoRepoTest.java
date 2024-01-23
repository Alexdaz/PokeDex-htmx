package net.alex.pokedex;

import net.alex.pokedex.Model.PokemonConsultado;
import net.alex.pokedex.repository.IEPokemonConsultadoRepo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PokemonConsultadoRepoTest {

    @Autowired
    IEPokemonConsultadoRepo pokeConsultado;

    @Test
    public void savePokemonConsultado()
    {
        PokemonConsultado test = pokeConsultado
                .save(new PokemonConsultado("Ditto", "Normal", null, 132, 101, 0.3, 4));

    }
}
