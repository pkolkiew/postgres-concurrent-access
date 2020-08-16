package pl.pkolkiew.postgresconcurrentacces.order;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@AllArgsConstructor
class OrderService {

    private final OrderRepository repository;

    @Scheduled(initialDelayString = "${initial.cron.delay}", fixedDelayString = "5000")
    @Transactional
    public void scheduler() {
        log.info("Started cron");
        repository.findByVersionId(0L, PageRequest.of(0, 2))
                .stream()
                .forEach(orderEntity -> {
                    log.info("orderId: " + orderEntity.getOrderId());
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    orderEntity.setClientId(orderEntity.getClientId()+1);
                    repository.save(orderEntity);
                });
        log.info("After cron");
    }


}
