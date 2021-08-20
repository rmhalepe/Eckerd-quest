import java.util.Scanner;
import java.util.ArrayList;

//class by Rachel Halepeska

public class SocialBattle extends Battle {
    //a self contained encounter where the player must find the correct move in order to win
    private Student s;              //enemy
    private Boolean finish = false; //for battle end
    private int attackPW;


    public SocialBattle(Player user){
        //standard case social battle
        System.out.println("*Battle Start*");
        s = new Student(user);
        attackPW = user.social; //damage based on player social stat
        s.attack();             //enemy gets first move

        while (!finish) {
            System.out.println("Your HP: "+ user.HP +"\t "+s.name+" HP: "+ s.hp);
            String move = response();                               //records player's move choice
            if (move.equalsIgnoreCase("Joke")) joke();
            if (move.equalsIgnoreCase("Tease")) tease();
            if (move.equalsIgnoreCase("Assist")) assist();
            if (move.equalsIgnoreCase("Run")){      //ends the battle immediately
                System.out.println("AHHHHHHHHHHHHHHHHH");
                System.out.println("The battle is over.");
                break;       //finishes while loop
            }
            if (s.hp <= 0){     //enemy hp reaches 0 (win)
                finish = true;
                user.HpMax++;
                win();
                user.increaseHP();
            }
            if (!(user.HP > 0)){    //player hp reaches 0 (lose)
                finish = true;
                lose();
            }
        }
    }
    public SocialBattle(Player user, String tutorial){
        //tutorial social battle
        System.out.println("--------------------");
        System.out.println("*Battle Start*");
        s = new Student(user, tutorial);
        attackPW = 2;       //damage fixed at 2 (hp per hit)
        s.attack();         //enemy gets first move

        System.out.println("Alex: “When you have to interact with other people you have 4 options to choose from: "
                +"\n\tJoke, Tease, Assist, or Run. People will respond better to one option over the others, "
                +"\n\talthough sometimes running is your only option to save you from battling. Go ahead and pick an option.” ");
        while (!finish) {
            System.out.println("Your HP: "+ user.HP +"\t "+tutorial+" HP: "+ s.hp);
            String move = response();       //records player's move choice
            if (move.equalsIgnoreCase("Joke")){ joke(); }
            if (move.equalsIgnoreCase("Tease")){ tease(); }
            if (move.equalsIgnoreCase("Assist")){ assist(); }
            if (move.equalsIgnoreCase("Run")){
                System.out.println("AHHHHHHHHHHHHHHHHH");   //ends the battle immediately
                System.out.println("The battle is over.");
                break;                  //finishes while loop
            }
            if (s.hp <= 0){         //enemy hp reaches 0 (win)
                finish = true;
                user.HpMax++;
                win();
            }
            if (!(user.HP > 0)){    //player hp reaches 0 (lose)
                finish = true;
                lose();
            }
        }
        //tutorial, battle explanation
        System.out.println("Alex: 'As you could probably tell, if you choose the right response enough times, you win the battle."
                + "\n\tHowever, if your HP falls to 0, you lose.' ");
    }


    private String response(){
        //returns player move choice
        Scanner scan = new Scanner(System.in);
        String input = "";

        while(!(input.equalsIgnoreCase("Joke") || input.equalsIgnoreCase("Tease") || input.equalsIgnoreCase("Assist") || input.equalsIgnoreCase("Run"))) {
            System.out.println("Joke  |  Tease  |  Assist  |  Run");
            System.out.println("Type here: ");
            input = scan.nextLine();
        }
        return input;
    }
    private void joke(){
        ArrayList<String> jokes = new ArrayList<String>();
        jokes.add("You tell " + s.name + " a bad pun.");
        jokes.add("You repeat a knock-knock joke you heard from Alex.");
        jokes.add("You tell "+s.name+" a funny childhood story.");
        int rand = (int)(Math.random()*jokes.size());  //chooses random joke
        System.out.println(jokes.get(rand));

        if(s.type.equals("Friend")){
            //joke is effective against friend type
            System.out.println(s.name + " laughs.");
            s.hp -= attackPW;
        }
        else if(s.type.equals("Antagonist")){
            //joke is wrong choice against antagonist
            s.counter();
        }
        //clueless is neutral
        else s.attack();
    }
    private void assist(){
        System.out.println("You attempt to help " +s.name+ " with their problems.");
        if(s.type.equals("Clueless")){
            //assist is effective against clueless type
            System.out.println(s.name+ " looks relieved and thanks you.");
            s.hp -= attackPW;
        }
        else if (s.type.equals("Friend")){
            //assist is wrong choice against friend
            s.counter();
        }
        ///antagonist is neutral
        else s.attack();
    }
    private void tease(){
        ArrayList<String> teases = new ArrayList<String>();
        teases.add("You comment on " +s.name+  "'s questionable fashion choices.");
        teases.add("You call the movie " +s.name+ " was just talking about trash.");
        teases.add("You challenge "+s.name+ " to a dare, but they refuse. You call " +s.name+ " a chicken.");
        int rand = (int)(Math.random()*teases.size());  //chooses random tease
        System.out.println(teases.get(rand));

        if (s.type.equals("Antagonist")){
            //tease is effective against antagonist
            System.out.println(s.name+ " respects your opinions and appreciates honesty.");
            s.hp -= attackPW;
        }
        if(s.type.equals("Clueless")){
            //tease is wrong choice against clueless
            s.counter();
        }
        //friend is neutral
        else s.attack();
    }
}
