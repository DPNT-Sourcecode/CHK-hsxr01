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
    public void invalidTest() {
        assertThat(checkout.checkout("F"), equalTo(-1));
    }

    @Test
    public void singleItemATest() {
        assertThat(checkout.checkout("A"), equalTo(50));
    }

    @Test
    public void moreThanOneItemATest() {
        assertThat(checkout.checkout("AA"), equalTo(50 + 50));
    }

    @Test
    public void ItemAOfferTest() {
        assertThat(checkout.checkout("AAA"), equalTo(50 + 50 + 50 - 150 + 130));
    }

    @Test
    public void ItemAOffer2Test() {
        assertThat(checkout.checkout("AAAAA"), equalTo(50 + 50 + 50 + 50 + 50 - 250 + 200));
    }

    @Test
    public void ItemAOffer1And2Test() {
        assertThat(checkout.checkout("AAAAAAAA"), equalTo(50 + 50 + 50 + 50 + 50 + 50 + 50 + 50 - 250 + 200 - 150 + 130));
    }

    @Test
    public void moreThanItemOfferATest() {
        assertThat(checkout.checkout("AAAA"), equalTo(50 + 50 + 50 + 50 - 150 + 130));
    }

    @Test
    public void singleItemBTest() {
        assertThat(checkout.checkout("B"), equalTo(30));
    }

    @Test
    public void ItemBOfferTest() {
        assertThat(checkout.checkout("BB"), equalTo(30 + 30 - 60 + 45));
    }

    @Test
    public void moreThanItemOfferBTest() {
        assertThat(checkout.checkout("BBB"), equalTo(30 + 30 + 30 - 60 + 45));
    }

    @Test
    public void moreThanItemOfferBAppliedMultipleTimesTest() {
        assertThat(checkout.checkout("BBBB"), equalTo(30 + 30 + 30 + 30 - 60 + 45 - 60 + 45));
    }

    @Test
    public void singleItemCTest() {
        assertThat(checkout.checkout("C"), equalTo(20));
    }

    @Test
    public void singleItemDTest() {
        assertThat(checkout.checkout("D"), equalTo(15));
    }

    @Test
    public void differentWithoutOffersTest() {
        assertThat(checkout.checkout("ABCDA"), equalTo(50 + 30 + 20 + 15 + 50));
    }

    @Test
    public void differentWithOffersTest() {
        assertThat(checkout.checkout("ABCDABA"), equalTo(50 + 30 + 20 + 15 + 50 + 30 + 50 - 150 + 130 - 60 + 45));
    }
}



