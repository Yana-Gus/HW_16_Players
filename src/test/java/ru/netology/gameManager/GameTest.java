package ru.netology.gameManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldNotRegisteredFirstPlayer() {
        Player player1 = new Player(1,"Oleg", 500);
        Player player2 = new Player(2,"Aleksandr", 700);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Jenya", "Oleg");}
        );
    }

    @Test
    public void shouldNotRegisteredSecondPlayer() {
        Player player1 = new Player(1,"Oleg", 500);
        Player player2 = new Player(2,"Aleksandr", 700);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Aleksandr", "Jenya");}
        );
    }

    @Test
    public void shouldNotRegisteredPlayers() {
        Player player1 = new Player(1,"Oleg", 500);
        Player player2 = new Player(2,"Aleksandr", 700);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () ->{
            game.round("Jenya", "Roman");}
        );
    }

    @Test
    public void shouldFirstPlayerWin() {
        Player player1 = new Player(1,"Oleg", 500);
        Player player2 = new Player(2,"Aleksandr", 700);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Aleksandr", "Oleg");
        int expected = 1;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldSecondPlayerWin() {
        Player player1 = new Player(1,"Oleg", 500);
        Player player2 = new Player(2,"Aleksandr", 400);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Aleksandr", "Oleg");
        int expected = 2;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testWhenPlayersqualEqualStrength() {
        Player player1 = new Player(1,"Oleg", 400);
        Player player2 = new Player(2,"Aleksandr", 400);
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int actual = game.round("Aleksandr", "Oleg");
        int expected = 0;

        Assertions.assertEquals(expected,actual);
    }
}
