import java.util.*;

public class AddressBook {

	private ArrayList<ContactDetails> contactList = new ArrayList<>();

	public void addContact(ContactDetails cd){
		contactList.add(cd);
		System.out.println(contactList.size());
	}

	private Scanner sc = new Scanner(System.in);

	public boolean editContactDetails(String contactName) {
		int flag = 0;
		if(contactList.size() > 0) {
			flag = 1;
			if(contactName.equals(contactList.get(0).getFirstName())) {
				System.out.println("Select the index for the contact detail you want to edit \n");
				System.out.println("1 : First Name of the contact to be edited");
				System.out.println("2 : Last Name of the contact to be edited");
				System.out.println("3 : Address of the contact to be edited");
				System.out.println("4 : City of the contact to be edited");
				System.out.println("5 : State of the contact to be edited");
				System.out.println("6 : Email of the contact to be edited");
				System.out.println("7 : Phone Number of the contact to be edited");
				System.out.println("8 : Zip of the contact to be edited");

				int selectContactIndex =  sc.nextInt();
				if(selectContactIndex <= 8)
					flag = 1;
				switch(selectContactIndex) {
				case 1:
					contactList.get(0).setFirstName(sc.next());
					break;
				case 2:
					contactList.get(0).setLastName(sc.next());
					break;
				case 3:
					contactList.get(0).setAddress(sc.next());
					break;
				case 4:
					contactList.get(0).setCity(sc.next());
					break;
				case 5:
					contactList.get(0).setState(sc.next());
					break;
				case 6:
					contactList.get(0).setEmail(sc.next());
					break;
				case 7:
					contactList.get(0).setPhoneNumber(sc.nextInt());
					break;
				case 8:
					contactList.get(0).setZip(sc.nextInt());
					break;

				}
			}
			
		}
		if(flag == 1)
			return true;
		else
			return false;
	}


}