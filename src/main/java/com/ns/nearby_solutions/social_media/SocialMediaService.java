package com.ns.nearby_solutions.social_media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    public List<SocialMedia> getAllSocialMedia() {
        return socialMediaRepository.findAll();
    }

    public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
        return socialMediaRepository.save(socialMedia);
    }
}