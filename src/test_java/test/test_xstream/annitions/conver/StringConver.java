package test_java.test.test_xstream.annitions.conver;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * AbstractSingleValueConverter.class
 * BigDecimalConverter.class
 * BigIntegerConverter.class
 * BooleanConverter.class
 * ByteConverter.class
 * CharConverter.class
 * DateConverter.class
 * DoubleConverter.class
 * FloatConverter.class
 * IntConverter.class
 * LongConverter.class
 * NullConverter.class
 * ShortConverter.class
 * StringBufferConverter.class
 * StringBuilderConverter.class
 * StringConverter.class
 * URIConverter.class
 * URLConverter.class
 * UUIDConverter.class
 * 
 * @author david
 *
 */
public class StringConver extends StringConverter{

	//这里表示设置的值
	//<sex>&lt;![CDATA[nan]]&gt;</sex>
	@Override
	public String toString(Object obj) {
		return "<![CDATA[" + super.toString(obj) + "]]>";
	}

}
