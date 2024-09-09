import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("My Hangman!");
        // Set number of "lives"
        int lives= 3;  //should be 13

        // Choose word to be guessed
        String myWord = "foo";

        //create underscores for each letter in the word and seperate word into letters
        String[] underscoreList = new String[myWord.length()];
        String[] corrWord = myWord.split("(?!^)");
        printMyList(corrWord);

        for( int i= 0; i< myWord.length(); i++){
            underscoreList[i]= "_";
        }

        printMyList(underscoreList);  // Prints the currently guessed word
        boolean noMoreUnderscore= false;

        while(lives > 0 && !noMoreUnderscore){
            noMoreUnderscore = true;
            int life = gameLoop(corrWord, underscoreList);
            lives -= life;
            //checks if there are any "_" left
            for( int i= 0; i<corrWord.length ; i++ ){
                if( underscoreList[i].equals("_") ){ //i C#: guess == corrWord[i]
                    noMoreUnderscore = false;
                }
            }       
        }

        System.out.println("You Lost");
        
    }

    public static int gameLoop(String[] corrWord, String[] underscoreList){
        // Scanner for all keyboard input
        Scanner myScan = new Scanner(System.in);

        //get input from user
        System.out.print("Guess a letter: ");
        String guess= myScan.nextLine();

        // System.out.println(guess);

        boolean letterFound = false; //used to check if letter has been found

        //Check if letter is in the list of letters (my word (an array))
        for( int i= 0; i<corrWord.length ; i++ ){
            if( guess.equals(corrWord[i]) ){ //i C#: guess == corrWord[i]
                letterFound= true;
                underscoreList[i] = guess;
            }
        }

        //Prints if letter has been found
        if (letterFound) {
            System.out.println("found the letter");
            printMyList(underscoreList);
            return 0; // no life has been lost
            
        } else {
            System.out.println("Wrong guess");
            return 1; //one life has been lost
        }
    }

    // Prints the contetnts of a array
    public static void printMyList(String[] myList){
        for( String str : myList){
            System.out.print(str + " ");
        }
        System.out.println();
    }


}
