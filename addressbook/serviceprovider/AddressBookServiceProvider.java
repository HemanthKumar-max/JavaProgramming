package com.bridgelabz.oops.addressbook.serviceprovider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.addressbook.model.Address;
import com.bridgelabz.oops.addressbook.model.Person;
import com.bridgelabz.oops.addressbook.repository.AddressBookRepository;
import com.bridgelabz.oops.addressbook.repository.AddressBookService;
import com.bridgelabz.oops.addressbook.utils.InputUtility;
import com.bridgelabz.oops.addressbook.utils.Utility;
import com.bridgelabz.userdefinedexception.CustomizedException;

public class AddressBookServiceProvider implements AddressBookService {

	Person person = Person.getInstance();
	Address address = Address.getInstance();

	AddressBookRepository repo = AddressBookRepository.getInstance();
	JSONArray personDetails = new JSONArray();

	JSONParser parser = new JSONParser();

	String json;

	String jsonOut;

	/**
	 * an instance method to create the new AddressBook by creating a new JSON File
	 * and adding the new person data into the JSON File
	 * 
	 * @param fileName of the NewAddressBook
	 */
	@Override
	public void createNewAddressBook(String fileName) {
//use JSON
		Utility.setFileName(fileName);
		personDetails = new JSONArray();

		repo.writeJson(personDetails, fileName);
		System.out.println("Enter Yes to add new Person :");
		if (InputUtility.readString().equalsIgnoreCase("yes")) {
			addPerson();
		} else {
			repo.writeJson(personDetails, fileName);
		}

	}

	/**
	 * an instance method to Open the Existing the AddressBook and perform
	 * Adding,Editing,Copying and Saving Operations on that File
	 * 
	 * @param fileName ->Name of the Json File which you want to open
	 */
	@Override
	public void openAddressBook(String fileName) {

		Utility.setFileName(fileName);

		String option;
		do {
			System.out.println("---------Address Book Edit Menu----------");
			System.out.println("1 : To add a New Person ");
			System.out.println("2 : To Edit Person ");
			System.out.println("3 : To Delete Person");
			System.out.println("4 : To Sort Entries by LastName");
			System.out.println("5 : To Sort Entries by Zip");
			System.out.println("6 : To print Entries in AddressBook");
			System.out.println("7 : To Exit");

			int choice = InputUtility.readInt();

			switch (choice) {

			case 1:
				addPerson();
				break;
			case 2:
				System.out.println("Enter Person's MobileNumber to edit");
				editPerson(InputUtility.readLong());
				break;
			case 3:
				System.out.println("Enter Person's MobileNumber to Delete :");
				deletePerson(InputUtility.readLong());
				break;
			case 4:
				sortEntriesByName();
				break;
			case 5:
				sortEntriesByZip();
				break;
			case 6:
				printEntries();
				break;
			case 7:
				System.out.println("Thank You");
				System.exit(0);
				break;
			}
			System.out.println("Would You like to Continue in Edit Menu (yes/no)? :");
			option = InputUtility.readString();
		} while (option.equals("yes"));
		System.out.println("Exited From AddressBook Edit Menu");
	}

	/**
	 * an instance method to add a new person details in to the Opened Addressbook
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addPerson() {

		String fileName = Utility.getFileName();

		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			setDetails();
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("firstName", person.getFirstName());
			jsonObject.put("lastName", person.getLastName());

			JSONObject addressObj = new JSONObject();
			addressObj.put("doorNo", address.getDoorNo());
			addressObj.put("streetName", address.getStreetName());
			addressObj.put("village", address.getVillage());
			jsonObject.put("address", addressObj);

			jsonObject.put("city", person.getCity());
			jsonObject.put("state", person.getState());
			jsonObject.put("zip", person.getZip());
			jsonObject.put("phoneNumber", person.getPhoneNumber());

			personDetails.add(jsonObject);

			jsonOut = personDetails.toJSONString();
			System.out.println("Do you Want Save the Details (yes/no)? :");
			if (InputUtility.readString().equalsIgnoreCase("yes")) {
				repo.writeJson(personDetails, fileName);
			}
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * an instance method to take the Person details from the User
	 */
	private void setDetails() {

		try {
			System.out.println("Enter FirstName : ");
			person.setFirstName(InputUtility.readString());
			System.out.println("Enter LastName : ");
			person.setLastName(InputUtility.readString());
			System.out.println("Enter DoorNo : ");
			address.setDoorNo(InputUtility.readString());
			System.out.println("Enter street name : ");
			address.setStreetName(InputUtility.readString());
			System.out.println("Enter Village : ");
			address.setVillage(InputUtility.readString());
			person.setAddress(address);

			System.out.println("Enter City :");
			person.setCity(InputUtility.readString());
			System.out.println("Enter State : ");
			person.setState(InputUtility.readString());
			System.out.println("Enter Zip :");
			person.setZip(InputUtility.readInt());
			System.out.println("Enter Mobile Number : ");
			person.setPhoneNumber(InputUtility.readLong());
		} catch (CustomizedException ce) {
			ce.printStackTrace();
		}
	}

