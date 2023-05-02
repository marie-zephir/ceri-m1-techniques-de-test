package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements  IPokemonMetadataProvider{

    //List containing metadatas of my pokemons
    private List<PokemonMetadata> pokemonMetadatas;

    /**
     * Default constructor.
     */
    public PokemonMetadataProvider() {
        this.pokemonMetadatas= new ArrayList<>();
        pokemonMetadatas.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadatas.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index <= -1 ) {
            throw new PokedexException("L'index de ce pokemon n'existe pas");
        }
        else {
            for(int i=0; i < pokemonMetadatas.size(); i++) {
                if (pokemonMetadatas.get(i).getIndex() == index) {
                    return pokemonMetadatas.get(i);
                }
            }
        }
        return null;
    }
}
