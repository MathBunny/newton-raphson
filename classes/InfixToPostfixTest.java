import junit.framework.TestCase;

/**
 * InfixToPostfix test cases.
 * @author Horatiu Lazu
 * @version 1.0
 */
public class InfixToPostfixTest extends TestCase {
  
  /**
   * Tests the countCharacters method.
   */
  public void testInfixToPostfix() {
    assertEquals("X * 3 => X 3 *", "X 3 *", InfixToPostfix.infixToPostfix("X * 3"));
    assertEquals("X => X", "X", InfixToPostfix.infixToPostfix("X"));
    assertEquals("X + X - 3 * 4 => X X 3 4 * - +", "X X 3 4 * - +", InfixToPostfix.infixToPostfix("X + X - 3 * 4"));
    assertEquals("X + ( X - 3 ) * 9 => X X 3 - 4 *", "X X 3 - 9 * +", InfixToPostfix.infixToPostfix("X + ( X - 3 ) * 9"));
  }
  
  /** Class constructor for unit tests. */
  public InfixToPostfixTest(){
    super();
  }
}
