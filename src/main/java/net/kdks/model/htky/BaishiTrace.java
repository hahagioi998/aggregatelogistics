package net.kdks.model.htky;

import java.util.List;

/**
 * 流转信息
 * @author wangze
 * @date 2020-10-10 19:07:25
 */
public class BaishiTrace {
	/**
	 * 流转信息项
	 */
	private List<BaishiTraceItems> trace;

	public List<BaishiTraceItems> getTrace() {
		return trace;
	}

	public void setTrace(List<BaishiTraceItems> trace) {
		this.trace = trace;
	}

	@Override
	public String toString() {
		return "BaishiTrace [trace=" + trace + "]";
	}
	
	
	
	
}
