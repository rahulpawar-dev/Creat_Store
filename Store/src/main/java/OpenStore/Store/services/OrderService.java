package OpenStore.Store.services;

import OpenStore.Store.dto.OrderItemRequest;
import OpenStore.Store.dto.OrderRequest;
import OpenStore.Store.entities.Order;
import OpenStore.Store.entities.OrderItem;
import OpenStore.Store.entities.Product;
import OpenStore.Store.repositories.OrderRepository;
import OpenStore.Store.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final  ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest){

        List<OrderItem> orderItems = new ArrayList<>();

        BigDecimal  totalPrice = BigDecimal.ZERO;

        Order order = new Order();

        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for(OrderItemRequest itemRequest:orderRequest.getItems()){

            Product product = productRepository.findById(
                    itemRequest.getProductId()
            ).orElseThrow(()-> new RuntimeException(
                    "Product Not Found"+itemRequest.getProductId()
            ));


//            Checking The Product Availability in Stock

            if(product.getStockQuantity() < itemRequest.getQuantity()){
                throw  new RuntimeException(" Not Enough Stock For These Product");

            }

//            Calculate Price


            BigDecimal priceOfItem = product.getPrice().multiply( BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice = totalPrice.add( priceOfItem);


//            Update the product Table With latest stock Quantity
            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );

            productRepository.save(product);

//            Builder pattern to make Obj

            OrderItem orderItem = OrderItem.builder().
                    order(order).
                    product(product).
                    quantity(itemRequest.getQuantity()).
                    priceAtPurchase(product.getPrice()).
                    build();


            orderItems.add(orderItem);

        }
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);


        return orderRepository.save(order);
    }



    @Transactional()
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional()
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }
}
