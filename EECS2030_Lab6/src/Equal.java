
public class Equal extends Expression {

	public Equal(int left, int right) {
		super(left, right);
		this.value = left == right;
	}

	@Override
	void evaluate() {
		this.value = (boolean) this.value;
	}

}
