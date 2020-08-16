package pl.pkolkiew.postgresconcurrentacces.order;

import java.util.UUID;

class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(UUID orderId){
        super("Order with id: "+orderId+" not found", null, false, false);
    }
}
