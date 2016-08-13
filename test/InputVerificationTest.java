package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import classes.*;


/**
 * InputVerification test cases.
 * @author Horatiu Lazu
 * @version 1.0
 */
public class InputVerificationTest {
  
  @Test
  /**
   * Tests the countCharacters method.
   */
  public void testCountCharacter() {
    assertEquals("Hello! has 1 '!'", 1, InputVerification.countCharacter("Hello!", '!'));
    assertEquals("!!! has 3 '!'", 3, InputVerification.countCharacter("!!!", '!'));
  }
  
  @Test
  /**
   * Tests the isValidExponent method. 
   */
  public void testIsValidExponent(){
    assertEquals("(X)^2 is valid", true, InputVerification.isValidExponent("(X)^2"));
    assertEquals("X)^2 is not valid", false, InputVerification.isValidExponent("X)^2"));
  }
  
  @Test
  /**
   * Tests if the brackets are proportional. 
   */
  public void testHasBalancedBrackets(){
    assertEquals("(() is not balanced as final", false, InputVerification.hasBalancedBrackets("(()", true));
    assertEquals("(())) is not balanced as final", false, InputVerification.hasBalancedBrackets("(()))", true));
    assertEquals("(() is balanced as non-final", true, InputVerification.hasBalancedBrackets("(()", false));
    assertEquals("(())) is not balanced as non-final", false, InputVerification.hasBalancedBrackets("(()))", false));
  }
  
  /** Class constructor for unit tests. */
  public InputVerificationTest(){
    super();
  }
}
