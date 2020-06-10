// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast;

import java.math.BigDecimal;

//Expression for a simple number
public class NumberExpression extends Expression 
{
	// Left and right expressions of the operation
	private BigDecimal fValue;
	
	// Getters for the expressions
	public BigDecimal getValue() { return fValue; }
	
	// Constructor taking in the number as a string. The constructor will convert it to a BigDecimal
	public NumberExpression(String aValue)
	{		
		// If the string should be null, return a zero to make it safe
		if (aValue != null)
		{
			fValue = new BigDecimal(aValue);
		}
		else
		{
			fValue = new BigDecimal("0");
		}
	}
	
	public NumberExpression(BigDecimal aValue)
	{
		// If the value should be null, return a zero to make it safe
		if (aValue != null)
		{
			fValue = aValue;
		}
		else
		{
			fValue = new BigDecimal("0");
		}
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate()
	{
		return fValue;
	}
}
