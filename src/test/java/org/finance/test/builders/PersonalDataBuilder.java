package org.finance.test.builders;

import org.finance.app.sharedcore.objects.Client;
import org.joda.time.DateTime;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PersonalDataBuilder {

    private Long clientId;

    private String firstName;

    private String lastName;

    private String address;

    private DateTime dateOfBirth;

    private SecureRandom random = new SecureRandom();

    public PersonalDataBuilder withClientId(Long id){
        this.clientId = id;
        return this;
    }

    public PersonalDataBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public PersonalDataBuilder withCorrectlyFilledData(){
        return new PersonalDataBuilder("Jan", "Kowalski", "Lesnej polanki 1", new DateTime().minusYears(30));
    }

    public PersonalDataBuilder withDefaultData(){
        return new PersonalDataBuilder("Michal", "Grochowski", "Marymoncka 1500", new DateTime().minusYears(30));
    }

    public Client build(){
        return new Client(clientId, firstName, lastName, address);
    }

    public PersonalDataBuilder(String firstName, String lastName, String address, DateTime dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonalDataBuilder withUniqueData(){
        String uniqueName = "Michal".concat(new BigInteger(130, random).toString(32));
        String uniqueLastName = "Grochowski".concat(new BigInteger(130, random).toString(32));
        String uniqueStreetName = "Marymoncka ".concat(new BigInteger(130, random).toString(32));

        return new PersonalDataBuilder(uniqueName, uniqueLastName , uniqueStreetName, new DateTime().minusYears(30));
    }

    public PersonalDataBuilder(){

    }
}
