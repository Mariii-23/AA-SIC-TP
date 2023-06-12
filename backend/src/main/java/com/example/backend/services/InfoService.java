package com.example.backend.services;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.dto.SocialNetworkDTO;
import com.example.backend.model.Company;
import com.example.backend.model.SocialNetwork;
import com.example.backend.repositories.CompanyRep;
import com.example.backend.repositories.SocialNetworkRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("infoService")
public class InfoService {

    @Autowired
    private CompanyRep companyRep;
    @Autowired
    private SocialNetworkRep socialNetworkRep;

    public Company addCompany(Company company) {
        return companyRep.save(company);
    }

    public CompanyDTO getCompanyById(int id) {
        Company company = companyRep.findById(id).orElse(null);
        return new CompanyDTO(company);
    }

    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> result = new ArrayList<>();
        List<Company> companies = companyRep.findAll();
        companies.forEach(company -> {
            result.add(new CompanyDTO(company));
        });
        return result;
    }

    public void addCompanyDTO(CompanyDTO companyDTO){
        if (Company.getInstance() == null) {
            Company company = new Company(companyDTO.getName(),
                    companyDTO.getEmail(),
                    companyDTO.getContact(),
                    companyDTO.getAddress(),
                    companyDTO.getLogoImage(),
                    companyDTO.getPostCode(),
                    companyDTO.getSchedule());
            addCompany(company);
        }
    }

    public SocialNetwork addSocialNetwork(SocialNetwork socialNetwork) {
        return socialNetworkRep.save(socialNetwork);
    }

    public void addSocialNetworkDTO(SocialNetworkDTO socialNetworkDTO){
        Company company = companyRep.findById(socialNetworkDTO.getCompanyID()).orElse(null);
        SocialNetwork socialNetwork = new SocialNetwork(socialNetworkDTO.getName(),
                                                        socialNetworkDTO.getLink(),
                                                        company);
        addSocialNetwork(socialNetwork);
    }

    public List<SocialNetworkDTO> getAllSocialNetworks() {
        List<SocialNetworkDTO> result = new ArrayList<>();
        List<SocialNetwork> socialNetworks = socialNetworkRep.findAll();
        socialNetworks.forEach(socialNetwork -> {
            result.add(new SocialNetworkDTO(socialNetwork));
        });
        return result;
    }

    public SocialNetwork getSocialNetworkById(int id) {
        return socialNetworkRep.findById(id).orElse(null);
    }

    public List<SocialNetworkDTO> getSocialNetworksByCompanyId(int id) {
        List<SocialNetworkDTO> result = new ArrayList<>();
        Company company = companyRep.findById(id).orElse(null);
        company.getSocialNetworks().forEach(socialNetwork -> {
            result.add(new SocialNetworkDTO(socialNetwork));
        });
        return result;
    }
}
