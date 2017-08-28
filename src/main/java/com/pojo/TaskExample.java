package com.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskExample {

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
	public TaskExample() {
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
		 * task_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIsNull() {
			addCriterion("task_id is null");
			return (Criteria) this;
		}

		/**
		 * task_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIsNotNull() {
			addCriterion("task_id is not null");
			return (Criteria) this;
		}

		/**
		 * task_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdEqualTo(Integer value) {
			addCriterion("task_id =", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotEqualTo(Integer value) {
			addCriterion("task_id <>", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdGreaterThan(Integer value) {
			addCriterion("task_id >", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_id >=", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdLessThan(Integer value) {
			addCriterion("task_id <", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("task_id <=", value, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdIn(List<Integer> values) {
			addCriterion("task_id in", values, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotIn(List<Integer> values) {
			addCriterion("task_id not in", values, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("task_id between", value1, value2, "taskId");
			return (Criteria) this;
		}

		/**
		 * task_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("task_id not between", value1, value2, "taskId");
			return (Criteria) this;
		}
		/**
		 * task_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameIsNull() {
			addCriterion("task_name is null");
			return (Criteria) this;
		}

		/**
		 * task_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameIsNotNull() {
			addCriterion("task_name is not null");
			return (Criteria) this;
		}

		/**
		 * task_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameEqualTo(String value) {
			addCriterion("task_name =", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameNotEqualTo(String value) {
			addCriterion("task_name <>", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameGreaterThan(String value) {
			addCriterion("task_name >", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
			addCriterion("task_name >=", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameLessThan(String value) {
			addCriterion("task_name <", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameLessThanOrEqualTo(String value) {
			addCriterion("task_name <=", value, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameIn(List<String> values) {
			addCriterion("task_name in", values, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameNotIn(List<String> values) {
			addCriterion("task_name not in", values, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameBetween(String value1, String value2) {
			addCriterion("task_name between", value1, value2, "taskName");
			return (Criteria) this;
		}

		/**
		 * task_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskNameNotBetween(String value1, String value2) {
			addCriterion("task_name not between", value1, value2, "taskName");
			return (Criteria) this;
		}
		/**
		 * task_describe字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeIsNull() {
			addCriterion("task_describe is null");
			return (Criteria) this;
		}

		/**
		 * task_describe字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeIsNotNull() {
			addCriterion("task_describe is not null");
			return (Criteria) this;
		}

		/**
		 * task_describe等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeEqualTo(String value) {
			addCriterion("task_describe =", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeNotEqualTo(String value) {
			addCriterion("task_describe <>", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeGreaterThan(String value) {
			addCriterion("task_describe >", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("task_describe >=", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeLessThan(String value) {
			addCriterion("task_describe <", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeLessThanOrEqualTo(String value) {
			addCriterion("task_describe <=", value, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeIn(List<String> values) {
			addCriterion("task_describe in", values, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeNotIn(List<String> values) {
			addCriterion("task_describe not in", values, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeBetween(String value1, String value2) {
			addCriterion("task_describe between", value1, value2, "taskDescribe");
			return (Criteria) this;
		}

		/**
		 * task_describe不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskDescribeNotBetween(String value1, String value2) {
			addCriterion("task_describe not between", value1, value2, "taskDescribe");
			return (Criteria) this;
		}
		/**
		 * task_createtime字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeIsNull() {
			addCriterion("task_createtime is null");
			return (Criteria) this;
		}

		/**
		 * task_createtime字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeIsNotNull() {
			addCriterion("task_createtime is not null");
			return (Criteria) this;
		}

		/**
		 * task_createtime等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeEqualTo(Timestamp value) {
			addCriterion("task_createtime =", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeNotEqualTo(Timestamp value) {
			addCriterion("task_createtime <>", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeGreaterThan(Timestamp value) {
			addCriterion("task_createtime >", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("task_createtime >=", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeLessThan(Timestamp value) {
			addCriterion("task_createtime <", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("task_createtime <=", value, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeIn(List<Timestamp> values) {
			addCriterion("task_createtime in", values, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime不在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeNotIn(List<Timestamp> values) {
			addCriterion("task_createtime not in", values, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("task_createtime between", value1, value2, "taskCreatetime");
			return (Criteria) this;
		}

		/**
		 * task_createtime不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskCreatetimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("task_createtime not between", value1, value2, "taskCreatetime");
			return (Criteria) this;
		}
		/**
		 * task_finishtime字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeIsNull() {
			addCriterion("task_finishtime is null");
			return (Criteria) this;
		}

		/**
		 * task_finishtime字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeIsNotNull() {
			addCriterion("task_finishtime is not null");
			return (Criteria) this;
		}

		/**
		 * task_finishtime等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeEqualTo(Timestamp value) {
			addCriterion("task_finishtime =", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime不等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeNotEqualTo(Timestamp value) {
			addCriterion("task_finishtime <>", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime大于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeGreaterThan(Timestamp value) {
			addCriterion("task_finishtime >", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime大于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeGreaterThanOrEqualTo(Timestamp value) {
			addCriterion("task_finishtime >=", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime小于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeLessThan(Timestamp value) {
			addCriterion("task_finishtime <", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime小于等于传入值
		 * @param value [Timestamp]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeLessThanOrEqualTo(Timestamp value) {
			addCriterion("task_finishtime <=", value, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeIn(List<Timestamp> values) {
			addCriterion("task_finishtime in", values, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime不在传入值之中
		 * @param values [List<Timestamp>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeNotIn(List<Timestamp> values) {
			addCriterion("task_finishtime not in", values, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeBetween(Timestamp value1, Timestamp value2) {
			addCriterion("task_finishtime between", value1, value2, "taskFinishtime");
			return (Criteria) this;
		}

		/**
		 * task_finishtime不在传入值之间
		 * @param value1 [Timestamp]传入值1
		 * @param value2 [Timestamp]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskFinishtimeNotBetween(Timestamp value1, Timestamp value2) {
			addCriterion("task_finishtime not between", value1, value2, "taskFinishtime");
			return (Criteria) this;
		}
		/**
		 * task_user字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserIsNull() {
			addCriterion("task_user is null");
			return (Criteria) this;
		}

		/**
		 * task_user字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserIsNotNull() {
			addCriterion("task_user is not null");
			return (Criteria) this;
		}

		/**
		 * task_user等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserEqualTo(Integer value) {
			addCriterion("task_user =", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserNotEqualTo(Integer value) {
			addCriterion("task_user <>", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserGreaterThan(Integer value) {
			addCriterion("task_user >", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_user >=", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserLessThan(Integer value) {
			addCriterion("task_user <", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserLessThanOrEqualTo(Integer value) {
			addCriterion("task_user <=", value, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserIn(List<Integer> values) {
			addCriterion("task_user in", values, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserNotIn(List<Integer> values) {
			addCriterion("task_user not in", values, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserBetween(Integer value1, Integer value2) {
			addCriterion("task_user between", value1, value2, "taskUser");
			return (Criteria) this;
		}

		/**
		 * task_user不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskUserNotBetween(Integer value1, Integer value2) {
			addCriterion("task_user not between", value1, value2, "taskUser");
			return (Criteria) this;
		}
		/**
		 * task_assigner字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerIsNull() {
			addCriterion("task_assigner is null");
			return (Criteria) this;
		}

		/**
		 * task_assigner字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerIsNotNull() {
			addCriterion("task_assigner is not null");
			return (Criteria) this;
		}

		/**
		 * task_assigner等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerEqualTo(Integer value) {
			addCriterion("task_assigner =", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerNotEqualTo(Integer value) {
			addCriterion("task_assigner <>", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerGreaterThan(Integer value) {
			addCriterion("task_assigner >", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerGreaterThanOrEqualTo(Integer value) {
			addCriterion("task_assigner >=", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerLessThan(Integer value) {
			addCriterion("task_assigner <", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerLessThanOrEqualTo(Integer value) {
			addCriterion("task_assigner <=", value, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerIn(List<Integer> values) {
			addCriterion("task_assigner in", values, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerNotIn(List<Integer> values) {
			addCriterion("task_assigner not in", values, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerBetween(Integer value1, Integer value2) {
			addCriterion("task_assigner between", value1, value2, "taskAssigner");
			return (Criteria) this;
		}

		/**
		 * task_assigner不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskAssignerNotBetween(Integer value1, Integer value2) {
			addCriterion("task_assigner not between", value1, value2, "taskAssigner");
			return (Criteria) this;
		}
		/**
		 * status字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		/**
		 * status字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		/**
		 * status等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		/**
		 * status不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		/**
		 * status大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		/**
		 * status大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		/**
		 * status小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		/**
		 * status小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		/**
		 * status在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		/**
		 * status不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		/**
		 * status在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		/**
		 * status不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

	}
}