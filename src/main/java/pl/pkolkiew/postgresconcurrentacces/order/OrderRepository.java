package pl.pkolkiew.postgresconcurrentacces.order;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.UUID;

interface OrderRepository extends CrudRepository<OrderEntity, UUID> {

//    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
//    @Query(value = "SELECT o.* FROM ORDERENTITY o WHERE o.versionId = ?1 LIMIT ?2", nativeQuery = true)
//    List<OrderEntity> findByVersionId(@Param("versionId") Long versionId, int limit);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT o FROM ORDERENTITY o WHERE o.versionId =:versionId")
    List<OrderEntity> findByVersionId(@Param("versionId") Long versionId, Pageable pageable);

}
