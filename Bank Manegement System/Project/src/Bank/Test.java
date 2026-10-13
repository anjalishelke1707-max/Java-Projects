package Bank;
import java.time.LocalTime;
import java.util.Date;

abstract class Account {
    int accountNo;
    String customerName;
    double balance;
    String accType;
    String phoneNumber;
    String email;
    String address;
    Date openingDate;
    String branchName;
    String ifScCode;
    String status;

    Transaction[] trans = new Transaction[100];
    int transactionCount;

    Account(int accountNo, String customerName, double balance, String accType,
            String phoneNumber, String email, String address, Date openingDate,
            String branchName, String ifScCode, String status) {

        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
        this.accType = accType;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.openingDate = openingDate;
        this.branchName = branchName;
        this.ifScCode = ifScCode;
        this.status = status;
    }

    int getAccountNo() {
        return accountNo;
    }

    void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    String getCustomerName() {
        return customerName;
    }

    void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    String getAccType() {
        return accType;
    }

    void setAccType(String accType) {
        this.accType = accType;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    Date getOpeningDate() {
        return openingDate;
    }

    void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    String getBranchName() {
        return branchName;
    }

    void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    String getIfScCode() {
        return ifScCode;
    }

    void setIfScCode(String ifScCode) {
        this.ifScCode = ifScCode;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    Transaction[] getTrans() {
        return trans;
    }

    void setTrans(Transaction[] trans) {
        this.trans = trans;
    }

    int getTransactionCount() {
        return transactionCount;
    }

    void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

 
    void deposite(double amount) {

        if (amount > 0) {

            balance = balance + amount;

            Transaction t = new Transaction(transactionCount + 1, accountNo,"Deposit",amount, new Date(), LocalTime.now(),"Online","REF" + (transactionCount + 1),balance,"Amount Deposited","success");

            addTransaction(t);

            System.out.println("Amount Deposited Successfully");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    
    void withdraw(double amount) {

        if (amount > 0 && balance >= amount) {

            balance = balance - amount;

            Transaction t = new Transaction( transactionCount + 1,accountNo, "Withdraw",amount,new Date(),LocalTime.now(),"Online","REF" + (transactionCount + 1), balance, "Amount Withdraw","success");

            addTransaction(t);

            System.out.println("Amount Withdraw Successfully");

        } else {
            System.out.println("Insufficient Balance");
        }
    }

    abstract void interestRate();

    void display() {

        System.out.println("Account Number is: " + accountNo);
        System.out.println("Customer Name is: " + customerName);
        System.out.println("Balance is: " + balance);
        System.out.println("Account Type is: " + accType);
        System.out.println("Phone Number is: " + phoneNumber);
        System.out.println("Email is: " + email);
        System.out.println("Address is: " + address);
        System.out.println("Opening Date is: " + openingDate);
        System.out.println("Branch Name is: " + branchName);
        System.out.println("IFSC Code: " + ifScCode);
        System.out.println("Status is: " + status);

        System.out.println("\n----- Transactions -----");

        for (int i = 0; i < transactionCount; i++) {
            trans[i].transactionDisplay();
            System.out.println();
        }
    }

    void addTransaction(Transaction t) {

        if (transactionCount < trans.length) {

            
            t.balanceAfterTransaction = this.balance;

            trans[transactionCount] = t;
            transactionCount++;

        } else {
            System.out.println("Transaction limit reached");
        }
    }

    void getTransaction() {

        for (int i = 0; i < transactionCount; i++) {
            trans[i].transactionDisplay();
            System.out.println();
        }
    }

    void updateContactDeatils(String phone, String email) {

        this.phoneNumber = phone;
        this.email = email;

        System.out.println("Details are updated Successfully..");
    }

    void closeAccount() {

        this.status = "Close";

        System.out.println("Account Closed !!!");
    }
}


class SavingAccount extends Account {

    double minimumBal;
    double interestRate;
    double withdrawLimit;
    String debitCardNumber;
    String nomineeName;
    boolean autoSweepEnabled;

    SavingAccount(int accountNo, String customerName, double balance,
                  String accType, String phoneNumber, String email,
                  String address, Date openingDate, String branchName,
                  String ifScCode, String status, double minimumBal,
                  double interestRate, double withdrawLimit,
                  String debitCardNumber, String nomineeName,
                  boolean autoSweepEnabled) {

        super(accountNo, customerName, balance, accType, phoneNumber,
                email, address, openingDate, branchName, ifScCode, status);

        this.minimumBal = minimumBal;
        this.interestRate = interestRate;
        this.withdrawLimit = withdrawLimit;
        this.debitCardNumber = debitCardNumber;
        this.nomineeName = nomineeName;
        this.autoSweepEnabled = autoSweepEnabled;
    }

    double getMinimumBal() {
        return minimumBal;
    }

    void setMinimumBal(double minimumBal) {
        this.minimumBal = minimumBal;
    }

    double getInterestRate() {
        return interestRate;
    }

    void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    double getWithdrawLimit() {
        return withdrawLimit;
    }

    void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    String getDebitCardNumber() {
        return debitCardNumber;
    }

    void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    String getNomineeName() {
        return nomineeName;
    }

    void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    boolean isAutoSweepEnabled() {
        return autoSweepEnabled;
    }

    void setAutoSweepEnabled(boolean autoSweepEnabled) {
        this.autoSweepEnabled = autoSweepEnabled;
    }

   
    @Override
    void withdraw(double amount) {

        if (amount > 0 && balance - amount >= minimumBal) {

            balance = balance - amount;

            Transaction t = new Transaction(transactionCount + 1, accountNo,"Withdraw", amount, new Date(),LocalTime.now() , "Online","REF" + (transactionCount + 1), balance,"Cash Withdraw","success");

            addTransaction(t);

            System.out.println("Amount Withdraw Successfully");

        } else {

            System.out.println("Minimum Balance Is Not Maintained");
        }
    }

    void display() {

        super.display();

        System.out.println("Minimum balance is: " + minimumBal);
        System.out.println("Interest rate is: " + interestRate);
        System.out.println("Withdraw limit is: " + withdrawLimit);
        System.out.println("Debit card number is: " + debitCardNumber);
        System.out.println("Nominee name is: " + nomineeName);
        System.out.println("Auto sweep enabled: " + autoSweepEnabled);
    }

    void autoSweep() {
        autoSweepEnabled = true;
    }

    boolean checkMinimumBalance() {

        return balance >= minimumBal;
    }

    @Override 
    void interestRate() {

        double interest = balance * interestRate / 100;

        System.out.println("Saving account interest: " + interest);
    }
}//SavingAccount class ends here



class SalaryAccount extends Account {

    Date lastTransactionDate;
    boolean isFrozen;
    String employeeName;
    String employeeId;
    double monthlySalary;
    int salaryCreditDate;
    String companyAccountNo;
    String salaryStatus;
    
	SalaryAccount(int accountNo, String customerName, double balance, String accType, String phoneNumber, String email,
			String address, Date openingDate, String branchName, String ifScCode, String status,
			Date lastTransactionDate, boolean isFrozen, String employeeName, String employeeId, double monthlySalary,
			int salaryCreditDate, String companyAccountNo, String salaryStatus) {
		super(accountNo, customerName, balance, accType, phoneNumber, email, address, openingDate, branchName, ifScCode,
				status);
		this.lastTransactionDate = lastTransactionDate;
		this.isFrozen = isFrozen;
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.monthlySalary = monthlySalary;
		this.salaryCreditDate = salaryCreditDate;
		this.companyAccountNo = companyAccountNo;
		this.salaryStatus = salaryStatus;
	}

	Date getLastTransactionDate() {
		return lastTransactionDate;
	}

	void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	boolean isFrozen() {
		return isFrozen;
	}

	void setFrozen(boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	String getEmployeeName() {
		return employeeName;
	}

	void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	String getEmployeeId() {
		return employeeId;
	}

	void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	double getMonthlySalary() {
		return monthlySalary;
	}

	void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	int getSalaryCreditDate() {
		return salaryCreditDate;
	}

	void setSalaryCreditDate(int salaryCreditDate) {
		this.salaryCreditDate = salaryCreditDate;
	}

	String getCompanyAccountNo() {
		return companyAccountNo;
	}

	void setCompanyAccountNo(String companyAccountNo) {
		this.companyAccountNo = companyAccountNo;
	}

	String getSalaryStatus() {
		return salaryStatus;
	}

	void setSalaryStatus(String salaryStatus) {
		this.salaryStatus = salaryStatus;
	}
	@Override
    public void withdraw(double amount) {

        if (isFrozen) {

            System.out.println("Account is Frozen.");

        } else if (amount > 0 && balance >= amount) {

            balance = balance - amount;

            lastTransactionDate = new Date();

            System.out.println("Amount Withdrawn : " + amount);
            System.out.println("Current Balance : " + balance);

        } else {

            System.out.println("Insufficient Balance.");
        }
    }
	
	@Override
    public void interestRate() { 

        double interest = balance * 2.5 / 100;

        System.out.println("Salary Account Interest : " + interest);
    }
	@Override
    public void display() {

        super.display();

        System.out.println("Last Transaction Date : "
                + lastTransactionDate);

        System.out.println("Account Frozen : " + isFrozen);

        System.out.println("Employee Name : " + employeeName);

        System.out.println("Employee ID : " + employeeId);

        System.out.println("Monthly Salary : " + monthlySalary);

        System.out.println("Salary Credit Date : " + salaryCreditDate);

        System.out.println("Company Account No : " + companyAccountNo);

        System.out.println("Salary Status : " + salaryStatus);
    }
	void checkAndFreezeAccount() {

        if (lastTransactionDate != null) {

            long difference =
                    new Date().getTime()
                    - lastTransactionDate.getTime();

            long days =
                    difference / (1000 * 60 * 60 * 24);

            if (days > 90) {

                isFrozen = true;

                System.out.println(
                        "Account Frozen due to inactivity.");

            } else {

                System.out.println("Account is Active.");
            }
        }
    }
	void notifyAccountHolder() {

        System.out.println(
                "Notification sent to : " + employeeName);
    }
	void creditSalary() {

        if (isFrozen) {

            System.out.println(
                    "Account is Frozen. Salary cannot be credited.");

        } else if (monthlySalary > 0) {

            balance = balance + monthlySalary;

            lastTransactionDate = new Date();

            salaryStatus = "Credited";

            System.out.println("Salary Credited Successfully.");
            System.out.println("Salary Amount : " + monthlySalary);
            System.out.println("Current Balance : " + balance);

        } else {

            salaryStatus = "Failed";

            System.out.println("Salary Credit Failed.");
        }
    }
	boolean verifySalaryCredit() {

        if (monthlySalary > 0 &&
                salaryStatus != null &&
                salaryStatus.equalsIgnoreCase("Credited")) {

            return true; 

        }

        return false;
    }
}//SalaryAccount class ends here


class Transaction { 

    int transactionId;
    int accountNo;
    String transactionType;
    double amount;
    Date transactionDate;
    LocalTime transactionTime;
    String mode;
    String referenceNo;
    double balanceAfterTransaction;
    String description;
    String status;

    Transaction(int transactionId, int accountNo, String transactionType,
                double amount, Date transactionDate,
                LocalTime transactionTime, String mode,
                String referenceNo, double balanceAfterTransaction,
                String description, String status) {

        this.transactionId = transactionId;
        this.accountNo = accountNo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.mode = mode;
        this.referenceNo = referenceNo;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.description = description;
        this.status = status;
    }


    int getTransactionId() {
		return transactionId;
	}


	void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	int getAccountNo() {
		return accountNo;
	}


	void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	String getTransactionType() {
		return transactionType;
	}


	void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	double getAmount() {
		return amount;
	}


	void setAmount(double amount) {
		this.amount = amount;
	}


	Date getTransactionDate() {
		return transactionDate;
	}


	void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	LocalTime getTransactionTime() {
		return transactionTime;
	}


	void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}


	String getMode() {
		return mode;
	}


	void setMode(String mode) {
		this.mode = mode;
	}


	String getReferenceNo() {
		return referenceNo;
	}


	void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}


	double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}


	void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}


	String getDescription() {
		return description;
	}


	void setDescription(String description) {
		this.description = description;
	}


	String getStatus() {
		return status;
	}


	void setStatus(String status) {
		this.status = status;
	}


	void transactionDisplay() {

        System.out.println("Transaction id: " + transactionId);
        System.out.println("Account No: " + accountNo);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Transaction Date: " + transactionDate);
        System.out.println("Transaction Time: " + transactionTime);
        System.out.println("Mode: " + mode);
        System.out.println("Reference No: " + referenceNo);
        System.out.println("Balance After Transaction: " + balanceAfterTransaction);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
    }

    boolean validateTransaction() {

        if (amount > 0 &&accountNo > 0 && transactionType != null) {

            return true;

        } else {

            return false;
        }
    }

    void revereseTransaction() {

        if (status != null && status.equalsIgnoreCase("success")) {

            status = "reverse";

            System.out.println("Transaction reversed Successfully");

        } else {

            System.out.println("Transaction can not be reversed");
        }
    }

    void generateReceipt() {

        System.out.println("------- Transaction Receipt -------");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account No: " + accountNo);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + transactionDate);
        System.out.println("Reference No: " + referenceNo);
        System.out.println("Balance After Transaction: " + balanceAfterTransaction);
        System.out.println("Status: " + status);
        System.out.println("-----------------------------------");
    }
}


class BankBranch {

