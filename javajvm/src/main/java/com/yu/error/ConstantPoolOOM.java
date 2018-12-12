package com.yu.error;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法区(永生区)内存溢出
 * 	
 *  方法区存放的是类的相关信息，如class信息(类名、访问修饰符、方法描述、字段描述)、常量、静态变量等，方法区包含常量池，常量池中存放常量。
 *  
 * 	方法区内存异常分为两种情况：
 * 		1.常量池内存溢出
 * 			常量太多
 * 		2.方法区内存溢出
 * 			新建的类太多(需要保存的class信息太多)
 * 
 * @author yuchangying
 *
 * JVM参数：VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 	-XX:PermSize=10M 方法区大小为10M
 *  -XX:MaxPermSize=10M 方法区最大为10M
 *  
 * Java1.8后-XX:PermSize=10M -XX:MaxPermSize=10M设置参数均无效，因为把常量池、类的元数据、类的静态变量移动到堆内存中。
 * 
 *  
 * 
 */
public class ConstantPoolOOM {

	public static void main(String[] args) {
		//保证不会被垃圾回收
		List<String> list = new ArrayList<String>();
		
		int i= 0;
		//String.intern(),常量池用有没有，有就拿出来，没有就放进去
		while(true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
