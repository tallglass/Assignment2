/**
 * This class is a subclass of Letter and extends the functionality. Instead of relying on a single 
 * char to represent the content of a Letter object, objects of this class will use a String instance variable.
 * This class adds more features to broaden the notion of a letter that will be used in the game. 
 * @author Oren Joffe // CS1027B // 251135702
 *
 */
public class ExtendedLetter extends Letter{
	private String content;
	private int family;
	private boolean related;
	static final int SINGLETON = -1;
	
	/**
	 * Constructor setting content=s, related=false, family=SINGLETON
	 * @param s instance variable from Letter superclass
	 */
	public ExtendedLetter(String s) {
		super ('c');
		content = s;
		related = false;
		family = SINGLETON;
	}
	
	/**
	 * Constructor setting content=s, related=false, family=fam
	 * @param s instance variable from Letter superclass
	 * @param fam family
	 */
	public ExtendedLetter(String s, int fam) {
		super ('c');
		content = s;
		related = false;
		family = fam;
	}
	
	/**
	 * Return false if the parameter other is not an instanceOf ExtendedLetter.
	 * Otherwise return true:
	 * It will set the instance variable related of this object to true if the family instance variable of other is the same as this.family.
	 * Return true if the instance variable content of other is equal to the instance variable content of this object;
	 * Otherwise it returns false
	 */
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) {
			if (this.family == ((ExtendedLetter) other).family) {
				related = true;
			}
			if (this.content == ((ExtendedLetter) other).content) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * An overridden method that gives a String representation of this ExtendedLetter object
	 */
	public String toString() {
		if ((this.isUnused() == true) && (related == true)) {
			return ("." + this.content + ".");
		} else {
			return (this.decorator() + this.content + this.decorator());
		}
	}
	
	/**
	 * Creates an array letters of Letter objects of the same size as the size of the array
	 * content received as parameter. This array letters will be returned by the method
	 * after storing in it the following information:
	 * @param content array of Strings
	 * @param codes array of integers
	 * @return letters array of Letter objects
	 */
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		
		if (codes == null) {
			for (int i=0; i<letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
		} else {
			for (int i=0; i<letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		return letters;
	}
}
