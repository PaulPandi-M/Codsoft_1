import java.util.Random;
import java.util.Scanner;

class GameMenu
{
    private char mode;
    GameMenu()
    {
        Scanner inScanner=new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("|           Guess the Number         |");
        System.out.println("|           ~~~~~~~~~~~~~~~~         |");
        System.out.println("| Enter \"N\" for Normal mode          |");
        System.out.println("| Enter \"A\" for Adventure mode       |");
        System.out.println("| Enter \"Q\" for Quit                 |");
        System.out.println("--------------------------------------");
        System.out.print("Enter the option:");
        mode=inScanner.nextLine().toLowerCase().charAt(0);
        System.out.println("");
        switch (mode) {
            case 'n':
                NormalMode normalMode=new NormalMode();
                normalMode.game();
                break;
            case 'a':
                AdventureMode adventureMode=new AdventureMode();
                adventureMode.game();
                break;
            case 'q':
                System.out.println("game closed");
                inScanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("invalid option");
                break;
        }
    }
}

class NormalMode
{
    private Random random;
    private final int randomNumber;
    private int guessedNumber;
    private int guess;
    private char playAgain;
    Scanner inputScanner;
    NormalMode()
    {
        random = new Random();
        randomNumber = random.nextInt(100) + 1;
        // System.out.println(randomNumber);
        guess = 7;
        inputScanner=new Scanner(System.in);
    }
    
    public void game()
    {   
        System.out.println("Guess the number between 1-100 in "+guess+" guesses\n");
        while(true)
        {
            if (guess == 0) {
                System.out.println("*************************");
                System.out.println("*                       *");
                System.out.println("*       GAME OVER       *");
                System.out.println("*   out of guesses :(   *");
                System.out.printf("*     Number is %-8d*\n",randomNumber);
                System.out.println("*                       *");
                System.out.println("*************************");
                // inputScanner.close();
                System.out.print("Do you want to play again(y/n):");
                    inputScanner.nextLine();
                    playAgain=inputScanner.nextLine().toLowerCase().charAt(0);
                    switch(playAgain)
                    {
                        case 'y':
                            GameMenu gMenu=new GameMenu();
                            break;
                        case 'n':
                            System.out.println("game closed");
                            inputScanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }
                break;
            } else {
                System.out.print("Enter your guess:");
                guessedNumber = inputScanner.nextInt();
                guess--;
                if (guessedNumber == randomNumber) {
                    System.out.println("\n****************************************");
                    System.out.println("*                                      *");
                    System.out.println("*               YOU WON                *");
                    System.out.println("*   you got the number in " + (6 - guess) + " guesses    *");
                    System.out.println("*                                      *");
                    System.out.println("****************************************");
                    // inputScanner.close();
                    System.out.print("Do you want to play again(y/n):");
                    inputScanner.nextLine();
                    playAgain=inputScanner.nextLine().toLowerCase().charAt(0);
                    switch(playAgain)
                    {
                        case 'y':
                            GameMenu gMenu=new GameMenu();
                            break;
                        case 'n':
                            System.out.println("game closed");
                            inputScanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("invalid option");
                            break;
                    }
                    break;
                } else if (guessedNumber > randomNumber) {
                    System.out.println("\nYou guess is TOO HIGH");
                    System.out.println("Remaining guesses:" + guess);
                    System.out.println("---------------------------");
                } else if (guessedNumber < randomNumber) {
                    System.out.println("\nYou guess is TOO LOW");
                    System.out.println("Remaining guesses:" + guess);
                    System.out.println("---------------------------");
                }
            }
        }
    }
}

class AdventureMode
{
    private Random random;
    private long range;
    private long randomNumber;
    private long guessedNumber;
    private long guess;
    private long level;
    private char playAgain;
    Scanner inputScanner;
    AdventureMode()
    {
        guess=4;
        range=25;
        level=1;
        inputScanner=new Scanner(System.in);
    }
    public void game()
    {

        outerloop:
        while (true)
        {
            long totalGuess=guess;
            System.out.println("\n_________________LEVEL "+level+"_________________");
            System.out.println("guess the number between 1-"+range+" in "+guess+" guesses\n");
            random=new Random();
            randomNumber=random.nextLong(range)+1;
            // System.out.println(randomNumber);

            innerloop:
            while(true)
            {
                if (guess == 0) 
                {
                    System.out.println("******************************");
                    System.out.println("*                            *");
                    System.out.println("*          GAME OVER         *");
                    System.out.println("*       out of guesses :(    *");
                    System.out.printf("*         Number is %-9d*\n",randomNumber);
                    System.out.println("* you've completed "+((level-1)==0?0:(level-1))+" levels  *");
                    System.out.println("*                            *");
                    System.out.println("******************************");
                    // inputScanner.close();
                    System.out.print("Do you want to play again(y/n):");
                        inputScanner.nextLine();
                        playAgain=inputScanner.nextLine().toLowerCase().charAt(0);
                        switch(playAgain)
                        {
                            case 'y':
                                GameMenu gMenu=new GameMenu();
                                break;
                            case 'n':
                                System.out.println("game closed");
                                inputScanner.close();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("invalid option");
                                break;
                        }
                    break outerloop;
                } 
                else 
                {
                    System.out.print("Enter your guess:");
                    guessedNumber = inputScanner.nextInt();
                    guess--;
                    if (guessedNumber == randomNumber) 
                    {
                        System.out.println("\n****************************************");
                        System.out.println("*                                      *");
                        System.out.println("*           level "+level+" completed          *");
                        System.out.println("*   you got the number in " + (totalGuess - guess) + " guesses    *");
                        System.out.println("*                                      *");
                        System.out.println("****************************************");
                        // inputScanner.close();
                        break innerloop;
                    } 
                    else if (guessedNumber > randomNumber) 
                    {
                        System.out.println("\nYou guess is TOO HIGH");
                        System.out.println("Remaining guesses:" + guess);
                        System.out.println("---------------------------");
                    } 
                    else if (guessedNumber < randomNumber) 
                    {
                        System.out.println("\nYou guess is TOO LOW");
                        System.out.println("Remaining guesses:" + guess);
                        System.out.println("---------------------------");
                    }
                }
            }
            level++;
            guess=totalGuess+2;
            range+=25;    
        }
    }
}

public class NumberGuess {
    public static void main(String[] args) {
        GameMenu gameMenu=new GameMenu();
    }
}