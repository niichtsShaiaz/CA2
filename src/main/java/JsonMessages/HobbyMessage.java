/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.Hobby;

/**
 *
 * @author Jbakke
 */
public class HobbyMessage implements JSONMessage<Hobby>{

    private String name;
    private String description;

    public HobbyMessage(Hobby h) {
        this.name = h.getName();
        this.description = h.getDescription();
    }
    
    
    
    @Override
    public Hobby toInternal() {
        Hobby hobby = new Hobby(name, description);
        return hobby;
    }
    
}
