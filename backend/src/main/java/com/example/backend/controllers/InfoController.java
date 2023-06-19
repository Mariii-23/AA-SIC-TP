package com.example.backend.controllers;

import com.example.backend.dto.infoDTOs.CompanyDTO;
import com.example.backend.dto.infoDTOs.CreateCompanyDTO;
import com.example.backend.dto.infoDTOs.EditSocialNetworksDTO;
import com.example.backend.dto.infoDTOs.SocialNetworkDTO;
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

    @GetMapping("/all/companyInfo")
    public CompanyDTO getCompanyInfo() {
        return infoService.getCompany();
    }

    @GetMapping(value = "/all/companyImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<org.springframework.core.io.Resource> logoImage() {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new ByteArrayResource(infoService.getCompanyImage()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @PostMapping("/companyInfo")
    public CompanyDTO addCompany(final @RequestBody CreateCompanyDTO company) {
        return infoService.addCompanyDTO(company);
    }

    @GetMapping("/socialNetworks")
    public SocialNetworkDTO getSocialNetworkById(final @RequestParam int id) {
        try {
            return infoService.getSocialNetworkById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all/socialNetworks")
    public List<SocialNetworkDTO> getAllSocialNetworks() {
        return infoService.getAllSocialNetworks();
    }

    @PostMapping("/socialNetworks")
    public SocialNetworkDTO addSocialNetwork(final @RequestBody SocialNetworkDTO socialNetwork) {
        return infoService.addSocialNetworkDTO(socialNetwork);
    }

    @PostMapping("/socialNetworks/edit")
    public void editSocialNetworks(final @RequestBody EditSocialNetworksDTO editSocialNetworkDTO) {
        infoService.editSocialNetworks(editSocialNetworkDTO);
    }

    @PostMapping("/companyInfo/edit")
    public void editCompanyInfo(final @RequestBody CreateCompanyDTO companyDTO) {
        infoService.editCompanyInfo(companyDTO);
    }
}
