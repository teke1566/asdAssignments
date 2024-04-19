import edu.miu.cs489.ArrayFlattenerService;
import edu.miu.cs489.ArrayReversor;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class ArrayReversorTest {

    @Test
    public void testReverseArrayWithLegitInput() {
        int[][] inputArray = {{1, 3}, {0}, {4, 5, 9}};
        ArrayFlattenerService arrayFlattenerServiceMock = mock(ArrayFlattenerService.class);
        when(arrayFlattenerServiceMock.flattenArray(inputArray)).thenReturn(new int[]{1, 3, 0, 4, 5, 9});

        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerServiceMock);
        int[] reversedArray = arrayReversor.reverseArray(inputArray);

        int[] expectedArray = {9, 5, 4, 0, 3, 1};
        assertArrayEquals(expectedArray, reversedArray);
        verify(arrayFlattenerServiceMock, times(1)).flattenArray(inputArray);
    }

    @Test
    public void testReverseArrayWithNullInput() {
        ArrayFlattenerService arrayFlattenerServiceMock = mock(ArrayFlattenerService.class);
        when(arrayFlattenerServiceMock.flattenArray(null)).thenReturn(new int[0]);

        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerServiceMock);
        int[] reversedArray = arrayReversor.reverseArray(null);

        int[] expectedArray = {};
        assertArrayEquals(expectedArray, reversedArray);
        verify(arrayFlattenerServiceMock, times(1)).flattenArray(null);
    }
}
