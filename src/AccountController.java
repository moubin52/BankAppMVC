import java.util.Scanner;

public class AccountController {
    private AccountModel accountModel;
    private AccountView accountView;
    private Scanner scanner;

    public AccountController(AccountModel accountModel, AccountView accountView) {
        this.accountModel = accountModel;
        this.accountView = accountView;
        this.scanner = new Scanner(System.in);
    }

    public void createAccount() {
        accountView.displayMessage("Enter account number:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); 
        accountView.displayMessage("Enter account name:");
        String accountName = scanner.nextLine();
        accountView.displayMessage("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 
        
        Account newAccount = new Account(accountNumber, accountName, initialBalance);
        accountModel.addAccount(newAccount);
        accountView.displayMessage("Account created successfully.");
    }

    public void transactionMenu() {
        int accountNumber;
        Account account;
        
        // insert account number
        accountView.displayMessage("Enter account number:");
        accountNumber = scanner.nextInt();
        scanner.nextLine(); 
        
        // find account
        account = accountModel.findAccount(accountNumber);
        
        if (account == null) {
            accountView.displayMessage("Account not found.");
            return;
        }
        
        int choice;
        do {
            accountView.displayTransactionMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (choice) {
                case 1:
                    // withdraw
                    accountView.displayMessage("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    withdraw(account, withdrawAmount);
                    break;
                case 2:
                    // deposit
                    accountView.displayMessage("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    deposit(account, depositAmount);
                    break;
                case 3:
                    // back to main menu
                    break;
                default:
                    accountView.displayMessage("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
    

    private void withdraw(Account account, double amount) {
        if (amount <= 0) {
            accountView.displayMessage("Invalid amount for withdrawal.");
            return;
        }

        if (account.getBalance() < amount) {
            accountView.displayMessage("Insufficient balance for withdrawal.");
            return;
        }

        account.setBalance(account.getBalance() - amount);
        accountView.displayMessage("Withdrawal successful. Current balance: " + account.getBalance());
    }

    private void deposit(Account account, double amount) {
        if (amount <= 0) {
            accountView.displayMessage("Invalid amount for deposit.");
            return;
        }

        account.setBalance(account.getBalance() + amount);
        accountView.displayMessage("Deposit successful. Current balance: " + account.getBalance());
    }
}
