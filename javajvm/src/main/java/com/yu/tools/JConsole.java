package com.yu.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用JConsole JDK可视化工具监控JVM内存
 * 
 * JConsole工具在jdk/bin目录下
 * 
 * @author yuchangying
 *
 */
public class JConsole {

	static class OOMObject{
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		for(int i=0; i<num; i++) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}
	public static void main(String[] args) throws InterruptedException {
		JConsole.fillHeap(1000);
	}
}
