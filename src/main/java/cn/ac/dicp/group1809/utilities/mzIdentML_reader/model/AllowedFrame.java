package cn.ac.dicp.group1809.utilities.mzIdentML_reader.model;

/**
 * @author ZhengFang 2018/9/19
 * @since V1.0
 */
public enum AllowedFrame {
	Three(3),
	Two(2),
	One(1),
	MinusThree(-3),
	MinusTwo(-2),
	MinusOne(-1);

	private int frame;

	AllowedFrame(int frame) {
		this.frame = frame;
	}

	public int getFrame() {
		return frame;
	}

	public static AllowedFrame forAllowedFrame(int frame) {
		for (AllowedFrame allowedFrame : AllowedFrame.values()) {
			if (frame == allowedFrame.getFrame()) {
				return allowedFrame;
			}
		}
		throw new IllegalArgumentException("Invalid frame: " + frame);
	}
}
