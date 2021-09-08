/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 05/30/2021
 */

package loancalculator;
import java.util.InputMismatchException;

public abstract class Loan implements LoanConstants {
    private String loanNumber;
    private String lastName;
    protected double loanAmount;
    protected double interestRate;
    protected char loanType;
    private int term;

    Loan(String loanNumber, String lastName, double loanAmount, int term) {
        this.loanNumber = loanNumber;
        this.lastName = lastName;

        try {
            if(loanAmount > MAX_AMOUNT){
                throw (new InputMismatchException("Loan amount is greater than maximum allowed"));
            } else {
                this.loanAmount = loanAmount;
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }

        if(term == SHORT_TERM | term == MEDIUM_TERM | term == LONG_TERM){
            this.term = term;
        } else {
            this.term = 1;
        }

    }


    public String toString(){
        return String.format("Loan #: %s\t Last Name: %s\t Amount: $%,.2f\t Interest: %.2f%%\t Term(Years): %d\t Amount Owed: $%,.2f",
                this.loanNumber, this.lastName, this.loanAmount, this.interestRate * 100,
                this.term, this.loanAmount + ((this.loanAmount * this.interestRate) * this.term));
    }


}
