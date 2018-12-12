package com.yu.error;

/**
 * 虚拟机栈和本地方法栈溢出
 * 
 * 虚拟机栈：方法执行的内存模型，用于保存方法的局部变量、动态链接、方法出口等。
 * 		    每个线程都会开辟自己独立的虚拟机栈，也就是说————虚拟机栈可以有很多。
 * 本地方法栈：与虚拟机栈相似，用于保存native方法执行的数据的存储区。
 * 
 * 虚拟机栈和本地方法栈溢出的两种异常：
 * 		StackOverflowError
 * 			线程请求的深度大于虚拟机允许的最大深度（如递归调用：方法中调用方法）。
 * 		OutOfMemoryError
 * 			线程太多。因为32位操作系统的jvm容量为2G，2G-Xmx(最大堆容量)-MaxPermSize(最大方法区容量)=虚拟机栈+本地方法区。
 * 			很多虚拟机将(虚拟机栈+本地方法区)合并成一个区域，而每个线程的大小在JDK1.6后为1M,所以(虚拟机栈+本地方法区容量)/1M=线程数。
 * 			线程数太多，超过了(虚拟机栈+本地方法区容量)就会造成OutOfMemoryError。
 * 
 * @author yuchangying
 *
 * 此类是测试StackOverflowError异常————线程请求深度过深
 * 设置虚拟机参数：
 * 	VM Args:-Xss228k
 * 	 -Xss228k————栈内存容量228k(一个线程的大小228k，现在使用的是jdk1.8，最小设置为228k)
 * 
 * 异常信息：
 * stackLength = 1517
 *	Exception in thread "main" java.lang.StackOverflowError
 *		at com.yu.error.VMStackSOF.stackLeak(VMStackSOF.java:31)
 *		at com.yu.error.VMStackSOF.stackLeak(VMStackSOF.java:32)
 *		at com.yu.error.VMStackSOF.stackLeak(VMStackSOF.java:32)
 *
 * 深度为1517
 */
public class VMStackSOF {
	
	private int stackLength = 1;
	
	//一直调用自己，深度越来越大
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		VMStackSOF vs = new VMStackSOF();
		try {
			vs.stackLeak();
		}catch (Throwable e) {
			// TODO: handle exception
			System.out.println("stackLength = " + vs.stackLength );
			throw e;
		}
	}
}
