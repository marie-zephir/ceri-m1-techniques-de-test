package fr.univavignon.pokedex.api;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Pokedex implements IPokedex{
    // List of pokemons in this pokedex
    private List<Pokemon> pokemons;

    //Get the metadata of the pokemon as it extends this class in the interface
    private IPokemonMetadataProvider pokemonMetadataProvider;

    // Creates a pokemon as it extends this class in the interface
    private IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        pokemons = new ArrayList<>();
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.indexOf(pokemon);
    }

    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id <= -1 || id > pokemons.size()-1) {
            throw new PokedexException("L'index de ce pokemon n'existe pas");
        }
        else{
            return pokemons.get(id);
        }
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemonsSorted = pokemons;
        pokemonsSorted.sort(order);
        return Collections.unmodifiableList(pokemonsSorted);
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        return pokemon;
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index <= -1 || index > pokemons.size()-1) {
            throw new PokedexException("L'index de ce pokemon n'existe pas");
        }
        else{
            return this.pokemonMetadataProvider.getPokemonMetadata(index);
        }
    }
}
