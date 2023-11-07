package test;

public class Intern {
    private String civilValue;
    private String lastName;
    private String firstName ;
    private String address ;
    private String birthDate;
    private String birthCountry;
    private String birthCity ;
    private String company;
    private String email;
    private String phone;
    private String lastNameAr;

    public Intern(String civilValue, String lastName, String firstName, String address, String birthDate, String birthCountry, String birthCity, String company, String email, String phone, String lastNameAr, String firstNameAr, String birthCityAr) {
        this.civilValue = civilValue;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.birthDate = birthDate;
        this.birthCountry = birthCountry;
        this.birthCity = birthCity;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.lastNameAr = lastNameAr;
        this.firstNameAr = firstNameAr;
        this.birthCityAr = birthCityAr;
    }

    public String getCivilValue() {
        return civilValue;
    }

    public void setCivilValue(String civilValue) {
        this.civilValue = civilValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }

    public String getFirstNameAr() {
        return firstNameAr;
    }

    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public String getBirthCityAr() {
        return birthCityAr;
    }

    public void setBirthCityAr(String birthCityAr) {
        this.birthCityAr = birthCityAr;
    }

    private String firstNameAr ;
    private String birthCityAr;
}

