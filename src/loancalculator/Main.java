/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 05/30/2021
 */

package loancalculator;
import java.util.*;

public class Main {

    private Loan[] loanDetails = new Loan[5];
    private Double totalBusinessLoans = 0.0;
    private Double totalPersonalLoans = 0.0;

    public static void main(String[] args) {
        Main loan = new Main();

        loan.getLoanDetails();
        loan.displayDetails();
    }

    public void displayDetails() {

        for (int x = 0; x < loanDetails.length; x++) {
            System.out.println(loanDetails[x].toString());

            Character type = loanDetails[x].loanType;
            if(type.equals('B')){
                totalBusinessLoans = totalBusinessLoans + loanDetails[x].loanAmount;
            } else {
                totalPersonalLoans = totalPersonalLoans + loanDetails[x].loanAmount;
            }
        }

        System.out.println();
        System.out.println("Total loaned by JPL:");
        System.out.println("Total Business Loans : " + totalBusinessLoans);
        System.out.println("Total Personal Loan : " + totalPersonalLoans);
        System.out.println("Grand Total Loans : " + (totalPersonalLoans + totalBusinessLoans));

    }

    public static String getLoanType() {
        Scanner sc = new Scanner(System.in);
        String loanType;

        System.out.print(" Is the loan for personal or business purposes? Please enter 'P' for Pesonal or 'B' for Business : ");
        loanType = sc.next();

        return loanType;
    }

    public static String getLoanNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Loan number: ");

        return sc.next();
    }

    public static String getLastName() {
        Scanner sc = new Scanner(System.in);
        String lastName;

        System.out.print(" Customer Last Name: ");
        lastName = sc.next();

        return lastName;
    }

    public static double getLoanAmount() {
        Scanner sc = new Scanner(System.in);
        double loanAmount;

        try {
            System.out.print(" Loan amount: ");
            loanAmount = sc.nextDouble();

            if (loanAmount < 0 | loanAmount > 50000 ) {
                throw (new InputMismatchException("Maximum loan amount must be $50,000."));
            }

            return loanAmount;
        } catch (InputMismatchException e) {
            System.out.print(" Invalid Loan amount: " + e.getMessage());
            return getLoanAmount();
        }
    }

    public static double getPrimeRate() {
        Scanner sc = new Scanner(System.in);
        double PrimeRate;

        System.out.print("Please enter Prime Interest Rate (%): ");
        PrimeRate = sc.nextDouble();

        return PrimeRate;
    }

    public static int getTerm() {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Loan term in years (1, 3, or 5): ");
        return sc.nextInt();
        
    }

    public void getLoanDetails() {

        String personal = "P";
        String business = "B";
        String loanType;
        String loanNumber;
        String lastName;
        double loanAmount;
        double PrimeRate;
        int term;

        PrimeRate = getPrimeRate();

        for (int x = 0; x < loanDetails.length; x++) {
            System.out.println("Please enter loan information for Customer " + (x + 1) + " below:");

            loanType = getLoanType();
            loanNumber = getLoanNumber();
            lastName = getLastName();
            loanAmount = getLoanAmount();
            term = getTerm();

            System.out.println();

            if (loanType.equals(personal)) {
                loanDetails[x] = new PersonalLoad(loanNumber, lastName,
                        loanAmount, term, PrimeRate);
            } else if (loanType.equals(business)) {
                loanDetails[x] = new BusinessLoan(loanNumber, lastName,
                        loanAmount, term, PrimeRate);
            }
        }
    }

}
