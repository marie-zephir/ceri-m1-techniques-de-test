package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static fr.univavignon.pokedex.api.Team.INSTINCT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonTrainerFactoryTest {

    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;

    public IPokedex iPokedexExample1;

    IPokemonFactory iPokemonFactoryExample1;

    public IPokedexFactory iPokedexFactoryExample1;


    public IPokemonTrainerFactoryTest() {
        iPokemonMetadataProviderExample1 = new PokemonMetadataProvider();
        iPokedexFactoryExample1 = new PokedexFactory();
        iPokemonFactoryExample1 = new PokemonFactory();
        iPokedexExample1 = new Pokedex(iPokemonMetadataProviderExample1,iPokemonFactoryExample1);

    }
    @Test
    void testcreateTrainer() {
        IPokedex pokedex = iPokedexFactoryExample1.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Marie",Team.MYSTIC,pokedex);
        assertEquals("Marie",pokemonTrainer.getName());
        assertEquals(Team.MYSTIC,pokemonTrainer.getTeam());
        assertEquals(iPokedexFactoryExample1.createPokedex(new PokemonMetadataProvider(), new PokemonFactory()).getPokemons(),pokemonTrainer.getPokedex().getPokemons());
    }
}