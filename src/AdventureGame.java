import java.util.Random;
import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        // Tizim ob'ektlari
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // O'yin o'zgaruvchilari
        String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // O'yinchi statistikasi
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; // foizda

        boolean running = true;

        System.out.println("🏰 Shadow Realm-ga xush kelibsiz!");

        GAME:
        while (running) {
            System.out.println("-------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t👾 " + enemy + " paydo bo'ldi! \n");

            while (enemyHealth > 0) {
                System.out.println("\tSizning HP: " + health);
                System.out.println("\t" + enemy + " HP: " + enemyHealth);
                System.out.println("\n\tNima qilasiz?");
                System.out.println("\t1. Hujum");
                System.out.println("\t2. Sog'liqni tiklash (Potion)");
                System.out.println("\t3. Qochish!");

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> Siz " + enemy + "ga " + damageDealt + " zarar yetkazdingiz.");
                    System.out.println("\t> Siz " + damageTaken + " zarar oldingiz!");

                    if (health < 1) {
                        System.out.println("\t> Siz juda ko'p zarar oldingiz, siz mag'lub bo'ldingiz!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> Siz potion ichdingiz. HP +" + healthPotionHealAmount + "."
                                + "\n\t> Hozirgi HP: " + health
                                + "\n\t> Qolgan potionlar: " + numHealthPotions);
                    } else {
                        System.out.println("\t> Sizda potion qolmagan! Dushmanni yengib potion yutib oling!");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\t> Siz " + enemy + "dan qochdingiz!");
                    continue GAME;
                } else {
                    System.out.println("\t> Noto'g'ri buyruq!");
                }
            }

            if (health < 1) {
                System.out.println("Siz qorong'ulikda qolib ketdingiz...");
                break;
            }

            System.out.println("-------------------------------------------");
            System.out.println(" ✨ " + enemy + " mag'lub etildi! ✨");
            System.out.println(" Sizda " + health + " HP qoldi.");

            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println(" 🎁 " + enemy + "dan sehrli potion tushdi! ");
                System.out.println(" Hozirgi potionlar soni: " + numHealthPotions);
            }

            System.out.println("-------------------------------------------");
            System.out.println("Nima qilasiz?");
            System.out.println("1. Jangni davom ettirish");
            System.out.println("2. O'yinni tugatish");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Noto'g'ri buyruq!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("Sarguzasht davom etadi!");
            } else if (input.equals("2")) {
                System.out.println("Siz sarguzashtni muvaffaqiyatli yakunladingiz!");
                break;
            }
        }

        System.out.println("#######################");
        System.out.println("# O'YIN UCHUN RAHMAT! #");
        System.out.println("#######################");
    }
}