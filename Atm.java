import java.util.ArrayList;
import java.util.Scanner;

class Atm {
    ArrayList<Account> accounts = new ArrayList<Account>();

    //constructor which takes account list
    public Atm(ArrayList<Account> accounts){
        this.accounts = accounts;
    }

    //if the account number exist and password matches then login to account and return the index of account
    public Integer login(int accountNumber, int password){
        int index = -1;
        for(int i = 0; i<accounts.size(); i=i+1){
            Account account = accounts.get(i);
            if(account.accountNumber == accountNumber && account.password == password){
                account.makeLoggedIn();
                index = i;
                System.out.println(" ");
                System.out.println("Welcome to your account");
                System.out.println(" ");

            }
        }
        if(index == -1){
            System.out.println("Account number or password is incorrect");
        }
        return index;
    }

    // return the money in the balance
    public String viewBalance(Account myAccount){
        return myAccount.showBalance();
    }

    // withdraw the given amount of money from the balance and return new balance 
    public String withdrawFunds(Account myAccount, double withdraw){
        if(myAccount.balance >= withdraw){
            myAccount.balance = myAccount.balance - withdraw;
            return myAccount.showBalance();
        }else{
            return "You do not have enough amount of money in your balance";
        }  
    }

    // deposit the given amount of money to balance and return new balance
    public String depositFunds( Account myAccount, double deposit){
        if(deposit > 0){
            myAccount.balance = myAccount.balance + deposit; 
            return myAccount.showBalance();
        }else{
            return "Please enter a positive number";
        }
    }

    // log out from the account
    public void exit(Account myAccount){
        myAccount.makeLoggedOut();
        System.out.println("See you again :)");
    }
    
    public static void main(String[] args) {
        Account accountOne = new Account(21902103, 1234);
        Account accountSec = new Account(2222,2222);
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(accountOne);
        accounts.add(accountSec);

        Atm ziraat = new Atm(accounts);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your account number ");
        int accountNumber = scanner.nextInt();

        System.out.println("Please enter your password ");
        int password = scanner.nextInt();

        
        int index = ziraat.login(accountNumber, password);

        // log in the account if given informations are correct otherwise ask for them again
        if( index == -1){
            System.out.println("Please enter your account number ");
            accountNumber = scanner.nextInt();

            System.out.println("Please enter your password ");
            password = scanner.nextInt();
        }else{
            Account myAccount = accounts.get(index);
            while(myAccount.loggedIn){
                // print the option list
                System.out.println(" ");
                System.out.println("1 Viewing Balance");
                System.out.println("2 Withdraw Funds");
                System.out.println("3 Deposit Funds");
                System.out.println("4 Exit");
                System.out.println(" ");


                // ask for one selection
                System.out.println("Please select one option");
                int option = scanner.nextInt();

                
                if( option == 1){
                    System.out.println(ziraat.viewBalance(myAccount));
                }else if( option == 2){
                    // ask for the amount of money 
                    System.out.println("Enter the amount of money that you want to withdraw ");
                    double withdraw = scanner.nextDouble();

                    System.out.println(" ");
                    System.out.println(ziraat.withdrawFunds(myAccount, withdraw));
                    System.out.println(" ");

                }else if( option == 3){
                    // ask for the amount of money 
                    System.out.println("Enter the amount of money that you want to deposit ");
                    double deposit = scanner.nextDouble();
    
                    System.out.println(" ");
                    System.out.println(ziraat.depositFunds(myAccount, deposit));
                    System.out.println(" ");

                }else if( option == 4){
                    ziraat.exit(myAccount);
                }
            }

        }


    }
    
}
