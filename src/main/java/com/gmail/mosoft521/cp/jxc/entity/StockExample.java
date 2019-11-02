package com.gmail.mosoft521.cp.jxc.entity;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andProductNoIsNull() {
            addCriterion("product_no is null");
            return (Criteria) this;
        }

        public Criteria andProductNoIsNotNull() {
            addCriterion("product_no is not null");
            return (Criteria) this;
        }

        public Criteria andProductNoEqualTo(String value) {
            addCriterion("product_no =", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotEqualTo(String value) {
            addCriterion("product_no <>", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThan(String value) {
            addCriterion("product_no >", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoGreaterThanOrEqualTo(String value) {
            addCriterion("product_no >=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThan(String value) {
            addCriterion("product_no <", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLessThanOrEqualTo(String value) {
            addCriterion("product_no <=", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoLike(String value) {
            addCriterion("product_no like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotLike(String value) {
            addCriterion("product_no not like", value, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoIn(List<String> values) {
            addCriterion("product_no in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotIn(List<String> values) {
            addCriterion("product_no not in", values, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoBetween(String value1, String value2) {
            addCriterion("product_no between", value1, value2, "productNo");
            return (Criteria) this;
        }

        public Criteria andProductNoNotBetween(String value1, String value2) {
            addCriterion("product_no not between", value1, value2, "productNo");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentIsNull() {
            addCriterion("quantity_current is null");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentIsNotNull() {
            addCriterion("quantity_current is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentEqualTo(Float value) {
            addCriterion("quantity_current =", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentNotEqualTo(Float value) {
            addCriterion("quantity_current <>", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentGreaterThan(Float value) {
            addCriterion("quantity_current >", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentGreaterThanOrEqualTo(Float value) {
            addCriterion("quantity_current >=", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentLessThan(Float value) {
            addCriterion("quantity_current <", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentLessThanOrEqualTo(Float value) {
            addCriterion("quantity_current <=", value, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentIn(List<Float> values) {
            addCriterion("quantity_current in", values, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentNotIn(List<Float> values) {
            addCriterion("quantity_current not in", values, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentBetween(Float value1, Float value2) {
            addCriterion("quantity_current between", value1, value2, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityCurrentNotBetween(Float value1, Float value2) {
            addCriterion("quantity_current not between", value1, value2, "quantityCurrent");
            return (Criteria) this;
        }

        public Criteria andQuantityMinIsNull() {
            addCriterion("quantity_min is null");
            return (Criteria) this;
        }

        public Criteria andQuantityMinIsNotNull() {
            addCriterion("quantity_min is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityMinEqualTo(Float value) {
            addCriterion("quantity_min =", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinNotEqualTo(Float value) {
            addCriterion("quantity_min <>", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinGreaterThan(Float value) {
            addCriterion("quantity_min >", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinGreaterThanOrEqualTo(Float value) {
            addCriterion("quantity_min >=", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinLessThan(Float value) {
            addCriterion("quantity_min <", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinLessThanOrEqualTo(Float value) {
            addCriterion("quantity_min <=", value, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinIn(List<Float> values) {
            addCriterion("quantity_min in", values, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinNotIn(List<Float> values) {
            addCriterion("quantity_min not in", values, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinBetween(Float value1, Float value2) {
            addCriterion("quantity_min between", value1, value2, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMinNotBetween(Float value1, Float value2) {
            addCriterion("quantity_min not between", value1, value2, "quantityMin");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxIsNull() {
            addCriterion("quantity_max is null");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxIsNotNull() {
            addCriterion("quantity_max is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxEqualTo(Float value) {
            addCriterion("quantity_max =", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxNotEqualTo(Float value) {
            addCriterion("quantity_max <>", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxGreaterThan(Float value) {
            addCriterion("quantity_max >", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxGreaterThanOrEqualTo(Float value) {
            addCriterion("quantity_max >=", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxLessThan(Float value) {
            addCriterion("quantity_max <", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxLessThanOrEqualTo(Float value) {
            addCriterion("quantity_max <=", value, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxIn(List<Float> values) {
            addCriterion("quantity_max in", values, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxNotIn(List<Float> values) {
            addCriterion("quantity_max not in", values, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxBetween(Float value1, Float value2) {
            addCriterion("quantity_max between", value1, value2, "quantityMax");
            return (Criteria) this;
        }

        public Criteria andQuantityMaxNotBetween(Float value1, Float value2) {
            addCriterion("quantity_max not between", value1, value2, "quantityMax");
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