/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.Phone;

/**
 *
 * @author Jbakke
 */
class PhoneMessage implements JSONMessage<Phone>{
    //private Long id;
    private Long number;
    private String description; 
    
    //private long personId;

    public PhoneMessage(Phone p){
        //this.id = p.getId();
        this.number = p.getNumber();
        this.description = p.getDescription();
        //this.personId = p.getPerson().getId();
    }
    
    @Override
    public Phone toInternal() {
        Phone phone = new Phone(number, description);
        return phone;
    }
    
}
