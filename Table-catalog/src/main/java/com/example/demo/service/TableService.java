package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.TableEntity;
import com.example.demo.repository.TableRepository;

@Service
public class TableService {

	@Autowired
	TableRepository repository;

	public List<TableEntity> getAllTables() {
		List<TableEntity> tableList = repository.findAll();

		if (tableList.size() > 0) {
			return tableList;
		} else {
			return new ArrayList<TableEntity>();
		}
	}

	public TableEntity getTableById(Long id) throws RecordNotFoundException {
		Optional<TableEntity> table = repository.findById(id);

		if (table.isPresent()) {
			return table.get();
		} else {
			throw new RecordNotFoundException("No table record exist for given id");
		}
	}

	public TableEntity getAllTablesByDate(Long id) throws RecordNotFoundException {
		Optional<TableEntity> table = repository.findById(id);

		if (table.isPresent()) {
			return table.get();
		} else {
			throw new RecordNotFoundException("No table record exist for given id");
		}
	}

}
