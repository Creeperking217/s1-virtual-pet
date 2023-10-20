public class Opponent {
    public String name;
    public int health;
    public String[] attacks;
    public int[] attackDamages;
    public String spriteName ;
    public Opponent(String n, int h, String[] a, int[] dmg, String s) {
        name = n;
        health = h;
        attacks = a;
        attackDamages = dmg;
        spriteName = s;
    }
}
