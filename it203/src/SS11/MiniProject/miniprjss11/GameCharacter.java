public abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected static int count = 0;

    public GameCharacter(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public static int getCount() {
        return count;
    }

    public int attackPower() {
        return attackPower;
    }

    // phuong thuc truu tuong
    public abstract void attack(GameCharacter target);

    // nhận sát thương
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + "Da bi ha guc");

        } else {
            System.out.println("   -> " + name + " mất " + amount + " máu. HP còn: " + hp);

        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp);
    }

}