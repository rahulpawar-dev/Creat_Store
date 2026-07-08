package OpenStore.Store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
//    these

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name" , nullable = false)
    private String customerName ;

    @Column(name = "customer_email" , nullable = false)
    private String customerEmail;


    @Column(nullable = false)
    private String Status;

    @Column(name = "total_price" , nullable = false)
    private BigDecimal totalPrice;

//    @JoinColumn(name = "order_id" ,nullable = false)
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name = "created_at" )
    private LocalDateTime createdAt;



    @PrePersist
    public void prePersist(){
         this.createdAt = LocalDateTime.now();
    }




}
