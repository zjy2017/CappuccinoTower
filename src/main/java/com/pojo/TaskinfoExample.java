package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class TaskinfoExample {

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
	public TaskinfoExample() {
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
		 * taskinfo_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdIsNull() {
			addCriterion("taskinfo_id is null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdIsNotNull() {
			addCriterion("taskinfo_id is not null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdEqualTo(Integer value) {
			addCriterion("taskinfo_id =", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdNotEqualTo(Integer value) {
			addCriterion("taskinfo_id <>", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdGreaterThan(Integer value) {
			addCriterion("taskinfo_id >", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("taskinfo_id >=", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdLessThan(Integer value) {
			addCriterion("taskinfo_id <", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdLessThanOrEqualTo(Integer value) {
			addCriterion("taskinfo_id <=", value, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdIn(List<Integer> values) {
			addCriterion("taskinfo_id in", values, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdNotIn(List<Integer> values) {
			addCriterion("taskinfo_id not in", values, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdBetween(Integer value1, Integer value2) {
			addCriterion("taskinfo_id between", value1, value2, "taskinfoId");
			return (Criteria) this;
		}

		/**
		 * taskinfo_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("taskinfo_id not between", value1, value2, "taskinfoId");
			return (Criteria) this;
		}
		/**
		 * taskinfo_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameIsNull() {
			addCriterion("taskinfo_name is null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameIsNotNull() {
			addCriterion("taskinfo_name is not null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameEqualTo(String value) {
			addCriterion("taskinfo_name =", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameNotEqualTo(String value) {
			addCriterion("taskinfo_name <>", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameGreaterThan(String value) {
			addCriterion("taskinfo_name >", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameGreaterThanOrEqualTo(String value) {
			addCriterion("taskinfo_name >=", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameLessThan(String value) {
			addCriterion("taskinfo_name <", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameLessThanOrEqualTo(String value) {
			addCriterion("taskinfo_name <=", value, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameIn(List<String> values) {
			addCriterion("taskinfo_name in", values, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameNotIn(List<String> values) {
			addCriterion("taskinfo_name not in", values, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameBetween(String value1, String value2) {
			addCriterion("taskinfo_name between", value1, value2, "taskinfoName");
			return (Criteria) this;
		}

		/**
		 * taskinfo_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoNameNotBetween(String value1, String value2) {
			addCriterion("taskinfo_name not between", value1, value2, "taskinfoName");
			return (Criteria) this;
		}
		/**
		 * takinfo_describe字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeIsNull() {
			addCriterion("takinfo_describe is null");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeIsNotNull() {
			addCriterion("takinfo_describe is not null");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeEqualTo(String value) {
			addCriterion("takinfo_describe =", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeNotEqualTo(String value) {
			addCriterion("takinfo_describe <>", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeGreaterThan(String value) {
			addCriterion("takinfo_describe >", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("takinfo_describe >=", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeLessThan(String value) {
			addCriterion("takinfo_describe <", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeLessThanOrEqualTo(String value) {
			addCriterion("takinfo_describe <=", value, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeIn(List<String> values) {
			addCriterion("takinfo_describe in", values, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeNotIn(List<String> values) {
			addCriterion("takinfo_describe not in", values, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeBetween(String value1, String value2) {
			addCriterion("takinfo_describe between", value1, value2, "takinfoDescribe");
			return (Criteria) this;
		}

		/**
		 * takinfo_describe不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTakinfoDescribeNotBetween(String value1, String value2) {
			addCriterion("takinfo_describe not between", value1, value2, "takinfoDescribe");
			return (Criteria) this;
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
		 * taskinfo_user字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserIsNull() {
			addCriterion("taskinfo_user is null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserIsNotNull() {
			addCriterion("taskinfo_user is not null");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserEqualTo(Integer value) {
			addCriterion("taskinfo_user =", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserNotEqualTo(Integer value) {
			addCriterion("taskinfo_user <>", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserGreaterThan(Integer value) {
			addCriterion("taskinfo_user >", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("taskinfo_user >=", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserLessThan(Integer value) {
			addCriterion("taskinfo_user <", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserLessThanOrEqualTo(Integer value) {
			addCriterion("taskinfo_user <=", value, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserIn(List<Integer> values) {
			addCriterion("taskinfo_user in", values, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserNotIn(List<Integer> values) {
			addCriterion("taskinfo_user not in", values, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserBetween(Integer value1, Integer value2) {
			addCriterion("taskinfo_user between", value1, value2, "taskinfoUser");
			return (Criteria) this;
		}

		/**
		 * taskinfo_user不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTaskinfoUserNotBetween(Integer value1, Integer value2) {
			addCriterion("taskinfo_user not between", value1, value2, "taskinfoUser");
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

	}
}