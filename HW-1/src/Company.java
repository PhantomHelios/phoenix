public class Company {
    static class Address{
        String street, no, town, city, country;

        public Address(String street, String no, String town, String city, String country) {
            this.street = street;
            this.no = no;
            this.town = town;
            this.city = city;
            this.country = country;
        }

        public String getAddress(){
            return street+" "+no+" "+town+" "+city+" "+country;
        }
    }

    private String name, facility_area, contact_person;
    private Address address;
    private Phone phone;
    private int internship_number = 0, id;
    private static int companyID =1;

    public Company(String name, String facility_area, String contact_person,Address address, Phone phone){
        this.name = name;
        this.facility_area = facility_area;
        this.contact_person = contact_person;
        this.address = address;
        this.phone = phone;
        id = companyID;
        companyID++;
    }
    //Second constructor to compare and prevent NullPointer error
    public Company(String name){
        this.name = name;
    }

    public void increaseInternships(){
        internship_number++;
    }

    public String getName() {
        return name;
    }

    public String getAllInfo(){
        return "Company ID: "+id+" - Company Name: "+name+" - Facility Area: "+facility_area+"\n"+
                "Contact Person: "+contact_person+" - Phone: "+phone.getPhoneNumber()+"\n"+
                "Address: "+address.getAddress();
    }

    public int getInternship_number() {
        return internship_number;
    }
}
