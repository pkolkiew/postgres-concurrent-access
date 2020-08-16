package pl.pkolkiew.postgresconcurrentacces.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "ORDERENTITY")
@AllArgsConstructor
@NoArgsConstructor
@Data
class OrderEntity {

    @Id
    private UUID orderId;
    private Long clientId;
    private Long basketId;
    private Long versionId;
    @Version
    private Timestamp version;

}
