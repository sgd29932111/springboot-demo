package com.example.demo.web;

import com.example.demo.entity.TableRecord;
import com.example.demo.entity.model.BasePageResult;
import com.example.demo.server.TableRecordServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.util.ConstUtil.*;

@RestController
@RequestMapping(TABLE_INTERFACE)
public class TableRecordController {

    private TableRecordServer tableRecordServer;

    @Autowired
    public TableRecordController(TableRecordServer tableRecordServer) {
        this.tableRecordServer = tableRecordServer;
    }

    @GetMapping(TABLE_GET_TABLE_RECORD)
    public BasePageResult<List<TableRecord>> getTableRecord(String type, Integer pageNum){
        BasePageResult<List<TableRecord>> result = new BasePageResult<>();
        tableRecordServer.getTableRecord(type, pageNum, result);
        return result;
    }
}
