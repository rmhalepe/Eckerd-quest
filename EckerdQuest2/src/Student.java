//class by Rachel Halepeska
public class Student extends Enemy{
    //the enemy for social battles
    public int hp;
    public String name;
    public String type;
    public Player p;

    public Student(Player user){
        //standard case enemy
        String[] names = {"Steve", "Caleb", "Chad", "Nick", "Ally", "May", "Corrina"};
        String[] types = {"Friend", "Antagonist", "Clueless"}; //random name and type for variety
        int rand = (int)(Math.random()*names.length); //0-6 for the names
        name = names[rand];
        rand = (int)(Math.random()*types.length); //0-2
        type = types[rand];
        hp = user.HpMax-2; //enemy hp based on user hp for scaling
        p = user;
    }
    public Student(Player user,String tutorial){
        //enemy for the tutorial battle
        name = tutorial;
        hp = 4;
        type = "Friend";
        p = user;
    }
    public void attack() {
        p.HP --; //always does 1 damage for neutral attack
        //different flavor text for each type
        if (type.equals("Friend")){
            System.out.println(name +" tells you about a party they're going to this weekend.");
        }
        if (type.equals("Antagonist")){
            System.out.println(name +" gets up in your face, insults you, and gestures with bravado.");
        }
        if (type.equals("Clueless")){
            System.out.println(name +" nervously asks for directions to the library.");
        }
    }
    public void counter() {
        p.HP -= p.social; //damage is based on player damage
        //different(bad choice) text for each type
        if (type.equals("Friend")){
            System.out.println(name +" looks kind of insulted.");
        }
        if (type.equals("Antagonist")){
            System.out.println(name +" is not amused.");
        }
        if (type.equals("Clueless")){
            System.out.println(name +" is hurt by your words.");
        }
    }
}
