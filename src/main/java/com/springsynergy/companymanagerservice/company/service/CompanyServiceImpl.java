package com.springsynergy.companymanagerservice.company.service;

import com.springsynergy.companymanagerservice.company.entity.Company;
import com.springsynergy.companymanagerservice.company.exception.CompanyAlreadyExistsException;
import com.springsynergy.companymanagerservice.company.model.CompanyDto;
import com.springsynergy.companymanagerservice.company.repository.CompanyRepository;
import com.springsynergy.companymanagerservice.company.util.CompanyEntityDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyEntityDtoMapper companEentityDtoMapper;

    @Override
    public Set<CompanyDto> getAllCompanies() {
        Set<CompanyDto> companyDtos = new HashSet<>();
        Set<Company> companies = new HashSet<>(companyRepository.findAll());
        for (Company company : companies) {
            companyDtos.add(companEentityDtoMapper.companyToCompanyDto(company));
        }
        return companyDtos;
    }

    @Override
    public CompanyDto getCompanyById(UUID companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        return companyOptional.map(companEentityDtoMapper::companyToCompanyDto).orElse(null);
    }

    @Override
    public void createCompany(CompanyDto companyDto) {
        Optional<Company> existingCompany = companyRepository.findByName(companyDto.getName());
        if (existingCompany.isPresent()) {
            throw new CompanyAlreadyExistsException("Company with name " + companyDto.getName() + " already exists.");
        } else {
            Company company = companEentityDtoMapper.companyDtoToCompany(companyDto);
            log.info("Company: {}", company);
            companyRepository.save(company);
        }
    }

    @Override
    public boolean updateCompanyById(String companyId, CompanyDto companyDto) {
        Optional<Company> companyOptional = companyRepository.findById(UUID.fromString(companyId));
        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            log.info("Company: {}", company);
            BeanUtils.copyProperties(companyDto, company);
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public CompanyDto getCompanyByName(String companyName) {
        log.info("Company name: {}", companyName);
        log.info("Company name length: {}", companyName.length());
        Optional<Company> companyOptional = companyRepository.findByName(companyName);
        return companyOptional.map(companEentityDtoMapper::companyToCompanyDto).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(String companyId) {
        Optional<Company> companyOptional = companyRepository.findById(UUID.fromString(companyId));
        if (companyOptional.isPresent()) {
            companyRepository.delete(companyOptional.get());
            return true;
        }
        return false;
    }

}
