##Newton-Raphson Approximation Program
###Developed by: Horatiu Lazu

###Purpose / Design:
* Find the root for _any_ expression using Newton's method
* Uses exp4j to evaluate expressions (reverse Polish notation)

It's important to note that 
> Newton's method of approximation does not work if the slope of tangency is zero at the guess, nor does it identify if there's multiple roots

###Features:
* Nice interface to input equation
* All input is error trapped right when entered by the user
* User's estimate is error-trapped to prevent guessing when the tangent is equal to zero
* Can compute over 1,000 iterations of Newton's method
* Various different trignometric functions

###Known Bugs:
* No button shadows for the "input guess" console

###Future Updates:
* Structure folders better
* Include settings to adjust number of iterations
* Erase lines along the "zero" button
* Include option to automatically identify roots

####Screenshot:
![Screenshot](http://software.horatiulazu.paperplane.io/NewtonRaphson.png "Screenshot")



