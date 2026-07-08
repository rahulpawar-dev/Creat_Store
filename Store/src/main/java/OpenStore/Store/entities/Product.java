package OpenStore.Store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name  = "Products ")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The Product Name is Required ")
    @Column(nullable = false)
    private String name;


    private String Description;

    @NotNull(message = "Price is Required ")
    @DecimalMin(value = "0.0" , inclusive = false ,message = "Price Must Be Greater Than Zero ")
    @Column(nullable = false)
    private BigDecimal Price;



    @NotNull(message = " StockQuantity is Required ")
    @Min(value = 0 , message = "Stock Can not BE Zero ")
    @Column(name = "stock_quantity" , nullable = false)
    private Integer StockQuantity;


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem>  orderItems;


}
