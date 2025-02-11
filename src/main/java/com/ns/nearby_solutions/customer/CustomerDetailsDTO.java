package com.ns.nearby_solutions.customer;

import com.ns.nearby_solutions.address.Address;
import com.ns.nearby_solutions.social_media.SocialMedia;
import com.ns.nearby_solutions.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Data
public class CustomerDetailsDTO {
    private User customerInformation;
    private List<Address> customerAddress;
    private List<SocialMedia> customerSocialMedias;
}
