// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast.functions;

import java.math.BigDecimal;

import ast.Expression;

//Expression for a tan function
public class TanFunctionExpression extends Expression 
{
	// Left and right expressions of the operation
	private Expression fExpression;
	
	// Getters for the expressions
	public Expression getLeft() { return fExpression; }
	
	// Constructor taking in the expression
	public TanFunctionExpression(Expression aExpression)
	{
		fExpression = aExpression;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate() 
	{
		return new BigDecimal(Math.tan(fExpression.evaluate().doubleValue()));
	}
}
