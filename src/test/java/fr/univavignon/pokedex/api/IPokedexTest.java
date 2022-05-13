package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class IPokedexTest {

    IPokemonMetadataProvider mockedMetadataProvider;
    IPokemonFactory mockedPokemonFactory;
    IPokedex pokedex;
    Pokemon p;
    List<Pokemon> lp;

    @Before
    public void init() {
        mockedMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        mockedPokemonFactory = Mockito.mock(IPokemonFactory.class);
        lp = new ArrayList<>();
        p = new Pokemon(1, "Toudoudou", 10, 40, 23, 34, 7, 3, 67, 10.0);
        lp.add(p);
        lp.add(p);
        pokedex = new Pokedex(mockedMetadataProvider, mockedPokemonFactory);
        //Mockito.when(pokedex.size()).thenReturn(0);
        //Mockito.when(pokedex.getPokemons()).thenReturn(lp);
    }

    @Test
    public void sizeTest() {
        IPokedex pokedex2 = new Pokedex(mockedMetadataProvider, mockedPokemonFactory);
        Assert.assertEquals(0, pokedex2.size());
        //Mockito.when(pokedex.size()).thenReturn(1);
        Pokemon p2 = new Pokemon(4, "Toudoudou", 10, 40, 23, 34, 7, 3, 67, 10.0);
        pokedex2.addPokemon(p2);
        Assert.assertEquals(1, pokedex2.size());
        pokedex2.addPokemon(p2);
        Assert.assertEquals(2, pokedex2.size());
    }

    @Test
    public void addPokemonReturnsWrongId() {
        int expected_int = pokedex.size();
        int returned_int = pokedex.addPokemon(p);
        Assert.assertEquals(expected_int, returned_int);
    }

    @Test
    public void addPokemonReturnsWrongPokemon() throws PokedexException {
        //Mockito.when(pokedex.addPokemon(p)).thenReturn(1);
        //Mockito.when(pokedex.getPokemon(1)).thenReturn(p);
        int id = pokedex.addPokemon(p);
        Assert.assertEquals(p.getIndex(), pokedex.getPokemon(id).getIndex());
        Assert.assertEquals(p.getName(), pokedex.getPokemon(id).getName());
    }

    @Test
    public void getPokemonThrowsExceptionWhenIdInvalid() {
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
        Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(pokedex.size()));
    }

    @Test
    public void getPokemonsIsWrongSize() {
        Assert.assertEquals(pokedex.size(), pokedex.getPokemons().size());
    }

}
