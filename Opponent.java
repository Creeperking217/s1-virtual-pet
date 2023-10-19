public class Opponent {
    public String name;
    public int health;
    public String[] attacks;
    public int[] attackDamages;
    public Opponent(String n, int h, String[] a, int[] dmg) {
        name = n;
        health = h;
        attacks = a;
        attackDamages = dmg;
    }
}
