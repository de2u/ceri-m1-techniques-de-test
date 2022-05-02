package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory mockedPokedexFactory;
    IPokemonMetadataProvider mockedMetadataProvider;
    IPokemonFactory mockedPokemonFactory;
    IPokedex mockedPokedex;

    @Before
    public void init() {
        mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
        mockedMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
        mockedPokedex = Mockito.mock(IPokedex.class);

        Mockito.when(mockedPokedex.size()).thenReturn(0);
        Mockito.when(mockedPokedexFactory.createPokedex(mockedMetadataProvider, mockedPokemonFactory)).thenReturn(mockedPokedex);
    }

    @Test
    public void createPokedexTest() {
        Assert.assertEquals(0, mockedPokedexFactory.createPokedex(mockedMetadataProvider, mockedPokemonFactory).size());
    }

}
