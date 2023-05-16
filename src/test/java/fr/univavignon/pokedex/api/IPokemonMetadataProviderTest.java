package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {
    PokemonMetadata example1;
    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;

    List<PokemonMetadata> iPokemonMetadata= new ArrayList<PokemonMetadata>();
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
        iPokemonMetadata.add(example1);
        assertEquals(0,iPokemonMetadata.get(0).getIndex());
        assertEquals("Bulbizarre",iPokemonMetadata.get(0).getName());
        assertEquals(126,iPokemonMetadata.get(0).getAttack());
        assertEquals(126,iPokemonMetadata.get(0).getDefense());
        assertEquals(90,iPokemonMetadata.get(0).getStamina());
        assertThrows(PokedexException.class, () -> iPokedexExample1.getPokemonMetadata(-1));
        assertThrows(PokedexException.class, () -> iPokedexExample1.getPokemonMetadata(-11));
    }
}