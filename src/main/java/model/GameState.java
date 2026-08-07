package model;


public class GameState {

    private Player player;
    private int currentQuestionId;
    private int correctAnswers;
    private boolean finished;
    private boolean won;
    private int gamesPlayed;


    public GameState(Player player) {

        this.player = player;
        this.currentQuestionId = 0;
        this.correctAnswers = 0;
        this.finished = false;
        this.won = false;

    }

    public Player getPlayer() {
        return player;
    }

    public int getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void moveToNextQuestion() {
        currentQuestionId++;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void addCorrectAnswer() {
        correctAnswers++;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isWon() {
        return won;
    }

    public void finishGame(boolean won) {
        this.finished = true;
        this.won = won;
    }

    public void increaseGamesPlayed() {
        gamesPlayed++;
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }
}