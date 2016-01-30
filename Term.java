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