//package p;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics;


public class Main {
    public static int day;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Eckerd Quest! We hope you enjoy our game.");
        System.out.println(" What is your name?");
        String name = input.nextLine();
        System.out.println("Hello there, " + name + "! Nice to meet you. You will soon be introduced to the daily life of a freshman at Eckerd College. ");
        System.out.println("You will go through the ups and downs of college life. At this college, you will meet new and exciting people, \n \t interact with the wild life," +
                " and try to become the best student you can be.");
        System.out.println("Can you survive your first semester of college? Let’s go!");
        //pause for readability
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Player user = new Player(name);
        tutorial(user);
        SocialBattle tutorialBattle = new SocialBattle(user, "Matt");
        dorm(user);
        System.out.println("Congratulations! You finished your first day of Autumn Term. Now it's up to you to make it through the rest of the semester.");
        //days 2-19
        while (day <= 19) {
            while (user.sta > 0) {
                String in = "";
                while (!(in.equalsIgnoreCase("Map") || in.equalsIgnoreCase("Stat")||
                        in.equalsIgnoreCase("Help")))  {
                    System.out.println("Map | Stat | Help ");
                    System.out.println("Type here: ");
                    in = input.nextLine();
                }
                if (in.equalsIgnoreCase("Map")) map(user);
                if (in.equalsIgnoreCase("Stat")) user.printStats();
                if (in.equalsIgnoreCase("Help")) help_me();
            }
            //after stamina reaches 0, player is forced back to the dorms, where day counter increases
            dorm(user);
        }
    }
    //method by Rachel Halepeska
    public static void tutorial(Player user) throws IOException {

            Scanner input = new Scanner(System.in);
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("*an alarm blares* You stumble out of bed. As you rummage through your closet and get dressed, your roommate, Alex, approaches you.");
            System.out.println("Alex: “Hey, " + user.name + ", do you want to go to the caf together?”");
            System.out.println(user.name + ": “......”");
            System.out.println("Alex: “Oh, you don't remember where that is? That’s ok, let me show you. It is a Monday after all.”");
            String in = "";
            //map explanation
            while (!(in.equalsIgnoreCase("map"))) {
                //loop until user types map
                System.out.println("Alex: “When you want to go somewhere, type the word “Map” into the prompt.”");
                System.out.println("Type the word here: ");
                in = input.nextLine();
            }
            displaymap();
            //map
            while (!(in.equals("1"))) {
                //loop until user types 1
                System.out.println("Alex: “Next, type in a number for the place you want to go. For the caf, the number is 1.”");
                System.out.println("Type the number here: ");
                in = input.nextLine();
                System.out.println("");
            }
            user.sta--;
            System.out.println("----------------------------------------");
            System.out.println("You and Alex go to the cafeteria.");
            //caf and stats explanation
            System.out.println("");
            System.out.println("Alex: “Now we’re finally at the caf! Let’s eat. \n\t" +
                    "Every time you come here, you are restored to full health, or full HP. What’s HP, you ask? It’s one of your stats.”");
            while (!in.equalsIgnoreCase("stat")) {
                //loop until stat is input
                System.out.println("Alex: 'You can see your player stats by typing the word “Stat” in the prompt. Go ahead and try it.“");
                in = input.nextLine();
                System.out.println("");
            }
            user.printStats();
            System.out.println("Alex: “Wow, nice stats! I wish I had stats like that, but my creators were too lazy to give me any.”");
            System.out.println("Alex: “Wait, look, your stamina bar has decreased a little bit.\n\t Oh right, I forgot. Every time you go somewhere on the Map, your stamina goes down. ");
            System.out.println("\t The only way to get your stamina back is by heading to your dorm and sleeping. Once your stamina reaches 0 you will be forced to go to the dorm for the night.");
            System.out.println("");
            System.out.println("Alex: Well, after that meal, I am ready to go. Should we head on to class?”");
            System.out.println("Type Yes or No: ");
            while (!in.equalsIgnoreCase("Yes")) {
                //must type yes
                in = input.nextLine();
            }
            System.out.println("Alex: “Great! Then open up the Map and enter the number 2.' ");
            while (!in.equalsIgnoreCase("Map")) {
                System.out.println("Type here: ");
                in = input.nextLine();
            }
            displaymap();
            while (!in.equals("2")) {
                System.out.println("Type the number here: ");
                in = input.nextLine();
            }
            //class explanation
            displayclass();
            classroom(user);
            user.sta--;
            System.out.println("----------------------------------------");
            System.out.println("");
            System.out.println("You had a fun, if stressful, first day of Autumn term. You learned everyone's name in class, and you like the professor."
                    + "\n\t On your way out of the classroom, you spot your roommate.");
            System.out.println("“Alex: 'Oh hey! I bet your stats have changed. Your stats should go up every time you go to class, right? Otherwise what’s the point!"
                    + " You should check them out.' ");
            while (!in.equalsIgnoreCase("stat")) {
                System.out.println("Type here: ");
                in = input.nextLine();
            }
            user.printStats();
            System.out.println("");
            System.out.println("Alex: 'Look, your Literacy and Wisdom have gone up by 1. Class will only be available on Weekdays, or days 1-5, 8-12, and 15-19, \n\t so make sure to go to class every day during the week to increase your stats.' ");
            System.out.println("Alex: “We still have some time in the day. Where do you want to go now: the waterfront or the library?' ");
            while (!(in.equalsIgnoreCase("waterfront") || in.equalsIgnoreCase("library"))) {
                //user must type waterfront or library
                System.out.println("Choose: ");
                in = input.nextLine();
            }
            if (in.equalsIgnoreCase("waterfront")) {
                //chooses waterfront
                System.out.println("Alex: 'Alright, open the map and then type 5' ");
                while (!in.equalsIgnoreCase("map")) {
                    System.out.println("Type here: ");
                    in = input.nextLine();
                }
                displaymap();
                while (!in.equals("5")) {
                    System.out.println("Type number here: ");
                    in = input.nextLine();
                }
                displaywaterfront();

                System.out.println("----------------------------------------");
                System.out.println("");
                System.out.println("Welcome to the Waterfront! This is where you can increase your maximum Stamina. The Waterfront is open every day for you to visit, so come by anytime!");
                System.out.println("");
                waterfront(user);
                System.out.println("You had fun with Alex out in the water for a few hours, catching plenty of sun.");
                System.out.println("");
                System.out.println("Alex: 'Well, let’s head home to the Dorm for some rest.' ");
                System.out.println("As Alex and you arrive in the courtyard of your Dorm, you see a guy walk to you and " +
                        "begin to strike up a conversation with you");
                System.out.println("Alex: This is Matt, he is our neighbor he came over to get to know us.");
                System.out.println("Matt: Hello. Nice to meet you, I am your neighbor Matt.");
                System.out.println("Alex: Matt here is like me, an NPC, that you can interact with and get to know better");
                System.out.println("");
                System.out.println("Alex: They will ask you questions or sometimes just talk to you and they are also a " +
                        "battle that you have to win");
                System.out.println("Alex: This is what happens for a social battle battle here.");

            } else if (in.equalsIgnoreCase("library")) {
                //chooses library
                System.out.println("Alex: 'Alright, open the map and then type 3' ");
                while (!in.equalsIgnoreCase("map")) {
                    System.out.println("Type here: ");
                    in = input.nextLine();
                }
                displaymap();
                while (!in.equals("3")) {
                    System.out.println("Type number here: ");
                    in = input.nextLine();
                }
                displaylibrary();
                library(user);

                System.out.println("----------------------------------------");
                System.out.println("Welcome to the Library, This is where you can do your studying and increase your stats for Literacy and Wisdom. It is random whether it will increase your Literacy \n\t or Wisdom stat, but it will always be by one point. "
                        + " The Library will be available to you to visit any day during your adventure at Eckerd.");
                System.out.println("");
                System.out.println("You and Alex work through homework together, occassionally taking a break to work on a puzzle laying out on one of the tables.");
                System.out.println("");
                System.out.println("Alex: 'Well, I'm all done! How about you? ... Great, let's head back to the Dorm already.' ");
                System.out.println("");
                //segue into social battle
                System.out.println("As Alex and you arrive in the courtyard of your Dorm, you see a guy walk to you and " +
                        "begin to strike up a conversation with you");
                System.out.println("Alex: This is Matt, he is our neighbor he came over to get to know us.");
                System.out.println("Matt: Hello. Nice to meet you, I am your neighbor Matt.");
                System.out.println("Alex: Matt here is like me, an NPC, that you can interact with and get to know better");
                System.out.println("");
                System.out.println("Alex: They will ask you questions or sometimes just talk to you and they are also a " +
                        "battle that you have to win");
                System.out.println("Alex: This is what happens for a social battle battle here.");
            }
    }


    public static void caf(Player user) {
        // Add the stats for HP to increase to full and randomly give one stat to social
        int Hp = user.HP;
        refillHP(user);

        // Generate random integers in range 0 to 10
        double rand_int1 = Math.random() * 100;

        if (rand_int1 <= 10) {
            // Updated to the change of the Global variable April 13th - Jacob Kula
            user.social++;
            System.out.println("Your Social stat has increased by 1");
        } else {
            System.out.println("Enjoy your lunch");
        }
    }

    public static void refillHP(Player user){
        //takes the current health of HP and replaces it with full HP
        // Updated to the change of the Global variable April 13th - Jacob Kula
       user.HP = user.HpMax;
    }

    public static void refill(Player user){
        //takes the current health of STA and replaces it with full STA
        user.sta = user.StaMax;
    }


    public static void classroom(Player user){
        // Adds 1 to the stats for Wisdom and Creativity
        if (day == 6 || day == 7 || day == 13 || day == 14) {
            System.out.println("It is the weekend. No class on the weekend. You can go to the Go Pavilion");
        }
        else {
        System.out.println("Enjoy class and learn a lot!");
        System.out.println("Your Wisdom and Creativity stats increased by 1");
        // Updated to the change of the Global variable
        user.Wisdom++;
        user.Literacy++;
        if(day==5 || day==9 || day==11 || day ==15 || day == 17 || day == 19) {
            AcademicBattle quizBattle = new AcademicBattle(user);
            }
        }

    }

    public static void library(Player user){
        // Randomly adds 1 to either Wisdom or Creativity

        // Generate random integers in range 0 to 10
        double rand_int1 = Math.random() * 100;

        if (rand_int1 <= 50) {
            // Updated to the change of the Global variable April 13th - Jacob Kula
            user.Wisdom++;
            System.out.println();
            System.out.println("Your Wisdom stat has increased by 1");
        } else {
            // Updated to the change of the Global variable April 13th - Jacob Kula
            user.Literacy++;
            System.out.println();
            System.out.println("Your Literacy stat has increased by 1");
        }

    }


    public static void waterfront(Player user){
        // Increases your maximum Stamina by 1
        user.currentExp++;
        int sta = user.StaMax;
        int x = sta - 2;
        int equation = (int)Math.round((Math.pow(x,2))/2 + 0.5);
        user.exp = equation;
        int current_exp = user.currentExp;

        if (current_exp == equation){
            // Updated to the change of the Global variable April 13th - Jacob Kula
            user.StaMax++;
            current_exp = 0;
            System.out.println("Your Maximum Stamina has increased");
        }
        else {
            System.out.println("You enjoyed your time at the Waterfront");
        }


    }


    public static void dorm(Player user){
        // This is the home reset for the game
        refill(user);
        //takes the current health of HP and replaces it with full HP
        // Updated to the change of the Global variable April 13th - Jacob Kula
        System.out.println("Have a good night's rest");
        day++;
        System.out.println("Day Counter: " + day);
        System.out.println("Good Morning! Don't forget, you have class quizzes on days 5, 9, 11, 15, 17 and 19.");
    }
    public static void gopavilion(Player user) throws IOException {
        // Method by Zack
        if (day == 6) {
            System.out.println("Welcome to the Go Pavilion!");
            System.out.println("The Go Pavilion is where parties are held during Autumn Term. Tonight the Glow Party is happening!");
            System.out.println("The Glow Party is held every year during Autumn Term");
            System.out.println(" ");
            System.out.println("The Glow Party is a great opportunity for you to have some fun social interactions, " +
                    "but you never know what can happen!");
            System.out.println(" ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 1 of 3
            SocialBattle partyBattle = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 2 of 3
            SocialBattle partyBattle2 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 3 of 3
            SocialBattle partyBattle3 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Glow Party has just ended so you head home for the night");
            dorm(user);
        }
        if (day == 7) {
            System.out.println("Welcome back to the Go Pavilion! Tonight ECOS will be hosting an event!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 1 of 3
            SocialBattle partyBattle = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 2 of 3
            SocialBattle partyBattle2 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 3 of 3
            SocialBattle partyBattle3 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("The party has ended so you head back to your dorm for the night");
            dorm(user);
        }
        if (day == 13) {
            System.out.println("Welcome to the Go Pavilion!");
            System.out.println("Tonight we will be hosting the Pirate Party!");
            System.out.println("The Pirate Party is another annual party that is held every year during Autumn Term");
            System.out.println("Hopefully you can have an amazing time and have some fun social interactions with other students");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 1 of 3
            SocialBattle partyBattle = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 2 of 3
            SocialBattle partyBattle2 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 3 of 3
            SocialBattle partyBattle3 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Pirate Party has just ended so you head home for the night");
            dorm(user);
        }
        if (day == 14) {
            System.out.println("Welcome to the Go Pavilion! Tonight the Activators will be hosting an event!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 1 of 3
            SocialBattle partyBattle = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 2 of 3
            SocialBattle partyBattle2 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Battle 3 of 3
            SocialBattle partyBattle3 = new SocialBattle(user);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("The party has ended so you head home for the night");
            dorm(user);
        }
    }
    // Method by Zack
    public static void map(Player user) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean newlocation = false;
        String error;
        displaymap();
        //random chance of battles implemented by Jacob
        int random = (int)(Math.random() * 100);
        int random1 = (int)(Math.random() * 100);

        System.out.println("Please enter a number (1-6) to choose a location on the map or enter 7 for the Map Key");
        String locnumber = input.nextLine();
        // Each location corresponds to a specific number and location method is called. Also displays photo of location

        if (locnumber.equals("1") ||locnumber.equals("2") || locnumber.equals("3") || locnumber.equals("4") ||
                locnumber.equals("5")|| locnumber.equals("6")){
            if (random <= 24){
                if (random1 <= 69){
                    WildBattle wild = new WildBattle(user);
                } else{
                    SocialBattle social = new SocialBattle(user);
                }
            }
        }
        while (newlocation == false) {

            if (locnumber.equals("1")) {
                System.out.println("Your location is the Caf");
                caf(user);
                newlocation = true;
                displaycaf();
            } else if (locnumber.equals("2")) {
                System.out.println("Your location is your Class");
                classroom(user);
                newlocation = true;
                displayclass();
            } else if (locnumber.equals("3")) {
                System.out.println("Your location is the Library");
                library(user);
                newlocation = true;
                displaylibrary();
            } else if (locnumber.equals("4")) {
                // Party(); or GoPavilion();
                System.out.println("Your location is a party at the Go Pavilion");
                newlocation = true;
                displaygopavilion();
                gopavilion(user);
            } else if (locnumber.equals("5")) {
                System.out.println("Your location is the Waterfront ");
                waterfront(user);
                newlocation = true;
                displaywaterfront();
            } else if (locnumber.equals("6")) {
                System.out.println("Your location is your Dorm ");
                dorm(user);
                newlocation = true;
                displaydorm();
            } else if (locnumber.equals("7"))  {
                System.out.println("Location #1 is the Cafe, Location #2 is Class, Location #3 is the Library,");
                System.out.println("Location #4 is the Go Pavilion (Party Area), Location #5 is the Waterfront");
                System.out.println("and Location #6 is your dorm");
                System.out.println(" ");
                System.out.println("Please enter a number (1-6) to choose a location on the map");
                locnumber = input.nextLine();
                newlocation = false;
            }
            // Returns an error if the number is greater than 7
            else {
                System.out.println("Error. This is not an appropriate entry. Please enter a valid number");
                locnumber = input.nextLine();
                newlocation = false;

            }

        }
        user.sta --;
        user.printStats();
    }

    // Method by Zack: Displays a photo of the caf
    public static void displaycaf() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("caf.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        w.setVisible(false);
    }

    // Method by Zack: Displays a photo of the classroom
    public static void displayclass() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("class.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);
    }

    // Method by Zack
    public static void displaylibrary() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("library.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }

    // Method by Zack: Displays a photo of the waterfront
    public static void displaywaterfront() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("waterfront.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }

    // Method by Zack: Displays a photo of the Go Pavillion
    public static void displaygopavilion() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("gopavillion.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }

    // Method by Zack: Displays photo of the dorm
    public static void displaydorm() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("dorm.jpg"));
        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }

    // Method by Zack: Displays the map for user
    public static void displaymap() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("EQ_Map.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }
    public static void displayfish() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("snook.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }
    public static void displaydolphin() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("dolphin.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }
    public static void displaysquirrel() throws IOException {
        JFrame w = new JFrame();
        w.setLocation(100, 100);
        w.setSize(600, 400);
        w.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        BufferedImage img = ImageIO.read(Main.class.getClassLoader().getResourceAsStream("squirrel.jpg"));

        JPanel p = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, this.getBounds().width, this.getBounds().height, null);
            }
        };
        w.add(p);
        w.setVisible(true);

    }

    public static void help_me() {
        //by Jacob
        Scanner input = new Scanner(System.in);
        String in = "";
        System.out.println("You have typed in Help, this command is used so that if you don't understand something this " +
                "can help");
        System.out.println("What can I help you with?");
        while (!(in.equalsIgnoreCase("Battle") || in.equalsIgnoreCase("Stats") ||
                in.equalsIgnoreCase("General"))) {
            System.out.println("For Battle Commands, type 'Battle'. For Stats help, type 'Stats'. For General Knowledge, " +
                    "type 'General'");
            System.out.println("Type Here: ");
            in = input.nextLine();
        }
        if (in.equalsIgnoreCase("Battle")){
            // Written by Jacob Kula
            // This is here for the Battle help questions that people may have during the game
            System.out.println("You Have Chosen 'Battle Commands' Help.");
            System.out.println("Great here is some information on the Battle Commands and how to do your best in the " +
                    "battles");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("There are three types of battles in this game. There are Social battles, " +
                    "Wild Battles and Academic Battles");
            System.out.println("---------------------------------------------------------------- Social Battle Help ----" +
                    "-----------------------------------------------------------------------");
            System.out.println("Social Battles can be run into randomly when going between locations and at the " +
                    "Party location on the Map.");
            System.out.println("---------------------------------------------------------------- Social Battle Help ----" +
                    "-----------------------------------------------------------------------");
            System.out.println("Social battles start with the NPC, or Non Player Character, attacking you for 1 HP and " +
                    "then they will ask you a question or say a statement that you ");
            System.out.println("must respond to. You are given 4 choices to choose from: Joke, Tease, Assist and Run");
            System.out.println("---------------------------------------------------------------- Social Battle Help ----" +
                    "-----------------------------------------------------------------------");
            System.out.println("Based upon the hint that is given to you at the start of the battle you have to choose " +
                    "the correct response to do damage to the enemy player.");
            System.out.println("Joke will say a joke to the NPC, Tease will tease the NPC, Assist will 'help' the NPC, " +
                    "and Run will end the battle by running away from the NPC.");
            System.out.println("---------------------------------------------------------------- Social Battle Help ----" +
                    "-----------------------------------------------------------------------");
            System.out.println("You must choose between these choices and find out which choice does damage to the NPC. " +
                    "The correct response is random each time but once you find the correct");
            System.out.println(" answer it will always be that answer. The Battle will end once the NPC or the Players " +
                    "health reaches 0");
            System.out.println("---------------------------------------------------------------- Social Battle Help ----" +
                    "-----------------------------------------------------------------------");
            System.out.println("After you have won the battle you will receive a Heart Piece which is used to increase " +
                    "your maximum Health");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wild Battles are also randomly run into when going to locations on the map, similar to " +
                    "the Social Battle. Wild Battles will have you run into an animal, a fish,");
            System.out.println(" a squirrel, and there is a secret animal as well");
            System.out.println("---------------------------------------------------------------- Wild Battle Help ------" +
                    "-----------------------------------------------------------------------");
            System.out.println("At the start of the battle you winn lose 1 Hp because they will attack before you have a " +
                    "turn, after that you are given 4 choices to choose from: Feed, Fight,");
            System.out.println(" Picture, and Run. Feed with throw out food or bait for the animal. Fight will try to " +
                    "catch the animal or stare challengingly at the animal. Picture will");
            System.out.println(" show a picture of the animal. Run will end the battle with you running away. ");
            System.out.println("---------------------------------------------------------------- Wild Battle Help ------" +
                    "-----------------------------------------------------------------------");
            System.out.println("During the battles with fish you should try to to Feed first to bait them in before " +
                    "you try to catch them. The Fish will try to escape you reeling it in but");
            System.out.println(" Never Give Up");
            System.out.println("---------------------------------------------------------------- Wild Battle Help ------" +
                    "-----------------------------------------------------------------------");
            System.out.println("During the Battles with squirrels, It is a risk vs. reward battle. Feed gives you a " +
                    "lower chance of winning but also a low chance at losing. However, Fight gives");
            System.out.println(" you a higher chance at winning but a higher risk of losing.");
            System.out.println("---------------------------------------------------------------- Wild Battle Help ------" +
                    "-----------------------------------------------------------------------");
            System.out.println("The final secret animal can only be taken a picture of, if you fight you lose, if you " +
                    "feed nothing happens. All you can do is hope to get a majestic picture to");
            System.out.println(" take home with you.");
            System.out.println("---------------------------------------------------------------- Wild Battle Help ------" +
                    "-----------------------------------------------------------------------");
            System.out.println("After you have won the battles, you will receive a heart piece for your troubles that " +
                    "can be use to increase your maximum Health.");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Final types of battles are the Academic Battles, there are quizzes and tests. You " +
                    "have 6 quizzes and 1 Final exam on the last day of the game.");
            System.out.println(" The quizzes will take place on Day 3, 5, 9, 11, 15, 17. The Final exam will be on Day " +
                    "19.");
            System.out.println("---------------------------------------------------------------- Academic Battle Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The way that these battles will work is the battles will have questions that they ask " +
                    "you. You must choose the best response to these battles, you will have 4");
            System.out.println(" choices: Give up, Guess, Remember, and Common Sense. Give up will make you answer the " +
                    "question wrong. Guess is a 50/50 chance to get the right answer.");
            System.out.println(" Remember is based on your Literacy stat. Common Sense in based on your Wisdom stat.");
            System.out.println("---------------------------------------------------------------- Academic Battle Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("You should always use the answer with the highest stat to have the best chance of " +
                    "answering the question correctly. Quizzes will have 5 questions in which");
            System.out.println(" you need 3 to pass. The Final exam will have 10 questions in which you need 7 to pass.");
            System.out.println("---------------------------------------------------------------- Academic Battle Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("If you win the quiz battles you win obtain a Heart scale and if you win the Final exam " +
                    "battle, you win the game.");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
        } else if (in.equalsIgnoreCase("Stats")){
            // Written by Jacob Kula
            // This is here for the Stat help questions that people may have during the game
            System.out.println("You have Chosen 'Stats' help.");
            System.out.println("There a bunch stats that are used in this game you should know. They are Literacy, " +
                    "Wisdom, Stamina, HP, or Hit Points, Social, Maximum HP, and Maximum Stamina.");
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("These stats are very important to know and understand what they do for you and how to " +
                    "increase them. The first stat is Literacy.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------- Literacy Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("Literacy is one of the main stats that you use for all of the battles and one of the " +
                    "easiest to obtain. Literacy is used to help you in your Academic battles");
            System.out.println(" that you have through out the game.");
            System.out.println("----------------------------------------------------------------------- Literacy Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Best way to obtain the Literacy stat is by going to Class and going to the Library. " +
                    "Both of these locations give you an increase of 1 in Literacy. The Class");
            System.out.println(" will always give you 1, however the Library is a 50/50 chance");
            System.out.println("----------------------------------------------------------------------- Literacy Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------- Wisdom Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Next stat is Wisdom. The Wisdom Stat is used in tandem with the Literacy stat, it is" +
                    " also used for the Academic battles that you will have. ");
            System.out.println("------------------------------------------------------------------------- Wisdom Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println(" The ways to increase your Wisdom stat is by going to Class and going to the Library. " +
                    "Both of these locations give you an increase of 1 in Literacy. The Class");
            System.out.println(" will always give you 1, however the Library is a 50/50 chance");
            System.out.println("------------------------------------------------------------------------- Wisdom Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------ Stamina Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Next stat is Stamina. This stat is broken down into two types: Current Stamina and " +
                    "Maximum Stamina. The Current Stamina is used whenever the Player goes to");
            System.out.println(" different locations.");
            System.out.println("------------------------------------------------------------------------ Stamina Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println(" This Current Stamina is only refilled by going to the Dorm. The Player will be forced " +
                    "to go to the Dorm when their Current Stamina is 0");
            System.out.println("------------------------------------------------------------------------ Stamina Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------- HP Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Next stat is HP. This stat is broken down into two types: Current HP and Maximum HP. " +
                    "The Current HP is used in the 3 types of battles: Social, Wild, and ");
            System.out.println(" Academic. This stat can be refilled by going to the Caf and eating there.");
            System.out.println("----------------------------------------------------------------------------- HP Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println(" If the Player's Current HP is 0 they will be forced to go to the caf, and if the " +
                    "Player's Current HP reaches 0 during the Final Exam it is a GAME OVER.");
            System.out.println("----------------------------------------------------------------------------- HP Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------- Social Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Next stat is Social. The Social stat is used in Social battles as your attack power." +
                    " Depending on the Player's Social stat is how much damage they will do ");
            System.out.println(" to the enemy in a social battle.");
            System.out.println("------------------------------------------------------------------------- Social Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Social stat can be increased by going to Party and winning the social battles that are " +
                    "there. The Player can also increase their social stat by being lucky ");
            System.out.println("and having it increase at the Caf.");
            System.out.println("------------------------------------------------------------------------- Social Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------- Maximum HP Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Next stat is Maximum HP. The Maximum HP is a different stat than the Current HP, " +
                    "because the Maximum HP does not decrease during battles. However, it");
            System.out.println("can be increased through winning battles.");
            System.out.println("--------------------------------------------------------------------- Maximum HP Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("After the Player wins a battle, they are rewarded with a Heart Piece that can be " +
                    "used to increase their Maximum HP. Once the Player obtains 3 Heart ");
            System.out.println("Pieces their Maximum HP is increased by 1.");
            System.out.println("--------------------------------------------------------------------- Maximum HP Help --" +
                    "-----------------------------------------------------------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------- Maximum Stamina Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Final stat is Maximum Stamina. Like Maximum HP, Maximum Stamina is a different stat " +
                    "than Current Stamina, because the Maximum Stamina doesn't decrease ");
            System.out.println("when the player moves to different locations.");
            System.out.println("---------------------------------------------------------------- Maximum Stamina Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("However, it can be increased through visited the Waterfront. There is an equation that " +
                    "calculates when you should increase your maximum stamina. Don't ");
            System.out.println("worry trust my math. :)");
            System.out.println("---------------------------------------------------------------- Maximum Stamina Help --" +
                    "-----------------------------------------------------------------------");

            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");

        } else if (in.equalsIgnoreCase("General")){
            // Written by Jacob Kula
            // This is here for the General help questions that people may have during the game
            System.out.println("You have Chosen 'General' Commands Help");

            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("If the Player has 0 Stamina, they will be forced to go to the Dorm.");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The Only commands that the Player can use is Stats, Map, and Help");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("After typing Map, the player must select a number that is less than 7 to go anywhere on " +
                    "the map");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("You can run into battles by going to different locations, only the Devs know how often " +
                    "it may be.");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");
            System.out.println("The images that come up from the map can be closed for your convenience.");
            System.out.println("------------------------------------------------------------------------ General Help --" +
                    "-----------------------------------------------------------------------");

            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------");

        }

    }
}
