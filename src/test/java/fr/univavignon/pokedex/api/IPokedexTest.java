package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexTest {
    Pokemon example1;
    Pokemon example2;

    IPokedex iPokedexExample1;
    IPokedex iPokedexExample2;
    List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    public  IPokedexTest(){
        this.example1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        this.example2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        this.iPokedexExample1 = new IPokedex() {
            @Override
            public int size() {
                return pokemonList.size();
            }

            @Override
            public int addPokemon(Pokemon pokemon) {
                pokemonList.add(pokemon);
                return pokemonList.indexOf(pokemon);
            }

            @Override
            public Pokemon getPokemon(int id) throws PokedexException {
                return pokemonList.get(id);
            }

            @Override
            public List<Pokemon> getPokemons() {
                return pokemonList;
            }

            @Override
            public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                pokemonList.sort(order);
                return pokemonList;
            }

            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                return example1;
            }

            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return example1;
            }
        };
        this.iPokedexExample2 = new IPokedex() {
            @Override
            public int size() {
                return pokemonList.size();
            }

            @Override
            public int addPokemon(Pokemon pokemon) {
                pokemonList.add(pokemon);
                return pokemonList.indexOf(pokemon);
            }

            @Override
            public Pokemon getPokemon(int id) throws PokedexException {
                return pokemonList.get(id);
            }

            @Override
            public List<Pokemon> getPokemons() {
                return pokemonList;
            }

            @Override
            public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                pokemonList.sort(order);
                return pokemonList;
            }

            @Override
            public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                return example2;
            }

            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return example2;
            }
        };
    }
    @Test
    void testAddPokemon() {
        assertEquals(0,iPokedexExample1.addPokemon(example1));
        assertEquals(1,iPokedexExample1.addPokemon(example2));
    }

    @Test
    void testGetPokemon() throws PokedexException {
        iPokedexExample1.addPokemon(example1);
        iPokedexExample1.addPokemon(example2);
        assertEquals(example1,iPokedexExample1.getPokemon(0));
        assertEquals(example2,iPokedexExample1.getPokemon(1));
    }

    @Test
    void testGetPokemons() {
        iPokedexExample2.addPokemon(example1);
        iPokedexExample2.addPokemon(example2);
        assertEquals(pokemonList,iPokedexExample2.getPokemons());
    }

    @Test
    void testGetPokemons2() {
        iPokedexExample2.addPokemon(example1);
        iPokedexExample2.addPokemon(example2);
        List<Pokemon> colors = new ArrayList<>(iPokedexExample2.getPokemons());
        for (int i = 0, j = colors.size() - 1; i < j; i++) {
            colors.add(i, colors.remove(j));
        }
        Collections.reverse(pokemonList);
        assertEquals(pokemonList,colors);
    }
    @Test
    void testsize() {
        iPokedexExample2.addPokemon(example1);
        iPokedexExample2.addPokemon(example2);
        assertEquals(2,iPokedexExample1.size());
        assertEquals(2,iPokedexExample2.size());
    }
}