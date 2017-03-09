package complementary;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComplementaryPairSearcherTest {

    /**
     * Test of searchForComplementaryPair method, of class
     * ComplementaryPairSearcher.
     */
    @Test
    public void testSearchForComplementaryPair() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int k = 9;
        try {
            ComplementaryPairSearcher.searchForComplementaryPair(array, k);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
