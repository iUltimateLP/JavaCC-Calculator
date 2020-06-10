// Jonathan Verbeek - Hochschule Bremen City University of Applied Sciences - 2020

package parser;

public class Main 
{	
	// Main program entry point
	public static void main(String[] args) 
	{
		// Parsing can fail, so catch any errors
		try
		{
			// Welcome message
			System.out.println("Welcome to the advanced calculator.\nEnter any mathematical calculation or assign variables.");
			System.out.println("Supported operations are: +, -, *, /, %, sin(), cos(), tan(), sqrt(), pow()");
			System.out.println("Example: x = 3 + 7;\n         y = 2 * x;");
			
			// Create a new instance of the parser
			AdvancedCalculator lParser = new AdvancedCalculator(System.in);
			
			// Endless loop causes the program to prompt again after a calculation has been made
			while (true)
			{
				System.out.print("> ");
		
				// Evaluate the line and print the result
				System.out.println("= " + lParser.Line().evaluate());
			}
		}
		catch (ParseException e)
		{
			System.err.println("Syntax error: " + e.getMessage());
		}
	}
}
