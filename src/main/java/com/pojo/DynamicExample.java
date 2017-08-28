package com.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DynamicExample {

	/**
	 * 排序从句
	 */
	protected String orderByClause;

	/**
	 * 是否使用distinct查询（去重查询）
	 */
	protected boolean distinct;

	/**
	 * example中包含多个criteria，
	 * criteria包含多个Criterion条件，条件中的内容是以and的形式加到where上的，
	 * criteria与criteria之间是以or的形式添加到where中的。
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * 构造方法，初始化criteria条件列表。
	 */
	public DynamicExample() {
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

	/**
	 * or形式在条件语句criteria列表中拼接一个新的criteria。
	 * @param criteria [Criteria]自定义的条件
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * or形式在条件语句criteria列表中创建一个新的criteria，并返回。
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria，
	 * 如果criteria列表中没有元素，则返回根节点。
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 创建一个条件语句criteria（内部方法）。
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 清空criteria列表中。
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	 /**
	 * 每个crteria中都有一个criterion列表，子条件列表，用and语句相互连接。
	 */
	public static class Criterion {

		 /**
		 * 条件关键字，例如：>=、<=等等
		 */
		private String condition;

		/**
		 * 条件语句会用到的值1
		 */
		private Object value;

		/**
		 * 条件语句会用到的值2
		 */
		private Object secondValue;

		/**
		 * 条件关键字没有值，例如：not null、 null
		 */
		private boolean noValue;

		/**
		 * 条件关键字有且只有一个值，例如：>= 1、<= 1
		 */
		private boolean singleValue;

		/**
		 * 条件关键字有且只有两个值，例如：between 1 and 2
		 */
		private boolean betweenValue;

		/**
		 * 条件关键字有且只有一个列表的值，例如：in(1、2、3、4)
		 */
		private boolean listValue;

		/**
		 * 该条件针对的字段名
		 */
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

		/**
		 * 无参数条件构造方法
		 * @param condition [String]条件关键字
		 */
		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		/**
		 * 单值参数或列表参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param typeHandler [String]该条件针对的字段名
		 */
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

		/**
		 * 单值参数或列表参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 */
		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		/**
		 * 双参数构造方法
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 * @param typeHandler [String]该条件针对的字段名
		 */
		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		/**
		 * 双参数构造方法（不指定所属字段）
		 * @param condition [String]条件关键字
		 * @param value [Object]条件语句会用到的值1
		 * @param secondValue [Object]条件语句会用到的值2
		 */
		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
	 * criteria条件类，父类GeneratedCriteria是动态生成的。
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	/**
	 * 动态生成的Criteria父类
	 */
	protected abstract static class GeneratedCriteria {

		/**
		 * 条件列表集合
		 */
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		/**
		 * 条件列表集合中是否有值
		 * @return [boolean]true : 有、 false : 没有
		 */
		public boolean isValid() {
			return criteria.size() > 0;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		/**
		 * 获取条件列表集合
		 * @return [List<Criterion>]条件列表集合
		 */
		public List<Criterion> getCriteria() {
			return criteria;
		}

		/**
		 * 无参数添加条件
 		 * @param condition [String]条件语句
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		/**
		 * 单参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value [Object]条件语句会用到的值1
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		/**
		 * 双参数添加条件
 		 * @param condition [String]条件语句
 		 * @param value1 [Object]条件语句会用到的值1
 		 * @param value2 [Object]条件语句会用到的值2
 		 * @param property [String]该条件针对的属性名
		 * @exception [RuntimeException]输入条件语句不能为null
		 */
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		/**
		 * dynamic_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdIsNull() {
			addCriterion("dynamic_id is null");
			return (Criteria) this;
		}

		/**
		 * dynamic_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdIsNotNull() {
			addCriterion("dynamic_id is not null");
			return (Criteria) this;
		}

		/**
		 * dynamic_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdEqualTo(Integer value) {
			addCriterion("dynamic_id =", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdNotEqualTo(Integer value) {
			addCriterion("dynamic_id <>", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdGreaterThan(Integer value) {
			addCriterion("dynamic_id >", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("dynamic_id >=", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdLessThan(Integer value) {
			addCriterion("dynamic_id <", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdLessThanOrEqualTo(Integer value) {
			addCriterion("dynamic_id <=", value, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdIn(List<Integer> values) {
			addCriterion("dynamic_id in", values, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdNotIn(List<Integer> values) {
			addCriterion("dynamic_id not in", values, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdBetween(Integer value1, Integer value2) {
			addCriterion("dynamic_id between", value1, value2, "dynamicId");
			return (Criteria) this;
		}

		/**
		 * dynamic_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDynamicIdNotBetween(Integer value1, Integer value2) {
			addCriterion("dynamic_id not between", value1, value2, "dynamicId");
			return (Criteria) this;
		}
		/**
		 * d_time字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeIsNull() {
			addCriterion("d_time is null");
			return (Criteria) this;
		}

		/**
		 * d_time字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeIsNotNull() {
			addCriterion("d_time is not null");
			return (Criteria) this;
		}

		/**
		 * d_time等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeEqualTo(Timestamp value) {
			addCriterion("d_time =", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeNotEqualTo(Timestamp value) {
			addCriterion("d_time <>", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeGreaterThan(Timestamp value) {
			addCriterion("d_time >", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("d_time >=", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeLessThan(Timestamp value) {
			addCriterion("d_time <", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("d_time <=", value, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeIn(List<Timestamp> values) {
			addCriterion("d_time in", values, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time不在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeNotIn(List<Timestamp> values) {
			addCriterion("d_time not in", values, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("d_time between", value1, value2, "dTime");
			return (Criteria) this;
		}

		/**
		 * d_time不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDTimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("d_time not between", value1, value2, "dTime");
			return (Criteria) this;
		}
		/**
		 * p_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdIsNull() {
			addCriterion("p_id is null");
			return (Criteria) this;
		}

		/**
		 * p_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdIsNotNull() {
			addCriterion("p_id is not null");
			return (Criteria) this;
		}

		/**
		 * p_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdEqualTo(Integer value) {
			addCriterion("p_id =", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdNotEqualTo(Integer value) {
			addCriterion("p_id <>", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdGreaterThan(Integer value) {
			addCriterion("p_id >", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("p_id >=", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdLessThan(Integer value) {
			addCriterion("p_id <", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdLessThanOrEqualTo(Integer value) {
			addCriterion("p_id <=", value, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdIn(List<Integer> values) {
			addCriterion("p_id in", values, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdNotIn(List<Integer> values) {
			addCriterion("p_id not in", values, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdBetween(Integer value1, Integer value2) {
			addCriterion("p_id between", value1, value2, "pId");
			return (Criteria) this;
		}

		/**
		 * p_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPIdNotBetween(Integer value1, Integer value2) {
			addCriterion("p_id not between", value1, value2, "pId");
			return (Criteria) this;
		}
		/**
		 * action字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionIsNull() {
			addCriterion("action is null");
			return (Criteria) this;
		}

		/**
		 * action字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionIsNotNull() {
			addCriterion("action is not null");
			return (Criteria) this;
		}

		/**
		 * action等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionEqualTo(String value) {
			addCriterion("action =", value, "action");
			return (Criteria) this;
		}

		/**
		 * action不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionNotEqualTo(String value) {
			addCriterion("action <>", value, "action");
			return (Criteria) this;
		}

		/**
		 * action大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionGreaterThan(String value) {
			addCriterion("action >", value, "action");
			return (Criteria) this;
		}

		/**
		 * action大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionGreaterThanOrEqualTo(String value) {
			addCriterion("action >=", value, "action");
			return (Criteria) this;
		}

		/**
		 * action小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionLessThan(String value) {
			addCriterion("action <", value, "action");
			return (Criteria) this;
		}

		/**
		 * action小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionLessThanOrEqualTo(String value) {
			addCriterion("action <=", value, "action");
			return (Criteria) this;
		}

		/**
		 * action在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionIn(List<String> values) {
			addCriterion("action in", values, "action");
			return (Criteria) this;
		}

		/**
		 * action不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionNotIn(List<String> values) {
			addCriterion("action not in", values, "action");
			return (Criteria) this;
		}

		/**
		 * action在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionBetween(String value1, String value2) {
			addCriterion("action between", value1, value2, "action");
			return (Criteria) this;
		}

		/**
		 * action不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andActionNotBetween(String value1, String value2) {
			addCriterion("action not between", value1, value2, "action");
			return (Criteria) this;
		}
		/**
		 * u_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIsNull() {
			addCriterion("u_id is null");
			return (Criteria) this;
		}

		/**
		 * u_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIsNotNull() {
			addCriterion("u_id is not null");
			return (Criteria) this;
		}

		/**
		 * u_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdEqualTo(Integer value) {
			addCriterion("u_id =", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotEqualTo(Integer value) {
			addCriterion("u_id <>", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdGreaterThan(Integer value) {
			addCriterion("u_id >", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("u_id >=", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdLessThan(Integer value) {
			addCriterion("u_id <", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdLessThanOrEqualTo(Integer value) {
			addCriterion("u_id <=", value, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdIn(List<Integer> values) {
			addCriterion("u_id in", values, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotIn(List<Integer> values) {
			addCriterion("u_id not in", values, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdBetween(Integer value1, Integer value2) {
			addCriterion("u_id between", value1, value2, "uId");
			return (Criteria) this;
		}

		/**
		 * u_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUIdNotBetween(Integer value1, Integer value2) {
			addCriterion("u_id not between", value1, value2, "uId");
			return (Criteria) this;
		}
		/**
		 * be_operated字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedIsNull() {
			addCriterion("be_operated is null");
			return (Criteria) this;
		}

		/**
		 * be_operated字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedIsNotNull() {
			addCriterion("be_operated is not null");
			return (Criteria) this;
		}

		/**
		 * be_operated等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedEqualTo(Integer value) {
			addCriterion("be_operated =", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedNotEqualTo(Integer value) {
			addCriterion("be_operated <>", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedGreaterThan(Integer value) {
			addCriterion("be_operated >", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedGreaterThanOrEqualTo(Integer value) {
			addCriterion("be_operated >=", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedLessThan(Integer value) {
			addCriterion("be_operated <", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedLessThanOrEqualTo(Integer value) {
			addCriterion("be_operated <=", value, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedIn(List<Integer> values) {
			addCriterion("be_operated in", values, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedNotIn(List<Integer> values) {
			addCriterion("be_operated not in", values, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedBetween(Integer value1, Integer value2) {
			addCriterion("be_operated between", value1, value2, "beOperated");
			return (Criteria) this;
		}

		/**
		 * be_operated不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeOperatedNotBetween(Integer value1, Integer value2) {
			addCriterion("be_operated not between", value1, value2, "beOperated");
			return (Criteria) this;
		}
		/**
		 * be_table字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableIsNull() {
			addCriterion("be_table is null");
			return (Criteria) this;
		}

		/**
		 * be_table字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableIsNotNull() {
			addCriterion("be_table is not null");
			return (Criteria) this;
		}

		/**
		 * be_table等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableEqualTo(String value) {
			addCriterion("be_table =", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableNotEqualTo(String value) {
			addCriterion("be_table <>", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableGreaterThan(String value) {
			addCriterion("be_table >", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableGreaterThanOrEqualTo(String value) {
			addCriterion("be_table >=", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableLessThan(String value) {
			addCriterion("be_table <", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableLessThanOrEqualTo(String value) {
			addCriterion("be_table <=", value, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableIn(List<String> values) {
			addCriterion("be_table in", values, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableNotIn(List<String> values) {
			addCriterion("be_table not in", values, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableBetween(String value1, String value2) {
			addCriterion("be_table between", value1, value2, "beTable");
			return (Criteria) this;
		}

		/**
		 * be_table不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andBeTableNotBetween(String value1, String value2) {
			addCriterion("be_table not between", value1, value2, "beTable");
			return (Criteria) this;
		}

	}
}