package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    // первый игрок не зарегистрирован
    @Test
    public void testWhenFirstPlayerIsNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(401, "Eva", 49);

        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Lilit", "Eva"));
    }

    // второй игрок не зарегистрирован
    @Test
    public void testWhenSecondPlayerIsNotRegistered() {
        Game game = new Game();
        Player player2 = new Player(307, "Deni", 78);

        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Deni", "Alex"));
    }

    // второй игрок победил, возвращает 2
    @Test
    public void testWhenTheSecondPlayerIsTheWinner() {
        Game game = new Game();
        Player player1 = new Player(401, "Eva", 49);
        Player player2 = new Player(633, "Lilit", 47);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Lilit", "Eva");

        Assertions.assertEquals(expected, actual);
    }

    // первый игрок победил, возвращает 1
    @Test
    public void testWhenTheFirstPlayerIsTheWinner() {
        Game game = new Game();
        Player player1 = new Player(116, "Alex", 81);
        Player player2 = new Player(307, "Deni", 78);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Alex", "Deni");

        Assertions.assertEquals(expected, actual);
    }

    // ничья, возвращает 0
    @Test
    public void testWhenTheForcesAreEqual() {
        Game game = new Game();
        Player player1 = new Player(501, "Sofi", 52);
        Player player2 = new Player(51, "Lala", 52);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Sofi", "Lala");

        Assertions.assertEquals(expected, actual);
    }
}