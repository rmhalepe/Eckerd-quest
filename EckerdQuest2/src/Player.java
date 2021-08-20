public class Player{
    // Changed the Global Variables to be no longer static April 13
    //by Jacob Kula

    int Literacy;
    int Wisdom;
    int sta;
    int HP;
    int social;
    int HpMax;
    int StaMax;
    int Heart;
    int exp;
    String name;
    int currentExp;

    public Player (String in) {
        Literacy = 1;
        Wisdom = 1;
        sta = 3;
        HP = 10;
        social = 2;
        HpMax = 10;
        StaMax = 3;
        Heart = 0;
        name = in;
        currentExp = 0;
        exp = 0;

    }


    public void printStats() {
        System.out.println("______________________________________________");
        System.out.println("Name: " + name);
        System.out.println("HP: " + HP);
        System.out.println("Max Hp: " + HpMax);
        System.out.println("Stamina: " + sta);
        System.out.println("Max Stamina: " + StaMax);
        System.out.println("Social " + social);
        System.out.println("Skills: Literacy: " + Literacy + " Wisdom: " + Wisdom);
        System.out.println("______________________________________________");

    }

    public void increaseHP() {
        Heart++;
        if (Heart == 3) {
            HpMax++;
            Heart = 0;
        }
    }
}