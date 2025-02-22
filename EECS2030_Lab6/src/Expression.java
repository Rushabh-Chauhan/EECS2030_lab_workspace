
/*
 * Your Tasks:
 * 1. Read the problem description and inheritance hierarchy diagram in the instructions.
 * 2. Add the necessary subclasses and implement the required methods.
 * 3. Study tests in TestExpressions.java to understand what's required to help your implementation. 
 */

public class Expression {

	/**
	 * Value of evaluation result. Dynamically, value may be an Integer or a
	 * Boolean.
	 */
	Object value;

	/**
	 * Initialize an expression.
	 * 
	 * @param left  left integer value
	 * @param right right integer value
	 */
	Expression(int left, int right) {

		// this.value = left * right;
	}

	/**
	 * After evaluation, obtain the evaluation result.
	 * 
	 * @return evaluation result of this expression
	 */
	Object getValue() {
		/* Your Task */
		return value;
	}

	void evaluate() {
		/* Your Task */
		// Hint: Leave this empty and override it in all subclasses such as Addition,
		// GreaterThan.
	}

}
