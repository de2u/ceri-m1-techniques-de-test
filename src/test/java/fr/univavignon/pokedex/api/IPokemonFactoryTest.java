package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    IPokemonFactory mockedPokemonFactory;
    Pokemon pokemon;

    @Before
    public void init() {
        pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
        Mockito.when(mockedPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon);
    }

    @Test
    public void createPokemonTest() {
        Assert.assertEquals(pokemon.getIndex(), mockedPokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex());
    }
}
