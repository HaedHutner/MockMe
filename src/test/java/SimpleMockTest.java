import com.mockme.MockMe;
import model.ComplexModel;
import org.junit.Test;

public class SimpleMockTest {

    @Test
    public void testMockAnnotated() {
        ComplexModel model = MockMe.mockAnnotated(ComplexModel.class);
        System.out.println(model.toString());
    }

}