	/**
	 * an instance method to Edit the person details except the person's Name we
	 * will search the person's phone number which is unique for every person and
	 * modify the data of that person by getting that Object
	 * 
	 * @param -> Mobile number of the person which user want to change details
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void editPerson(long mobileNumber) {
		String fileName = Utility.getFileName();
		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			JSONObject temp = new JSONObject();
			JSONObject removeObj = new JSONObject();
			System.out.println(personDetails);

			Iterator<?> iterator = personDetails.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				 
				long number = (long) jsonObject.get("phoneNumber");

				if (mobileNumber == number) {

					person.setFirstName((String) jsonObject.get("firstName"));
					temp.put("firstName", person.getFirstName());
					person.setLastName((String) jsonObject.get("lastName"));
					temp.put("lastName", person.getLastName());
					JSONObject addressObj = (JSONObject) jsonObject.get("address");
					System.out.println("Enter Door Number :");
					address.setDoorNo(InputUtility.readString());
					addressObj.put("doorNo", address.getDoorNo());
					System.out.println("Enter streetName :");
					address.setStreetName(InputUtility.readString());
					addressObj.put("streetName", address.getStreetName());
					System.out.println("Enter Village :");
					address.setVillage(InputUtility.readString());
					addressObj.put("village", address.getVillage());
					temp.put("address", addressObj);
					System.out.println("Enter city :");
					person.setCity(InputUtility.readString());
					temp.put("city", person.getCity());
					System.out.println("Enter state :");
					person.setState(InputUtility.readString());
					temp.put("state", person.getState());
					System.out.println("Enter zip :");
					temp.put("zip", InputUtility.readInt());
					System.out.println("Enter Phone Number :");
					person.setPhoneNumber(InputUtility.readLong());
					temp.put("phoneNumber", person.getPhoneNumber());
					removeObj = jsonObject;
					break;
				}
				else
					System.out.println("Number Not Found");
			}
			personDetails.remove(removeObj);
			personDetails.add(temp);
			jsonOut = personDetails.toJSONString();
			repo.writeJson(personDetails, fileName);
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * an instance method to delete the person's details from the AddressBook Take
	 * the person's mobile number as input and search in the AddressBook and remove
	 * that Object from the Json File
	 * 
	 * @param -> Mobile Number of the person which user want to delete the User
	 *           details
	 */
	@Override
	public void deletePerson(long mobileNumber) {

		String fileName = Utility.getFileName();
		try {
			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			JSONObject removeObj = new JSONObject();
			System.out.println(personDetails);

			Iterator<?> iterator = personDetails.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				long number = (long) jsonObject.get("phoneNumber");
				if (mobileNumber == number) {
					removeObj = jsonObject;
					break;
				}
			}
			personDetails.remove(removeObj);

			jsonOut = personDetails.toJSONString();
			repo.writeJson(personDetails, fileName);
			System.out.println("Deleted Successfully..!!!");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * an instance method to sort the entries in the AddressBook by their LastName
	 * Read data from Json file and store the objects in a arraylist and perform the
	 * sorting operation on the list by Overiding the compareTo() in Comparator
	 * interface and store the list in JsonArray and write the sorted Json Array
	 * into a Json File
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sortEntriesByName() {

		String fileName = Utility.getFileName();
		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			JSONArray jsonArray = personDetails;
			JSONArray sortedJsonArray = new JSONArray();
			List<JSONObject> list = new ArrayList<>();
			for (int i = 0; i < jsonArray.size(); i++) {
				list.add((JSONObject) jsonArray.get(i));
			}
			Collections.sort(list, new Comparator<JSONObject>() {

				@Override
				public int compare(JSONObject a, JSONObject b) {
					String str1 = (String) a.get("lastName");
					String str2 = ((String) b.get("lastName"));

					if (str1.equals(str2)) {
						str1 = (String) a.get("firstName");
						str2 = (String) b.get("firstName");
					}
					return str1.compareTo(str2);
				}
			});
			for (int i = 0; i < jsonArray.size(); i++) {
				sortedJsonArray.add((JSONObject) (list.get(i)));
			}

			jsonOut = sortedJsonArray.toJSONString();
			repo.writeJson(sortedJsonArray, fileName);
			System.out.println("Sorted Successfully By Name");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * an instance method to sort the entries in the AddressBook by their Zip Read
	 * data from Json file and store the objects in a arraylist and perform the
	 * sorting operation on the list by Overiding the compareTo() in Comparator
	 * interface and store the list in JsonArray and write the sorted Json Array
	 * into a Json File
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sortEntriesByZip() {

		String fileName = Utility.getFileName();
		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			JSONArray jsonArray = personDetails;
			JSONArray sortedJsonArray = new JSONArray();
			List<JSONObject> list = new ArrayList<>();
			for (int i = 0; i < jsonArray.size(); i++) {
				list.add((JSONObject) jsonArray.get(i));
			}
			Collections.sort(list, new Comparator<JSONObject>() {

				public int compare(JSONObject a, JSONObject b) {
					Integer str1 = ((Long) a.get("zip")).intValue();
					Integer str2 = ((Long) b.get("zip")).intValue();

					if (str1.equals(str2)) {
						String str3 = (String) a.get("firstName");
						String str4 = (String) b.get("firstName");
						return str3.compareTo(str4);
					}
					return str1.compareTo(str2);
				}
			});
			for (int i = 0; i < jsonArray.size(); i++) {
				sortedJsonArray.add((JSONObject) (list.get(i)));
			}

			jsonOut = sortedJsonArray.toJSONString();
			repo.writeJson(sortedJsonArray, fileName);
			System.out.println("Sorted Successfully By zip");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * an instance method to print the entries in the AddressBook in Mailing label
	 * format iterate over the Json array and print the details of each Object
	 */
	@Override
	public void printEntries() {

		String fileName = Utility.getFileName();
		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			if (personDetails == null)
				throw new CustomizedException("No Data In the File To Print");

			Iterator<?> iterator = personDetails.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = (JSONObject) iterator.next();
				System.out.println("-------------------------------------------------------");
				System.out.println("FirstName : " + jsonObject.get("firstName") + "\nLastName : "
						+ jsonObject.get("lastName") + "\nAddress : "
						+ (String) ((JSONObject) jsonObject.get("address")).get("doorNo") + "\n        : "
						+ (String) ((JSONObject) jsonObject.get("address")).get("streetName") + "\n        : "
						+ (String) ((JSONObject) jsonObject.get("address")).get("village") + "\nCity : "
						+ jsonObject.get("city") + "\nState : " + jsonObject.get("state") + "\nzip : "
						+  jsonObject.get("zip")+ "\nPhone Number : "
						+ jsonObject.get("phoneNumber"));
				System.out.println("-------------------------------------------------------");
			}
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * an instance method to save the details of the person' details get the Json
	 * Object and store that in the Json file
	 */
	@Override
	public void saveAddressBook() {

		String fileName = Utility.getFileName();
		try {

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);

			jsonOut = personDetails.toJSONString();
			repo.writeJson(personDetails, fileName);
			System.out.println("Saved Succesfully");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * an instance method to copy the person's details of the addressBook into a new
	 * AddressBook read the Json array of which addressBook you want to copy and
	 * save that data into a new File
	 */
	@Override
	public void saveAsAddressBook() {
		System.out.println("Enter which File to SaveAs newFile...");
		String fileName = InputUtility.readString() + ".json";
		try {
			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);
			System.out.println("Enter New FileName :");
			String newFileName = InputUtility.readString() + ".json";

			jsonOut = personDetails.toJSONString();
			repo.writeJson(personDetails, newFileName);
			System.out.println("Succesfully saved as a new File");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * an instance method to save the details of the Person details and Exit from
	 * the window
	 */
	@Override
	public void quit() {
		String fileName = Utility.getFileName();

		try {
			if (fileName == null) {
				throw new CustomizedException("You have not open any book to save");
			}

			json = repo.readJson(fileName);
			Object obj = parser.parse(json);
			personDetails = (JSONArray) obj;

//			personDetails = repo.readJson(fileName);

			jsonOut = personDetails.toJSONString();
			repo.writeJson(personDetails, fileName);
			System.out.println("successfully saved and exit ");
			System.out.println("Thank You!!!");
		} catch (CustomizedException | ParseException e) {
			e.printStackTrace();
		}

	}
}
