package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider metadataProvider;
    PokemonMetadata pokemonMetadata;


    @Before
    public void init() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        //Mockito.when(mockedMetadataProvider.getPokemonMetadata(pokemonMetadata.getIndex())).thenReturn(pokemonMetadata);
        //Mockito.when(mockedMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));
        //Mockito.when(mockedMetadataProvider.getPokemonMetadata(152)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        Assert.assertEquals(pokemonMetadata.getName(), metadataProvider.getPokemonMetadata(pokemonMetadata.getIndex()).getName());
    }

    @Test
    public void getPokemonThrowsExceptionWhenInvalidId() {
        Assert.assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(-1));
        Assert.assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(152));
    }

}
