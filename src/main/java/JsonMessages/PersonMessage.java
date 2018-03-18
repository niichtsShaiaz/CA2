/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.Address;
import Entities.Hobby;
import Entities.Person;
import Entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jbakke
 */
public class PersonMessage implements JSONMessage<Person>{
    private long id;
    private String fName;
    private String lName;
    private String email;
    private AddressMessage address;
    private List<PhoneMessage> phoneNumbers;
    private List<Hobby> hobbys;

    public PersonMessage(long id, String fName, String lName, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        //this.address = address;
    }
    
    public PersonMessage(Person p){
        this.id = p.getId();
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.email = p.getEmail();
        this.phoneNumbers = new ArrayList<PhoneMessage>();
        this.address = new AddressMessage(p.getAddress());
        for(int i = 0; i < p.getPhones().size(); i++){
            this.phoneNumbers.add(new PhoneMessage(p.getPhones().get(i)));
        }
        this.hobbys = p.getHobbys();
    }

    @Override
    public Person toInternal() {
        Person person = new Person(fName, lName);
        person.setAddress(address.toInternal());
        person.setId(id);
        return person;
    }
}
