package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonFactoryTest {
    Pokemon example1;

    Pokemon example2;

    public IPokemonFactory iPokemonFactoryExample1;

    RocketPokemonFactory rocketPokemonFactory;

    public  IPokemonFactoryTest(){
        this.example1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        this.example2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        this.iPokemonFactoryExample1 = new PokemonFactory();
        rocketPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = iPokemonFactoryExample1.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(),example1.getIndex());
        assertEquals(pokemon.getName(), example1.getName());
        assertEquals(pokemon.getAttack(), example1.getAttack());
        assertEquals(pokemon.getDefense(), example1.getDefense());
        assertEquals(pokemon.getStamina(), example1.getStamina());
        assertEquals(pokemon.getCp(), example1.getCp());
        assertEquals(pokemon.getHp(), example1.getHp());
        assertEquals(pokemon.getDust(), example1.getDust());
        assertEquals(pokemon.getCandy(), example1.getCandy());

    }
    @Test
    void testCreateRocketPokemon() {
        Pokemon rocketPokemon = rocketPokemonFactory.createPokemon(-1,613,64,4000,4);
        assertEquals(rocketPokemon.getAttack(), 1000);
        assertEquals(rocketPokemon.getDefense(), 1000);
        assertEquals(rocketPokemon.getStamina(), 1000);
        assertEquals(rocketPokemon.getIv(),0);
    }

    @Test
    public void testPokedexException(){
        assertThrows(PokedexException.class, () -> iPokemonFactoryExample1.createPokemon(-1,613,64,4000,4));
    }
}