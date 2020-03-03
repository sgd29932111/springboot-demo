package com.example.demo.entity.model;

import org.springframework.data.domain.Page;


//当前页首页为1， 后一页+1
public class BasePageResult<T> extends BaseResult<T>{
    private Integer totalPages;//总页数
    private Integer currentPage;//当前页
    private Long totalElement;//element总个数
    private Boolean isMoreRecord;//是否还有更多数据

    public BasePageResult() {
    }

    public BasePageResult(String message, boolean success, T data, Page page) {
        super(message, success, data);
        this.totalPages = page.getTotalPages();
        this.currentPage= page.getNumber()+1;
        this.totalElement = page.getTotalElements();
    }

    public void construct(String message, boolean success, T data, Page page){
        this.construct(message, success, data);
        this.totalPages = page.getTotalPages();
        this.currentPage= page.getNumber()+1;
        this.totalElement = page.getTotalElements();
    }
    public void construct(String message, boolean success, T data, Page page, Boolean isMoreRecord){
        this.construct(message, success, data);
        this.totalPages = page.getTotalPages();
        this.currentPage= page.getNumber()+1;
        this.totalElement = page.getTotalElements();
        this.isMoreRecord = isMoreRecord;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage+1;
    }

    public Long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(Long totalElement) {
        this.totalElement = totalElement;
    }

    public Boolean getMoreRecord() {
        return isMoreRecord;
    }

    public void setMoreRecord(Boolean moreRecord) {
        isMoreRecord = moreRecord;
    }
}
