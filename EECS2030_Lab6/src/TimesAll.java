import java.util.ArrayList;

public class TimesAll extends ExpressionCollector {

	public TimesAll() {
		super();
		this.list = new ArrayList<Expression>();
		this.value = 1;
	}

	@Override
	void evaluate() {
		if (this.list.size() == 0) {
			this.value = 1;
		} else {
			for (int i = 0; i < this.list.size(); i++) {
				Object a = this.list.get(i).value;
				this.value = (int) this.value * (int) a;
			}
		}
	}
}
