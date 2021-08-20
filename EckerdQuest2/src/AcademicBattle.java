import java.util.Scanner;

//class by Rachel Halepeska

public class AcademicBattle extends Battle{
        //a self contained encounter where the player must win 3 out of 5 questions
        private Quiz q;              //enemy
        private Boolean finish = false; //for battle end
        private int correct = 0;
        private Player p;

        public AcademicBattle(Player user) {
            //standard case social battle
            q = new Quiz(user);
            p = user;

            System.out.println("It's quiz day! You must get at least 3 out of 5 questions correct to pass.");
            System.out.println("*Quiz Start*");

            while (!finish && q.number <=5) {
                System.out.println("Your HP: " + p.HP+ "  Q's correct: "+correct);
                q.attack();             //quiz questions
                String move = response();                               //records player's move choice
                if (move.equalsIgnoreCase("Remember")) remember();
                if (move.equalsIgnoreCase("Common Sense")) commonsense();
                if (move.equalsIgnoreCase("Guess")) guess();
                if (move.equalsIgnoreCase("Give Up")) {      //get incorrect automatically
                    System.out.println("You leave the question blank.");
                }
                if (!(p.HP > 0)){    //player hp reaches 0 (lose)
                    System.out.println("You suddenly feel light headed and the room spins. You pass out.");
                    System.out.println("The rest of the questions were left blank.");
                    finish = true;
                }
                q.number++;
            }
            System.out.println("You finished the quiz.");
            if (correct >= 3){
                win();
                p.increaseHP();
            }
            else lose();
        }
    private String response(){
        //returns player move choice
        Scanner scan = new Scanner(System.in);
        String input = "";

        while(!(input.equalsIgnoreCase("Remember") || input.equalsIgnoreCase("Common Sense") || input.equalsIgnoreCase("Guess") || input.equalsIgnoreCase("Give Up"))) {
            System.out.println("Remember  |  Common Sense  |  Guess  |  Give Up");
            System.out.println("Type here: ");
            input = scan.nextLine();
        }
        return input;
    }
    private void remember(){
        int rand = (int)(Math.random()*51); //0 to 50
        if (rand + p.Literacy > 30){    //whether or not correct is based on chance and literacy stat
            System.out.println("You got the question correct!");
            correct ++;
        }
        else System.out.println("You got the question wrong...");
    }
    private void commonsense(){
        int rand = (int)(Math.random()*51); //0 to 50
        if (rand + p.Wisdom > 30){    //whether or not correct is based on chance and wisdom stat
            System.out.println("You got the question correct!");
            correct ++;
        }
        else System.out.println("You got the question wrong...");
    }
    private void guess(){
        //50 50 chance correct
        int rand = (int)(Math.random()*2); //either 0, or 1
        if (rand == 0){
            System.out.println("You got the question correct!");
            correct ++;
        }
        else System.out.println("You got the question wrong...");
    }
}
