package com.example.backend.dto.infoDTOs;

import com.example.backend.model.SocialNetwork;

public class SocialNetworkDTO {
    private String name;
    private String link;

    public SocialNetworkDTO() {
    }

    public SocialNetworkDTO(SocialNetwork socialNetwork) {
        this.name = socialNetwork.getName();
        this.link = socialNetwork.getLink();
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
}
