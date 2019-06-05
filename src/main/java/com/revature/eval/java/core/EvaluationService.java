package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string - String that will be reversed.
	 * @return newString - a String that is the reverse of the @param string.
	 * @throws - Nothing.
	 */
	public String reverse(String string) {
		String newString = "";
		for(int x = string.length()-1; x >= 0; x--) {
			newString += string.charAt(x);
		}
			
		return newString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase - String that needs to be turned into an acronym
	 * @return acronym - a String that represents the acronym of @param phrase.
	 * @throws - Nothing.
	 */
	public String acronym(String phrase) {
		String acronym = "";
		phrase = phrase.replace("-", " ").toUpperCase();
		String[] str = phrase.trim().split(" ");
		for(String s: str) {
			acronym += s.charAt(0);
		}
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {// class header
		private double sideOne;
		private double sideTwo;
		private double sideThree;
		
		/**
		 * Description - No args constructor
		 * @param - Nothing.
		 * @throws - Nothing.
		 */
		public Triangle() {
			super();
		}
		
		/**
		 * Description - Constructor that accepts three doubles that represents a side of a triangle
		 * @param sideOne - a double value for a side of a triangle
		 * @param sideTwo - a double value for a side of a triangle
		 * @param sideThree - a double value for a side of a triangle
		 * @throws - Nothing.
		 */
		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}
		
		/**
		 * Description - gets the value of side one of the triangle object
		 * @return sideOne - a double representation of side one of the triangle
		 * @throws - Nothing.
		 */
		public double getSideOne() {
			return sideOne;
		}
		
		/**
		 * Description - Change the length of side one of the triangle
		 * @param sideOne - a double value that will replace the current value of side one
		 * @return - Nothing.
		 * @throws - Nothing.
		 */
		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		/**
		 * Description - gets the value of side two of the triangle object
		 * @return sideOne - a double representation of side two of the triangle
		 * @throws - Nothing.
		 */
		public double getSideTwo() {
			return sideTwo;
		}

		/**
		 * Description - Change the length of side two of the triangle
		 * @param sideOne - a double value that will replace the current value of side two
		 * @return - Nothing.
		 * @throws - Nothing.
		 */
		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		/**
		 * Description - gets the value of side three of the triangle object
		 * @return sideOne - a double representation of side three of the triangle
		 * @throws - Nothing.
		 */
		public double getSideThree() {
			return sideThree;
		}

		/**
		 * Description - Change the length of side three of the triangle
		 * @param sideOne - a double value that will replace the current value of side three
		 * @return - Nothing.
		 * @throws - Nothing.
		 */
		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		/**
		 * Description - Determines if this triangle is an equilateral triangle
		 * @return - true if the triangle is an equilateral triangle, false otherwise
		 * @throws - Nothing
		 */
		public boolean isEquilateral() {
			if(this.getSideOne() == this.getSideTwo() && this.getSideOne() == this.getSideThree())
				return true;
			return false;
		}

		/**
		 * Description - Determines if this triangle is an isosceles triangle
		 * @return - true if the triangle is an isosceles triangle, false otherwise
		 * @throws - Nothing
		 */
		public boolean isIsosceles() {
			boolean equalToSideOne = false;
			
			if(this.getSideOne() == this.getSideTwo() || this.getSideOne() == this.getSideThree())
				equalToSideOne = true;
			
			if(!this.isEquilateral())
				if(this.getSideTwo() == this.getSideThree() || equalToSideOne)
					return true;
			return false;
		}

		/**
		 * Description - Determines if this triangle is an scalene triangle
		 * @return - true if the triangle is an scalene triangle, false otherwise
		 * @throws - Nothing
		 */
		public boolean isScalene() {
			if(this.isEquilateral() || this.isIsosceles())
				return false;
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string - String representation of the word that needs a scrabble score
	 * @return - the score of the scrabbled word
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		
		for(int x = 0; x < string.length(); x++) {
			if(string.substring(x, x+1).matches("[A, E, I, O, U, L, N, R, S, T]|[a, e, i, o, u, l, n, r, s, t]"))
				score += 1;
			else if(string.substring(x, x+1).matches("[D, G]|[d, g]"))
				score += 2;
			else if(string.substring(x, x+1).matches("[B, C, M, P]|[b, c, m, p]"))
				score += 3;
			else if(string.substring(x, x+1).matches("[F, H, V, W, Y]|[f, h, v, w, y]"))
				score += 4;
			else if(string.substring(x, x+1).matches("[K]|[k]"))
				score += 5;
			else if(string.substring(x, x+1).matches("[J, X]|[j, x]"))
				score += 8;
			else if(string.substring(x, x+1).matches("[Q, Z]|[q, z]"))
				score += 10;
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String cleanNum = "";
		String[] cleaner = string.trim().split("[+?1]|[-]|[(]|[)]|['.']|[' ']");
		for(String str: cleaner) {
			if(str.matches("[^0-9]+"))
				throw new IllegalArgumentException();
			cleanNum += str;
		}
		
		if(cleanNum.length() > 10) {
			throw new IllegalArgumentException();
		}
		
		
		
		return cleanNum;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string - String that contains a phrase
	 * @return - Map<String, Integer> where String is the word, and Integer is the number of occurrences
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> tempList = new HashMap<>();; //Object to be returned
		
		//counter for how many words exist
		
		//ArrayList that holds the counted words
		ArrayList<String> counted = new ArrayList<>();
		
		//ArrayList that holds the words after splitting the phrase
		ArrayList<String> word = new ArrayList<>();
		
		//clean the string to only hold words separated by a whitespace
		string = string.replaceAll(",", " ");
		
		//Split the string into separate words
		for(String input: string.split("\\s+")) {
			word.add(input);
		}
		
		while(word.size() > 0) {
			String str = word.get(0);
			int counter = 0;
			for(int y = 0; y < word.size(); y++) {
				if(str.compareTo(word.get(y)) == 0) {
					counter++;
					word.remove(y);
					if(y != 0)
						y -= 1;
				}
			}//end y loop
			tempList.put(str, counter);
		}//end x loop
		
		return tempList;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		public int indexOf(T t) {
			
			Comparator<T> c = (T str1, T str2) -> {
				return str2.toString().compareTo(str1.toString());
			};
			
			int index = Collections.binarySearch(sortedList, t, c);
			
			if(index < 0)
				return 0;
			
			
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String str = Integer.toString(input);
		int total = 0;
		
		for(int x = 0; x < str.length(); x++) {
			total += Math.pow(Integer.parseInt(str.substring(x, x+1)), str.length());
		}
		
		if(total == input)
			return true;
		
		return false;
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		for(char a = 'A'; a <= 'Z'; a++) {
			if(string.indexOf(a) < 0 && (string.indexOf((char) (a + 32)) < 0)) //if char exists in the string. + 32 for lowercase chars
				return false;
		}
		return true;
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
			
		}

		public String rotate(String string) {
			char[] c = string.toCharArray();
			String newStr = "";
			char upperBoundMax = (char) 91; //used to check if char is above 'Z'
			char upperBoundMin = (char) 65; //used to keep char from going below 'A'
			char lowerBoundMax = (char) 123; //used to check if char is above 'z'
			char lowerBoundMin = (char) 97; //used to keep char from going below 'A'
			
			for(int x = 0; x < c.length; x++) {
				if((c[x] + key) >= upperBoundMax && Character.isUpperCase(c[x])) {
					int diff = ((c[x] + key) - upperBoundMax);
					c[x] = (char) (upperBoundMin + diff);
				} else if(Character.isUpperCase(c[x])){
					c[x] = (char) (c[x] + key);
				}
				
				if((c[x] + key) >= lowerBoundMax && Character.isLowerCase(c[x])) {
					int diff = ((c[x] + key) - lowerBoundMax);
					c[x] = (char) (lowerBoundMin + diff);
				} else if(Character.isLowerCase(c[x])) {
					c[x] = (char) (c[x] + key);
				}
				
				newStr += c[x];
			}
			
			
			return newStr;
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		
		Map<Character, Character> decoder = new HashMap<>();
		
		
		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			Map<Character, Character> encoder = new HashMap<>();
			String encoded = "";
			int pos = 97;
			int spacer = 0;
			for(char x = 'z'; x >= 'a'; x--) {
				char c = (char) pos;
				encoder.put(c, x);
				pos++;
			}
			
			string = string.toLowerCase().replaceAll("\\s", "");
			char[] toEncode = string.toCharArray();
			
			
			for(int x = 0; x < toEncode.length; x++) {
				
				if(Character.isAlphabetic(toEncode[x]))
					encoded += encoder.get(toEncode[x]);
				else if(Character.isDigit(toEncode[x])){
					encoded += toEncode[x];
				} else {
					continue;
				}
				
				spacer++;
				if(spacer == 5) {
					spacer = 0;
					encoded += " ";
				}
				
			}
			
			
			
			return encoded.trim();
		}

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			Map<Character, Character> decoder = new HashMap<>();
			String decoded = "";
			int pos = 122;
			//int spacer = 0;
			for(char x = 'a'; x <= 'z'; x++) {
				char c = (char) pos;
				decoder.put(c, x);
				pos--;
			}
			
			string = string.toLowerCase().replaceAll("\\s", "");
			char[] toDecode = string.toCharArray();
			
			for(int x = 0; x < toDecode.length; x++) {
				
				if(Character.isAlphabetic(toDecode[x]))
					decoded += decoder.get(toDecode[x]);
				else if(Character.isDigit(toDecode[x])){
					decoded += toDecode[x];
				} else {
					continue;
				}
				
			}
			
			
			return decoded;
		}
	}

	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
