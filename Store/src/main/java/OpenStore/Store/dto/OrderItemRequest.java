package OpenStore.Store.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest {

    @NotNull(message = "The Product Id Is Required ")
    private Long productId;

    @NotNull(message = "Quantity Is Required ")
    @Min(value = 1 ,message = "Quantity Must AtLeast 1")
    private Integer quantity;

}
