package test_java.test.test_json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import test_java.test.socket.bean.CBaseDataBean;
import test_java.test.socket.bean.User;
import test_java.test.test_json.benas.LastNews;

/**
 * 
 * @author david
 *
 */
public class FastJsonTest {

	/**
	 * 测试fastjson 将实体类转换为 json 字符串 序列化
	 */
	@Test
	public void test() {
		// 1. 首先，拷贝jar包，创建两个实体类 User UserGroup 并赋值
		UserGroup group = new UserGroup();
		group.setId(1L);
		group.setName("admin");

		Employee guestUser = new Employee();
		guestUser.setId(2L);
		guestUser.setName("guest");
		guestUser.setDate(new Date());

		Employee rootUser = new Employee();
		rootUser.setId(3L);
		rootUser.setName("root");
		rootUser.setDate(new Date());

		ArrayList<Employee> mArrayList = new ArrayList<>();

		mArrayList.add(guestUser);
		mArrayList.add(rootUser);
		group.setUserList(mArrayList);

		// 2. 使用JSON.toJSONString 将实体类转换为json字符串
		String geString = JSON.toJSONString(guestUser);
		String rooString = JSON.toJSONString(rootUser);

		// 输出结果
		// {"date":1480578800595,"id":2,"name":"guest"}
		// {"date":1480578800595,"id":3,"name":"root"}
		System.out.println(geString);
		System.out.println(rooString);

		// fastjson序列化 List 返回来的是一个json数组，由[]包含两个json
		// {"id":1,"name":"admin","userList":[{"date":1480578800595,"id":2,"name":"guest"},{"date":1480578800595,"id":3,"name":"root"}]}
		String gString = JSON.toJSONString(group);
		System.out.println(gString);
	}

	/**
	 * 测试将json字符串转换为实体类 JSON.parseObject 反序列化
	 */
	@Test
	public void testParse() {
		String json = "{\"id\":1,\"name\":\"admin\",\"userList\":[{\"date\":1480578800595,"
				+ "\"id\":2,\"name\":\"guest\"},{\"date\":1480578800595,\"id\":3,\"name\":\"root\"}]}";
		
		String json1 = "{\"dataType\":1,\"json\":\"{\"result\":1,\"message\":{\"name\":\"梁国俏\",\"password\":\"123456\"}}\"}";
		User user1 = new User();  
        user1.setName("梁国俏");  
        user1.setPassword("123456");  
        String objStr = JSON.toJSONString(user1);
    	CBaseDataBean cbbean = new CBaseDataBean();
    	cbbean.setDataType(1);
    	cbbean.setJson(objStr);
        String objStrcc = JSON.toJSONString(cbbean);
        System.out.println(objStrcc);
        CBaseDataBean cBaseDataBean = JSON.parseObject(objStrcc, CBaseDataBean.class);
		
		System.out.println(cBaseDataBean);
		/*// 一般的反序列化
		UserGroup group = JSON.parseObject(json, UserGroup.class);
		// UserGroup [id=1, name=admin, userList=[User [id=2, name=guest,
		// date=Thu Dec 01 15:53:20 CST 2016], User [id=3, name=root, date=Thu
		// Dec 01 15:53:20 CST 2016]]]
		System.out.println(group.toString());

		// list 数组的反序列化
		List<Employee> list1 = group.getUserList();
		// List<User> list = JSON.parseArray(json, User.class);
		for (Employee user : list1) {

			System.out.println(user);
		}*/

		// Map<String,Object> map=(Map)JSON.parse(json);

	}

	// fastjson序列化单个对象 与反序列化
	@Test
	public void test1() {
		Employee e = new Employee("001", "张三", 23, new Date());

		// 序列化
		String jsonStr = JSON.toJSONString(e);
		System.out.println(jsonStr);

		// 反序列化
		Employee emp = JSON.parseObject(jsonStr, Employee.class);
		System.out.println(emp);
	}

	// fastjson序列化list集合 与反序列化
	@Test
	public void test2() {
		Employee e = new Employee("001", "张三", 23, new Date());
		Employee e2 = new Employee("002", "李四", 29, new Date());

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e);
		emps.add(e2);

		// fastjson序列化list， 返回来的是一个json数组，由[]包含两个json
		String jsonArryStr = JSON.toJSONString(emps);
		System.out.println(jsonArryStr);

