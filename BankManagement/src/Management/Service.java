package Management;


import java.util.Scanner;

public class Service {

	Scanner ip = new Scanner(System.in);
	Bankdb db = new Bankdb();
	Account a;
	int accountnumber;

	public void displayMenu() throws Exception{
		System.out.println("`````` Choose Option ``````");
		System.out.println("\t 1.New User \n\t 2.Existing User \n\t 0.Exit");
		System.out.println("Enter option : ");
		

		switch(ip.nextInt()){
			case 1:{
				createAcc();
			}
			break;
			case 2:{
				displayOption();
			}
			break;
			case 0:{
				System.exit(0);
			}
			default:{
				System.out.println("Enter Correct Option! Try Again.");
			}
			break;
		}
	}
	
	public void createAcc() throws Exception {
		System.out.println("Enter Your name    : ");
		String name = ip.nextLine();
		ip.nextLine();
		
		System.out.println("Enter Your Address : ");
		
		String add = ip.nextLine();
//		ip.nextLine();
		
		System.out.println("Enter Your Contact : ");
		
		long contact = ip.nextLong();
		
		System.out.println("Enter Your Pan no. : ");
		String pan = ip.next();
		
		System.out.println("Enter Your PIN     : ");
		
		int pin = ip.nextInt();
		
		System.out.println("Enter Your Balance : ");
		
		double bal = ip.nextDouble();
		
		a = new Account(name,add,contact,pan,pin,bal);
		db.saveAcc(a);
	}

	public void displayOption() throws Exception{

		System.out.print("Enter Your Account Number : ");
		accountnumber = ip.nextInt();
		do{ 
			System.out.println("``````````````````````````````````````````````");
			System.out.println("`````` HELLO CUSTOMER ``````");
			System.out.println("Choose Option");
			System.out.println("\t 1.WITHDRAW \n\t 2.DEPOSIT \n\t 3.CHECK BALANCE \n\t 4.CHANGE PIN \n\t 5.DISPLAY DETAILS \n\t 6.UPDATE DETAILS \n\t 0.Back");
			System.out.print("Enter option : ");

			switch(ip.nextInt()){
				case 1:{
					//withdraw	
					withdraw();
					System.out.println("\n\n\n");

				}
				break;
				case 2:{
					//deposit	
					deposit();
					System.out.println("\n\n\n");
				}
				break;
				case 3:{
					//check bal	
					displayBal();
					System.out.println("\n\n\n");
				}
				break;
				case 4:{
					//change pin
					changePin();	
					System.out.println("\n\n\n");
				}
				break;
				case 5:{
					//display details
					accDetails();	
				}
				break;
				case 6:{
					//update details
					updateDetails();	
					System.out.println("\n\n\n");
				}
				break;
				case 0:{
					System.out.println("\n\n\n");
				}
				break;
				default:{
					System.out.println("Enter Correct Option! Try Again.");
					System.out.println("``````````````````````````````````````````````");
					System.out.println("\n\n\n");

				}
				break;
			}
		}
		while(ip.nextInt()!=0);
	}
	
	
	public boolean checkPin(int accountnumber) throws Exception{
		int count = 0;
		boolean ans = false;
		do{
			if(count>2){break;}
			
			System.out.print("Enter Your pin : ");
			int vpin = ip.nextInt();
			System.out.println();
			
			if(db.getPin(accountnumber) == vpin){
				ans = true;
			}
			else{
				System.out.println("\t Incorrect Pin! Try Again.");
			}
			count++;
		}
		while(ans == false);
		return ans;
	}
	
	
	public void withdraw() throws Exception {
		System.out.println("`````````````````````````WINTHDRAW`````````````````````````");
		System.out.println("Enter the Amount : ");
		double amt = ip.nextDouble();
		if(checkPin(accountnumber)) {
			double acbal = db.getBal(accountnumber);
			if(amt<acbal) {
				acbal -= amt;
				db.updateBal(acbal,accountnumber);
			}
		}
	}
	

	public void deposit() throws Exception {
		System.out.println("`````````````````````````DEPOSIT CASH`````````````````````````");
		System.out.println("Enter the Amount : ");
		double amt = ip.nextDouble();
		if(checkPin(accountnumber)) {
			double acbal = db.getBal(accountnumber);
			acbal += amt;
			db.updateBal(acbal, accountnumber);
		}
	}
	
	
	public void displayBal() throws Exception {
		System.out.println("`````````````````````````CHECKING BALANCE`````````````````````````");
		if(checkPin(accountnumber)) {
			double acbal = db.getBal(accountnumber);
			System.out.println("Account Balance : "+acbal);
		}
	}
	
	
	public void accDetails() throws Exception {
		if(checkPin(accountnumber)) {
			db.displayAcc(accountnumber);
		}
	}
	
	
	public void changePin() throws Exception {
		if(checkPin(accountnumber)) {
			System.out.print("Enter new Pin     : ");
			int pin = ip.nextInt();
			db.updatePin(pin,accountnumber);
		}	
	}
	
	
	public void updateDetails() throws Exception{
		int op;
		do{	
			System.out.println("\t Choose Option To Update");
			System.out.println("\t 1.Name \n\t 2.Adress \n\t 3.Contact \n\t 0.Back");

			System.out.print("enter you option : ");
			op = ip.nextInt();
			
			switch(op){
				case 1:{
					System.out.print("Enter Your Name : ");
					String name = ip.next();
//					ip.nextLine();
					System.out.println();
					if(checkPin(accountnumber)){
						db.updateName(name,accountnumber);
						System.out.println("\t`````` NAME UPDATED ``````");
						System.out.println("``````````````````````````````````````````````");
						System.out.println("\n\n\n");
					}
				}
				break;
				case 2:{
					System.out.print("Enter Your Address : ");
					String add = ip.next();
//					ip.next();
					System.out.println();
					if(checkPin(accountnumber)){
						db.updateAdd(add,accountnumber);
						System.out.println("\t`````` ADDRESS UPDATED ``````");
						System.out.println("``````````````````````````````````````````````");
						System.out.println("\n\n\n");
					}
				}
				break;
				case 3:{
					System.out.print("Enter Your Contact : ");
					long contact = ip.nextLong();
					// ip.nextLong();
					if(checkPin(accountnumber)){
						db.updateContact(contact, accountnumber);
						System.out.println("\t`````` CONTACT UPDATED ``````");
						System.out.println("``````````````````````````````````````````````");
						System.out.println("\n\n\n");
					}
				}
				break;
				case 0:{

				}
				break;
				default:{
					System.out.println("Enter Correct Option! Try Again.");
				}
			}
		}
		while(op!=0);	
	}

}
