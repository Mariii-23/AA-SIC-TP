package com.example.backend.services;

import com.example.backend.dto.infoDTOs.CompanyDTO;
import com.example.backend.dto.infoDTOs.CreateCompanyDTO;
import com.example.backend.dto.infoDTOs.EditSocialNetworksDTO;
import com.example.backend.dto.infoDTOs.SocialNetworkDTO;
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

    public CompanyDTO getCompany() {
        List<Company> companies = companyRep.findAll();
        return new CompanyDTO(companies.get(0));
    }

    public void addCompanyDTO(CreateCompanyDTO companyDTO){
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
        Company company = companyRep.findAll().get(0);
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

    public void editCompanyInfo(CreateCompanyDTO companyDTO) {
        Company company = companyRep.findAll().get(0);
        if (companyDTO.getName() != null) company.setName(companyDTO.getName());
        if (companyDTO.getEmail() != null) company.setEmail(companyDTO.getEmail());
        if (companyDTO.getContact() != null) company.setContact(companyDTO.getContact());
        if (companyDTO.getAddress() != null) company.setAddress(companyDTO.getAddress());
        if (companyDTO.getLogoImage() != null) company.setLogoImage(companyDTO.getLogoImage());
        if (companyDTO.getPostCode() != null) company.setPostCode(companyDTO.getPostCode());
        if (companyDTO.getSchedule() != null) company.setSchedule(companyDTO.getSchedule());
        companyRep.save(company);
    }

    public byte[] getCompanyImage() {
        Company company = companyRep.findAll().get(0);
        return company.getLogoImage();
    }

    public void editSocialNetworks(EditSocialNetworksDTO editSocialNetworkDTO) {
        Company company = companyRep.findAll().get(0);
        List<SocialNetwork> socialNetworks = new ArrayList<>();
        editSocialNetworkDTO.getSocialNetworks().forEach(socialNetworkDTO ->
                socialNetworks.add(new SocialNetwork(socialNetworkDTO.getName(),socialNetworkDTO.getLink(),company)));
        socialNetworkRep.deleteAll();
        socialNetworkRep.saveAll(socialNetworks);
    }
}
