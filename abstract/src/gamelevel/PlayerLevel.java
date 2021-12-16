package gamelevel;

public abstract class PlayerLevel {

    public abstract void run();
    public abstract void jump();
    public abstract void turn();
    public abstract void showLevelMessage();

    final public void go(int n) {
        run();
        for(int i = 0; i < n; i++) {
            jump();
        }
        turn();
    }
}
