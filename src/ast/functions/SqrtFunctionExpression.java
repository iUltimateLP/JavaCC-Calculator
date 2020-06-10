// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast.functions;

import java.math.BigDecimal;
import java.math.MathContext;

import ast.Expression;

//Expression for a square root function
public class SqrtFunctionExpression extends Expression 
{
	// Left and right expressions of the operation
	private Expression fExpression;
	
	// Getters for the expressions
	public Expression getLeft() { return fExpression; }
	
	// Constructor taking in the expression
	public SqrtFunctionExpression(Expression aExpression)
	{
		fExpression = aExpression;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate() 
	{
		return fExpression.evaluate().sqrt(MathContext.DECIMAL32);
	}
}
