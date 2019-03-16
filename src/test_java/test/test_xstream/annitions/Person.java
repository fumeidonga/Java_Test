package test_java.test.test_xstream.annitions;

import java.util.Arrays;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamContainedType;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamConverters;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;

/**
 * 
 * @author david
 * 
 * 		@XStreamAlias("name") 最基本的类型，字段跟别名 重命名注解
 * 
 * @XStreamAsAttribute 将字段定义为属性
 * 
 * @XStreamImplicit 省略集合根节点,将列表定义为隐式集合
 * 
 * @XStreamOmitField 隐藏字段
 * 
 * @XStreamConverter 设置转换器 converter主要用于将某些字段进行复杂的转换
 * 
 * @XStreamAliasType 用于定义XStream类型别名的注释。
 * 
 * @XStreamConverters
 * 
 * @XStreamInclude 注释强制自动处理其他类。
 *
 */

@XStreamAliasType("人") // 用于定义XStream类型别名的注释。
// @XStreamAlias("人") // 定义类级别别名
public class Person {

	@XStreamAlias("name") // 定义字段级的别名
	@XStreamAsAttribute // 将字段定义为属性
	private String name;

	@XStreamAlias("age") // 定义字段级的别名
	@XStreamOmitField // 隐藏字段
	private int age;

	@XStreamAlias("sex") // 定义字段级的别名
	@XStreamConverter(value = BooleanConverter.class, booleans = { true, false }, strings = { "男", "女" }) // 设置转换器
	private boolean sex;

	@XStreamImplicit(itemFieldName="friends") // 省略集合根节点,将列表定义为隐式集合
	private List<String> friends;
	
	@XStreamImplicit(itemFieldName="bankcard") // 省略集合根节点,将列表定义为隐式集合
	private List<BankCard> BankCards;
	
	public List<BankCard> getBankCards() {
		return BankCards;
	}

	public void setBankCards(List<BankCard> bankCards) {
		BankCards = bankCards;
	}

	@XStreamAlias("bankcard")
	public static class BankCard {
		public String cardName;
		
		public int cardNo;

		public BankCard(String cardName, int cardNo){
			this.cardName = cardName;
			this.cardNo = cardNo;
		}
		public String getCardName() {
			return cardName;
		}

		public void setCardName(String cardName) {
			this.cardName = cardName;
		}

		public int getCardNo() {
			return cardNo;
		}

		public void setCardNo(int cardNo) {
			this.cardNo = cardNo;
		}
		
	}

	public Person(){
		
	}
	
	public Person(String name, int age, boolean sex, String... strings) {
		this.name = name;
		this.age = age;
		this.friends = Arrays.asList(strings);
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", friends=" + friends + "]";
	}

}
