import java.util.ArrayList;

//class by Rachel Halepeska
public class Quiz extends Enemy{
    private Player p;
    public int number;

    public Quiz(Player user) {
        //standard case quiz
        p = user;
        number = 1;  //counter: quizes have 5 questions
    }
    public void attack() {
        ArrayList<String> questions = new ArrayList<String>();
        questions.add("Question "+number+" is about the book chapter you read for homework.");
        questions.add("Question "+number+" asks for a common theme between the topics the class had discussed.");
        questions.add("Question "+number+" asks you to write your own (summary) version of an allegory");
        questions.add("Question "+number+" asks you to discuss your favorite character in the class.");
        questions.add("Question "+number+" asks for 2 names and fun facts about your classmates.");
        int rand = (int)(Math.random()*questions.size());  //chooses random question
        System.out.println(questions.get(rand));
        rand = (int)(Math.random()*5);
        if (rand == 0){     // 1 in 5 chance
            counter();
        }
    }
    public void counter() {
        //chance for losing hp
        System.out.println("The hard question tires you out.");
        p.HP -= 4;
    }
}
