package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;

    private String companyname;
    private String country;

    public static CompanyBuilder builder(){
        return new CompanyBuilder();
    }


    private Company(CompanyBuilder builder){
        this.id = builder.id;
        this.companyname = builder.companyname;
        this.country = builder.country;
        this.maxId = builder.maxId;
    }

    public static class CompanyBuilder{
        private int maxId;
        private int id;
        private String companyname;
        private String country;


        public static CompanyBuilder aCompany() {
            return new CompanyBuilder();
        }

        public CompanyBuilder withMaxId(int maxId){
            this.maxId = maxId;
            return this;
        }

        public CompanyBuilder withId(int idToUse) {
            this.id = idToUse;
            return this;
        }

        public CompanyBuilder withCompanyname(String companynameToUse){
            this.companyname = companynameToUse;
            return this;
        }
        public CompanyBuilder withCountry(String countryToUse){
            this.country = countryToUse;
            return this;
        }

        public Company build(){
            this.id = maxId;
            maxId++;
            return new Company(this);
        }
    }
    public int getId(){
        return id;
    }

    public String getCompanyname(){
        return companyname;
    }

    public String getCountry(){
        return country;
    }
}

