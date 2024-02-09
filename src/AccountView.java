import java.util.List;

public class AccountView {


    // display main menu options
    public void displayMainMenu() {
        System.out.println("1. Create Account");
        System.out.println("2. Display Accounts");
        System.out.println("3. Withdraw or Deposit");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
    }

    // display  transaction menu options
    public void displayTransactionMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Back to Main Menu");
        System.out.println("Enter your choice:");
    }

    // display a message to user
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // display list of accounts
    public void displayAccounts(List<Account> accounts) {
        System.out.println("All Accounts:");
        for (Account account : accounts) {
            System.out.println("------------");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("------------");
        }
    }
}
