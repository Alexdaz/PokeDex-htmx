package net.alex.pokedex.Controller;

import net.alex.pokedex.Model.PokemonConsultado;
import net.alex.pokedex.repository.IEPokemonConsultadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PokedexController {

    @Autowired
    IEPokemonConsultadoRepo pokeConsultado;

    @PostMapping("/")
    public String pokedex() { return "pokedex"; }

    @PostMapping("/pokemons")
    public ResponseEntity<PokemonConsultado> InsertPokemon(@RequestBody PokemonConsultado poke) {
        try {
            var _poke = pokeConsultado
                    .save(new PokemonConsultado(poke.getNombre(), poke.getTipo1(), poke.getTipo2(), poke.getNopokedex(), poke.getExpbase(), poke.getAltura(), poke.getPeso()));
            return new ResponseEntity<>(_poke, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPokemons")
    public ResponseEntity<List<PokemonConsultado>> getAllPokemons(@RequestParam(required = false) String name) {
        try {
            var pokemans = new ArrayList<PokemonConsultado>();

            if (name == null) {
                pokeConsultado.findAll().forEach(pokemans::add);
            }
            else {
                pokeConsultado.findByNombre(name).forEach(pokemans::add);
            }

            if (pokemans.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
