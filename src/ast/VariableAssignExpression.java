// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast;

import java.math.BigDecimal;
import java.util.*;

//Expression for the variable assignment (e.g. x = 4)
public class VariableAssignExpression extends Expression 
{
	// Expression of the operation
	private Expression fExpression;
	
	// Name of the variable to add
	private String fName;
	
	// The memory where to store the variables
	private Hashtable<String, BigDecimal> fMemory;
	
	// Getters for the expression
	public Expression getLeft() { return fExpression; }

	// Constructor taking in the expression and the memory where to store the variable
	public VariableAssignExpression(String aName, Expression aExpression, Hashtable<String, BigDecimal> aMemory)
	{
		fName = aName;
		fExpression = aExpression;
		fMemory = aMemory;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate() 
	{
		// Evaluate the expression we want to assign
		BigDecimal value = fExpression.evaluate();
		
		// Add the result of the expression to the memory
		fMemory.put(fName, value);
		
		// Simply return the result of the expression we just added as a variable
		return value;
	}
}
