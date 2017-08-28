package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {

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
	public ProjectExample() {
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
		 * p_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameIsNull() {
			addCriterion("p_name is null");
			return (Criteria) this;
		}

		/**
		 * p_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameIsNotNull() {
			addCriterion("p_name is not null");
			return (Criteria) this;
		}

		/**
		 * p_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameEqualTo(String value) {
			addCriterion("p_name =", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameNotEqualTo(String value) {
			addCriterion("p_name <>", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameGreaterThan(String value) {
			addCriterion("p_name >", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameGreaterThanOrEqualTo(String value) {
			addCriterion("p_name >=", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameLessThan(String value) {
			addCriterion("p_name <", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameLessThanOrEqualTo(String value) {
			addCriterion("p_name <=", value, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameIn(List<String> values) {
			addCriterion("p_name in", values, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameNotIn(List<String> values) {
			addCriterion("p_name not in", values, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameBetween(String value1, String value2) {
			addCriterion("p_name between", value1, value2, "pName");
			return (Criteria) this;
		}

		/**
		 * p_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPNameNotBetween(String value1, String value2) {
			addCriterion("p_name not between", value1, value2, "pName");
			return (Criteria) this;
		}
		/**
		 * p_describe字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeIsNull() {
			addCriterion("p_describe is null");
			return (Criteria) this;
		}

		/**
		 * p_describe字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeIsNotNull() {
			addCriterion("p_describe is not null");
			return (Criteria) this;
		}

		/**
		 * p_describe等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeEqualTo(String value) {
			addCriterion("p_describe =", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeNotEqualTo(String value) {
			addCriterion("p_describe <>", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeGreaterThan(String value) {
			addCriterion("p_describe >", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("p_describe >=", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeLessThan(String value) {
			addCriterion("p_describe <", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeLessThanOrEqualTo(String value) {
			addCriterion("p_describe <=", value, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeIn(List<String> values) {
			addCriterion("p_describe in", values, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeNotIn(List<String> values) {
			addCriterion("p_describe not in", values, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeBetween(String value1, String value2) {
			addCriterion("p_describe between", value1, value2, "pDescribe");
			return (Criteria) this;
		}

		/**
		 * p_describe不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPDescribeNotBetween(String value1, String value2) {
			addCriterion("p_describe not between", value1, value2, "pDescribe");
			return (Criteria) this;
		}
		/**
		 * p_sensitive字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveIsNull() {
			addCriterion("p_sensitive is null");
			return (Criteria) this;
		}

		/**
		 * p_sensitive字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveIsNotNull() {
			addCriterion("p_sensitive is not null");
			return (Criteria) this;
		}

		/**
		 * p_sensitive等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveEqualTo(Integer value) {
			addCriterion("p_sensitive =", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveNotEqualTo(Integer value) {
			addCriterion("p_sensitive <>", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveGreaterThan(Integer value) {
			addCriterion("p_sensitive >", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("p_sensitive >=", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveLessThan(Integer value) {
			addCriterion("p_sensitive <", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveLessThanOrEqualTo(Integer value) {
			addCriterion("p_sensitive <=", value, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveIn(List<Integer> values) {
			addCriterion("p_sensitive in", values, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveNotIn(List<Integer> values) {
			addCriterion("p_sensitive not in", values, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveBetween(Integer value1, Integer value2) {
			addCriterion("p_sensitive between", value1, value2, "pSensitive");
			return (Criteria) this;
		}

		/**
		 * p_sensitive不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andPSensitiveNotBetween(Integer value1, Integer value2) {
			addCriterion("p_sensitive not between", value1, value2, "pSensitive");
			return (Criteria) this;
		}
		/**
		 * ispublic字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicIsNull() {
			addCriterion("ispublic is null");
			return (Criteria) this;
		}

		/**
		 * ispublic字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicIsNotNull() {
			addCriterion("ispublic is not null");
			return (Criteria) this;
		}

		/**
		 * ispublic等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicEqualTo(Integer value) {
			addCriterion("ispublic =", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicNotEqualTo(Integer value) {
			addCriterion("ispublic <>", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicGreaterThan(Integer value) {
			addCriterion("ispublic >", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicGreaterThanOrEqualTo(Integer value) {
			addCriterion("ispublic >=", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicLessThan(Integer value) {
			addCriterion("ispublic <", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicLessThanOrEqualTo(Integer value) {
			addCriterion("ispublic <=", value, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicIn(List<Integer> values) {
			addCriterion("ispublic in", values, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicNotIn(List<Integer> values) {
			addCriterion("ispublic not in", values, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicBetween(Integer value1, Integer value2) {
			addCriterion("ispublic between", value1, value2, "ispublic");
			return (Criteria) this;
		}

		/**
		 * ispublic不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andIspublicNotBetween(Integer value1, Integer value2) {
			addCriterion("ispublic not between", value1, value2, "ispublic");
			return (Criteria) this;
		}
		/**
		 * t_id字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdIsNull() {
			addCriterion("t_id is null");
			return (Criteria) this;
		}

		/**
		 * t_id字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdIsNotNull() {
			addCriterion("t_id is not null");
			return (Criteria) this;
		}

		/**
		 * t_id等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdEqualTo(Integer value) {
			addCriterion("t_id =", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdNotEqualTo(Integer value) {
			addCriterion("t_id <>", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdGreaterThan(Integer value) {
			addCriterion("t_id >", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("t_id >=", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdLessThan(Integer value) {
			addCriterion("t_id <", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdLessThanOrEqualTo(Integer value) {
			addCriterion("t_id <=", value, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdIn(List<Integer> values) {
			addCriterion("t_id in", values, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdNotIn(List<Integer> values) {
			addCriterion("t_id not in", values, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdBetween(Integer value1, Integer value2) {
			addCriterion("t_id between", value1, value2, "tId");
			return (Criteria) this;
		}

		/**
		 * t_id不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andTIdNotBetween(Integer value1, Integer value2) {
			addCriterion("t_id not between", value1, value2, "tId");
			return (Criteria) this;
		}
		/**
		 * discusallid字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidIsNull() {
			addCriterion("discusallid is null");
			return (Criteria) this;
		}

		/**
		 * discusallid字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidIsNotNull() {
			addCriterion("discusallid is not null");
			return (Criteria) this;
		}

		/**
		 * discusallid等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidEqualTo(Integer value) {
			addCriterion("discusallid =", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidNotEqualTo(Integer value) {
			addCriterion("discusallid <>", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidGreaterThan(Integer value) {
			addCriterion("discusallid >", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidGreaterThanOrEqualTo(Integer value) {
			addCriterion("discusallid >=", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidLessThan(Integer value) {
			addCriterion("discusallid <", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidLessThanOrEqualTo(Integer value) {
			addCriterion("discusallid <=", value, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidIn(List<Integer> values) {
			addCriterion("discusallid in", values, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidNotIn(List<Integer> values) {
			addCriterion("discusallid not in", values, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidBetween(Integer value1, Integer value2) {
			addCriterion("discusallid between", value1, value2, "discusallid");
			return (Criteria) this;
		}

		/**
		 * discusallid不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andDiscusallidNotBetween(Integer value1, Integer value2) {
			addCriterion("discusallid not between", value1, value2, "discusallid");
			return (Criteria) this;
		}
		/**
		 * f_totalid字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidIsNull() {
			addCriterion("f_totalid is null");
			return (Criteria) this;
		}

		/**
		 * f_totalid字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidIsNotNull() {
			addCriterion("f_totalid is not null");
			return (Criteria) this;
		}

		/**
		 * f_totalid等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidEqualTo(Integer value) {
			addCriterion("f_totalid =", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid不等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidNotEqualTo(Integer value) {
			addCriterion("f_totalid <>", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid大于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidGreaterThan(Integer value) {
			addCriterion("f_totalid >", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid大于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidGreaterThanOrEqualTo(Integer value) {
			addCriterion("f_totalid >=", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid小于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidLessThan(Integer value) {
			addCriterion("f_totalid <", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid小于等于传入值
		 * @param value [Integer]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidLessThanOrEqualTo(Integer value) {
			addCriterion("f_totalid <=", value, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidIn(List<Integer> values) {
			addCriterion("f_totalid in", values, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid不在传入值之中
		 * @param values [List<Integer>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidNotIn(List<Integer> values) {
			addCriterion("f_totalid not in", values, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidBetween(Integer value1, Integer value2) {
			addCriterion("f_totalid between", value1, value2, "fTotalid");
			return (Criteria) this;
		}

		/**
		 * f_totalid不在传入值之间
		 * @param value1 [Integer]传入值1
		 * @param value2 [Integer]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andFTotalidNotBetween(Integer value1, Integer value2) {
			addCriterion("f_totalid not between", value1, value2, "fTotalid");
			return (Criteria) this;
		}

	}
}