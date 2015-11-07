/* Programming Competition - Template (Horatiu Lazu) */

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.geom.*;
import java.math.*;
import java.text.*;


class Term{
	private Operation operation;
	private int coefficient;
	private Term nestedTerm;
	
	public int getCoefficient(){
		return coefficient;	
	}
	
	public Term getNestedTerm(){
		return nestedTerm;	
	}
	
	public Operation getOperation(){
		return operation;
	}
}