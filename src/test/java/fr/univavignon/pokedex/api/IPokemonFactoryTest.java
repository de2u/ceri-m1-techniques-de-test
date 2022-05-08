package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    IPokemonMetadataProvider mockedMetadataProvider;
    IPokemonFactory pokemonFactory;
    Pokemon pokemon;

    @Before
    public void init() {
        mockedMetadataProvider = new PokemonMetadataProvider();
        pokemon = new Pokemon(0, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        pokemonFactory = new PokemonFactory(mockedMetadataProvider);
        //Mockito.when(mockedPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon);
    }

    @Test
    public void createPokemonTest() throws PokedexException {
        Assert.assertEquals(pokemon.getIndex(), pokemonFactory.createPokemon(0, 2729, 202, 5000, 4).getIndex());
    }
}
