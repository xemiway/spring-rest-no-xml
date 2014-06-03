package org.finance.app.core.domain.common;

import org.finance.app.ddd.annotation.ValueObject;

/**
 * Created by maciek on 02.06.14.
 */
@ValueObject
public class Client {

    private String firstName;

    private String LastName;

    private String address;

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
