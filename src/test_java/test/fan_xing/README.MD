https://blog.csdn.net/u012152619/article/details/47253811


命名规则
类型参数的命名有一套默认规则，为了提高代码的维护性和可读性，强烈建议遵循这些规则。JDK中，随处可见这些命名规则的应用。

E - Element (通常代表集合类中的元素)

K - Key

N - Number

T - Type

V - Value

S,U,V etc. – 第二个，第三个，第四个类型参数……


泛型的本质是参数化类型
例如：使用 Java 泛型的概念，我们可以写一个泛型方法来对一个对象数组排序。然后，调用该泛型方法来对整型数组、浮点数数组、字符串数组等进行排序， 该方法在调用时可以接收不同类型的参数

泛型接口
	public interface Generator<T> {
	    T next();
	}

泛型方法
    //定义泛型方法，只需将泛型参数列表置于返回值之前
	public static <T, V> T getT(T t, V v){
		return null;
	}
	
	public static <T> void sysOut(T t){
		System.out.println(t.getClass().getName());
	}

泛型类

边界符
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}


类型通配符
public class GenericTest {
     
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        
        name.add("icon");
        age.add(18);
        number.add(314);
 
        getData(name);
        getData(age);
        getData(number);
       
   }
 
   public static void getData(List<?> data) {
      System.out.println("data :" + data.get(0));
   }
}
类型通配符上限
       public static void getUperNumber(List<? extends Number> data) {
          System.out.println("data :" + data.get(0));
       }
       
类型通配符下限       
    ? super Number 表示类型只能接受Number及其三层父类类型   
       
       
       
       