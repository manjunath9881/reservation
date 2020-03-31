package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.TableEntityDTO;
import com.example.demo.model.TableEntity;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {

	@Query("SELECT new com.example.demo.dto.TableEntityDTO(tableEntity.id, tableEntity.seats ,tableEntity.seatCordinates) FROM TableEntity tableEntity where tableEntity.id not in (select tableEntity.id  FROM TableEntity tableEntity INNER JOIN tableEntity.reservationEntity reservation where reservation.reservedDdate = :date)")
	List<TableEntityDTO> fetchEmpDeptDataInnerJoin(@Param("date") String date);
}
