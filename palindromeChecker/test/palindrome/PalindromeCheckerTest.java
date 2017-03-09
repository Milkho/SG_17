package palindrome;

import org.junit.Test;
import static org.junit.Assert.*;

/** 
 * тестування класу PalindromeChecker
 * @author Михайло Хорошун
 */
public class PalindromeCheckerTest {

    /**
     * тестування методу checkForPalindrome з класу PalindromeChecker
     */
    @Test
    public void checkForPalindrome_isQwertyPalindrome_falseReturned() {
        String inputString = "";
        boolean expResult = false;
        
        boolean result = PalindromeChecker.checkForPalindrome(inputString);
        
        try {
            assertEquals(expResult, result);
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    /**
     * тестування методу checkForPalindrome з класу PalindromeChecker
     */
    @Test
    public void checkForPalindrome_isQwerttrewqPalindrome_trueReturned() {
        String inputString = "Qwerttrewq";
        boolean expResult = true;
        
        boolean result = PalindromeChecker.checkForPalindrome(inputString);
        
        try {
            assertEquals(expResult, result);
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }

    /**
     * тестування методу checkForPalindrome з класу PalindromeChecker
     */
    @Test
    public void checkForPalindrome_isQwertrewqPalindrome_trueReturned() {
        String inputString = "Qwertrewq";
        boolean expResult = true;
        
        boolean result = PalindromeChecker.checkForPalindrome(inputString);
        
        try {
            assertEquals(expResult, result);
        } catch (AssertionError e) {
            fail(e.getMessage());
        }
    }
    
}
