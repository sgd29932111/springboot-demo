package com.example.demo.server.Impl;

import com.example.demo.Dao.TableRecordDao;
import com.example.demo.entity.TableRecord;
import com.example.demo.entity.model.BasePageResult;
import com.example.demo.server.TableRecordServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.ConstUtil.FIND_SUCCESS;

@Service
public class TableRecordServerImpl implements TableRecordServer {

    private TableRecordDao tableRecordDao;

    @Autowired
    public TableRecordServerImpl(TableRecordDao tableRecordDao) {
        this.tableRecordDao = tableRecordDao;
    }

    @Override
    public void getTableRecord(String type, Integer pageNum, BasePageResult<List<TableRecord>> result) {
        Pageable pageable = PageRequest.of(pageNum -1, 10);
        Page<TableRecord> page = tableRecordDao.findAllByFieldType(type, pageable);
        List<TableRecord> tableRecords = page.getContent();
        result.construct(FIND_SUCCESS, true, tableRecords, page);
    }
}
