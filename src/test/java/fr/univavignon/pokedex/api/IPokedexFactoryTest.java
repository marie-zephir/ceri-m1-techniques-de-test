package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexFactoryTest {
    Pokemon example1;
    Pokemon example2;
    public IPokemonMetadataProvider iPokemonMetadataProviderExample1;

    public IPokemonFactory iPokemonFactoryExample1;

    public IPokedexFactory iPokedexFactoryExample1;

    IPokedex iPokedexExample1;

    IPokedex iPokedexExample2;
    List<Pokemon> pokemonList = new ArrayList<Pokemon>();
    public IPokedexFactoryTest(){
        this.example1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        this.example2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
        this.iPokemonMetadataProviderExample1 = index -> example1;
        this.iPokemonFactoryExample1 = (index, cp, hp, dust, candy) -> example1;

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
        this.iPokedexFactoryExample1 = new IPokedexFactory() {
            @Override
            public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
                return iPokedexExample1;
            }
        };
    }

    @Test
    void testcreatePokedex(){
        assertEquals(iPokedexExample1,iPokedexFactoryExample1.createPokedex(iPokemonMetadataProviderExample1,iPokemonFactoryExample1));
    }
}