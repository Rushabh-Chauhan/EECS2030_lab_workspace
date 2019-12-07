import java.util.ArrayList;

public class ConjoinAll extends ExpressionCollector {

	public ConjoinAll() {
		super();
		this.list = new ArrayList<Expression>();
		this.value = true;
	}

	@Override
	void evaluate() {
		if (this.list.size() == 0) {
			this.value = true;
		} else {
			for (int i = 0; i < this.list.size(); i++) {
				Object a = this.list.get(i).value;
				this.value = (Boolean) this.value && (Boolean) a;
			}
		}
	}
}
