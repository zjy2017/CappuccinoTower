package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserExample {

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
	public UserExample() {
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
		 * u_email字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailIsNull() {
			addCriterion("u_email is null");
			return (Criteria) this;
		}

		/**
		 * u_email字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailIsNotNull() {
			addCriterion("u_email is not null");
			return (Criteria) this;
		}

		/**
		 * u_email等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailEqualTo(String value) {
			addCriterion("u_email =", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailNotEqualTo(String value) {
			addCriterion("u_email <>", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailGreaterThan(String value) {
			addCriterion("u_email >", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailGreaterThanOrEqualTo(String value) {
			addCriterion("u_email >=", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailLessThan(String value) {
			addCriterion("u_email <", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailLessThanOrEqualTo(String value) {
			addCriterion("u_email <=", value, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailIn(List<String> values) {
			addCriterion("u_email in", values, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailNotIn(List<String> values) {
			addCriterion("u_email not in", values, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailBetween(String value1, String value2) {
			addCriterion("u_email between", value1, value2, "uEmail");
			return (Criteria) this;
		}

		/**
		 * u_email不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUEmailNotBetween(String value1, String value2) {
			addCriterion("u_email not between", value1, value2, "uEmail");
			return (Criteria) this;
		}
		/**
		 * u_password字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordIsNull() {
			addCriterion("u_password is null");
			return (Criteria) this;
		}

		/**
		 * u_password字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordIsNotNull() {
			addCriterion("u_password is not null");
			return (Criteria) this;
		}

		/**
		 * u_password等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordEqualTo(String value) {
			addCriterion("u_password =", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordNotEqualTo(String value) {
			addCriterion("u_password <>", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordGreaterThan(String value) {
			addCriterion("u_password >", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("u_password >=", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordLessThan(String value) {
			addCriterion("u_password <", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordLessThanOrEqualTo(String value) {
			addCriterion("u_password <=", value, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordIn(List<String> values) {
			addCriterion("u_password in", values, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordNotIn(List<String> values) {
			addCriterion("u_password not in", values, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordBetween(String value1, String value2) {
			addCriterion("u_password between", value1, value2, "uPassword");
			return (Criteria) this;
		}

		/**
		 * u_password不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPasswordNotBetween(String value1, String value2) {
			addCriterion("u_password not between", value1, value2, "uPassword");
			return (Criteria) this;
		}
		/**
		 * u_picture字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureIsNull() {
			addCriterion("u_picture is null");
			return (Criteria) this;
		}

		/**
		 * u_picture字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureIsNotNull() {
			addCriterion("u_picture is not null");
			return (Criteria) this;
		}

		/**
		 * u_picture等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureEqualTo(String value) {
			addCriterion("u_picture =", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureNotEqualTo(String value) {
			addCriterion("u_picture <>", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureGreaterThan(String value) {
			addCriterion("u_picture >", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureGreaterThanOrEqualTo(String value) {
			addCriterion("u_picture >=", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureLessThan(String value) {
			addCriterion("u_picture <", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureLessThanOrEqualTo(String value) {
			addCriterion("u_picture <=", value, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureIn(List<String> values) {
			addCriterion("u_picture in", values, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureNotIn(List<String> values) {
			addCriterion("u_picture not in", values, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureBetween(String value1, String value2) {
			addCriterion("u_picture between", value1, value2, "uPicture");
			return (Criteria) this;
		}

		/**
		 * u_picture不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUPictureNotBetween(String value1, String value2) {
			addCriterion("u_picture not between", value1, value2, "uPicture");
			return (Criteria) this;
		}
		/**
		 * u_name字段为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameIsNull() {
			addCriterion("u_name is null");
			return (Criteria) this;
		}

		/**
		 * u_name字段为不为null
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameIsNotNull() {
			addCriterion("u_name is not null");
			return (Criteria) this;
		}

		/**
		 * u_name等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameEqualTo(String value) {
			addCriterion("u_name =", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name不等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameNotEqualTo(String value) {
			addCriterion("u_name <>", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name大于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameGreaterThan(String value) {
			addCriterion("u_name >", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name大于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameGreaterThanOrEqualTo(String value) {
			addCriterion("u_name >=", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name小于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameLessThan(String value) {
			addCriterion("u_name <", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name小于等于传入值
		 * @param value [String]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameLessThanOrEqualTo(String value) {
			addCriterion("u_name <=", value, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameIn(List<String> values) {
			addCriterion("u_name in", values, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name不在传入值之中
		 * @param values [List<String>]传入值
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameNotIn(List<String> values) {
			addCriterion("u_name not in", values, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameBetween(String value1, String value2) {
			addCriterion("u_name between", value1, value2, "uName");
			return (Criteria) this;
		}

		/**
		 * u_name不在传入值之间
		 * @param value1 [String]传入值1
		 * @param value2 [String]传入值2
		 * @return [Criteria]更新后的criteria
		 */
		public Criteria andUNameNotBetween(String value1, String value2) {
			addCriterion("u_name not between", value1, value2, "uName");
			return (Criteria) this;
		}

	}
}