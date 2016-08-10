import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * NumericalTokenizerTest test cases.
 */
public class NumericalTokenizerTest{
  
  @Test
  /**
   * Tests the ConvertToSpacedNumericalFormat method.
   */
  public void testConvertToSpacedNumericalFormat() {
    NumericalTokenizer nT = new NumericalTokenizer();
    assertEquals("x^2+3x => x ^ 2 + 3 * x + 1", "X ^ 2 + 3 * X + 1", nT.convertToSpacedNumericalFormat("X^2+3X+1"));
    assertEquals("3x => 3 * x", "3 * X", nT.convertToSpacedNumericalFormat("3X"));
    assertEquals("9sin(x^2(3x))+2 => 9 * sin ( x ^ 2 * ( 3 * x ) ) + 2", "9 * sin ( X ^ 2 * ( 3 * X ) ) + 2", nT.convertToSpacedNumericalFormat("9sin(X^2(3X))+2"));
    assertEquals("x^2+3x => x ^ 2 + 3 * x", "X ^ 2 + 3 * X", nT.convertToSpacedNumericalFormat("X^2+3X"));
    assertEquals("9 => 9", "9", nT.convertToSpacedNumericalFormat("9"));
    assertEquals("x => x", "X", nT.convertToSpacedNumericalFormat("X"));
    assertEquals("99+3 => 99 + 3", "99 + 3", nT.convertToSpacedNumericalFormat("99+3"));
  }
  
  /** Class constructor for unit tests. */
  public NumericalTokenizerTest(){
    super();
  }
}
