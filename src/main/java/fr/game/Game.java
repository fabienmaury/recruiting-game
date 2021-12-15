package fr.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<String> players = new ArrayList<>();
    private static List<Integer> gains = new ArrayList<>();

    public Game() {
        reset();
    }

    public void handle(String player, boolean delete) {
        if(!delete) {
            players.add(player);
            gains.add(0);
        } else {
            players.remove(player);
        }
    }

    public void won(String player) {
        int position = -1;
        int i = 0;
        for(String s : players) {
            if(s.equals(player)) {
                position = i;
            }
            i++;
        }
        gains.set(position, gains.get(position) + 500);
    }

    public Double getGains(String player, String currency) {
        switch (currency) {
            case "EUR":
                return gains.get(players.indexOf(player)) / 100.0;
            case "USD":
                return gains.get(players.indexOf(player)) * 1.12 / 100.0;
            default:
                return 0.0;
        }
    }


    public void reset() {
        players.clear();
        gains.clear();
    }
}
