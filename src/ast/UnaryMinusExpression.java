// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast;

import java.math.BigDecimal;

//Expression for the unary minus operation (e.g. -n)
public class UnaryMinusExpression extends Expression 
{
	// Left and right expressions of the operation
	private Expression fExpression;
	
	// Getters for the expressions
	public Expression getLeft() { return fExpression; }
	
	// Constructor taking in the expression
	public UnaryMinusExpression(Expression aExpression)
	{
		fExpression = aExpression;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate() 
	{
		return fExpression.evaluate().multiply(new BigDecimal("-1"));
	}
}
