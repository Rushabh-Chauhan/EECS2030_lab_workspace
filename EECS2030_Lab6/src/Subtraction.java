
public class Subtraction extends Expression {

	public Subtraction(int left, int right) {
		super(left, right);
		this.value = left - right;
	}

	@Override
	void evaluate() {
		this.value = (int) this.value;
	}

}
