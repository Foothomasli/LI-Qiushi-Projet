package Level;
import    Character.Ennemy.Boss.Dolores_Ombrage;
import    Character.Ennemy.Empty_ennemy;
import    Character.Ennemy.Ennemy;
import    Character.Ennemy.Ennemy5;
import    Character.Wizard;
import    Potion.LifePotion;
import    Potion.MagicPotion;
import    Potion.StrengtheningPotion;

import java.util.Random;
import java.util.Scanner;

public class Level5 {

    Ennemy[] ennemies = new Ennemy[3];
    Ennemy boss = new Dolores_Ombrage();
    boolean invalid_operation;
    Ennemy[] surviving_enemy = new Ennemy[3];
    int number_fireworks = 0;

    public Level5(){

        for(int i = 0; i< ennemies.length; i++){
            ennemies[i] = new Ennemy5();
            ennemies[i].name = "Ennemy"+(i+1);
        }
    }

    public void affiche(Wizard wizard){

        System.out.print(wizard.name + " :" + wizard.hp + "   mp: " + wizard.mp + "     ");
        int potion1 = 0 , potion2 = 0, potion3 = 0;
        for (int i = 0; i<wizard.potions.length; i++){

            switch (wizard.potions[i].name){

                case "LifePotion"->potion1++;
                case "MagicPotion"->potion2++;
                case "StrengtheningPotion"->potion3++;
            }
        }
        System.out.print("LifePotion: "+potion1+"  "+"MagicPotion: "+potion2+"  "+"StrengtheningPotion: "+potion3+"  ");
        System.out.print("                   ");
        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {

                System.out.print(ennemy.name + ": " + ennemy.hp + "   ");
            }
        }
    }

    public void affiche_boss(Wizard wizard){


        System.out.print(wizard.name + " :" + wizard.hp + "   mp: " + wizard.mp + "     ");
        int potion1 = 0 , potion2 = 0, potion3 = 0;
        for (int i = 0; i<wizard.potions.length; i++){

            switch (wizard.potions[i].name){

                case "LifePotion"->potion1++;
                case "MagicPotion"->potion2++;
                case "StrengtheningPotion"->potion3++;
            }
        }
        System.out.print("LifePotion: "+potion1+"  "+"MagicPotion: "+potion2+"  "+"StrengtheningPotion: "+potion3+"  ");
        System.out.print("Number of fireworks: " + number_fireworks);
        System.out.print("                   ");
        System.out.print(boss.name + ": " + boss.hp);

    }

    void surviving_enemy_nb(){

        for(int i = 0; i < surviving_enemy.length; i++){

            surviving_enemy[i] = new Empty_ennemy();
        }


        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {

                for (int a = 0; a < surviving_enemy.length; a++) {

                    if (surviving_enemy[a].name.equals("null")) {
                        surviving_enemy[a] = ennemy;
                        break;
                    }
                }
            }
        }
    }
    public void attack(Wizard wizard){

        surviving_enemy_nb();
        System.out.print("Choose the ennemy you want to attack: ");
        for( int i = 0; i < surviving_enemy.length; i++){

            if(surviving_enemy[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_enemy[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();

        switch (ennemy){
            case (1)-> wizard.attack(surviving_enemy[0]);
            case (2)-> wizard.attack(surviving_enemy[1]);
            case (3)-> wizard.attack(surviving_enemy[2]);
            default -> {
                System.out.println("Cannot attack this ennemy, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void attack_boss(Wizard wizard){

        wizard.attack(boss);
        Random random = new Random();
        int random_number = random.nextInt(99) + 1;
        if(random_number <= 40){

            System.out.println("You get a firework.");
            number_fireworks++;
        }
        else {

            System.out.println("You don't get a firework.");
        }

    }

    public void magic_attack(Wizard wizard){

        surviving_enemy_nb();
        System.out.print("Choose the ennemy you want to attack: ");
        for( int i = 0; i < surviving_enemy.length; i++){

            if(surviving_enemy[i].hp > 0){

                System.out.print( (i+1) + "." + surviving_enemy[i].name + "  ");
            }
        }
        System.out.println(" ");
        Scanner scanner = new Scanner(System.in);
        int ennemy = scanner.nextInt();

        switch (ennemy){

            case (1)-> wizard.magicattack(surviving_enemy[0]);
            case (2)-> wizard.magicattack(surviving_enemy[1]);
            case (3)-> wizard.magicattack(surviving_enemy[2]);
            default -> {
                System.out.println("Cannot attack this ennemy, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void magic_attack_boss(Wizard wizard){

        wizard.magicattack(boss);
        Random random = new Random();
        int random_number = random.nextInt(99) + 1;
        if(random_number <= 50){

            System.out.println("You get a firework.");
            number_fireworks++;
        }
        else {
            System.out.println("You don't get a firework.");
        }
    }

    public void ennemy_attack(Wizard wizard){

        for (Ennemy ennemy : ennemies) {

            if (ennemy.hp > 0) {
                ennemy.attack(wizard);
            }
        }
    }

    public void operater( Wizard wizard){

        Scanner scanner = new Scanner(System.in);
        affiche(wizard);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Choose what you want to do : 1. attack  2. magicattack  3. use the potion");
        int a = scanner.nextInt();
        this.invalid_operation = false;
        switch (a){
            case 1 -> attack(wizard);
            case 2 -> magic_attack(wizard);
            case 3 -> wizard.usePotion();
            default -> {
                System.out.println("This operation is invalid, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void operater_boss(Wizard wizard){

        Scanner scanner = new Scanner(System.in);
        affiche_boss(wizard);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Choose what you want to do : 1. attack  2. magicattack  3. use the potion");
        int a = scanner.nextInt();
        this.invalid_operation = false;
        switch (a){
            case 1 -> {attack_boss(wizard); System.out.println("You attacked the enemy.");}
            case 2 -> {magic_attack_boss(wizard); System.out.println("You attacked the enemy.");}
            case 3 -> {wizard.usePotion(); System.out.println("You used a potion.");}
            default -> {
                System.out.println("This operation is invalid, please select action again.\n");
                this.invalid_operation = true;
            }
        }
    }

    public void settlement(Wizard wizard){

        wizard.hpmax = wizard.hpmax + 50;
        wizard.mpmax = wizard.mpmax + 25;
        wizard.defense = wizard.defense + 5;
        wizard.hp = wizard.hpmax;
        wizard.mp = wizard.mpmax;
        for(int i = 0; i<5; i++){
            wizard.potions[i] = new LifePotion();
        }
        for(int i = 5; i<10; i++){
            wizard.potions[i] = new MagicPotion();
        }
        for(int i = 10; i<15; i++){
            wizard.potions[i] = new StrengtheningPotion();
        }

        System.out.println("You have learned Expecto Patronum");

    }

    public void settlement_boss(Wizard wizard){

        wizard.hpmax = wizard.hpmax + 50;
        wizard.mpmax = wizard.mpmax + 25;
        wizard.defense = wizard.defense + 5;
        wizard.hp = wizard.hpmax;
        wizard.mp = wizard.mpmax;
        for(int i = 0; i<5; i++){
            wizard.potions[i] = new LifePotion();
        }
        for(int i = 5; i<10; i++){
            wizard.potions[i] = new MagicPotion();
        }
        for(int i = 10; i<15; i++){
            wizard.potions[i] = new StrengtheningPotion();
        }
    }

    public void normal_level(Wizard wizard){

        System.out.println("You have successfully enrolled in your fifth year!\n");
        System.out.println("To improve abilities, defeat these enemies.");
        while( (ennemies[0].hp > 0 || ennemies[1].hp > 0 || ennemies[2].hp > 0) && wizard.hp > 0) {
            do {
                operater(wizard);
            } while (this.invalid_operation);
            ennemy_attack(wizard);
            System.out.println("The enemy has attacked you.");
            System.out.println("\n");
        }
        if(wizard.hp > 0){
            System.out.println("Your abilities have been improved\n");
            settlement(wizard);
            System.out.println("\n");
        }
        else {
            System.out.println("You died, game over");
        }
    }

    public void boss_level(Wizard wizard){

        Random random = new Random();
        System.out.println("You met Dolores Ombrage\n");
        while( number_fireworks < 7  && wizard.hp > 0){

            do {
                operater_boss(wizard);
            } while (this.invalid_operation);
            boss.attack(wizard);
            System.out.println("Boss has attacked you.");
            System.out.println("\n");

        }
        if(wizard.hp > 0){

            System.out.println("You've collected enough fireworks, and the party's on!");
            System.out.println("Your abilities have been improved\n");
            settlement_boss(wizard);
        }
        else {
            System.out.println("You died, game over");
        }
    }
}
