package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider mockedMetadataProvider;
    PokemonMetadata pokemonMetadata;


    @Before
    public void init() throws PokedexException {
        mockedMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonMetadata = new PokemonMetadata(10, "Toudoudou", 10, 10, 10);
        Mockito.when(mockedMetadataProvider.getPokemonMetadata(pokemonMetadata.getIndex())).thenReturn(pokemonMetadata);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        Assert.assertEquals(pokemonMetadata.getName(), mockedMetadataProvider.getPokemonMetadata(pokemonMetadata.getIndex()).getName());
    }

}
