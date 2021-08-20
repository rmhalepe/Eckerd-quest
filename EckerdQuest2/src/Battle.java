//class by Rachel Halepeska
abstract class Battle {
//abstract class for the various battle types
    public void win(){
        //generic win statement for any battle
        System.out.println("");
        System.out.println("The battle is over.");
        System.out.println("Congratulations, you won!");
        System.out.println("You gained some health.");
        System.out.println("");
    }
    public void lose(){
        //generic lose statement for any battle
        System.out.println("The battle is over.");
        System.out.println("Oh no, you lost!");
        System.out.println("");
    }

}
