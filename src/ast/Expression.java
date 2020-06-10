// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

// Abstract Syntax Tree
package ast;

import java.math.BigDecimal;

// Parent class for any expression, children can overwrite evaluate()
public abstract class Expression 
{
	// Evaluates the expression and returns the result
	public abstract BigDecimal evaluate();
}
