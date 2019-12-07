
public class GreaterThan extends Expression {

	public GreaterThan(int left, int right) {
		super(left, right);
		this.value = left > right;
	}

	@Override
	void evaluate() {
		this.value = (boolean) this.value;
	}
}
