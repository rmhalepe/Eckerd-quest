//class by Rachel Halepeska
public class Animal extends Enemy {
    //the enemy for social battles
    public int hp;
    public String type;
    private Player p;

    public Animal(Player user){
        //standard case enemy
        String[] types = {"Fish", "Squirrel", "Dolphin"}; //random name and type for variety
        int rand = (int)(Math.random()*types.length); //0-2
        type = types[rand];
        hp = user.HpMax-2; //enemy hp based on user hp for scaling
        p = user;
    }
    public void attack() {
        p.HP --; //always does 1 damage for neutral attack
        //different flavor text for each type
        if (type.equals("Fish")){
            System.out.println("You wait at the water's edge for a fish to bite.");
        }
        if (type.equals("Squirrel")){
            System.out.println("The "+type +" seems to be assessing you.");
        }
        if (type.equals("Dolphin")){
            System.out.println("You try to get a better look at the creature in the water.");
        }
    }
    public void counter() {
        //different(bad choice) text for each type
        p.HP -= 2;
        if (type.equals("Fish")){
            System.out.println("The fish you hooked is attempting to get away!");
        }
        if (type.equals("Squirrel")){
            System.out.println("The squirrel intimidates you.");
        }
        if (type.equals("Dolphin")){
            System.out.println("The creature is spooked and swims away.");
        }
    }
}
