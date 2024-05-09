import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount bankAccount;
    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount("Tom", "Peace", 1999, 11, 29, 123456, "Savings");
    }


//    Test the getters:
    @Test
    public void canReturnFirstName(){
        String result = bankAccount.getFirstName();
        assertThat(result).isEqualTo("Tom");
    }
    @Test
    public void canReturnLastName(){
        String result = bankAccount.getLastName();
        assertThat(result).isEqualTo("Peace");
    }
    @Test
    public void canReturnDateOfBirth(){
        LocalDate result = bankAccount.getDateOfBirth();
        assertThat(result).isEqualTo("1999-11-29");
    }
    @Test
    public void canReturnBalance(){
        double result = bankAccount.getBalance();
        assertThat(result).isEqualTo(0);
    }
    @Test
    public void canReturnAccountType(){
        String result = bankAccount.getAccountType();
        assertThat(result).isEqualTo("Savings");
    }


    //Testing the setters:
    @Test
    public void canChangeFirstName(){
        bankAccount.setFirstName("John");
        String newFirstName = bankAccount.getFirstName();
        assertThat(newFirstName).isEqualTo("John");
    }
    @Test
    public void canChangeLastName(){
        bankAccount.setLastName("Doe");
        String newLastName = bankAccount.getLastName();
        assertThat(newLastName).isEqualTo("Doe");
    }
    @Test
    public void canChangeDateOfBirth(){
        bankAccount.setDateOfBirth(1900, 01, 01);
        LocalDate newDOB = bankAccount.getDateOfBirth();
        assertThat(newDOB).isEqualTo("1900-01-01");
    }
    @Test
    public void canChangeAccountNumber(){
        bankAccount.setAccountNumber(999999);
        int newAccountNumber = bankAccount.getAccountNumber();
        assertThat(newAccountNumber).isEqualTo(999999);
    }
    @Test
    public void canDeposit(){
        bankAccount.deposit(100000);
        double newBalance = bankAccount.getBalance();
        assertThat(newBalance).isEqualTo(100000);
    }
    @Test
    public void canWithdraw(){
        bankAccount.deposit(100000);
        bankAccount.withdraw(60000);
        double newBalance = bankAccount.getBalance();
        assertThat(newBalance).isEqualTo(40000);
    }
    @Test
    public void canWithdrawBeyondOverdraft(){
        bankAccount.withdraw(300);
        double newBalance = bankAccount.getBalance();
        assertThat(newBalance).isEqualTo(0);
    }
    @Test
    public void canChangeAccountType(){
        bankAccount.setAccountType("Current");
        String newAccountType = bankAccount.getAccountType();
        assertThat(newAccountType).isEqualTo("Current");
    }

//    Test the methods:
    @Test
    public void canPayInterestSavingsAccount(){
        bankAccount.deposit(100000);
        bankAccount.setAccountType("Savings");
        bankAccount.payInterest();
        double newBalance = bankAccount.getBalance();
        assertThat(newBalance).isEqualTo(100000*1.06);
    }
    @Test
    public void canPayInterestCurrentAccount() {
        bankAccount.deposit(100000);
        bankAccount.setAccountType("Current");
        bankAccount.payInterest();
        double newBalance = bankAccount.getBalance();
        assertThat(newBalance).isEqualTo(100000*1.02);
    }

}
