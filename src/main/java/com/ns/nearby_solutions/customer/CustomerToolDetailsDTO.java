package com.ns.nearby_solutions.customer;

import com.ns.nearby_solutions.tool_rental.ToolRentalListing;
import com.ns.nearby_solutions.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Data
public class CustomerToolDetailsDTO {
    private User customerInformation;
    private Optional<ToolRentalListing> toolRentalDetails;

    public void setToolRentalDetails(Optional<ToolRentalListing> tool) {
        toolRentalDetails = tool;
    }
}
