public class Monster{
    String name;
    int Health;
    int attackPower;

    public Monster(String name, int Health, int attackPower) {
        this.name = name;
        this.Health = Health;
        this.attackPower = attackPower;
    }
    void attack(Player p){
        p.takeDamage(attackPower);
    }

     void takeDamage(int damage){
         Health -= damage;
         if (Health < 0) {
             Health = 0;
         }
    }

    boolean isAlive(){
         return Health > 0;
    }
}
