package model;

public class Player {

    private String name;
    private int gamesPlayed;
    private int bestScore;

    public Player() { // конструктор для библиотек
    }

    public Player(String name) { // конструктор для создание игрока
        this.name = name;
        this.gamesPlayed = 0;
        this.bestScore = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getBestScore() {
        return bestScore;
    }
    // счетчик
     public void increaseGamesPlayed() {
         gamesPlayed++;
     }

    public void updateBestScore(int score) {
        if (score > bestScore) {
            bestScore = score;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + name + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", bestScore=" + bestScore +
                '}';
    }
}
