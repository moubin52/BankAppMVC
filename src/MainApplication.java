import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountModel accountModel = new AccountModel();
        AccountView accountView = new AccountView();
        AccountController accountController = new AccountController(accountModel, accountView);

        int choice;

        do {
            accountView.displayMainMenu();

            while (!scanner.hasNextInt()) {
                accountView.displayMessage("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    accountController.createAccount();
                     break;
                case 2:
                    accountView.displayAccounts(accountModel.getAccounts());
                    break;
                case 3:
                    accountController.transactionMenu();
                    break;
                case 4:
                    accountView.displayMessage("Exiting...");
                    break;
                default:
                    accountView.displayMessage("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close(); 
    }
}
