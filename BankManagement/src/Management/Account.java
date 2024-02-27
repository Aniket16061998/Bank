package Management;

public class Account {
	String name;
	public int accountNumber = 454548;
    private long contact;
	private String address;
	private String pan;
	private int pin;
	private double balance;

	

	Account(String name,String address,long contact,String pan,int pin,double balance){
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.pan = pan;
		this.pin = pin;
		this.balance = balance;
		this.accountNumber = accountNumber++;
		System.out.println("\n\n```Account Created Succesfully```");
		System.out.println("``````````````````````````````````````````````");
		
		
	}
	
	
	

	// Setter Methods
	public void setName(String newName){
		this.name = newName;
	}

	public void setContact(long newContact){
		this.contact = newContact;
	}

	public void setAddress(String newAdd){
		this.address = newAdd;
	}

	public void setPan(String newPan){
		this.pan = newPan;
	}

	public void setBalance(double newBal){
		this.balance = newBal;
		
	}
	public void setPin(int pin) {
		this.pin = pin;
	}


	//Getter Methods
	public int getPin() {
		return pin;
	}

	public String getPan(){
		return this.pan;
	}

	public double getBalance(){
		return this.balance;
	}

	public String getAddress() {
		return this.address;
	} 
	
	public long getContact() {
		return this.contact;
	}
	public String getName() {
		return this.name;
		
	}

	//Display Account Details
	public void displayDetails(){
		System.out.println("\n\n\n");
		System.out.println();
		System.out.println();
		System.out.println(" ```````````` Acoount Details ```````````` ");
		System.out.println("Name         : "+this.name);
		System.out.println("Account No.  : "+this.accountNumber);
		System.out.println("Address      : "+this.address);
		System.out.println("Contact      : "+this.contact);
		System.out.println("Pan No.      : "+this.pan);
		System.out.println();
		System.out.println("``````````````````````````````````````````````");
		System.out.println("\n\n\n");
	}

	
	

}
