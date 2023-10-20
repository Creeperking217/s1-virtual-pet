public class Opponent {
    public String name;
    public int health;
    public String[] attacks;
    public int[] attackDamages;
    public String enteranceLine;
    public Opponent(String n, int h, String[] a, int[] dmg, String e) {
        name = n;
        health = h;
        attacks = a;
        attackDamages = dmg;
        enteranceLine = e;
    }
}
