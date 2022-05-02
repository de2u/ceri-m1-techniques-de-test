package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    IPokedex mockedIPokedex;
    Pokemon p;
    List<Pokemon> lp = new ArrayList<>();

    @Before
    public void init() {
        p = new Pokemon(1, "Toudoudou", 10, 40, 23, 34, 7, 3, 67, 10.0);
        lp.add(p);
        lp.add(p);
        mockedIPokedex = Mockito.mock(IPokedex.class);
        Mockito.when(mockedIPokedex.size()).thenReturn(0);
        Mockito.when(mockedIPokedex.getPokemons()).thenReturn(lp);
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(0, mockedIPokedex.size());
        Mockito.when(mockedIPokedex.size()).thenReturn(1);
        Assert.assertEquals(1, mockedIPokedex.size());
    }

    @Test
    public void addPokemonThrowsExceptionWhenNotAdded() throws PokedexException {
        Mockito.when(mockedIPokedex.addPokemon(p)).thenReturn(1);
        Mockito.when(mockedIPokedex.getPokemon(1)).thenReturn(p);
        int id = mockedIPokedex.addPokemon(p);
        Assert.assertEquals(p.getIndex(), mockedIPokedex.getPokemon(id).getIndex());
    }

    @Test
    public void getPokemonsDoesntReturnList() {
        Assert.assertEquals(lp.get(0).getIndex(), mockedIPokedex.getPokemons().get(0).getIndex());
    }

}
