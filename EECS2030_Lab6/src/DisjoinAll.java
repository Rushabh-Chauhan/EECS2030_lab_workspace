import java.util.ArrayList;

public class DisjoinAll extends ExpressionCollector {

	public DisjoinAll() {
		super();
		this.list = new ArrayList<Expression>();
		this.value = false;
	}

	@Override
	void evaluate() {
		if (this.list.size() == 0) {
			this.value = false;
		} else {
			for (int i = 0; i < this.list.size(); i++) {
				Object a = this.list.get(i).value;
				this.value = (Boolean) this.value || (Boolean) a;
			}
		}
	}
}
