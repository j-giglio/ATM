public class MailingAddress {
    java.lang.String primaryStreet = "";
    java.lang.String secondaryStreet = "";
    java.lang.String city = "";
    java.lang.String state = "";
    java.lang.String postalCode = "";
    final java.lang.String[] STATES = {
        "Alabama" ,
        "Alaska" ,
        "Arizona" ,
        "Arkansas" ,
        "California" ,
        "Colorado" ,
        "Connecticut" ,
        "Delaware" ,
        "Florida" ,
        "Georgia" ,
        "Hawaii" ,
        "Idaho" ,
        "Illinois" ,
        "Indiana" ,
        "Iowa" ,
        "Kansas" ,
        "Kentucky" ,
        "Louisiana" ,
        "Maine" ,
        "Maryland" ,
        "Massachusetts" ,
        "Michigan" ,
        "Minnesota" ,
        "Mississippi" ,
        "Missouri" ,
        "Montana" ,
        "Nebraska" ,
        "Nevada" ,
        "New Hampshire" ,
        "New Jersey" ,
        "New Mexico" ,
        "New York" ,
        "North Carolina" ,
        "North Dakota" ,
        "Ohio" ,
        "Oklahoma" ,
        "Oregon" ,
        "Pennsylvania" ,
        "Rhode Island" ,
        "South Carolina" ,
        "South Dakota" ,
        "Tennessee" ,
        "Texas" ,
        "Utah" ,
        "Vermont" ,
        "Virginia" ,
        "Washington" ,
        "West Virginia" ,
        "Wisconsin",
        "Wyoming"};
    final java.lang.String[] ABBREVIATIONS = {
        "AK",
        "AL",
        "AR",
        "AZ",
        "CA",
        "CO",
        "CT",
        "DE",
        "FL",
        "GA",
        "HI",
        "IA",
        "ID",
        "IL",
        "IN",
        "KS",
        "KY",
        "LA",
        "MA",
        "MD",
        "ME",
        "MI",
        "MN",
        "MO",
        "MS",
        "MT",
        "NC",
        "ND",
        "NE",
        "NH",
        "NJ",
        "NM",
        "NV",
        "NY",
        "OH",
        "OK",
        "OR",
        "PA",
        "RI",
        "SC",
        "SD",
        "TN",
        "TX",
        "UT",
        "VA",
        "VT",
        "WA",
        "WI",
        "WV",
        "WY"};

    public MailingAddress(java.lang.String primaryStreet,
                          java.lang.String secondaryStreet,
                          java.lang.String city,
                          java.lang.String state,
                          java.lang.String postalCode) {
        this.primaryStreet = validateStreet(primaryStreet);
        this.secondaryStreet = validateStreet(secondaryStreet);
        this.city = validateCity(city);
        this.state = validateState(state);
        this.postalCode = validatePostalCode(postalCode);
    }

    public java.lang.String getFormattedAddress() {
        if (validateStreet(primaryStreet) != null &&
            validateState(state) != null &&
            validateCity(city) != null &&
            validatePostalCode(postalCode) != null)
        {
            String address = primaryStreet.concat("\n");
            if (validateStreet(secondaryStreet) != null){
                address = address.concat(secondaryStreet + "\n");
            }
            return address.concat(city).concat(", ").concat(state).concat(" ").concat(postalCode);
        } else {
            return "N/A";
        }
    }

    public java.lang.String validateStreet(java.lang.String street) {
        if (street != null && street.length() > 0) {
            return street;
        } else {
            return null;
        }
    }

    public java.lang.String validateCity(java.lang.String city) {
        if (city != null && city.length() > 0) {
            return city;
        } else {
            return null;
        }
    }

    public java.lang.String validateState(java.lang.String state) {
        for (int i = 0; state != null && i < STATES.length; i++) {
            if (state.equals(STATES[i]) || state.equals(ABBREVIATIONS[i])) {
                return ABBREVIATIONS[i];
            }
        }
        return null;
    }

    public java.lang.String validatePostalCode(java.lang.String postalCode) {
        if (postalCode != null && postalCode.length() == 5) {
            return postalCode;
        } else {
            return null;
        }
    }

    public java.lang.String getPrimaryStreet() {
        return primaryStreet;
    }

    public void setPrimaryStreet(java.lang.String primaryStreet) {
        this.primaryStreet = primaryStreet;
    }

    public java.lang.String getSecondaryStreet() {
        return secondaryStreet;
    }

    public void setSecondaryStreet(java.lang.String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }

    public java.lang.String getState() {
        return state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(java.lang.String postalCode) {
        this.postalCode = postalCode;
    }
}
