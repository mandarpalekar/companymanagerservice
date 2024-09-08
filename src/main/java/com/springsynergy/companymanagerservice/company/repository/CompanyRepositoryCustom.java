package com.springsynergy.jobapp.company.repository;

import com.springsynergy.jobapp.company.entity.Company;

import java.util.Optional;

public interface CompanyRepositoryCustom {

    Optional<Company> findByCompanyName(String companyName);
}
