import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenPlayer1Win() {
        Game game = new Game();
        Player first = new Player(1, "dinamo", 80);
        Player second = new Player(2, "hacker", 100);
        game.register(first);
        game.register(second);

        int expected = 2;
        int actual = game.round("dinamo", "hacker");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayer2Win() {
        Game game = new Game();
        Player first = new Player(1, "dinamo", 90);
        Player second = new Player(2, "hacker", 60);
        game.register(first);
        game.register(second);

        int expected = 1;
        int actual = game.round("dinamo", "hacker");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayersStrengthEqual() {
        Game game = new Game();
        Player first = new Player(1, "dinamo", 70);
        Player second = new Player(2, "hacker", 70);
        game.register(first);
        game.register(second);

        int expected = 0;
        int actual = game.round("dinamo", "hacker");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNameFirstPlayerWrong() {
        Game game = new Game();
        Player first = new Player(1, "dinamo", 80);
        Player second = new Player(2, "hacker", 70);
        game.register(first);
        game.register(second);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("sunny", "hacker");
        });
    }

    @Test
    public void testWhenNameSecondPlayerWrong() {
        Game game = new Game();
        Player first = new Player(1, "dinamo", 80);
        Player second = new Player(2, "hacker", 70);
        game.register(first);
        game.register(second);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("dinamo", "jack");
        });
    }
}

