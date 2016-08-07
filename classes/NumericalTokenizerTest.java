import junit.framework.TestCase;

/**
 * NumericalTokenizerTest test cases.
 */
public class NumericalTokenizerTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testConvertToSpacedNumericalFormat() {
    //x^2+3x => x ^ 2 + 3 * x
    //3x => 3 * x
    //9sin(x^2(3x))+2 => 9 * sin ( x ^ 2 * ( 3 * x ) ) + 2
    //2x => 2 * x
    //9 => 9
    //x => x
    //99+3 => 99 + 3
  }
  
}
