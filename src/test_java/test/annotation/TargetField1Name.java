package test_java.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解元素的默认值：
 * 
 * 注解元素必须有确定的值，要么在定义注解的默认值中指定，要么在使用注解时指定，非基本类型的注解元素的值不可为null。 因此,
 * 使用空字符串或0作为默认值是一种常用的做法。这个约束使得处理器很难表现一个元素的存在或缺失的状态，
 * 因为每个注解的声明中，所有元素都存在，并且都具有相应的值，为了绕开这个约束，我们只能定义一些特殊的值，
 * 例如空字符串或者负数，一次表示某个元素不存在，在定义注解时，这已经成为一个习惯用法。
 * 
 * @author david
 * 
 *    1. ElementType .CONSTRUCTOR:用于描述构造器
　　　　2. ElementType .FIELD:用于描述域，全局变量，枚举
　　　　3. ElementType .LOCAL_VARIABLE:用于描述局部变量
　　　　4. ElementType .METHOD:用于描述方法
　　　　5. ElementType .PACKAGE:用于描述包
　　　　6. ElementType .PARAMETER:用于描述参数
　　　　7. ElementType .TYPE:用于描述类、接口(包括注解类型) 或enum声明

	RetentionPolicy .SOURCE（源码时注解仅存在于源码中，在class字节码文件中不包含），
	RetentionPolicy .CLASS（编译时默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得），
	RetentionPolicy .RUNTIME（运行时注解会在class字节码文件中存在，在运行时可以通过反射获取到），	默认为 CLASS
	
	自定义一个Annotation（@interface）
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetField1Name {
    String value() default "";
}
