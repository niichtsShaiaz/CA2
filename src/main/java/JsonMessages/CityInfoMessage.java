/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonMessages;

import Entities.CityInfo;

/**
 *
 * @author Jbakke
 */
public class CityInfoMessage implements JSONMessage<CityInfo>{

    private long zip;
    private String city;
    //private List<Address> addresses;

    public CityInfoMessage(CityInfo ci) {
        this.zip = ci.getZipCode();
        this.city = ci.getCity();
    }
    
    
    
    @Override
    public CityInfo toInternal() {
        CityInfo cityInfo = new CityInfo(zip, city);
        return cityInfo;
    }
    
}
