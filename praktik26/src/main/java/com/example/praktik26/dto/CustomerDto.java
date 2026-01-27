package com.example.praktik26.dto;

public class CustomerDto {
    private String customerCode;
    private String customerName;
    private String customerInn;
    private String customerKpp;
    private String email;
    private Boolean isOrganization;
    private Boolean isPerson;

    // Пустой конструктор
    public CustomerDto() {}

    // Полный конструктор
    public CustomerDto(String customerCode, String customerName, String customerInn, String customerKpp, String email, Boolean isOrganization, Boolean isPerson) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerInn = customerInn;
        this.customerKpp = customerKpp;
        this.email = email;
        this.isOrganization = isOrganization;
        this.isPerson = isPerson;
    }

    // Getters and Setters
    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerInn() { return customerInn; }
    public void setCustomerInn(String customerInn) { this.customerInn = customerInn; }

    public String getCustomerKpp() { return customerKpp; }
    public void setCustomerKpp(String customerKpp) { this.customerKpp = customerKpp; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getIsOrganization() { return isOrganization; }
    public void setIsOrganization(Boolean organization) { isOrganization = organization; }

    public Boolean getIsPerson() { return isPerson; }
    public void setIsPerson(Boolean person) { isPerson = person; }
}
