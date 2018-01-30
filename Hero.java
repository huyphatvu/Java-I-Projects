/*Create a class object that store a Hero (both monster and hero)
//Health
//Attack Power
//Magic Power
*/
import java.util.*;

public class Hero extends GameCharacter{
    private int magicPow;
    private int points;//used as money to level him up
    private static final int UP_HP=20; // increase hero HP whenever he levels up
    private static final int UP_AP=2; // increase hero AP whenever he levels up

    //using when upgrade a hero
    private static final int HP = 10;
    private static final int AP = 1;
    private static final int MP = 3;
    //ends of ENUM
    private static final int CHARGING_MANA=  1;
    private static int round=0;
    private Scanner input = new Scanner(System.in);

    public Hero(String name, int health, int attackPow, int magicPow, int lv, int xp, int points){
        super(name, health, attackPow, lv, xp);
        setPoints(points);
        setMP(magicPow);
        }


    public Hero(){
    	super();
        this.points=20;
    }

    //Method
    public void setPoints(int points){
    	if(points<0 || points>1000){
    		throw new IllegalArgumentException("Points must be between 0 and 1000");
    	}
    	this.points = points;
    }
    public void setMP(int MP){
    	if(MP<0 || MP>1000){
    		throw new IllegalArgumentException("Magic Power must be between 0 and 1000");
    	}
    	this.magicPow = MP;
    }
    public int getMP(){
    	return magicPow;
    }

    public int getPoints(){
        return this.points;
    }
    public void decreaseMP(int magicPow){
        this.magicPow-=magicPow;
    }

    public void increaseMP(int magicPow){
	    this.magicPow += magicPow;
	}

	public void increasePoints(int points){
	    //increase the points by the xp gained
	    //increase hero's points by the monster's XP

	    this.points +=points;
	}


	public void combatPrompt(){
    	/*Combat menu Prompt*/
        //Print Option 1: Sword Attack
        //Printoptions 2: Cast Spell
        //Print Option 3: Charge Mana
        //Print Option 4: Healing increase 10% of your health
        //Print Option 5: Run Away
        //Prompt Player for action
        System.out.println("What action to perform?");
        System.out.println(" 1) Sword Attack");
        System.out.println(" 2) Cast Spell");
        System.out.println(" 3) Charge Mana");
        System.out.println(" 4) Heal(random from 10-19)");
        System.out.println(" 5) Run Away");
}


    public Hero copyHero(Hero hero){
        //Copy the value of the Hero into another hero
    	Hero newHero = new Hero(hero.getName(),
    							hero.getHP(),
    							hero.getAP(),
    							hero.getMP(),
    							hero.getLv(),
    							hero.getXP(),
    							hero.getPoints());
    	return newHero;
    }

    public boolean checkLV(){
        int levelPoint = (4+getLv()*2);
        //increase lv after xp get 6, 8, 10, 12, so on

        if(getXP()>=levelPoint){
            increaseLv();
            super.increaseHP(UP_HP);
            super.increaseAP(UP_AP);

            decreaseXP(levelPoint); //reset xp
            System.out.printf("\nHero level up with +%d HP, +%d AP\n\n", UP_HP, UP_AP);
            System.out.println(this.toString());;
            return true;
        }
        return false;

    }

    public String toString(){
    	String hero =
    	        String.format("%s(lv:%d, xp:%d) HP: %d",getName(),getLv(), getXP(), getHP())
    		    +String.format(", AP: %d",getAP())
    		    +String.format(", MP: %d",getMP())
    		    +String.format(", money: %d coins",points);
    	return hero;
    }


    public void upgradeHero(){
    //upgrade the Hero status by the Hero's points
    //ask the player to choose the type of hero


    while(points >0 ){
	    System.out.print(this.toString()+"\n");

    	//display the stat choice
    	System.out.println("1) +10 Health");
    	System.out.println("2) +1 Attack");
    	System.out.println("3) +3 Magic");
	    System.out.printf("You have %d coins to spend: ", points);
        String choice = input.next();
        System.out.println();
	    //execute the order
	    switch(choice){
		        case "1":
		        {
		            super.increaseHP(HP); //health
		            break;
		        }
		        case "2":
		        {
		            super.increaseAP(AP); //attack power
		            break;
		        }
		        case "3":
		        {
		            this.increaseMP(MP); //magic power
		            break;
		        }
		        default:
		        {
		            System.out.println("Please enter a valid option!\n");
		            points++;
		            break;
		        }

		    }
	    points--;
    	}
    }//end UpgradeHero

