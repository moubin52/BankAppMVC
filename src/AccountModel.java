import java.util.ArrayList;
import java.util.List;

public class AccountModel {
    private List<Account> accounts;

    public AccountModel() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // if account not found
    }
}
