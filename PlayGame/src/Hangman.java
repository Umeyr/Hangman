public class Hangman
{
    //Properties:
   
    //It determines the maximum incorrect tries
    private int maxAllowedIncorrectTries;
    
    private StringBuffer secretWord;
    
    //all letters in english alphabet
    private StringBuffer allLetters;
    
    //used letters so far
    private StringBuffer usedLetters;
    
    // secretWord but with chars not yet found blanked out
    private StringBuffer knownSoFar;   
    
    private int numberOfIncorrectTries;
                                              
                


    //Constructor:
    
    public Hangman ()
    {
       	allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
    	maxAllowedIncorrectTries = 6;
    	numberOfIncorrectTries = 0;
    	usedLetters = new StringBuffer("");
   		secretWord =new StringBuffer( chooseSecretWord());
		knownSoFar = new StringBuffer(createKnownSoFar());
    }
    
   
   	//method that determines the length of the secret word and creates a string with stars with the same length
	public String createKnownSoFar()
	{
		String knownSoFar1 = "";

		for(int i = 0; i<secretWord.length(); i++)
		{
			knownSoFar1 += "*";
		}
		return knownSoFar1;
	}
   
   
   
   
   
   
   
    //Accessors:
    
    public StringBuffer getSecretWord()
    {
    	return secretWord;
    }
    
    public StringBuffer getAllLetters()
    {
        return allLetters;
    }
    
    public StringBuffer getUsedLetters()
    {
        return usedLetters;
    }
    
    public int getNumOfIncorrectTries ()
    {
        return numberOfIncorrectTries;
    }
    
    public int getMaxAllowedIncorrectTries()
    {
        return maxAllowedIncorrectTries;
    }
    
    public StringBuffer getKnownSoFar ()
    {
        return knownSoFar;
    }
    
    //Mutators:
    // User will not change anything therefore no mutators are required.
    
    //Additional Methods:
    
   
    //this method chooses the secret word randomly
   public  String chooseSecretWord() 
  {
    /**** Variables ****/
    int randomNo; //A Random number to choose the word from the string array.  
    String[] list= {"hesitant","yak","extra-small","juvenile","abashed","brake","sigh","appliance","successful","imaginary","yellow","quick","shock","day","brother","taste","scrawny","dance","request","stretch","adaptable","lean","science","hang","loving","airplane","flock","balance"};
    randomNo = (int) (Math.random() * list.length);
    String result = list[randomNo];
    return result;
  }
  
  
  
    
    // Checks if game is over.
    public boolean isGameOver()
    {
        if ( numberOfIncorrectTries == maxAllowedIncorrectTries )
        {
            return true;
        }
        if ( knownSoFar.toString().equals(secretWord.toString()))
        {
            return true;
        }
        return false;
    }
    
    // If game is really over checks for win or lose, else returns false
    public boolean hasLost()
    {
        if ( isGameOver() )
        {
            return numberOfIncorrectTries >= maxAllowedIncorrectTries;
        }
        else
        {
            return false;
        }
    }  
    	
    	
    	
    	
    //this method try to add letter given by user into  secretword if secretword include the letter.	
    public int tryThis(char letter)
	{
		 int times = 0;
		  
		 //If the game is over it will return -3
		 if (isGameOver() == true)
		   return  -3;
		 else
		 {
		   //If the entered letter exist in English alphabet method continues else returns -1
		   for (int i = 0 ; i < allLetters.length(); i++)
		   {
		     if ( allLetters.charAt(i) == letter)
		     {
		       //If the letter had already used it will return -2 else it fill add that letter to usedletters
		       for (int A = 0; A < usedLetters.length(); A++)
		       {
		         if ( letter == usedLetters.charAt(A))
		         {
		           return -2; 
		         }
		       }
		       usedLetters.append(letter); 
		       
		       // If the letter exist in secretWord it will return how many of them is the letter. Else it will increase the incorrect tries.
		       for ( int B = 0; B < secretWord.length(); B++)
		       {
		         //Updates knownSoFar to open the letter in it.
		         if ( secretWord.charAt(B) == letter)
		         {
		           times++ ;
		           knownSoFar.setCharAt( B , letter);
		         }
		       }
		       if ( times == 0)
		       {
		         numberOfIncorrectTries++;  
		       } 
		       return times;
		     }
		   }
		   return -1;
		 }
	}
} // end of class Hangman
