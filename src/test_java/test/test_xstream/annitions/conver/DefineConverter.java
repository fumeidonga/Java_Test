package test_java.test.test_xstream.annitions.conver;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 
 * @author david
 * 
 *         自定义的转换器 
 *         常用的转换器接口与抽象类 
 *         SingleValueConverter：单值转换接口
 *         AbstractSingleValueConverter：单值转换抽象类 
 *         Converter：常规转换器接口
 * 
 */
public class DefineConverter implements Converter {

	//定义转换器能转换的JavaBean类型
	@Override
	public boolean canConvert(Class type) {
		// TODO Auto-generated method stub
		return false;
	}

	//把对象序列化成XML或Json
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		// TODO Auto-generated method stub

	}

	//把XML或Json反序列化成对象
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
