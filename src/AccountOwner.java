public class AccountOwner {
    String salutation;
    String firstName;
    String lastName;
    String emailAddress;
    long phoneNumber;
    MailingAddress mailingAddress;

    public AccountOwner(java.lang.String salutation,
                         java.lang.String firstName,
                         java.lang.String lastName,
                         java.lang.String emailAddress,
                         long phoneNumber,
                         MailingAddress mailingAddress) {
        this.salutation = validateSalutation(salutation);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = validateEmailAddress(emailAddress);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.mailingAddress = mailingAddress;
    }

    public java.lang.String getName(int format) {
        if (format == ATM.DEFAULT) {
            return firstName.concat(" ").concat(lastName);
        } else if (format == ATM.FORMAL && salutation != null) {
            return salutation.concat(". ").concat(lastName);
        } else if (format == ATM.SORTABLE) {
            return lastName.concat(", ").concat(firstName);
        } else {
            return firstName.concat(" ").concat(lastName);
        }
    }

    public java.lang.String getFormattedPhoneNumber() {
        if (phoneNumber != 0) {
            String num = Long.toString(phoneNumber);
            return "(".concat(num.substring(0, 3)).concat(")").concat(num.substring(3, 6)).concat("-").concat(num.substring(6));
        } else {
            return null;
        }
    }

    public java.lang.String validateSalutation(java.lang.String salutation) {
        if (salutation != null && !salutation.isEmpty()){
            return salutation;
        } else {
            return null;
        }
    }

    public java.lang.String validateEmailAddress(java.lang.String emailAddress) {
        if (emailAddress != null &&
            emailAddress.length() >= 7 &&
            emailAddress.length() <= 256 &&
            emailAddress.contains("@") &&
            emailAddress.contains(".") &&
            emailAddress.lastIndexOf("@") >= 2 &&
            emailAddress.lastIndexOf(".") == emailAddress.length() - 4)
        {
            return emailAddress;
        } else {
            return null;
        }
    }

    public long validatePhoneNumber(long phoneNumber) {
        if (phoneNumber != 0L &&  Long.toString(phoneNumber).length() == 10) {
            return phoneNumber;
        } else {
            return 0L;
        }
    }

    public java.lang.String getSalutation() {
        return salutation;
    }

    public void setSalutation(java.lang.String salutation) {
        this.salutation = salutation;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmailAddress(){
        return emailAddress;
    }

    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
