package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokedexTest {
    Pokemon example1;
    Pokemon example2;

    IPokedex iPokedexExample1;
    List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    IPokemonMetadataProvider iPokemonMetadataProviderExample1;
    IPokemonFactory iPokemonFactoryExample1;

    public  IPokedexTest() {
        this.example1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        this.example2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        iPokemonMetadataProviderExample1 = new PokemonMetadataProvider();
        iPokemonFactoryExample1 = new PokemonFactory();
        iPokedexExample1 = new Pokedex(iPokemonMetadataProviderExample1, iPokemonFactoryExample1);

    }
    @Test
    void testsize() {
        iPokedexExample1.addPokemon(example1);
        assertEquals(1,iPokedexExample1.getPokemons().size());
    }

    @Test
    void testaddPokemon() {
        assertEquals(0,iPokedexExample1.addPokemon(example1));
        assertEquals(1,iPokedexExample1.addPokemon(example2));
    }

    @Test
    void testgetPokemon() throws PokedexException {
        iPokedexExample1.addPokemon(example1);
        iPokedexExample1.addPokemon(example2);

        assertEquals(iPokedexExample1.getPokemon(0),example1);
        assertEquals(iPokedexExample1.getPokemon(0).getIndex(),0);
        assertEquals(iPokedexExample1.getPokemon(0).getName(), "Bulbizarre");
        assertEquals(iPokedexExample1.getPokemon(0).getAttack(), 126);
        assertEquals(iPokedexExample1.getPokemon(0).getDefense(), 126);
        assertEquals(iPokedexExample1.getPokemon(0).getStamina(), 90);
        assertEquals(iPokedexExample1.getPokemon(0).getCp(), 613);
        assertEquals(iPokedexExample1.getPokemon(0).getHp(), 64);
        assertEquals(iPokedexExample1.getPokemon(0).getDust(), 4000);
        assertEquals(iPokedexExample1.getPokemon(0).getCandy(), 4);
        assertEquals(iPokedexExample1.getPokemon(0).getIv(), 56);

        assertEquals(iPokedexExample1.getPokemon(1),example2);
        assertEquals(iPokedexExample1.getPokemon(1).getIndex(),133);
        assertEquals(iPokedexExample1.getPokemon(1).getName(), "Aquali");
        assertEquals(iPokedexExample1.getPokemon(1).getAttack(), 186);
        assertEquals(iPokedexExample1.getPokemon(1).getDefense(), 168);
        assertEquals(iPokedexExample1.getPokemon(1).getStamina(), 260);
        assertEquals(iPokedexExample1.getPokemon(1).getCp(), 2729);
        assertEquals(iPokedexExample1.getPokemon(1).getHp(), 202);
        assertEquals(iPokedexExample1.getPokemon(1).getDust(), 5000);
        assertEquals(iPokedexExample1.getPokemon(1).getCandy(), 4);
        assertEquals(iPokedexExample1.getPokemon(1).getIv(), 100);

    }

    @Test
    void testgetPokemons(){
        pokemonList.add(example1);
        pokemonList.add(example2);

        iPokedexExample1.addPokemon(example1);
        iPokedexExample1.addPokemon(example2);
        assertEquals(iPokedexExample1.getPokemons(),pokemonList);
    }

    @Test
    void testgetPokemons2(){
        pokemonList.add(example1);
        pokemonList.add(example2);

        iPokedexExample1.addPokemon(example2);
        iPokedexExample1.addPokemon(example1);

        assertEquals(iPokedexExample1.getPokemons(PokemonComparators.INDEX),pokemonList);
    }
    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        assertEquals(pokemon.getIndex(),example1.getIndex());
        assertEquals(pokemon.getName(), example1.getName());
        assertEquals(pokemon.getAttack(), example1.getAttack());
        assertEquals(pokemon.getDefense(), example1.getDefense());
        assertEquals(pokemon.getStamina(), example1.getStamina());
        assertEquals(pokemon.getCp(), example1.getCp());
        assertEquals(pokemon.getHp(), example1.getHp());
        assertEquals(pokemon.getDust(), example1.getDust());
        assertEquals(pokemon.getCandy(), example1.getCandy());
        assertEquals(pokemon.getIv(), example1.getIv());
    }

    @Test
    void testgetPokemonMetadata() throws PokedexException {
        assertEquals(PokemonMetadata.class, iPokedexExample1.getPokemonMetadata(example1.getIndex()).getClass());
    }

    @Test
    public void textPokedexException(){
        assertThrows(PokedexException.class, () -> iPokedexExample1.getPokemon(3));
        assertThrows(PokedexException.class, () -> iPokedexExample1.getPokemon(-1));
    }

}