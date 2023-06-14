package com.example.backend.controllers;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.dto.CreateCompanyDTO;
import com.example.backend.dto.SocialNetworkDTO;
import com.example.backend.model.SocialNetwork;
import jakarta.annotation.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.services.InfoService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Resource(name = "infoService")
    private InfoService infoService;

    @GetMapping("all/companyInfo")
    public CompanyDTO getCompanyInfo() {
        return infoService.getCompany();
    }

    @GetMapping(value = "all/companyImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> logoImage() {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(infoService.getCompanyImage()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("/companyInfo/socialNetworks")
    public List<SocialNetworkDTO> getSocialNetworksByCompany() {
        return infoService.getSocialNetworksByCompany();
    }

    @PostMapping("/companyInfo")
    public void addCompany(final @RequestBody CreateCompanyDTO company) {
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

    @PostMapping("/companyInfo/edit")
    public void editCompanyInfo(final @RequestBody CreateCompanyDTO companyDTO) {
        infoService.editCompanyInfo(companyDTO);
    }
}
