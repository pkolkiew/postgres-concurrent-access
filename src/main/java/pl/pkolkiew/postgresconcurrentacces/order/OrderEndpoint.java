package pl.pkolkiew.postgresconcurrentacces.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
class OrderEndpoint {

    private final OrderRepository orderRepository;

    @GetMapping("/find/{orderId}")
    public OrderEntity findById(@PathVariable UUID orderId) {
        return orderRepository.findById(orderId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @PostMapping("/add")
    public void addOrder() {
        log.info("addOrder called");
        orderRepository.save(new OrderEntity(UUID.randomUUID(), 12L, 123L, 0L, Timestamp.valueOf(LocalDateTime.now())));
    }

}
