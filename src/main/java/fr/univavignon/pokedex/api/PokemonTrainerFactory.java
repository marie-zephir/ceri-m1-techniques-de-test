package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        PokemonTrainer pokemonTrainer = new PokemonTrainer(name,team,pokedex);
        return null;
    }
}
