package com.example.demo.Dao;

import com.example.demo.entity.TableRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRecordDao extends JpaRepository<TableRecord, String> {
    Page<TableRecord> findAllByFieldType(String type, Pageable pageable);
}
