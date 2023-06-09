package com.example.backend.dto;

import com.example.backend.model.SocialNetwork;

public class SocialNetworkDTO {
    private String name;
    private String link;

    private Integer companyID;

    public SocialNetworkDTO() {
    }

    public SocialNetworkDTO(SocialNetwork socialNetwork) {
        this.name = socialNetwork.getName();
        this.link = socialNetwork.getLink();
        this.companyID = socialNetwork.getCompany().getiD();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }
}