    String bankName;
    String bankCode;
    String branchName;
    String branchCode;
    String ifScCode;
    String address;
    String email;
    String phoneNumber;

    Account[] account = new Account[100];
    int accountCount;

    BankBranch(String bankName, String bankCode, String branchName,
               String branchCode, String ifScCode, String address,
               String email, String phoneNumber) {

        this.bankName = bankName;
        this.bankCode = bankCode;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.ifScCode = ifScCode;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    BankBranch(String bankName) {

        this.bankName = bankName;

        this.account = new Account[100];

        this.accountCount = 0;
    }

    void addAccount(Account a) {

        if (accountCount < account.length) {

            account[accountCount] = a;
            accountCount++;

            System.out.println("Account added successfully");

        } else {

            System.out.println("Account limit reached");
        }
    }

    Account findAccount(int accountNo) {

        for (int i = 0; i < accountCount; i++) {

            if (account[i].accountNo == accountNo) {
                return account[i];
            }
        }

        return null;
    }

    void displayAllAccount() {

        System.out.println();
        System.out.println("Bank Name: " + bankName);
        System.out.println("Bank Code: " + bankCode);
        System.out.println("Branch Name: " + branchName);
        System.out.println("Branch Code: " + branchCode);
        System.out.println("IFSC Code: " + ifScCode);
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);

        System.out.println("\n----- Accounts -----");

        for (int i = 0; i < accountCount; i++) {

            account[i].display();
        }
    }

