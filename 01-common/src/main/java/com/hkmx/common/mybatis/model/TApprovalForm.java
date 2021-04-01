package com.hkmx.common.mybatis.model;

import java.math.BigDecimal;

public class TApprovalForm {
    private Integer id;

    private String approvalNo;

    private String userUid;

    private Integer firstLevelType;

    private Integer secondLevelType;

    private Byte implTravel;

    private String travalReason;

    private String originCity;

    private String destinationCity;

    private Long beginTime;

    private Long endTime;

    private String travelSummary;

    private BigDecimal totalAmount;

    private String expenseDepartment;

    private Byte settlementMethod;

    private String bankAccountUid;

    private String approvers;

    private String copyUsers;

    private Byte status;

    private Byte rejectType;

    private Long createTime;

    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApprovalNo() {
        return approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo == null ? null : approvalNo.trim();
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid == null ? null : userUid.trim();
    }

    public Integer getFirstLevelType() {
        return firstLevelType;
    }

    public void setFirstLevelType(Integer firstLevelType) {
        this.firstLevelType = firstLevelType;
    }

    public Integer getSecondLevelType() {
        return secondLevelType;
    }

    public void setSecondLevelType(Integer secondLevelType) {
        this.secondLevelType = secondLevelType;
    }

    public Byte getImplTravel() {
        return implTravel;
    }

    public void setImplTravel(Byte implTravel) {
        this.implTravel = implTravel;
    }

    public String getTravalReason() {
        return travalReason;
    }

    public void setTravalReason(String travalReason) {
        this.travalReason = travalReason == null ? null : travalReason.trim();
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity == null ? null : originCity.trim();
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity == null ? null : destinationCity.trim();
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTravelSummary() {
        return travelSummary;
    }

    public void setTravelSummary(String travelSummary) {
        this.travelSummary = travelSummary == null ? null : travelSummary.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getExpenseDepartment() {
        return expenseDepartment;
    }

    public void setExpenseDepartment(String expenseDepartment) {
        this.expenseDepartment = expenseDepartment == null ? null : expenseDepartment.trim();
    }

    public Byte getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(Byte settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public String getBankAccountUid() {
        return bankAccountUid;
    }

    public void setBankAccountUid(String bankAccountUid) {
        this.bankAccountUid = bankAccountUid == null ? null : bankAccountUid.trim();
    }

    public String getApprovers() {
        return approvers;
    }

    public void setApprovers(String approvers) {
        this.approvers = approvers == null ? null : approvers.trim();
    }

    public String getCopyUsers() {
        return copyUsers;
    }

    public void setCopyUsers(String copyUsers) {
        this.copyUsers = copyUsers == null ? null : copyUsers.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRejectType() {
        return rejectType;
    }

    public void setRejectType(Byte rejectType) {
        this.rejectType = rejectType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}