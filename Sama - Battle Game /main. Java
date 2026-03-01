import java.util.Scanner;

public class BattleGame{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter player’s name:");
        String playername = input.next();

        System.out.println("Enter player health:");
        int playerHealth = input.nextInt();

        System.out.println("Enter player attack power:");
        int playerAttack = input.nextInt();

        Player p = new Player(playername, playerHealth, playerAttack);

        System.out.println("Enter monster’s name:");
        String monstername = input.next();

        System.out.println("Enter monster health:");
        int monsterHealth = input.nextInt();

        System.out.println("Enter monster attack power:");
        int monsterAttack = input.nextInt();

        Monster m = new Monster(monstername, monsterHealth, monsterAttack);

        while (p.isAlive() && m.isAlive()) {
            p.attack(m);

            if (m.isAlive()) {
                m.attack(p);
            }
            System.out.println("Player health: " + p.Health);
            System.out.println("Monster health: " + m.Health);
        }

        if (m.Health <= 0) {
            System.out.println("THE" + " " + m.name + " IS DEAD !");
        }

        else if(p.Health <= 0) {
            System.out.println("THE " + " " + p.name + " IS DEAD !");
        }
    }
}

