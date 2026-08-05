import model.Player;

public class TestPlayer {

    public static void main(String[] args) {

        Player player = new Player("Jury");

        player.increaseGamesPlayed();
        player.updateBestScore(4);

        player.increaseGamesPlayed();
        player.updateBestScore(6);

        System.out.println(player);
    }
}
