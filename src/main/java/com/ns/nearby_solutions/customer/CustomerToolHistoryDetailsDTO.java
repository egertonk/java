package com.ns.nearby_solutions.customer;

import com.ns.nearby_solutions.tool_rental.ToolRentalListing;
import com.ns.nearby_solutions.tool_rental.history.ToolOrderHistory;
import com.ns.nearby_solutions.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Data
public class CustomerToolHistoryDetailsDTO {
    private User customerInformation;
    private Optional<ToolOrderHistory> toolOrderHistory;

    public void setToolRentalHistoryDetails(Optional<ToolOrderHistory> tool) {
        toolOrderHistory = tool;
    }
}
