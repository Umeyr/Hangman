import java.util.Scanner;

/**
 * PlayGame In the main method of a word guessing game we do:
 * 		-print the game information  
 * 		-create an instance of the Hangman class meaning we choose a new secret word and try to guess it
 * 		-print game status each time which is:
 * 			-the known word combined of found letters and stars for unknown letters
 * 			-the number of incorrect tries (maximum allowed incorrect tries is 6)
 * 			-the alphabet which the letter is chosen from
 * 			-the letters chosen before (to help player not to choose the same letter again)
 * 		-ask player to guess a letter, check if the letter is in the secret word.
 * 		-if the letter is invalid (meaning it is not in the given alphabet) we ask player to choose a letter again
 * 		-if the letter is in the word, we reveal that letter in the word 
 * 		-if the letter is used before, we inform the player and ask him/her to choose again
 * 		-if the letter is not in the word, we remove one of the tries that player has
 * 		-player loses if he/she runs out of all (6) of his chances
 * 		-player wins if he/she finds the secret word in or less than 6 tries
 * 		
 * 
 *
 * @author YUNUS UMEYR KILIÇ
 * @version 1.00 2015/2/17
 */
 
public class PlayGame 
{
    public static void main( String[] args) 
    {
    	// VARIABLES
		Hangman game1;		//instance of the Hangman class
		char letter;		//letter which we ask from the user
		String answer;		
		int result;

		// PROGRAM CODE
		Scanner scan = new Scanner( System.in);
		
		//The welcome message  
    	System.out.println( "Welcome to the greatest game ever!!! \nThe game's main goal is to guess a secret word by choosing a letter from the alphabet each time.\nYou can guess a letter for six times. You can not choose the same letter again.\nIf you run out of chances, then you lose the game.\nIf you succesfully find the word in or less than six tries you win the game.\nThis easy! Lets roll then!");
    	
    	//the do while loop where we create an instance of Hangman class and play the game while player wants to continue
		do{
			game1 = new Hangman();		//we create the instance of Hangman class with default constructor
			
			do{
				System.out.println();
				System.out.println("This is the secret word:\t\t" + game1.getKnownSoFar() );	//prints the secret word but with stars
				System.out.println("Number of incorrect tries: " + game1.getNumOfIncorrectTries() + "\tRemember you have " + (6 - game1.getNumOfIncorrectTries() ) + " more!");		//prints the number of incorrect tries made and the remaining ones
				System.out.println("Guess a letter from the alphabet below: \n" + game1.getAllLetters() );		//prints the alphabet which the letter is being chosen
				System.out.println("These are the letters that you used before: \n" + game1.getUsedLetters() );		//prints the letters used before
				
				//Getting the letter from the player
				System.out.print("\nEnter a letter: ");
				String instance= scan.nextLine().toLowerCase();		//we use toLowerCase() (assuming that alphabet is in lower case letters) to prevent potential problems in the use of letter in tryThis() method  
				letter=instance.charAt(0);
				
				System.out.println();
				
				//we then use the letter in tryThis method
				result = game1.tryThis(letter);
				
				//if the letter is invalid (not in the given alphabet) we inform the player and ask him/her to choose again
				if(result == -1){
					System.out.println("Your input is not valid. Try again! ");
				}
				//if the letter is taken before we ask player to choose again
				else if(result == -2){
					System.out.println("Your letter is already used! Try again!");
				}
				//if function returns -3 this means game is over. So we inform the player about this.
				else if(result == -3){
					System.out.println("Game over buddy!");
				}
				//if function returns 0 this means chosen letter is valid but not in the word. We inform the player and deduce one of his/her chances
				else if(result == 0){
					System.out.println("Nice try! But not this time!");
				}
						
			}while(!game1.isGameOver() && result != -3);	//we start again if the game is not over
			
			//If hasLost() method returns false, this means the player has won the game. 
			if(!game1.hasLost()){
				System.out.println("You won! Nice Game!\nThe secret word is " + game1.getSecretWord());		//We congratulate the player and show the secret word if getSecretWord() method is available which returns the secret word from Hangman class
			}
			else{
				System.out.println("You lost the game! Nice try!\nThe secret word is " + game1.getSecretWord());		//Again here we assume getSecretWord() method is available
			}
			
			//We ask the player if he/she wants to continue again.
			System.out.print("Do you want to play again? (Y/N)");
			answer = scan.nextLine().toLowerCase();		//we use toLowerCase() method to prevent the problem of comparing 'Y' with 'y'
			
		}while(answer.equals("y"));
		
		System.out.println("End of the game. Hope you enjoyed it. Come again!");
		
	}
	
} // end of class HangmanGame