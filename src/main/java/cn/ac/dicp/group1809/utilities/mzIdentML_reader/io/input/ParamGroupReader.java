package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AbstractParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.UserParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamReader;

/**
 * @author ZhengFang 2018/9/20
 * @since V1.0
 */
public class ParamGroupReader {
	private static Logger logger = LoggerFactory.getLogger(ParamGroupReader.class);

	public static AbstractParam read(XMLStreamReader reader, AbstractParam paramGroup) {
		if (paramGroup instanceof CVParam) {
			return CVParamReader.read(reader);
		} else if (paramGroup instanceof UserParam) {
			return UserParamReader.read(reader);
		}
		logger.error("Invalid paramgroup type: " + paramGroup.getClass().getSimpleName());
		throw new IllegalArgumentException("Invalid paramgroup type: " + paramGroup.getClass().getSimpleName());
	}
}
