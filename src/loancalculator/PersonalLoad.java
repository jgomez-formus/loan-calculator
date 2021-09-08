/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 05/30/2021
 */

package loancalculator;

public class PersonalLoad extends Loan{
    PersonalLoad(String loanNumber, String lastName, double loanAmount, int term, double primeRate) {
        super(loanNumber, lastName, loanAmount, term);
        super.interestRate = (primeRate / 100) + 0.02;
        super.loanType = 'P';
    }
}
