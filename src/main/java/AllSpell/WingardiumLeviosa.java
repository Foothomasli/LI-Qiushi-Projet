package AllSpell;
import Character.Ennemy.Ennemy;
import Character.Wizard;
import java.util.Random;
import lombok.Getter;

public class WingardiumLeviosa extends Spell{

    @Getter
    public String name = "Wingardium Leviosa";
    public void usespell(Wizard wizard, Ennemy ennemy){

        System.out.println("\n");
        System.out.println("You use Wingardium Leviosa to "+ ennemy.name + "\n");
        Random random = new Random();
        int a = random.nextInt(99)+1;
        if(wizard.mp >= 10){

            if(a>20){
                ennemy.state = "Floating";
                wizard.mp = wizard.mp - 10;
                System.out.println("You successfully used the spell");
            }
            else {
                System.out.println("Your spell has failed.");
                wizard.mp = wizard.mp - 10;
            }
        }
        else {
            System.out.println("You don't have enough magic");
        }
    }

}