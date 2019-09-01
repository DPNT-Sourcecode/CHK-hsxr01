package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkout;

    @Before
    public void setUp() {
        checkout = new CheckoutSolution();
    }

    @Test
    public void emptyTest() {
        assertThat(checkout.checkout(""), equalTo(0));
    }

    @Test
    public void singleItemATest() {
        assertThat(checkout.checkout("A"), equalTo(50));
    }
}
