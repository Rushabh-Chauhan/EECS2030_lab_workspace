
public class Addition extends Expression {

	public Addition(int left, int right) {
		super(left, right);
		this.value = left + right;
	}

	@Override
	void evaluate() {
		this.value = (int) this.value;
	}

}
