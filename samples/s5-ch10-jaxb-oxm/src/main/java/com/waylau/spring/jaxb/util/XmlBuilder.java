package com.waylau.spring.jaxb.util;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Xml Builder.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月23日
 */
public class XmlBuilder {

	/**
	 * 将XML转为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */

	/**
	 * mynote： xml 转 object
	 */
	public static Object xmlStrToOject(Class<?> clazz, String xmlStr) throws Exception {
		Object xmlObject;
		Reader reader;
		JAXBContext context = JAXBContext.newInstance(clazz);

		// XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();

		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);

		if (null != reader) {
			reader.close();
		}

		return xmlObject;
	}
}
