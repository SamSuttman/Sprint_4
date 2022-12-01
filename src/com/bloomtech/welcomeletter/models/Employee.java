package com.bloomtech.welcomeletter.models;

import java.time.LocalDate;

public class Employee{
    private static int maxId = 1;
    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private int salary;
    private java.time.LocalDate startdate;
    private Role role;
    private Company company;

    /**
     * New EmployeeBuilder constructor inside Employee class.
     *
     * @return ->new EmployeeBuilder.
     */

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    private Employee(EmployeeBuilder builder) {
        this.email = builder.email;
        this.salary = builder.salary;
        this.company = builder.company;
        this.firstname = builder.firstname;
        this.phonenumber = builder.phonenumber;
        this.startdate = builder.startdate;
        this.role = builder.role;
        this.lastname = builder.lastname;
        //this.maxId = builder.maxId;
        this.id = maxId;
        maxId++;
    }

    public static class EmployeeBuilder{
        private int id;
        private String firstname;
        private String lastname;
        private String phonenumber;
        private String email;
        private int salary;
        private java.time.LocalDate startdate;
        private Role role;
        private Company company;

        public static EmployeeBuilder anEmployee(){
            return new EmployeeBuilder();
        }
        public EmployeeBuilder withId(int idToUse){
            this.id = idToUse;
            return this;
        }
        public EmployeeBuilder withFirstname(String firstnameToUse){
            this.firstname = firstnameToUse;
            return this;
        }
        public EmployeeBuilder withLastname(String lastnameToUse){
            this.lastname = lastnameToUse;
            return this;
        }
        public EmployeeBuilder withPhonenumber(String phonenumberToUse){
            this.phonenumber = phonenumberToUse;
            return this;
        }
        public EmployeeBuilder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public EmployeeBuilder withSalary(int salaryToUse) {
            this.salary = salaryToUse;
            return this;
        }

        public EmployeeBuilder withStartdate(LocalDate startdateToUse) {
            this.startdate = startdateToUse;
            return this;
        }

        public EmployeeBuilder withRole(Role roleToUse) {
            this.role = roleToUse;
            return this;
        }

        public EmployeeBuilder withCompany(Company companyToUse) {
            this.company = companyToUse;
            return this;
        }

        public Employee build() {
            if (firstname == null) {
                throw new RuntimeException("firstname cannot be null!\n" +
                        "Please provide a valid firstname:");
            }
            if (company == null) {
                throw new RuntimeException("Company name cannot be null!\n" +
                        "Please provide a valid company:");
            }
            return new Employee(this);
        }
    }

    //Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public String getStartdate () {
        String dateString = "";
        dateString += Integer.toString(startdate.getYear());
        dateString += "-";
        int month = startdate.getMonthValue();
        String monthString = Integer.toString(month);
        if (monthString.length() == 1) {
            monthString = "0" + monthString;
        }

        int day = startdate.getDayOfMonth();
        String dayString = Integer.toString(day);
        if (dayString.length() == 1) {
            dayString = "0" + dayString;
        }
        dateString += monthString;
        dateString += "-";
        dateString += dayString;

        return dateString;
    }

    public Role getRole() {
        return role;
    }

    public Company getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }
}
