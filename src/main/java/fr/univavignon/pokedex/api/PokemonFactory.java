package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory{

    private PokemonMetadata pokemonMetadata;
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
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        if (index <= -1 ) {
            throw new PokedexException("L'index de ce pokemon n'existe pas");
        }
        else {
            pokemonMetadata = new PokemonMetadataProvider().getPokemonMetadata(index);
            String name = pokemonMetadata.getName();
            int attack = pokemonMetadata.getAttack();
            int defense = pokemonMetadata.getDefense();
            int stamina = pokemonMetadata.getStamina();
            Random r = new Random();
            int lowestIv = 30;
            int highestIv = 100;
            // generate random number between 30 and 100 as it is a percentage(for the iv)
            int iv = r.nextInt(highestIv-lowestIv);

            return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
        }
    }
}
