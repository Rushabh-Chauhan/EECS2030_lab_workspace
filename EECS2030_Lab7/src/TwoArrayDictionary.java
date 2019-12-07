/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words = new String[this.MAX_CAPACITY];
	String[] definitions = new String[this.MAX_CAPACITY];

	@Override
	public int size() {

		return this.count;
	}

	@Override
	public boolean isEmpty() {

		if (this.count == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {

		String result = "";
		int i = 0;
		do {
			if (count == 0) {
				throw new WordNotInDictionaryException();
			} else if (word.equals(this.words[i])) {
				result = this.definitions[i];
			}
			i++;
		} while (i < count);

		if (result.equals("")) {
			throw new WordNotInDictionaryException();
		} else {
			return result;
		}

	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {

		int k = 0;
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				k++;
			}
		}

		if (this.count == this.MAX_CAPACITY) {
			throw new DictionaryFullException("");
		} else if (k == 1) {
			throw new WordAlreadyExistsInDictionaryException("");
		} else {
			this.words[this.count] = word;
			this.definitions[this.count] = definition;
			this.count++;
		}

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {

		String result = "";
		int k = 0;
		boolean a = true;
		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				k = i;
				a = false;
			}
		}

		if (k == 0 && a) {
			throw new WordNotInDictionaryException();
		} else if (k != this.count - 1) {
			result = this.definitions[k];
			for (int i = k; i < this.count - 1; i++) {
				this.words[i] = this.words[i + 1];
				this.definitions[i] = this.definitions[i + 1];
			}
			this.count--;

			String[] tempw = new String[this.MAX_CAPACITY];
			String[] tempd = new String[this.MAX_CAPACITY];
			for (int i = 0; i < this.count; i++) {
				tempw[i] = this.words[i];
				tempd[i] = this.definitions[i];
			}
			this.words = tempw;
			this.definitions = tempd;
		} else if (k == this.count - 1) {
			result = this.definitions[k];
			this.words[k] = null;
			this.definitions[k] = null;
			this.count--;
		}

		return result;
	}

	@Override
	public String[] getWords() {
		String[] result = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.words[i];
		}

		return result;
	}

	@Override
	public String[] getDefinitions() {

		String[] result = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.definitions[i];
		}

		return result;
	}

	@Override
	public WordDefinitionPair[] getEntries() {

		WordDefinitionPair[] result = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = new WordDefinitionPair(this.words[i], this.definitions[i]);
		}

		return result;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
}
