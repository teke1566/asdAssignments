package edu.miu.cs489;

import java.util.ArrayList;
import java.util.List;

public record Contact(String firstName,String lastName,String company,String jobTitle,List<PhoneNumber> phoneNumbers,List<EmailAddress> emailAddresses) {


}
