package ru.netology.collections;
import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) { // метод регистрации игрока
        players.add(player);              // у коллекции players есть встроенный метод add
    }

    public int round(String playerName1, String playerName2) { // метод соревнования между двумя игроками
        Player player1 = null;                                // изначально равны null
        Player player2 = null;                                // изначально равны null
        for (Player player : players) {                       // перебираем всех игроков
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {                                    // проверяем игроков
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) {      // сравниваем их силы
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
