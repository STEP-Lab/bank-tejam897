import com.thoughtworks.step.Account;
import com.thoughtworks.step.InsufficientFundException;
import com.thoughtworks.step.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account teja;
    @Before
    public void setUp() throws Exception {
        teja = new Account("teja", 1000);
    }

    @Test
    public void getBal() {
     assertThat(teja.getBal(),is(1000.0F));
    }

    @Test
    public void credit() {
        assertThat(teja.credit(1000),is(2000.0F));
    }

    @Test
    public void debit() throws InsufficientFundException {
        assertThat(teja.debit(1000),is(0.0F));
    }

    @Test(expected = InsufficientFundException.class)
    public void checkingIfFundsAreInsufficientForWithdrawl() throws InsufficientFundException {
        teja.debit(1200);
    }

    @Test(expected = MinimumBalanceException.class)
    public void minimumBalanceCheckingForCreatingAccount() throws MinimumBalanceException {
        new Account("teja", 400);
    }
}