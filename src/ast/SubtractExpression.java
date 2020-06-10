// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast;

import java.math.BigDecimal;

//Expression for the - operation
public class SubtractExpression extends Expression 
{
	// Left and right expressions of the operation
	private Expression fLeft;
	private Expression fRight;
	
	// Getters for the expressions
	public Expression getLeft() { return fLeft; }
	public Expression getRight() { return fRight; }
	
	// Constructor taking in the two expressions
	public SubtractExpression(Expression aLeft, Expression aRight)
	{
		fLeft = aLeft;
		fRight = aRight;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate()
	{
		return fLeft.evaluate().subtract(fRight.evaluate());
	}
}
