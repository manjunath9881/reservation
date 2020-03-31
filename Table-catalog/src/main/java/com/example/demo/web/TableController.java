package com.example.demo.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.TableEntity;
import com.example.demo.service.ReservationService;
import com.example.demo.service.TableService;


@RestController
@RequestMapping("/tables")
public class TableController
{
   @Autowired
   TableService service;
   
   @Autowired
	ReservationService reservationService;

   @GetMapping
   public ResponseEntity<List<TableEntity>> getAllTables() {
       List<TableEntity> list = service.getAllTables();

       return new ResponseEntity<List<TableEntity>>(list, new HttpHeaders(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<TableEntity> getTableById(@PathVariable("id") Long id)
                                                   throws RecordNotFoundException {
       TableEntity entity = service.getTableById(id);

       return new ResponseEntity<TableEntity>(entity, new HttpHeaders(), HttpStatus.OK);
   }
   
  

   

}
