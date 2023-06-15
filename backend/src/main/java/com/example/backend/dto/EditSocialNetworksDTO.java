package com.example.backend.dto;

import java.util.List;

public class EditSocialNetworksDTO {
    private List<SocialNetworkDTO> socialNetworks;

    public EditSocialNetworksDTO(){}

    public EditSocialNetworksDTO(List<SocialNetworkDTO> socialNetworks){
        this.socialNetworks = socialNetworks;
    }

    public List<SocialNetworkDTO> getSocialNetworks(){
        return this.socialNetworks;
    }

    public void setSocialNetworks(List<SocialNetworkDTO> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }
}
