# JavaCC-Calculator
A calculator built with JavaCC supporting mathematical expressions, variables and functions.

---

This project was built for the Hochschule Bremen City University of Applied Sciences. 
The task was to create a program which uses [JavaCC](https://javacc.github.io/javacc/) to parse any character sequence and interpret it.

Therefore, I built a calculator running on the command line, which can parse mathematical operations and evaluate their result. An example:
```
> 3 + 4;
= 7
> 2 - 3;
= -1
> 1 + (2 * 3);
= 7
```

It also supports a small set of functions (impemented in `ast.functions`):
```
> sin(0);
= 0
> sin(pi / 2);
= 1
> tan(1)
= 1.557407724654902292371616567834280431270599365234375
> sqrt(2)
= 1.414214
```

Also, I added support for assigning and reading variables:
```
> a = 5;
= 5
> b = 10;
= 10
> c = a * b;
= 50;
> c * 3;
= 150;
```

Obviously, these can be used all together to evaluate complex calculations.
Check out the [AdvancedCalculator.jj](https://github.com/iUltimateLP/JavaCC-Calculator/blob/master/src/AdvancedCalculator.jj) to see how the language is parsed and interpreted.
