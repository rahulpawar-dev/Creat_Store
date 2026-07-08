package OpenStore.Store.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {


    @NotBlank(message = "Customer Name Is Required ")
    private String customerName;

    @NotBlank(message = " Customer Email Is Required")
    @Email(message = "Enter The Valid Email")
    private String customerEmail;

    @Valid
    @NotEmpty(message = "Order Must Contain At Least One Item ")
    private List<OrderRequest> items;


}
