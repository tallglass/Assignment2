/**
 * This class is a central repository for information about a WordLL game: It stores a mystery word
 * and all word guesses tried so far. It keeps a history of the past word guesses in a linked
 * structure. Its name is a bit of play on words: Word-Linked-List.
 * @author Oren Joffe // CS1027B // 251135702
 *
 */
public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	/**
	 * Constructor that initializes an empty history linked list.
	 * @param mystery mysteryWord
	 */
	public WordLL(Word mystery) {
		history = null; 	// empty LL
		mysteryWord = mystery;
	}
	
	/**
	 * Takes a Word as an argument to test against this games' mystery Word. Updates the label of all the 
	 * letters contained within Word guess and adds Word
	 * guess to the front of history. Returns true if the word represented by guess is identical to the 
	 * word represented by mysteryWord.
	 * @param guess becomes a new node
	 * @return true or false
	 */
	public boolean tryWord(Word guess) {
		guess.labelWord(mysteryWord);
		
		LinearNode<Word> guessNode = new LinearNode(guess);
		guessNode.setNext(history); 	// points to the node that history points to
		history = guessNode;	// point to the new node
		
		return guess.labelWord(mysteryWord);
	}
	
	/**
	 * Creates a String representation of the past guesses with the most recent guess first.
	 */
	public String toString() {
		String returnString = "";
		
		LinearNode<Word> current = history;
		while (current != null) {
			returnString = returnString + "\n" + current.getElement();
			current = current.getNext();
		}
		return returnString;
	}
}
