package cn.ac.dicp.group1809.utilities.mzIdentML_reader.io.input;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.CVParam;
import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.ParamGroup;
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

	public static ParamGroup read(XMLStreamReader reader, ParamGroup paramGroup) {
		if (paramGroup instanceof CVParam) {
			CVParam cvParam = CVParamReader.read(reader);
			return cvParam;
		} else if (paramGroup instanceof UserParam) {
			UserParam userParam = UserParamReader.read(reader);
			return userParam;
		}
		logger.error("Invalid paramgroup type: " + paramGroup.getClass().getSimpleName());
		throw new IllegalArgumentException("Invalid paramgroup type: " + paramGroup.getClass().getSimpleName());
	}
}