    public Hero heroChoice(){

    	while(true){
    		System.out.println("Choose your type of Hero\n"
	    			+ "1) Crusader (HP: 70, AP: 30, MP: 0)\n"
	    			+ "2) Barbarian (HP: 100, AP: 25, MP: 3)\n"
	    			+ "3) Wizard (HP: 90, AP: 8, MP: 20)\n"
	    			+ "4) Monk (HP: 200, AP: 10, MP: 9)\n"
	    			+ "5) Witch (HP: 150, AP: 5, MP: 26)\n\n"
	    			+ "Your Hero is: ");
    		String choice = input.next();

	    	if(choice.equals("1")){
	    		System.out.println("You choice is Crusader\n");

	    		return new Crusader();
	    	}
	    	else if(choice.equals("2")){
	    		System.out.println("You choice is Barbarian\n");
	    		return new Barbarian();
	    	}
	    	else if(choice.equals("3")){
	    		System.out.println("You choice is Wizard\n");
	    		return new Wizard();
	    	}
	    	else if(choice.equals("4")){
	    		System.out.println("You choice is Monk\n");
	    		return new Monk();
	    	}
	    	else if(choice.equals("5")){
	    		System.out.println("You choice is Witch\n");
	    		return new Witch();
	    	}
	    	else{
	    		System.out.println("Wrong input\nPlease try to re-enter\n");
	    	}
    	}
    }// ends heroChoice

    public int startCombat(Monster monster){
    	while(true){
	    	System.out.println(monster);
	    	System.out.println(toString());
	    	System.out.println();

            combatPrompt();

   	       //Declare variable for user input (as number) and acquire value from Scanner object
	    	String option = input.next();
            if(option.equals("1")){
            //If player choose option 1,(check with equality operator)
                //print attack text
                //Calculate damage & update monster health using subtraction
                //Calculation: new monster health is old monster health minus hero attack power
                System.out.printf("\n%s strike the %s with your sword for %d damage\n",getName(), monster.getName(), getAP());
                monster.decreaseHP(getAP());
            }
            else if(option.equals("2")){
            //If player choose option 2,(check with equality operator)

                if(getMP() >= 3){
                    //Reduce players mana points by the spell cast using subtraction
                    //Calculation:new magic power is old magic power minus 3
                    decreaseMP(3);
                    System.out.printf("\n%s cast the weaken spell on the %s\n", getName(), monster.getName());
                    monster.halfHP();
                }

                else{
                    System.out.printf("\n%s need %d more mana to cast the spell\n", getName(), (3-getMP()));
                    System.out.print("Reset the round\n\n");
                    continue;
                }

            }
            else if(option.equals("3")){
            //Else if the player chose option 3,(check with equality operator)
                //print charging message:
                //"You focus and charge your magic power."
                //Increment magic points and update players magic using addition
                //Calculation: new hero magic is old hero magic plus one
                System.out.printf("\n%s focus and charge your magic power by %d mana\n\n", getName(), CHARGING_MANA);
                increaseMP(CHARGING_MANA);

            }
            else if(option.equals("4")){
            //Print message said that you want to incease your health
            //Increase the Player's health by healing power from 10-19

            Random randomGen = new Random();
            int heal = randomGen.nextInt(10)+10;
                System.out.printf("\n%s increase your health with %d points\n\n", getName(), heal);
                increaseHP(heal);

            }
            else if(option.equals("5")){
                //Else if the player chose option 3,(check with equality operator)
                //Stop Combat Loop By setting control variable to false
                //print retreat message:
                //"You run away!"
                System.out.printf("\n%s run away from the Monster!\n\n", getName());
                return Status.RUN.getStatus();//end the combat
            }
            else{
                //Else the player chose incorrectly
                //prints error message:
                //"I Don't understand that Command."
                System.out.println("\nWrong input\nReset the round!");
                continue;
            }
            round++; //upgrade the round


            /*Evaluate the combat*/
            if(monster.getHP() <= 0){
                //If Monsters health is 0 or below
                //Stop combat loop by setting control variable to false
                //Print Victory message:You defeated the <monster name>!
                System.out.printf("\nCONGRATULATION!!! You defeated the %s after %d rounds\n\n", monster.getName(), round);
                System.out.printf("%s had gained %d xp from the %s\n\n", getName(), monster.getXP(), monster.getName());
                return Status.WIN.getStatus();

            }
            //Monster attack the player after each turn
            decreaseHP(monster.getAP());
            System.out.printf("The monster attack %s back with %d damage\n\n", getName(), monster.getAP());
            if(getHP() <=0 ){
                //If the player dies you must
                //End the loop by setting control variable to false
                System.out.printf("\nGAME OVER!!! %s was defeated by the %s\n\n", getName(), monster.getName());
                return Status.LOST.getStatus();
            }

        }
	}
}

