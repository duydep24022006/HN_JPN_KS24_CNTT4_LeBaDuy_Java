public class Warrior extends GameCharacter implements ISkill {

    private int armor;

    public Warrior(String name, int hp, int attackPower, int armor) {
        super(name, hp, attackPower);
        this.armor = armor;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " tấn công " + target.getName() + "!");
        target.takeDamage(attackPower);
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Chiến binh] " + name + " dùng 'Đấm ngàn cân'!");
        int damage = attackPower * 2;
        target.takeDamage(damage);

        // mất 10% HP hiện tại
        int selfDamage = (int) (hp * 0.1);
        hp -= selfDamage;
        System.out.println("" + name + " tự mất " + selfDamage + " HP do gắng sức.");
    }

    // Ghi đè để trừ giáp trước khi trừ máu
    @Override
    public void takeDamage(int amount) {
        int finalDamage = amount - armor;
        if (finalDamage < 0)
            finalDamage = 0;
        super.takeDamage(finalDamage);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
    }
}