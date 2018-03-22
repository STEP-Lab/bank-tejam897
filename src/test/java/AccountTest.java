import com.thoughtworks.step.Account;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    @Test
    public void getBal() {
     Account teja = new Account("teja",1000);
     assertThat(teja.getBal(),is(1000));
    }

    @Test
    public void credit() {
        Account teja = new Account("teja",1000);
        assertThat(teja.credit(1000),is(2000));
    }

    @Test
    public void debit() {
        Account teja = new Account("teja",1000);
        assertThat(teja.debit(1000),is(0));
    }
}