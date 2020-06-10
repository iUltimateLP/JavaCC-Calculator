// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package ast.functions;

import java.math.BigDecimal;
import java.util.*;
import ast.Expression;

//Expression for the unary minus operation (e.g. -n)
public class PrintMemoryExpression extends Expression 
{
	// Holds the memory
	private Hashtable<String, BigDecimal> fMemory;

	// Constructor taking in the expression
	public PrintMemoryExpression(Hashtable<String, BigDecimal> aMemory)
	{
		fMemory = aMemory;
	}
	
	// Overwritten evaluate
	public BigDecimal evaluate() 
	{
		// Go through all keys stored in the memory
		for (String var : fMemory.keySet())
		{
			// Print out the var name and value
			System.out.println(var + " = " + fMemory.get(var));
		}
		
		// This is a dummy operation, return a zero
		return new BigDecimal("0");
	}
}
