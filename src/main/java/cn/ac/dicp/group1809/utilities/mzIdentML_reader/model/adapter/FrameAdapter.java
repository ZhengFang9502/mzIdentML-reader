package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.adapter;

import cn.ac.dicp.group1809.utilities.mzIdentML_reader.model.AllowedFrame;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author ZhengFang 2018/9/18
 * @since V1.0
 */
public class FrameAdapter extends XmlAdapter<Integer, AllowedFrame> {
	@Override
	public AllowedFrame unmarshal(Integer v) {
		return AllowedFrame.forAllowedFrame(v);
	}

	@Override
	public Integer marshal(AllowedFrame v) {
		if (v == null) {
			return null;
		}
		return v.getFrame();
	}
}
