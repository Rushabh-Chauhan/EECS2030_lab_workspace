
public class WordDefinitionPair {

	private String word;
	private String definition;

	public WordDefinitionPair(String word, String definition) {
		this.word = word;
		this.definition = definition;
	}

	public String getWord() {
		return this.word;
	}

	public String getDefinition() {
		return this.definition;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		WordDefinitionPair other = (WordDefinitionPair) obj;

		if (this.word.equals(other.word) && this.definition.equals(other.definition)) {
			return true;
		} else {
			return false;
		}

	}

}
