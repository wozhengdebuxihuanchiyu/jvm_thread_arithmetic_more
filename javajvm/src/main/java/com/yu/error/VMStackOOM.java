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
 * 此类是测试OutOfMemoryError异常————线程太多，导致内存溢出
 * 设置vm参数：
 * 	VM Args:-Xss2M
 * 	-Xss2M设置单个线程的虚拟机栈大小为2M
 * 
 * 无异常信息，假死
 */
public class VMStackOOM {

	private void dontStop() {
		while(true) {}
	}
	
	public void stackLeakByThread() {
		while(true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					dontStop();
				}
			}).start();;
		}
	}
	
	public static void main(String[] args) {
		VMStackOOM voom = new VMStackOOM();
		voom.stackLeakByThread();
	}
}
