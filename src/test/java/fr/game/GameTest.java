package fr.game;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class GameTest {

    @Test
    public void should_add_player() {
        Game game = new Game();
        game.handle("player01", false);
    }

    @Test
    public void should_have_default_gain_to_0_when_new_player() {
        Game game = new Game();
        game.handle("player2", false);
        Assertions.assertThat(game.getGains("player2", "EUR")).isEqualTo(0.0);
    }

    @Test
    public void should_won_gain_for_player() {
        Game game = new Game();
        game.handle("A", false);
        game.handle("B", false);

        game.won("A");

        Assertions.assertThat(game.getGains("A", "EUR")).isEqualTo(5.0);
    }



}