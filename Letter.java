/**
 * This class represents a single letter that will be used in the game. Each game letter also has an accompanying integer which indicated whether it is used 
 * unused, or correct with respect to the mystery word.
 * @author Oren Joffe // CS1027B // 251135702
 *
 */

public class Letter {
	private char letter;
	private int label;
	static final int UNSET = 0;
	static final int UNUSED = 1;
	static final int USED = 2;
	static final int CORRECT = 3;
	
	
	/**
	 * Constructor creates a letter with label set to UNSET.
	 * @param c any letter
	 */
	public Letter(char c) {
		label = UNSET;
		letter = c;
	}
	
	/**
	 * Checks if another object is of the Letter class, then compares letter values.
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Letter) {
			if (this.letter == ((Letter) otherObject).letter) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a char to be added onto letter for toString().
	 * @return '+' '-' '!' ' ' 
	 */
	public String decorator() {
		if (label == USED) {
			return "+";
		} else if (label == UNUSED) {
			return "-";
		} else if (label == CORRECT) {
			return "!";
		} else { 			// UNSET
			return " ";
		}
	}
	
	/**
	 * Adds char from decorator method to beginning and end of letter.
	 */
	public String toString() {
		return (this.decorator() + letter + this.decorator());
	}
	
	/**
	 * Setter classes for label.
	 */
	public void setUnused() {
		label = UNUSED;
	}
	public void setUsed() {
		label = USED;
	}
	public void setCorrect() {
		label = CORRECT;
	}
	
	/**
	 * Checks if letter is unused.
	 * @return true or false if label is set to UNUSED.
	 */
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Produces an array of objects of the class Letter from the string s given as
	 * parameter. For each character in s a Letter object is created and stored in the
	 * array. The Letter objects are stored in the array in the same order in which the
	 * corresponding characters appear in s.
	 * @param s is any String
	 * @return sArr an array of Letter objects
	 */
	public static Letter[] fromString(String s) {
		Letter[] sArr = new Letter[s.length()];
		for (int i=0; i<s.length(); i++) {
			sArr[i] = new Letter(s.charAt(i));
		}
		return sArr;
	}
}