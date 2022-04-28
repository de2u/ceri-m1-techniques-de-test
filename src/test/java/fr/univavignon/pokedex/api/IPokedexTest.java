package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {

    IPokedex mockedIPokedex;

    @Before
    public void init() {
        mockedIPokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void addPokemonThrowsExceptionWhenNotAdded() throws Exception {
        Pokemon p = new Pokemon(1, "Toudoudou", 10, 40, 23, 34, 7, 3, 67, 10.0);
        Mockito.when(mockedIPokedex.addPokemon(p)).thenReturn(1);
        Mockito.when(mockedIPokedex.getPokemon(1)).thenReturn(p);
        int id = mockedIPokedex.addPokemon(p);
        Assert.assertEquals(p.getIndex(), mockedIPokedex.getPokemon(id).getIndex());
    }

}
