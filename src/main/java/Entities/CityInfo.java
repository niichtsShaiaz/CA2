/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Shxnna
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zip;
    private String city;
    
    
    @OneToMany(mappedBy = "cityInfo")
    private List<Address> addresses;

    public long getZip() {
        return zip;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    
    public long getZipCode() {
        return zip;
    }

    public void setZipCode(long zipCode) {
        this.zip = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CityInfo(long zipCode, String city) {
        this.zip = zipCode;
        this.city = city;
    }

    public CityInfo() {
    }
}
