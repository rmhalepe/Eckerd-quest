import java.io.IOException;
import java.util.Scanner;

//class by Rachel Halepeska
public class WildBattle extends Battle{
    //a self contained encounter where the player must find the correct move in order to win
    private Animal a;              //enemy
    private Boolean finish = false; //for battle end
    private Boolean fed = false; //for fish enemies (whether the player used feed)
    private Player p;

    public WildBattle(Player user) throws IOException{
        //standard case social battle
        a = new Animal(user);
        p = user;
        String loc = "";           //dialogue that depends on animal type
        if (a.type.equals("Fish")) loc = "the lake by the library in order to do some fishing.";
        if (a.type.equals("Squirrel")) loc = "the benches in the acedemic quad in order to rest. A squirrel starts inching towards your table.";
        if (a.type.equals("Dolphin")) loc = "south beach to look out on the water. Hang on...there's something in the water!";
        System.out.println("On the way, you decide to go to "+loc);
        System.out.println("*Battle Start*");
        a.attack();             //enemy gets first move

        while (!finish) {
            System.out.println("Your HP: " + p.HP);
            String move = response();                               //records player's move choice
            if (move.equalsIgnoreCase("Fight")) fight();
            if (move.equalsIgnoreCase("Feed")) feed();
            if (move.equalsIgnoreCase("Picture")) picture();
            if (move.equalsIgnoreCase("Run")) {      //ends the battle immediately
                System.out.println("AHHHHHHHHHHHHHHHHH");
                System.out.println("The battle is over.");
                break;       //finishes while loop
            }
            if (!(user.HP > 0)){    //player hp reaches 0 (lose)
                finish = true;
                lose();
            }
        }

    }
    private String response(){
        //returns player move choice
        Scanner scan = new Scanner(System.in);
        String input = "";

        while(!(input.equalsIgnoreCase("Fight") || input.equalsIgnoreCase("Feed") || input.equalsIgnoreCase("Picture") || input.equalsIgnoreCase("Run"))) {
            System.out.println("Fight  |  Feed  |  Picture  |  Run");
            System.out.println("Type here: ");
            input = scan.nextLine();
        }
        return input;
    }
    private void fight(){
        if(a.type.equals("Fish")){
            if (fed){ //once the player chooses feed at least once
                a.counter(); //the fish fights you at first
                String move = response(); //player must input fight again to win
                if (move.equalsIgnoreCase("Fight")){
                    System.out.println("You pull back the rod and real in the fish. You caught it!");
                    finish = true;
                    win();
                    p.increaseHP();
                }
                else{ //if the player does not input fight, they lose
                    System.out.println("Aw, it got away...");
                    finish = true;
                    lose();
                }
            } // if the player has not chosen feed yet, nothing happens
            else System.out.println("...but there was nothing to fight.");
        }
        if (a.type.equals("Squirrel")){
            //fighting the squirrel has 50/50 chance of winning, but takes more hp
            a.counter();
            int rand = (int)(Math.random()*2); //either 0-1
            if (rand == 1){
                System.out.println("You stare down the squirrel, challenging it. It looks away first.");
                finish = true;
                win();
                p.increaseHP();
            }
            else{
                System.out.println("You try to scare away the squirrel, but it's too powerful");
                a.counter();
            }
        }
        if(a.type.equals("Dolphin")){
            //fight loses the battle with dolphin
            System.out.println("You jump into the water fully clothed, ready to fight the creature.");
            a.counter();
            finish = true;
            lose();
        }
    }
    private void feed(){
        if(a.type.equals("Fish")){
            //first part of fish battle complete
            fed = true;
            System.out.println("You put some bait on your hook and cast the line into the lake. You got a bite!");
        }
        if (a.type.equals("Squirrel")){
            //feeding the squirrel has 1/3 chance of winning, 1/3 chance of losing, 1/3 chance nothing
            System.out.println("You place a piece of bread on the table next to you.");
            int rand = (int)(Math.random()*3); //either 0, 1, or 2
            if (rand == 2){
                System.out.println("The squirrel scurries up the table and grabs the food. It looks at you with gratitude while it nibbles.");
                finish = true;
                win();
                p.increaseHP();
            }
            else if (rand == 0){
                System.out.println("The squirrel ignores the bread and goes to your table, stealing your sandwich.");
                finish = true;
                lose();
            }
            else System.out.println("The squirrel does not seem to notice the food.");
        }
        if(a.type.equals("Dolphin")){
            //feed has no affect on dolphin
            System.out.println("You throw some food into the ocean. It drifts away...");
        }
    }
    private void picture()throws IOException {
        if(a.type.equals("Fish")){
            Main.displayfish();
        }
        if (a.type.equals("Squirrel")){
            Main.displaysquirrel();
        }
        if(a.type.equals("Dolphin")){
            //50/50 chance of getting the picture of the dolphin and winning
            int rand = (int)(Math.random()*2); //either 0, or 1
            if (rand == 0){
                System.out.println("You look away to pull out your phone, but when you go to take a picture, the creature is gone.");
                finish = true;
                lose();
            }
            else{
                System.out.println("You pull out your phone and carefully zoom in on the water.");
                Main.displaydolphin();
                finish = true;
                win();
                p.increaseHP();
            }
        }
    }
}
