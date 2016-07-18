#Newton-Raphson Approximation Program

##Purpose
The purpose of this program is to find the root for _any_ expression using Newton's method. Provided any random point, this program can determine a root of the expression.

It's important to note that: 
> Newton's method does not work if the slope of tangency is zero at the guess, nor does it identify multiple roots

##Features
* Nice interface to input equation
* All input is error trapped right when entered by the user
* User's estimate is error-trapped to prevent guessing when the tangent is equal to zero
* Can compute over 1,000 iterations of Newton's method
* Various different trignometric functions with scientific constants
* Utilized Dijkstra's Shunting-Yard algorithm (Reverse Polish Notation) and stacks to parse expressions

##How to Run & Documentation
Simply run the `NewtonRaphsonApp.java`, and the program will run. You can find the JavaDoc documentation in the `doc/` folder.

##Screenshot
![Screenshot](http://horatiulazu.ca/software/images/NewtonRaphson.png "Screenshot")



