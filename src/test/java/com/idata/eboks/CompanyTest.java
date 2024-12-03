package com.idata.eboks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.idata.eboks.controller.CompanyController;
import com.idata.eboks.models.CompanyID;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private CompanyController controller;

    @BeforeEach
    void setUp() {
        controller = new CompanyController();
    }

    @Test
    void testAddCompany() {
        String tenantKey = "tenant1";
        CompanyID company = new CompanyID("Company A", "123");

        controller.associateCompanyId(tenantKey, company);

        List<CompanyID> companies = controller.getAllCompanyIds().getBody();
        assertTrue(companies.stream().anyMatch(c -> c.getOrgnr().equals("123")));
    }

    @Test
    void testDeleteCompany() {
        String tenantKey = "tenant1";
        CompanyID company = new CompanyID("Company A", "123");

        controller.associateCompanyId(tenantKey, company);
        controller.deleteCompanyByOrgnr(tenantKey, "123");

        List<CompanyID> companies = controller.getAllCompanyIds().getBody();
        assertTrue(companies.stream().noneMatch(c -> c.getOrgnr().equals("123")));
    }

    @Test
    void testGetAllCompanies() {
        String tenantKey = "tenant1";
        CompanyID company1 = new CompanyID("Company A", "123");

        controller.associateCompanyId(tenantKey, company1);

        List<CompanyID> companies = controller.getAllCompanyIds().getBody();
        assertEquals(1, companies.size());
    }
}
