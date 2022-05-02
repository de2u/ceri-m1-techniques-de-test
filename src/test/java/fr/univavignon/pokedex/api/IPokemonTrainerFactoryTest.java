package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory mockedPokemonTrainerFactory;
    IPokedexFactory mockedPokedexFactory;
    IPokedex mockedPokedex;
    Team team;
    PokemonTrainer trainer;

    @Before
    public void init() {
        mockedPokedex = Mockito.mock(IPokedex.class);
        team = Team.VALOR;
        trainer = new PokemonTrainer("Jean", team, mockedPokedex);
        mockedPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        mockedPokedexFactory = Mockito.mock(IPokedexFactory.class);
        Mockito.when(mockedPokemonTrainerFactory.createTrainer("Jean", team, mockedPokedexFactory)).thenReturn(trainer);
    }

    @Test
    public void createTrainerTest() {
        Assert.assertEquals(trainer.getName(), mockedPokemonTrainerFactory.createTrainer("Jean", team, mockedPokedexFactory).getName());
    }

}
