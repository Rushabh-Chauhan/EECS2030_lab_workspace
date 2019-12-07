/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict = new WordDefinitionPair[100];

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {

		if (count == 0) {
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
			} else if (word.equals(dict[i].getWord())) {
				result = dict[i].getDefinition();
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
			if (this.dict[i].getWord().equals(word)) {
				k++;
			}
		}

		if (this.count == this.MAX_CAPACITY) {
			throw new DictionaryFullException("");
		} else if (k == 1) {
			throw new WordAlreadyExistsInDictionaryException("");
		} else {
			this.dict[this.count] = new WordDefinitionPair(word, definition);
			this.count++;
		}

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		String result = "";
		int k = 0;
		boolean a = true;
		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				k = i;
				a = false;
			}
		}

		if (k == 0 && a) {
			throw new WordNotInDictionaryException();
		} else if (k != this.count - 1) {
			result = this.dict[k].getDefinition();
			for (int i = k; i < this.count - 1; i++) {
				this.dict[i] = new WordDefinitionPair(this.dict[i + 1].getWord(), this.dict[i + 1].getDefinition());
			}
			this.count--;
			WordDefinitionPair[] temp = new WordDefinitionPair[100];
			for (int i = 0; i < this.count; i++) {
				temp[i] = this.dict[i];
			}
			this.dict = temp;
		} else if (k == this.count - 1) {
			result = this.dict[k].getDefinition();
			this.dict[k] = new WordDefinitionPair(null, null);
			this.count--;
		}

		return result;
	}

	@Override
	public String[] getWords() {

		String[] result = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i].getWord();
		}

		return result;
	}

	@Override
	public String[] getDefinitions() {
		String[] result = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i].getDefinition();
		}

		return result;
	}

	@Override
	public WordDefinitionPair[] getEntries() {

		WordDefinitionPair[] result = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i];
		}

		return result;
	}

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

}