    void closeBranch() {
        System.out.println("Branch Closed");
    }

    void openBranch() {
        System.out.println("Branch Open");
    }
}

public class Test {

	public static void main(String[] args) {
		System.out.println("Saving Account");
		Account a1 = new SavingAccount(101,"Sayali",5000,"Saving","1234567890","sayali@gmail.com","Pune", new Date(),"PuneMainBranch", "KOTAK123abc","Active", 1000,2.7,20000,"XYZqwe23","Sneha", true);

        System.out.println("========== INITIAL ACCOUNT ==========");
        a1.display();

        System.out.println("\n========== WITHDRAW ==========");

        a1.withdraw(500);

        System.out.println("Current Balance: " + a1.getBalance());

        System.out.println("\n========== DEPOSIT ==========");

        a1.deposite(1200);

        System.out.println("Current Balance: " + a1.getBalance());

        System.out.println("\n========== INTEREST ==========");

        a1.interestRate();

        System.out.println("\n========== ALL TRANSACTIONS ==========");

        a1.getTransaction();

        System.out.println("\n========== RECEIPT ==========");

        if (a1.getTransactionCount() > 0) {

            a1.getTrans()[0].generateReceipt();
        }

        System.out.println("\n========== BANK BRANCH ==========");

        BankBranch bank = new BankBranch("Kotak Mahindra Bank","ABC123","PuneBank","hub23","QWED12","Pune","sayali@gmail.com","9876543210");

        bank.addAccount(a1);
        
        bank.displayAllAccount();
        
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       
        System.out.println("Salary Account");
        Account a2 = new SalaryAccount(103,"Rahul", 60000, "Salary Account","9876543211","rahul@gmail.com", "Mumbai", new Date(),"Mumbai Branch", "SBIN0001235", "Active", new Date(), false,"Rahul Patil","EMP102",50000, 1,"COMP002", "Pending");
        
        System.out.println("========== INITIAL SALARY ACCOUNT ==========");

        a2.display(); 


        System.out.println("\n========== WITHDRAW ==========");

        a2.withdraw(500);

        System.out.println("Current Balance: " + a2.getBalance());


        System.out.println("\n========== DEPOSIT ==========");

        a2.deposite(1200);

        System.out.println("Current Balance: " + a2.getBalance());


        System.out.println("\n========== INTEREST ==========");

        a2.interestRate();


        System.out.println("\n========== CREDIT SALARY ==========");

        ((SalaryAccount) a2).creditSalary();


        System.out.println("\n========== VERIFY SALARY CREDIT ==========");

        System.out.println(
                "Salary Credit Verified : "
                + ((SalaryAccount) a2).verifySalaryCredit()
        );


        System.out.println("\n========== CHECK AND FREEZE ACCOUNT ==========");

        ((SalaryAccount) a2).checkAndFreezeAccount();


        System.out.println("\n========== NOTIFY ACCOUNT HOLDER ==========");

        ((SalaryAccount) a2).notifyAccountHolder();
        
        System.out.println("\n========== TRANSACTION HISTORY ==========");

        a2.getTransaction();


        System.out.println("\n========== BANK BRANCH ==========");

        BankBranch bank1 = new BankBranch( "Kotak Mahindra Bank", "ABC123", "PuneBank","hub23","QWED12", "Pune", "anjali@gmail.com", "9876543210");

        bank1.addAccount(a2);


        System.out.println("\n========== BANK ACCOUNTS ==========");
        
        
         bank1.displayAllAccount();

	}

}

/*
 * public Transaction(Transaction t) {
 * 
 * this.transactionId = t.transactionId; this.accountNo = t.accountNo;
 * this.transactionType = t.transactionType; this.amount = t.amount;
 * this.transactionDate = t.transactionDate; this.transactionTime =
 * t.transactionTime; this.mode = t.mode; this.referenceNo = t.referenceNo;
 * this.balanceAfterTransaction = t.balanceAfterTransaction; this.description =
 * t.description; this.status = t.status; }
 */
