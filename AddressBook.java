
import java.util.*;

public class AddressBook {
	private ArrayList<ContactDetails> contactList = new ArrayList<>();

	public ArrayList<ContactDetails> getAddContactDetails() {
		return contactList;
	}

	public void contactList(ContactDetails cd){
		contactList.add(cd);
	}
	
	public ArrayList<ContactDetails> viewAddedContact() {
		ArrayList<ContactDetails> viewContactDetail = new ArrayList<>();
		for(int i = 0; i < contactList.size(); i++) {
			viewContactDetail.add(contactList.get(i));
		}
		return viewContactDetail;
	}

}