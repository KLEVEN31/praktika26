package com.example.praktik26.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LotDto {
    private Integer id;
    private String lotName;
    private String customerCode;
    private BigDecimal price;
    private String currencyCode;
    private String ndsRate;
    private LocalDateTime dateDelivery;

    public LotDto() {}

    public LotDto(Integer id, String lotName, String customerCode, BigDecimal price, String currencyCode, String ndsRate, LocalDateTime dateDelivery) {
        this.id = id;
        this.lotName = lotName;
        this.customerCode = customerCode;
        this.price = price;
        this.currencyCode = currencyCode;
        this.ndsRate = ndsRate;
        this.dateDelivery = dateDelivery;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getLotName() { return lotName; }
    public void setLotName(String lotName) { this.lotName = lotName; }

    public String getCustomerCode() { return customerCode; }
    public void setCustomerCode(String customerCode) { this.customerCode = customerCode; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public String getNdsRate() { return ndsRate; }
    public void setNdsRate(String ndsRate) { this.ndsRate = ndsRate; }

    public LocalDateTime getDateDelivery() { return dateDelivery; }
    public void setDateDelivery(LocalDateTime dateDelivery) { this.dateDelivery = dateDelivery; }
}