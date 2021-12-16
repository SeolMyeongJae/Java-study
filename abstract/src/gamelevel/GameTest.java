package gamelevel;

public class GameTest {
    public static void main(String[] args) {
        Player pl = new Player();
        pl.play(1);

        PlayerLevel aLevel = new AdvancedLevel();
        pl.upgradeLevel(aLevel);
        pl.play(1);

        PlayerLevel sLevel = new SpuerLevel();
        pl.upgradeLevel(sLevel);
        pl.play(3);
    }
}
