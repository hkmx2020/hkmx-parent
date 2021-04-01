package com.hkmx.common.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TApprovalFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TApprovalFormExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNull() {
            addCriterion("approval_no is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIsNotNull() {
            addCriterion("approval_no is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNoEqualTo(String value) {
            addCriterion("approval_no =", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotEqualTo(String value) {
            addCriterion("approval_no <>", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThan(String value) {
            addCriterion("approval_no >", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoGreaterThanOrEqualTo(String value) {
            addCriterion("approval_no >=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThan(String value) {
            addCriterion("approval_no <", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLessThanOrEqualTo(String value) {
            addCriterion("approval_no <=", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoLike(String value) {
            addCriterion("approval_no like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotLike(String value) {
            addCriterion("approval_no not like", value, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoIn(List<String> values) {
            addCriterion("approval_no in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotIn(List<String> values) {
            addCriterion("approval_no not in", values, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoBetween(String value1, String value2) {
            addCriterion("approval_no between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andApprovalNoNotBetween(String value1, String value2) {
            addCriterion("approval_no not between", value1, value2, "approvalNo");
            return (Criteria) this;
        }

        public Criteria andUserUidIsNull() {
            addCriterion("user_uid is null");
            return (Criteria) this;
        }

        public Criteria andUserUidIsNotNull() {
            addCriterion("user_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUserUidEqualTo(String value) {
            addCriterion("user_uid =", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotEqualTo(String value) {
            addCriterion("user_uid <>", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThan(String value) {
            addCriterion("user_uid >", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThanOrEqualTo(String value) {
            addCriterion("user_uid >=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThan(String value) {
            addCriterion("user_uid <", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThanOrEqualTo(String value) {
            addCriterion("user_uid <=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLike(String value) {
            addCriterion("user_uid like", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotLike(String value) {
            addCriterion("user_uid not like", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidIn(List<String> values) {
            addCriterion("user_uid in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotIn(List<String> values) {
            addCriterion("user_uid not in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidBetween(String value1, String value2) {
            addCriterion("user_uid between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotBetween(String value1, String value2) {
            addCriterion("user_uid not between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeIsNull() {
            addCriterion("first_level_type is null");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeIsNotNull() {
            addCriterion("first_level_type is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeEqualTo(Integer value) {
            addCriterion("first_level_type =", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeNotEqualTo(Integer value) {
            addCriterion("first_level_type <>", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeGreaterThan(Integer value) {
            addCriterion("first_level_type >", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_level_type >=", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeLessThan(Integer value) {
            addCriterion("first_level_type <", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("first_level_type <=", value, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeIn(List<Integer> values) {
            addCriterion("first_level_type in", values, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeNotIn(List<Integer> values) {
            addCriterion("first_level_type not in", values, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeBetween(Integer value1, Integer value2) {
            addCriterion("first_level_type between", value1, value2, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andFirstLevelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("first_level_type not between", value1, value2, "firstLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeIsNull() {
            addCriterion("second_level_type is null");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeIsNotNull() {
            addCriterion("second_level_type is not null");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeEqualTo(Integer value) {
            addCriterion("second_level_type =", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeNotEqualTo(Integer value) {
            addCriterion("second_level_type <>", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeGreaterThan(Integer value) {
            addCriterion("second_level_type >", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_level_type >=", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeLessThan(Integer value) {
            addCriterion("second_level_type <", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("second_level_type <=", value, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeIn(List<Integer> values) {
            addCriterion("second_level_type in", values, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeNotIn(List<Integer> values) {
            addCriterion("second_level_type not in", values, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeBetween(Integer value1, Integer value2) {
            addCriterion("second_level_type between", value1, value2, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andSecondLevelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("second_level_type not between", value1, value2, "secondLevelType");
            return (Criteria) this;
        }

        public Criteria andImplTravelIsNull() {
            addCriterion("impl_travel is null");
            return (Criteria) this;
        }

        public Criteria andImplTravelIsNotNull() {
            addCriterion("impl_travel is not null");
            return (Criteria) this;
        }

        public Criteria andImplTravelEqualTo(Byte value) {
            addCriterion("impl_travel =", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelNotEqualTo(Byte value) {
            addCriterion("impl_travel <>", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelGreaterThan(Byte value) {
            addCriterion("impl_travel >", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelGreaterThanOrEqualTo(Byte value) {
            addCriterion("impl_travel >=", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelLessThan(Byte value) {
            addCriterion("impl_travel <", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelLessThanOrEqualTo(Byte value) {
            addCriterion("impl_travel <=", value, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelIn(List<Byte> values) {
            addCriterion("impl_travel in", values, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelNotIn(List<Byte> values) {
            addCriterion("impl_travel not in", values, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelBetween(Byte value1, Byte value2) {
            addCriterion("impl_travel between", value1, value2, "implTravel");
            return (Criteria) this;
        }

        public Criteria andImplTravelNotBetween(Byte value1, Byte value2) {
            addCriterion("impl_travel not between", value1, value2, "implTravel");
            return (Criteria) this;
        }

        public Criteria andTravalReasonIsNull() {
            addCriterion("traval_reason is null");
            return (Criteria) this;
        }

        public Criteria andTravalReasonIsNotNull() {
            addCriterion("traval_reason is not null");
            return (Criteria) this;
        }

        public Criteria andTravalReasonEqualTo(String value) {
            addCriterion("traval_reason =", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonNotEqualTo(String value) {
            addCriterion("traval_reason <>", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonGreaterThan(String value) {
            addCriterion("traval_reason >", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonGreaterThanOrEqualTo(String value) {
            addCriterion("traval_reason >=", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonLessThan(String value) {
            addCriterion("traval_reason <", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonLessThanOrEqualTo(String value) {
            addCriterion("traval_reason <=", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonLike(String value) {
            addCriterion("traval_reason like", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonNotLike(String value) {
            addCriterion("traval_reason not like", value, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonIn(List<String> values) {
            addCriterion("traval_reason in", values, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonNotIn(List<String> values) {
            addCriterion("traval_reason not in", values, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonBetween(String value1, String value2) {
            addCriterion("traval_reason between", value1, value2, "travalReason");
            return (Criteria) this;
        }

        public Criteria andTravalReasonNotBetween(String value1, String value2) {
            addCriterion("traval_reason not between", value1, value2, "travalReason");
            return (Criteria) this;
        }

        public Criteria andOriginCityIsNull() {
            addCriterion("origin_city is null");
            return (Criteria) this;
        }

        public Criteria andOriginCityIsNotNull() {
            addCriterion("origin_city is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCityEqualTo(String value) {
            addCriterion("origin_city =", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotEqualTo(String value) {
            addCriterion("origin_city <>", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityGreaterThan(String value) {
            addCriterion("origin_city >", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityGreaterThanOrEqualTo(String value) {
            addCriterion("origin_city >=", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLessThan(String value) {
            addCriterion("origin_city <", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLessThanOrEqualTo(String value) {
            addCriterion("origin_city <=", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLike(String value) {
            addCriterion("origin_city like", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotLike(String value) {
            addCriterion("origin_city not like", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityIn(List<String> values) {
            addCriterion("origin_city in", values, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotIn(List<String> values) {
            addCriterion("origin_city not in", values, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityBetween(String value1, String value2) {
            addCriterion("origin_city between", value1, value2, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotBetween(String value1, String value2) {
            addCriterion("origin_city not between", value1, value2, "originCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityIsNull() {
            addCriterion("destination_city is null");
            return (Criteria) this;
        }

        public Criteria andDestinationCityIsNotNull() {
            addCriterion("destination_city is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationCityEqualTo(String value) {
            addCriterion("destination_city =", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityNotEqualTo(String value) {
            addCriterion("destination_city <>", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityGreaterThan(String value) {
            addCriterion("destination_city >", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityGreaterThanOrEqualTo(String value) {
            addCriterion("destination_city >=", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityLessThan(String value) {
            addCriterion("destination_city <", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityLessThanOrEqualTo(String value) {
            addCriterion("destination_city <=", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityLike(String value) {
            addCriterion("destination_city like", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityNotLike(String value) {
            addCriterion("destination_city not like", value, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityIn(List<String> values) {
            addCriterion("destination_city in", values, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityNotIn(List<String> values) {
            addCriterion("destination_city not in", values, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityBetween(String value1, String value2) {
            addCriterion("destination_city between", value1, value2, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andDestinationCityNotBetween(String value1, String value2) {
            addCriterion("destination_city not between", value1, value2, "destinationCity");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Long value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Long value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Long value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Long value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Long value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Long> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Long> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Long value1, Long value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Long value1, Long value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Long value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Long value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Long value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Long value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Long> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Long> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Long value1, Long value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryIsNull() {
            addCriterion("travel_summary is null");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryIsNotNull() {
            addCriterion("travel_summary is not null");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryEqualTo(String value) {
            addCriterion("travel_summary =", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryNotEqualTo(String value) {
            addCriterion("travel_summary <>", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryGreaterThan(String value) {
            addCriterion("travel_summary >", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("travel_summary >=", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryLessThan(String value) {
            addCriterion("travel_summary <", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryLessThanOrEqualTo(String value) {
            addCriterion("travel_summary <=", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryLike(String value) {
            addCriterion("travel_summary like", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryNotLike(String value) {
            addCriterion("travel_summary not like", value, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryIn(List<String> values) {
            addCriterion("travel_summary in", values, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryNotIn(List<String> values) {
            addCriterion("travel_summary not in", values, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryBetween(String value1, String value2) {
            addCriterion("travel_summary between", value1, value2, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTravelSummaryNotBetween(String value1, String value2) {
            addCriterion("travel_summary not between", value1, value2, "travelSummary");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentIsNull() {
            addCriterion("expense_department is null");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentIsNotNull() {
            addCriterion("expense_department is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentEqualTo(String value) {
            addCriterion("expense_department =", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentNotEqualTo(String value) {
            addCriterion("expense_department <>", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentGreaterThan(String value) {
            addCriterion("expense_department >", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("expense_department >=", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentLessThan(String value) {
            addCriterion("expense_department <", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentLessThanOrEqualTo(String value) {
            addCriterion("expense_department <=", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentLike(String value) {
            addCriterion("expense_department like", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentNotLike(String value) {
            addCriterion("expense_department not like", value, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentIn(List<String> values) {
            addCriterion("expense_department in", values, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentNotIn(List<String> values) {
            addCriterion("expense_department not in", values, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentBetween(String value1, String value2) {
            addCriterion("expense_department between", value1, value2, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andExpenseDepartmentNotBetween(String value1, String value2) {
            addCriterion("expense_department not between", value1, value2, "expenseDepartment");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodIsNull() {
            addCriterion("settlement_method is null");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodIsNotNull() {
            addCriterion("settlement_method is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodEqualTo(Byte value) {
            addCriterion("settlement_method =", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodNotEqualTo(Byte value) {
            addCriterion("settlement_method <>", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodGreaterThan(Byte value) {
            addCriterion("settlement_method >", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("settlement_method >=", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodLessThan(Byte value) {
            addCriterion("settlement_method <", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodLessThanOrEqualTo(Byte value) {
            addCriterion("settlement_method <=", value, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodIn(List<Byte> values) {
            addCriterion("settlement_method in", values, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodNotIn(List<Byte> values) {
            addCriterion("settlement_method not in", values, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodBetween(Byte value1, Byte value2) {
            addCriterion("settlement_method between", value1, value2, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andSettlementMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("settlement_method not between", value1, value2, "settlementMethod");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidIsNull() {
            addCriterion("bank_account_uid is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidIsNotNull() {
            addCriterion("bank_account_uid is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidEqualTo(String value) {
            addCriterion("bank_account_uid =", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidNotEqualTo(String value) {
            addCriterion("bank_account_uid <>", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidGreaterThan(String value) {
            addCriterion("bank_account_uid >", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_uid >=", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidLessThan(String value) {
            addCriterion("bank_account_uid <", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidLessThanOrEqualTo(String value) {
            addCriterion("bank_account_uid <=", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidLike(String value) {
            addCriterion("bank_account_uid like", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidNotLike(String value) {
            addCriterion("bank_account_uid not like", value, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidIn(List<String> values) {
            addCriterion("bank_account_uid in", values, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidNotIn(List<String> values) {
            addCriterion("bank_account_uid not in", values, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidBetween(String value1, String value2) {
            addCriterion("bank_account_uid between", value1, value2, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andBankAccountUidNotBetween(String value1, String value2) {
            addCriterion("bank_account_uid not between", value1, value2, "bankAccountUid");
            return (Criteria) this;
        }

        public Criteria andApproversIsNull() {
            addCriterion("approvers is null");
            return (Criteria) this;
        }

        public Criteria andApproversIsNotNull() {
            addCriterion("approvers is not null");
            return (Criteria) this;
        }

        public Criteria andApproversEqualTo(String value) {
            addCriterion("approvers =", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversNotEqualTo(String value) {
            addCriterion("approvers <>", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversGreaterThan(String value) {
            addCriterion("approvers >", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversGreaterThanOrEqualTo(String value) {
            addCriterion("approvers >=", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversLessThan(String value) {
            addCriterion("approvers <", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversLessThanOrEqualTo(String value) {
            addCriterion("approvers <=", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversLike(String value) {
            addCriterion("approvers like", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversNotLike(String value) {
            addCriterion("approvers not like", value, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversIn(List<String> values) {
            addCriterion("approvers in", values, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversNotIn(List<String> values) {
            addCriterion("approvers not in", values, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversBetween(String value1, String value2) {
            addCriterion("approvers between", value1, value2, "approvers");
            return (Criteria) this;
        }

        public Criteria andApproversNotBetween(String value1, String value2) {
            addCriterion("approvers not between", value1, value2, "approvers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersIsNull() {
            addCriterion("copy_users is null");
            return (Criteria) this;
        }

        public Criteria andCopyUsersIsNotNull() {
            addCriterion("copy_users is not null");
            return (Criteria) this;
        }

        public Criteria andCopyUsersEqualTo(String value) {
            addCriterion("copy_users =", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersNotEqualTo(String value) {
            addCriterion("copy_users <>", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersGreaterThan(String value) {
            addCriterion("copy_users >", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersGreaterThanOrEqualTo(String value) {
            addCriterion("copy_users >=", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersLessThan(String value) {
            addCriterion("copy_users <", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersLessThanOrEqualTo(String value) {
            addCriterion("copy_users <=", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersLike(String value) {
            addCriterion("copy_users like", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersNotLike(String value) {
            addCriterion("copy_users not like", value, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersIn(List<String> values) {
            addCriterion("copy_users in", values, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersNotIn(List<String> values) {
            addCriterion("copy_users not in", values, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersBetween(String value1, String value2) {
            addCriterion("copy_users between", value1, value2, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andCopyUsersNotBetween(String value1, String value2) {
            addCriterion("copy_users not between", value1, value2, "copyUsers");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRejectTypeIsNull() {
            addCriterion("reject_type is null");
            return (Criteria) this;
        }

        public Criteria andRejectTypeIsNotNull() {
            addCriterion("reject_type is not null");
            return (Criteria) this;
        }

        public Criteria andRejectTypeEqualTo(Byte value) {
            addCriterion("reject_type =", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeNotEqualTo(Byte value) {
            addCriterion("reject_type <>", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeGreaterThan(Byte value) {
            addCriterion("reject_type >", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("reject_type >=", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeLessThan(Byte value) {
            addCriterion("reject_type <", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeLessThanOrEqualTo(Byte value) {
            addCriterion("reject_type <=", value, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeIn(List<Byte> values) {
            addCriterion("reject_type in", values, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeNotIn(List<Byte> values) {
            addCriterion("reject_type not in", values, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeBetween(Byte value1, Byte value2) {
            addCriterion("reject_type between", value1, value2, "rejectType");
            return (Criteria) this;
        }

        public Criteria andRejectTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("reject_type not between", value1, value2, "rejectType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}