		// //反序列化
		// 法一
		// List<Employee> empList = JSON.parseObject(jsonArryStr, new TypeReference<List<Employee>>(){} );
		// 法二
		List<Employee> empList = JSON.parseArray(jsonArryStr, Employee.class);
		for (Employee employee : empList) {
			System.out.println(employee.getName());
			System.out.println(employee.getDate());
		}

	}

	// fastjson序列化复杂对象 与反序列化
	@Test
	public void test3() {
		Employee e = new Employee("001", "张三", 23, new Date());
		Employee e2 = new Employee("002", "李四", 29, new Date());

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e);
		emps.add(e2);

		UserGroup dept = new UserGroup("d001", "研发部", emps);
		// 序列化
		String jsonStr = JSON.toJSONString(dept);
		System.out.println(jsonStr);

		// 反序列化
		UserGroup d = JSON.parseObject(jsonStr, UserGroup.class);
		System.out.println(d);

		// json转map
		// 法一
		Map<String, Object> map1 = JSON.parseObject(jsonStr);// 返回JSONObject，JSONObject实现Map<String,
																// Object>接口
		// 法二
		// Map<String, Object> map1 = (Map<String, Object>)JSON.parse(jsonStr);
		for (String key : map1.keySet()) {
			System.out.println(key + ":" + map1.get(key));
		}
	}

	// fastjson 的 JSONObject的使用
	@Test
	public void test4() {
		Employee e = new Employee("001", "张三", 23, new Date());

		// 序列化
		String jsonStr = JSON.toJSONString(e);
		System.out.println(jsonStr);

		// 反序列化 (可以和test1比较)
		JSONObject emp = JSON.parseObject(jsonStr, JSONObject.class);
		System.out.println(emp);
		System.out.println(emp.getString("name"));

		// 再放一个Employee不存在的字段
		emp.put("salary", "8000");
		System.out.println(emp.toJSONString());
		System.out.println(emp.get("salary"));

	}

	// fastjson序列化字符串
	@Test
	public void test5() {

		List<String> strs = new ArrayList<String>();
		strs.add("hello");
		strs.add("world");
		strs.add("banana");

		// 序列化
		String jsonStr = JSON.toJSONString(strs);
		System.out.println(jsonStr);

		// 反序列化
		List<String> strList = JSON.parseObject(jsonStr, new TypeReference<List<String>>() {
		});
		// List<String> strList = JSON.parseArray(jsonStr,
		// String.class);//等同于上一句
		for (String str : strList) {
			System.out.println(str);
		}
	}

	// fastjson过滤字段
	@Test
	public void test6() {

		Employee e = new Employee("001", "张三", 23, new Date());
		Employee e2 = new Employee("002", "李四", 29, new Date());

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e);
		emps.add(e2);

		// 构造过滤器
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Employee.class, "id", "age");
		String jsonStr = JSON.toJSONString(emps, filter);

		System.out.println(jsonStr);
	}

	// fastjson 日期处理
	@Test
	public void test7() {

		Date date = new Date();

		String dateStr = JSON.toJSONString(date);
		System.out.println(dateStr);

		String dateStr2 = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println(dateStr2);

		// 序列化实体
		Employee emp = new Employee("001", "张三", 23, new Date());

		// 法一
		String empStr = JSON.toJSONStringWithDateFormat(emp, "yyyy-MM-dd HH:mm:ss");
		System.out.println(empStr);
		// 法二
		String empStr2 = JSON.toJSONString(emp, SerializerFeature.WriteDateUseDateFormat);
		System.out.println(empStr2);

		// 法三
		SerializeConfig config = new SerializeConfig();
		config.put(Date.class, new SimpleDateFormatSerializer("yyyy年MM月dd日 HH时mm分ss秒"));
		String empStr3 = JSON.toJSONString(emp, config);
		System.out.println(empStr3);
	}

	// fastjson 去掉值的双引号 实现JSONAware接口
	@Test
	public void test8() {
		// 见同级目录的Function.java
	}
	
	@Test
	public void test9(){
		String json = "{\n" +
				"    \"date\": \"20170309\",\n" +
				"    \"stories\": [\n" +
				"        {\n" +
				"            \"images\": [\n" +
				"                \"http://pic4.zhimg.com/4f9665a1a920cc5d139dd9c68636e2e7.jpg\"\n" +
				"            ],\n" +
				"            \"type\": 0,\n" +
				"            \"id\": 9275902,\n" +
				"            \"ga_prefix\": \"030913\",\n" +
				"            \"title\": \"靠着直播，陌陌赚了不少钱，盈利能力超过了微博\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"images\": [\n" +
				"                \"http://pic3.zhimg.com/41aa8d3163f78a9d8fa2955252e09a1e.jpg\"\n" +
				"            ],\n" +
				"            \"type\": 0,\n" +
				"            \"id\": 9275502,\n" +
				"            \"ga_prefix\": \"030912\",\n" +
				"            \"title\": \"大误 · 大话西游中的隐藏剧情\"\n" +
				"        }\n" +
				"    ],\n" +
				"    \"top_stories\": [\n" +
				"        {\n" +
				"            \"image\": \"http://pic4.zhimg.com/287a31b1a17abefc08e7bf4cee5f754f.jpg\",\n" +
				"            \"type\": 0,\n" +
				"            \"id\": 9275902,\n" +
				"            \"ga_prefix\": \"030913\",\n" +
				"            \"title\": \"靠着直播，陌陌赚了不少钱，盈利能力超过了微博\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"image\": \"http://pic2.zhimg.com/298008981f6413b82e2835162652f1fd.jpg\",\n" +
				"            \"type\": 0,\n" +
				"            \"id\": 9273684,\n" +
				"            \"ga_prefix\": \"030815\",\n" +
				"            \"title\": \"NBA 和微博成了合作伙伴，腾讯：我可能买到了假版权\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";

		//System.out.println(json);
		// 一般的反序列化
		LastNews group = JSON.parseObject(json, LastNews.class);
		// UserGroup [id=1, name=admin, userList=[User [id=2, name=guest,
		// date=Thu Dec 01 15:53:20 CST 2016], User [id=3, name=root, date=Thu
		// Dec 01 15:53:20 CST 2016]]]
		System.out.println(group.toString());
	}
}
