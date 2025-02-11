package com.ns.nearby_solutions.social_media;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    public List<SocialMedia> getAllSocialMedia() {
        return socialMediaRepository.findAll();
    }

    public SocialMedia saveSocialMedia(SocialMedia socialMedia) {
        log.info("Save social media information {}");
        return socialMediaRepository.save(socialMedia);
    }

    public Object getSocialMediaByUserId(Long id) {
        log.info("Get social media by user id: {}", id);
        return socialMediaRepository.findByUserId(id);
    }

    public SocialMedia updateSocialMedia(SocialMedia socialMedia) {
        log.info("Update social media information {}");
        return socialMediaRepository.save(socialMedia);
    }

    public void deleteSocialMedia(Long id) {
        log.info("Delete social media information with id: {}", id);
        socialMediaRepository.deleteById(id);
    }
}