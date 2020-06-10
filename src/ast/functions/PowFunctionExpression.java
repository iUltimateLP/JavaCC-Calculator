// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast.functions;

import java.math.BigDecimal;

import ast.Expression;

// Expression for the power operation
public class PowFunctionExpression extends Expression 
{
	// Left and right expressions of the operation
	private Expression fBase;
	private Expression fExponent;
	
	// Getters for the expressions
	public Expression getBase() { return fBase; }
	public Expression getExponent() { return fExponent; }
	
	// Constructor taking in the two expressions
	public PowFunctionExpression(Expression aBase, Expression aExponent)
	{
		fBase = aBase;
		fExponent = aExponent;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate()
	{
		return new BigDecimal(Math.pow(fBase.evaluate().doubleValue(), fExponent.evaluate().doubleValue()));
	}
}
