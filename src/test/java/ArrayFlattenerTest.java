import edu.miu.cs489.ArrayFlattener;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @Before
    public void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @Test
    public void testFlattenArrayWithLegitInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        assertArrayEquals(expectedOutput, arrayFlattener.flattenArray(inputArray));
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        int[][] inputArray = null;
        assertArrayEquals(null, arrayFlattener.flattenArray(inputArray));
    }
}

