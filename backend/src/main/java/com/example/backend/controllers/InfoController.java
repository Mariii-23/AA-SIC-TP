package com.example.backend.controllers;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.dto.SocialNetworkDTO;
import com.example.backend.model.SocialNetwork;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.example.backend.services.InfoService;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Resource(name = "infoService")
    private InfoService infoService;

    @GetMapping("/companyInfo/{id}")
    public CompanyDTO getCompanyInfo(int id) {
        return infoService.getCompanyById(id);
    }

    @GetMapping("/companyInfo/all")
    public List<CompanyDTO> getAllCompanies() {
        return infoService.getAllCompanies();
    }

    @GetMapping("/companyInfo/{id}/socialNetworks")
    public List<SocialNetworkDTO> getSocialNetworksByCompanyId(@PathVariable int id) {
        return infoService.getSocialNetworksByCompanyId(id);
    }

    @PostMapping("/companyInfo")
    public void addCompany(final @RequestBody CompanyDTO company) {
        infoService.addCompanyDTO(company);
    }

    @GetMapping("/socialNetworks/{id}")
    public SocialNetwork getSocialNetworkById(int id) {
        return infoService.getSocialNetworkById(id);
    }

    @GetMapping("/socialNetworks/all")
    public List<SocialNetworkDTO> getAllSocialNetworks() {
        return infoService.getAllSocialNetworks();
    }

    @PostMapping("/socialNetworks")
    public void addSocialNetwork(final @RequestBody SocialNetworkDTO socialNetwork) {
        infoService.addSocialNetworkDTO(socialNetwork);
    }


}
