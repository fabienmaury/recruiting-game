package fr.game;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void should_add_player() {
        Game game = new Game();
        game.addPlayer("player01");
    }

    @Test
    public void should_have_default_gain_to_0_when_new_player() {
        Game game = new Game();
        game.addPlayer("player2");
        Assertions.assertThat(game.getGains("player2", "EUR")).isEqualTo(0.0);
    }

    @Test
    public void should_won_gain_for_player() {
        Game game = new Game();
        game.addPlayer("A");
        game.addPlayer("B");

        game.won("A");

        Assertions.assertThat(game.getGains("A", "EUR")).isEqualTo(5.0);
    }



}