/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.Person;
import Entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jbakke
 */
public class ContactInfo {
    private String fName;
    private String lName;
    private String email;
    private List<PhoneMessage> phoneList;
    private String street;
    private String additionalInfo;
    private Long zip;
    private String city;

    public ContactInfo(Person p) {
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.email = p.getEmail();
        this.phoneList = new ArrayList<PhoneMessage>();
        for(Phone phone : p.getPhones()){
            this.phoneList.add(new PhoneMessage(phone));
        }
        this.street = p.getAddress().getStreet();
        this.additionalInfo = p.getAddress().getAdditionalInfo();
        this.zip = p.getAddress().getCityInfo().getZipCode();
        this.city = p.getAddress().getCityInfo().getCity();
    }
    
    
}
