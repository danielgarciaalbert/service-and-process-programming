package data;

public class Enemy implements Character {
    public boolean isEnemy() {
        return true;
    }

    public void kill() {
        System.out.println("Ahhhggg, you killed me, bastard!");
    }
}
