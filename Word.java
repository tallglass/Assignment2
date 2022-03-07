/**
 * This class represents a word in the game that is comprised of any number of letters. Each letter
 * is represented by a Letter object. The Letter objects are stored in a linked list formed by objects
 * of the class LinearNode.
 * @author Oren Joffe // CS1027B // 251135702
 *
 */
public class Word {
	private LinearNode<Letter> firstLetter;
	
	/**
	 * Initialize the Word object so the Letter objects in array letters is stored within its linked structure. 
	 * @param letters an array of letters
	 */
	public Word(Letter[] letters) {
		firstLetter = new LinearNode(letters[0]);
		LinearNode<Letter> newNode = new LinearNode(letters[1]);
		firstLetter.setNext(newNode); 
		
		for (int i=2; i<letters.length; i++) {
			LinearNode<Letter> pre = newNode; // node added 1 loop before
			newNode = new LinearNode(letters[i]); // node being added
			
			LinearNode<Letter> succ = pre.getNext(); // points to node that pre points to (null)
			newNode.setNext(succ);	// newNode points to succ (null)
			pre.setNext(newNode);	// pre points to newNode (letter)
		}
	}
	
	/**
	 * Creates a String produced by invoking the toString method on each Letter object of this Word.
	 */
	public String toString() {
		String returnString = "";
		
		LinearNode<Letter> current = firstLetter; // front of LL
		while (current != null) { // until end of LL
			returnString = returnString + " " + current.getElement(); 
			current = current.getNext(); // current = next node
		}
		returnString += " ";
		
		return ("Word:" + returnString);
	}
	
	/**
	 * Takes a mystery word as a parameter and updates each of Letters label attribute contained in this Word object with respect to the mystery word.
	 * @param mystery word that user will try to guess
	 */
	private void letterCheck(Word mystery) {
		int gIndex = 0;
		LinearNode<Letter> guessCurr = this.firstLetter; // front of guess LL
		while (guessCurr != null) {		// until end of guess LL
			
			boolean correct = false;
			boolean used = false;
			boolean unused = false;
			int mIndex = 0; 	// need to reset mystery's index every loop
			LinearNode<Letter> mysteryCurr = mystery.firstLetter;	// front of mystery LL
			while (mysteryCurr != null) { 	// until end of mystery LL
				
				if (guessCurr.getElement().equals(mysteryCurr.getElement())) { 	// letter == letter
					if (gIndex == mIndex) { 	// comparing indexes
						correct = true;
					} else {
						used = true;
					}
				} else {
					unused = true;
				}
				
				mysteryCurr = mysteryCurr.getNext();
				mIndex++;
			}
			
			if (correct == true) {
				guessCurr.getElement().setCorrect();
			} else if (used == true) {
				guessCurr.getElement().setUsed();
			} else {
				guessCurr.getElement().setUnused();
			}
			
			guessCurr = guessCurr.getNext();
			gIndex++;
		}
	}
	
	/**
	 * Handles a case for labelWord in which all letters of a word are used, but not all are correct.
	 * @return true or false
	 */
	private boolean isCorrect() {
		LinearNode<Letter> current = this.firstLetter;
		while (current != null) {
			char symbol1 = current.getElement().toString().charAt(0);
			char symbol2 = current.getElement().toString().charAt(2);
			if (symbol1 != '!' && symbol2 != '!') {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	/**
	 * Takes a mystery word as a parameter and updates each of Letters label attribute contained in this Word object with respect to the mystery word.
	 * Returns true if this word is identical in content to the mystery word.
	 * @param mystery word that user will try to guess
	 * @return true or false
	 */
	public boolean labelWord(Word mystery) {
		this.letterCheck(mystery);
		
		LinearNode<Letter> current = firstLetter;
		while (current != null) {
			if ((current.getElement().isUnused() == true) || (this.isCorrect() == false)) {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
}
