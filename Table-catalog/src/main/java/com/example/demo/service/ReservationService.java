package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TableEntityDTO;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.ReservationEntity;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.TableRepository;

@Service
public class ReservationService {

	@Autowired
	TableRepository tableRepository;

	@Autowired
	ReservationRepository reservationRepository;

	public List<TableEntityDTO> getAllTablesByDate(String date) throws RecordNotFoundException {
		List<TableEntityDTO> table = tableRepository.fetchEmpDeptDataInnerJoin(date);

		if (table.isEmpty()) {
			throw new RecordNotFoundException("Please choose different Date/Time");

		} else {
			return table;
		}
	}

	public ReservationEntity createReservation(ReservationEntity entity) throws RecordNotFoundException {

		entity = reservationRepository.save(entity);

		return entity;

	}

}
