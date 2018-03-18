/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.Address;

/**
 *
 * @author Jbakke
 */
public class AddressMessage implements JSONMessage<Address>{
    
    private Long id;
    private String street;
    private String additionalInfo;
    private CityInfoMessage cityInfoMessage;

    public AddressMessage(Long id, String street, String additionalInfo) {
        this.id = id;
        this.street = street;
        this.additionalInfo = additionalInfo;
    }
    
    public AddressMessage(Address a){
        this.id = a.getId();
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        this.cityInfoMessage = new CityInfoMessage(a.getCityInfo());
    }

    @Override
    public Address toInternal() {
        Address address = new Address(street, additionalInfo);
        address.setCityInfo(cityInfoMessage.toInternal());
        return address;
    }
    
}
