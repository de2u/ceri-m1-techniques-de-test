package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider mockedMetadataProvider;
    IPokemonFactory mockedPokemonFactory;
    IPokedex mockedPokedex;

    @Before
    public void init() {
        pokedexFactory = new PokedexFactory();
        mockedMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
        mockedPokedex = Mockito.mock(IPokedex.class);

        //Mockito.when(mockedPokedex.size()).thenReturn(0);
        //Mockito.when(pokedexFactory.createPokedex(mockedMetadataProvider, mockedPokemonFactory)).thenReturn(mockedPokedex);
    }

    @Test
    public void createPokedexTest() {
        Assert.assertEquals(0, pokedexFactory.createPokedex(mockedMetadataProvider, mockedPokemonFactory).size());
    }

}
