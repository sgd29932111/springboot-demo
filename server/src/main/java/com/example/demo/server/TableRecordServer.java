package com.example.demo.server;

import com.example.demo.entity.TableRecord;
import com.example.demo.entity.model.BasePageResult;

import java.util.List;

public interface TableRecordServer {
    void getTableRecord(String type, Integer pageNum, BasePageResult<List<TableRecord>> result);
}
