import com.thoughtworks.step.Account;
import com.thoughtworks.step.AccountNumber;
import com.thoughtworks.step.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {

    @Test(expected = InvalidAccountNumberException.class)
    public void checkingIfAccountNUmberIsInvalid() throws Exception {
        new AccountNumber("teja_1234");
    }
}
