import java.util.ArrayList;

public class AddAll extends ExpressionCollector {

	public AddAll() {
		super();
		this.list = new ArrayList<Expression>();
		this.value = 0;
	}

	@Override
	public void evaluate() {
		if (this.list.size() == 0) {
			this.value = 0;
		} else {
			for (int i = 0; i < this.list.size(); i++) {
				Object a = this.list.get(i).value;
				this.value = (int) this.value + (int) a;
			}
		}
	}

}
