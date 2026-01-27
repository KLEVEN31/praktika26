package com.example.praktik26.service;


import com.example.praktik26.dto.CustomerDto;
import com.example.praktik26.dto.LotDto;
import com.example.praktik26.model.tables.Customer;
import com.example.praktik26.model.tables.Lot;
import com.example.praktik26.model.tables.records.CustomerRecord;
import com.example.praktik26.model.tables.records.LotRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    private final DSLContext dsl;

    // Внедрение зависимости через конструктор (вместо @RequiredArgsConstructor Lombok)
    public PurchaseService(DSLContext dsl) {
        this.dsl = dsl;
    }

    // --- Customer Operations ---

    public List<CustomerDto> getAllCustomers() {
        return dsl.selectFrom(Customer.CUSTOMER)
                .fetch()
                .stream()
                .map(this::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    public void createCustomer(CustomerDto dto) {
        dsl.insertInto(Customer.CUSTOMER)
                .set(Customer.CUSTOMER.CUSTOMER_CODE, dto.getCustomerCode())
                .set(Customer.CUSTOMER.CUSTOMER_NAME, dto.getCustomerName())
                .set(Customer.CUSTOMER.CUSTOMER_INN, dto.getCustomerInn())
                .set(Customer.CUSTOMER.CUSTOMER_KPP, dto.getCustomerKpp())
                .set(Customer.CUSTOMER.CUSTOMER_EMAIL, dto.getEmail())
                .set(Customer.CUSTOMER.IS_ORGANIZATION, dto.getIsOrganization())
                .set(Customer.CUSTOMER.IS_PERSON, dto.getIsPerson())
                .execute();
    }

    public void updateCustomer(String code, CustomerDto dto) {
        dsl.update(Customer.CUSTOMER)
                .set(Customer.CUSTOMER.CUSTOMER_NAME, dto.getCustomerName())
                .set(Customer.CUSTOMER.CUSTOMER_EMAIL, dto.getEmail())
                .where(Customer.CUSTOMER.CUSTOMER_CODE.eq(code))
                .execute();
    }

    // Маппер вручную
    private CustomerDto mapToCustomerDto(CustomerRecord r) {
        return new CustomerDto(
                r.getCustomerCode(),
                r.getCustomerName(),
                r.getCustomerInn(),
                r.getCustomerKpp(),
                r.getCustomerEmail(),
                r.getIsOrganization(),
                r.getIsPerson()
        );
    }

    // --- Lot Operations ---

    public List<LotDto> getAllLots() {
        return dsl.selectFrom(Lot.LOT)
                .fetch()
                .stream()
                .map(this::mapToLotDto)
                .collect(Collectors.toList());
    }

    public void createLot(LotDto dto) {
        dsl.insertInto(Lot.LOT)
                .set(Lot.LOT.LOT_NAME, dto.getLotName())
                .set(Lot.LOT.CUSTOMER_CODE, dto.getCustomerCode())
                .set(Lot.LOT.PRICE, dto.getPrice())
                .set(Lot.LOT.CURRENCY_CODE, dto.getCurrencyCode())
                .set(Lot.LOT.NDS_RATE, dto.getNdsRate())
                .set(Lot.LOT.DATE_DELIVERY, dto.getDateDelivery())
                .execute();
    }

    private LotDto mapToLotDto(LotRecord r) {
        return new LotDto(
                r.getLotId(),
                r.getLotName(),
                r.getCustomerCode(),
                r.getPrice(),
                r.getCurrencyCode(),
                r.getNdsRate(),
                r.getDateDelivery()
        );
    }
}
