# Newton-Raphson Approximation Program
[![Build Status](https://travis-ci.org/MathBunny/newton-raphson.svg?branch=master)](https://travis-ci.org/MathBunny/
newton-raphson)
![Issue Tracker](https://img.shields.io/github/issues/MathBunny/newton-raphson.svg)
[![Packagist](https://img.shields.io/packagist/l/doctrine/orm.svg?maxAge=2592000)]()

## Purpose:
The purpose of this program is to find the root for _any_ expression using Newton's method. Provided any random point, this program can determine a root of the expression.

It's important to note that: 
> Newton's method does not work if the slope of tangency is zero at the guess, nor does it identify multiple roots

## Features:
* Nice interface to input equation
* All input is error trapped right when entered by the user
* User's estimate is error-trapped to prevent guessing when the tangent is equal to zero
* Can compute over 1,000 iterations of Newton's method
* Various different trignometric functions with scientific constants
* Utilized Dijkstra's Shunting-Yard algorithm (Reverse Polish Notation) and stacks to parse expressions
* JUnit tests
* Ability to run in a console window (no GUI)

## How to Run & Documentation:
You can use ANT to build this project, or you can manually compile all the Java files. If you are interested in running this app through a command-line interface, run `NewtonRaphsonConsole.java`, or GUI `NewtonRaphsonApp.java`. Documentation can be found in the `/doc/` folder.

## Screenshot
![Screenshot](http://horatiulazu.ca/software/images/NewtonRaphson.png "Screenshot")



