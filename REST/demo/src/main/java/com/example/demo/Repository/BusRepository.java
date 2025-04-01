package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.Bus;

import java.util.List;
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    // Retrieve all buses
    @Query("SELECT b FROM Bus b")
    List<Bus> findAllBuses();

    // Retrieve a bus by ID
    @Query("SELECT b FROM Bus b WHERE b.id = :id")
    Bus findBusById(@Param("id") Long id);

    // Retrieve buses by route
    @Query("SELECT b FROM Bus b WHERE b.route = :route")
    List<Bus> findBusesByRoute(@Param("route") String route);

    // Update bus capacity by ID
    @Transactional
    @Modifying
    @Query("UPDATE Bus b SET b.capacity = :capacity WHERE b.id = :id")
    void updateBusCapacity(@Param("id") Long id, @Param("capacity") int capacity);

    @Modifying
    @Transactional
    @Query("DELETE FROM Bus b WHERE b.id = :id")
    void deleteBusById(@Param("id") Long id);
}