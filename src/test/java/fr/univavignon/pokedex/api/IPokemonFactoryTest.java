package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonFactoryTest {
    Pokemon example1;
    Pokemon example2;
    public IPokemonFactory iPokemonFactoryExample1;
    public IPokemonFactory iPokemonFactoryExample2;
    public  IPokemonFactoryTest(){
        this.example1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        this.example2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        this.iPokemonFactoryExample1 = (index, cp, hp, dust, candy) -> example1;
        this.iPokemonFactoryExample2 = (index, cp, hp, dust, candy) -> example2;
    }

    @Test
    void testCreatePokemon() throws PokedexException {
        assertEquals(example1,iPokemonFactoryExample1.createPokemon(0,613,64,4000,4));
        assertEquals(example2,iPokemonFactoryExample2.createPokemon(133,2729,202,5000,4));
    }

}