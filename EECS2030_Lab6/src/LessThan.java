
public class LessThan extends Expression {

	public LessThan(int left, int right) {
		super(left, right);
		this.value = left < right;
	}

	@Override
	void evaluate() {
		this.value = (boolean) this.value;
	}

}
