import java.util.*;

public class AddressBook {

	private ArrayList<ContactDetails> contactList = new ArrayList<>();

	public void addContact(ContactDetails cd){
		contactList.add(cd);
		System.out.println(contactList.size());
	}

	private Scanner sc = new Scanner(System.in);
public boolean editContactDetails(String contactName) {
		int flag = 1;
		if(contactList.size() > 0 && flag == 1) {
			for(int i = 0;i < contactList.size(); i++ ) {
				if(contactName.equals(contactList.get(i).getFirstName())) {
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
					switch(selectContactIndex) {
					case 1:
						contactList.get(i).setFirstName(sc.next());
						break;
					case 2:
						contactList.get(i).setLastName(sc.next());
						break;
					case 3:
						contactList.get(i).setAddress(sc.next());
						break;
					case 4:
						contactList.get(i).setCity(sc.next());
						break;
					case 5:
						contactList.get(i).setState(sc.next());
						break;
					case 6:
						contactList.get(i).setEmail(sc.next());
						break;
					case 7:
						contactList.get(i).setPhoneNumber(sc.nextInt());
						break;
					case 8:
						contactList.get(i).setZip(sc.nextInt());
						break;
					default:
						return false;

					}
				}
				else {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}

	public boolean deleteContact(String deleteContact) {
		int flag = 0;
		for(int i = 0;i < contactList.size(); i++  ) {
			if(deleteContact.equals(contactList.get(i).getFirstName())) {
				contactList.remove(0);
				flag = 1;
			}
		}
		if(flag == 1) {
			return true;
		}else
			return false;

	}

}