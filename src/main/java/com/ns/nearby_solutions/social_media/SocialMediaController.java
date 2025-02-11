package com.ns.nearby_solutions.social_media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/social-media")
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping
    public List<SocialMedia> getAllSocialMedia() {
        return socialMediaService.getAllSocialMedia();
    }

    @PostMapping
    public SocialMedia saveSocialMedia(@RequestBody SocialMedia socialMedia) {
        return socialMediaService.saveSocialMedia(socialMedia);
    }

    @PutMapping("/{id}")
    public SocialMedia updateSocialMedia(@PathVariable Long id, @RequestBody SocialMedia socialMedia) {
        socialMedia.setId(id); // Ensure the ID is set
        return socialMediaService.updateSocialMedia(socialMedia);
    }

    @DeleteMapping("/{id}")
    public void deleteSocialMedia(@PathVariable Long id) {
        socialMediaService.deleteSocialMedia(id);
    }
}
