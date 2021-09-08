/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 05/30/2021
 */

package loancalculator;

public class BusinessLoan extends Loan{
    BusinessLoan(String loanNumber, String lastName, double loanAmount, int term, double primeRate) {
        super(loanNumber, lastName, loanAmount, term);
        super.interestRate = (primeRate / 100) + 0.01;
        super.loanType = 'B';
    }
}
