/*
Kürşad Güzelkaya
ATM machine
Fall 2020
*/

class Account {
    int accountNumber, password;
    double balance = 0;
    boolean loggedIn = false;

    // contructor 
    public Account(int accountNumber, int password){
        this.accountNumber = accountNumber;
        this.password = password;

    }

    // if old password is correct then replace password with new one
    public void changePassword(int newPassword, int oldPassword){
        if(oldPassword == password){
            this.password = newPassword;
        }
    }

    // if log in make the account looged in
    public void makeLoggedIn(){
        this.loggedIn = true;
    }

    // if log out make the account logged out
    public void makeLoggedOut(){
        this.loggedIn = false;
    }

    // return the money in the balance
    public String showBalance(){
        return "The amount of money in your balance is $"+ String.valueOf(balance);
    }

    public static void main(String[] args) {
        Account newAccount = new Account(21902103, 1234);
        System.out.println(newAccount.password);
        newAccount.changePassword(4321, 1234);
        System.out.println(newAccount.password);
        System.out.println(newAccount.loggedIn);
        newAccount.makeLoggedIn();
        System.out.println(newAccount.loggedIn);
        System.out.println(newAccount.balance);
        System.out.println(newAccount.showBalance());






    }
    

    
}
