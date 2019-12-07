
//import java.util.ArrayList;
import java.util.List;

/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class ExpressionCollector {

	/*
	 * Your Task: Declare attribute(s) to store the list of Expression objects of
	 * this collector.
	 */
	public List<Expression> list;
	public Object value;

	/**
	 * Initialize an expression collector which stores an empty collection of
	 * expressions.
	 */
	ExpressionCollector() {
		/* Your Task */
		// list = new ArrayList<>();
	}

	/**
	 * Add a new expression.
	 * 
	 * @param e an expression
	 */
	void addExpression(Expression e) {
		/* Your Task */
		this.list.add(e);
	}

	/**
	 * Add a new expression.
	 * 
	 * @param left  integer value of the left operand
	 * @param op    operator (i.e., "+", "-", "*", ">", "<", "==")
	 * @param right integer value of the right operand
	 */
	void addExpression(int left, String op, int right) {
		/* Your Task */
		// Hint: Depending on the operator given (e.g., +), create the corresponding
		// expression object
		// (e.g., Addition) and add it to the collector.

		if (op.equals("+")) {
			Expression add = new Addition(left, right);
			this.list.add(add);
		} else if (op.equals("-")) {
			Expression sub = new Subtraction(left, right);
			this.list.add(sub);
		} else if (op.equals("*")) {
			Expression mul = new Multiplication(left, right);
			this.list.add(mul);
		} else if (op.equals("==")) {
			Expression eq = new Equal(left, right);
			this.list.add(eq);
		} else if (op.equals(">")) {
			Expression g = new GreaterThan(left, right);
			this.list.add(g);
		} else {
			Expression l = new LessThan(left, right);
			this.list.add(l);
		}
	}

	/**
	 * If this collector is AddAll or TimesAll, then all stored expressions must be
	 * integer expressions (i.e., Addition, Subtraction, Multiplication). If this
	 * collection is ConjoinAll or DisjoinAll, then all stored expressions must be
	 * boolean expressions (i.e., GreaterThan, LessThan, Equal)
	 * 
	 * @return whether it is possible to evaluate the stored collection of
	 *         expressions.
	 */
	boolean isTypeCorrect() {
		/* Your Task */

		boolean k = true;
		if (this.list.size() == 0) {
			return true;
		} else {
			for (int i = 0; i < this.list.size(); i++) {
				if (this.value instanceof Integer) {
					if (!(this.list.get(i).getValue() instanceof Integer)) {
						k = false;
						break;
					}
				} else {
					if (!(this.list.get(i).getValue() instanceof Boolean)) {
						k = false;
						break;
					}
				}
			}

			return k;

		}

	}

	/**
	 * Given that this expression collector is type correct (see `isTypeCorrect()`),
	 * evaluate it. Store the evaluation result so that it can be returned by
	 * `getValue()`.
	 */
	void evaluate() {
		/* Your Task */
		// Hint: Leave this empty and override it in all subclasses such as AddAll and
		// ConjoinAll.
	}

	/**
	 * Get the result of the latest evaluation (i.e., after the latest call to
	 * `evaluate()`).
	 * 
	 * @return the last evaluation result.
	 */
	Object getValue() {
		/* Your Task */
		return this.value;
	}

	/**
	 * Obtain the list of stored expressions.
	 * 
	 * @return all stored expressions as an array
	 */
	Expression[] getExpressions() {
		/* Your Task */
		Expression result[] = new Expression[this.list.size()];
		if (this.list.size() == 0) {
			return result;
		} else {
			return result;
		}
	}

	/**
	 * Override the equals method. Two expression collectors are equals if: 1) They
	 * are both type correct 2) Their evaluation results are identical
	 * 
	 * @return whether or not the two expression collectors are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		/* Your Task */

		ExpressionCollector other = (ExpressionCollector) obj;

		if (other.value.getClass() == this.value.getClass()) {
			if (this.value instanceof Integer && (int) other.value == (int) this.value) {
				return true;
			} else if (this.value instanceof Boolean && ((boolean) other.value == (boolean) this.value)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
