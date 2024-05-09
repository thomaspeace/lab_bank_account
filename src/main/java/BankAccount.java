import java.time.LocalDate;

public class BankAccount {


//    Properties
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance; //using double as data type as interest will cause decimal numbers
    private String accountType;
    private double overdraft;


//    Constructor (assuming you need to provide name, DOB, account number and account type when you make an account)
    public BankAccount(String firstName, String lastName, int DOByear, int DOBmonth, int DOBday, int accountNumber, String accountType){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.of(DOByear, DOBmonth, DOBday);
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.accountType = accountType;
        this.overdraft = 250;
    }


//    Getters
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance(){
        return this.balance;
    }
    public String getAccountType(){
        return this.accountType;
    }


//    Setters (you can't change your DOB or account number)
    public void setFirstName(String inputFirstName){
        this.firstName = inputFirstName;
    }
    public void setLastName(String inputLastName){
        this.lastName = inputLastName;
    }
    public void setDateOfBirth(int inputDOByear, int inputDOBmonth, int inputDOBday){
        this.dateOfBirth = LocalDate.of(inputDOByear, inputDOBmonth, inputDOBday);
    }
    public void setAccountNumber(int inputAccountNumber){
        this.accountNumber = inputAccountNumber;
    }
    public void deposit(double depositAmount){
        this.balance += depositAmount;
    }
    public void withdraw(double withdrawAmount){
        if ((this.balance-withdrawAmount) > -this.overdraft){
            this.balance -= withdrawAmount;
        }
    }
    public void setAccountType(String inputAccountType){
        this.accountType = inputAccountType;
    }


    //Methods
    public void payInterest(){
        if (this.accountType.equals("Savings")) {
            this.balance += (this.balance)*0.06;
        } else if (this.accountType.equals("Current")) {
            this.balance += (this.balance)*0.02;
        }
    }
}
