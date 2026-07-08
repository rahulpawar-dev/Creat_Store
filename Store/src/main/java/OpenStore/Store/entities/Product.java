package OpenStore.Store.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
// REMOVED ALL LOMBOK ANNOTATIONS HERE
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The Product Name is Required")
    @Column(nullable = false)
    private String name;

    private String description;

    @NotNull(message = "Price is Required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price Must Be Greater Than Zero")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "StockQuantity is Required")
    @Min(value = 0, message = "Stock Cannot Be Zero")
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    // --- MANUAL CONSTRUCTORS ---

    // Empty constructor needed by Hibernate
    public Product() {
    }

    // --- MANUAL GETTERS AND SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}