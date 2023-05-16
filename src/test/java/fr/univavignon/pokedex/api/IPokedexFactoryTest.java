package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexFactoryTest {
    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;

    public IPokemonFactory iPokemonFactoryExample1;

    public IPokedexFactory iPokedexFactoryExample1;

    public IPokedexFactoryTest() {
        iPokemonMetadataProviderExample1 = new PokemonMetadataProvider();
        iPokemonFactoryExample1 = new PokemonFactory();
        iPokedexFactoryExample1 = new PokedexFactory();
    }
    @Test
    void testcreatePokedex(){
        assertEquals(Pokedex.class, iPokedexFactoryExample1.createPokedex(iPokemonMetadataProviderExample1, iPokemonFactoryExample1).getClass());
    }
}