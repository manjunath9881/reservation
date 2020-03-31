package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TableEntityDTO;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.ReservationEntity;
import com.example.demo.service.ReservationService;
import com.example.demo.service.TableService;

@RestController
@RequestMapping("/v1/restaurants")
public class ReservationController {

	@Autowired
	TableService tableService;

	@Autowired
	ReservationService reservationService;

	@GetMapping("/availability")
	public ResponseEntity<List<TableEntityDTO>> getAllTablesByDate(
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "people", required = false) Integer people) throws RecordNotFoundException {
		List<TableEntityDTO> entity = reservationService.getAllTablesByDate(date);
		return new ResponseEntity<List<TableEntityDTO>>(entity, HttpStatus.OK);		
	}
	
	@PostMapping("/reserve")
    public ResponseEntity<ReservationEntity> createReservation(@RequestBody ReservationEntity reservationEntity)
                                                    throws RecordNotFoundException {
		ReservationEntity updated = reservationService.createReservation(reservationEntity);
        return new ResponseEntity<ReservationEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

}
