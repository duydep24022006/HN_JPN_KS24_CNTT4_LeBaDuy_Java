public class Mage extends GameCharacter implements ISkill {

    private int mana;

    public Mage(String name, int hp, int attackPower, int mana) {
        super(name, hp, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println("[Pháp sư] " + name + " tấn công " + target.getName() + "!");

        if (mana >= 5) {
            mana -= 5;
            target.takeDamage(attackPower);
            System.out.println("   Tốn 5 mana. Mana còn: " + mana);
        } else {
            int damage = attackPower / 2;
            target.takeDamage(damage);
            System.out.println(" Hết mana! Sát thương giảm còn " + damage);
        }
    }

    @Override
    public void useUltimate(GameCharacter target) {
        System.out.println("[Pháp sư] " + name + " dùng 'Hỏa cầu'!");
        if (mana >= 50) {
            mana -= 50;
            int damage = attackPower * 3;
            target.takeDamage(damage);
            System.out.println("  Tốn 50 mana. Mana còn: " + mana);
        } else {
            System.out.println(" Không đủ mana để dùng chiêu cuối!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
    }
}