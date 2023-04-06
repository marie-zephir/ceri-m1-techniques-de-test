package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonMetadataProviderTest {
    PokemonMetadata example1;
    PokemonMetadata example2;
    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;
    public IPokemonMetadataProvider iPokemonMetadataProviderExample2;
    public  IPokemonMetadataProviderTest(){
        this.example1 = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        this.example2 = new PokemonMetadata(133,"Aquali",186,168,260);
        this.iPokemonMetadataProviderExample1 = index -> example1;
        this.iPokemonMetadataProviderExample2 = index -> example2;
    }

    @Test
    void testGetPokemonMetadata() throws PokedexException {
        assertEquals(example1,iPokemonMetadataProviderExample1.getPokemonMetadata(0));
        assertEquals(example2,iPokemonMetadataProviderExample2.getPokemonMetadata(133));
    }
}