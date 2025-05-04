package com.bankingprojectnew.Entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private int customerPhone;

    @Embedded
    private Address customerAddress;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Account customerAccount;
    
    public Account getCustomerAccount() {
        return customerAccount;
    }
    public void setCustomerAccount(Account customerAccount) {
        this.customerAccount = customerAccount;
    }
    public Address getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public int getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }
}
