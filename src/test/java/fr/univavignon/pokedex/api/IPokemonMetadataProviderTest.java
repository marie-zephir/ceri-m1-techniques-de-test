package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {
    PokemonMetadata example1;
    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;
    IPokedex iPokedexExample1;
    IPokemonFactory iPokemonFactoryExample1;

    public  IPokemonMetadataProviderTest(){
        this.example1 = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        iPokemonMetadataProviderExample1 = new PokemonMetadataProvider();
        iPokemonFactoryExample1 = new PokemonFactory();
        iPokedexExample1 = new Pokedex(iPokemonMetadataProviderExample1, iPokemonFactoryExample1);

    }

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        assertEquals(PokemonMetadata.class, iPokedexExample1.getPokemonMetadata(example1.getIndex()).getClass());
        assertEquals(0,example1.getIndex());
        assertEquals("Bulbizarre",example1.getName());
        assertEquals(126,example1.getAttack());
        assertEquals(126,example1.getDefense());
        assertEquals(90,example1.getStamina());
        assertThrows(PokedexException.class, () -> iPokedexExample1.getPokemonMetadata(-1));
    }
}