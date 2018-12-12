package com.yu.error;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 * 
 * 测试堆内存溢出OutOfMemoryError:Java heap space
 * @author yuchangying
 * 
 *  设置虚拟机的内存参数：vm args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 					   -Xms初始堆内存大小
 * 					   -Xmx最大堆内存大小
 * 					   -XX:+HeapDumpOnOutOfMemoryError 内存溢出异常时，dump出当前内存堆存储快照
 * 
 * <p>
 *  异常信息：
 * 	java.lang.OutOfMemoryError: Java heap space
 *	Dumping heap to java_pid23712.hprof ...
 *	Heap dump file created [28500405 bytes in 0.088 secs]
 *
 *  Java heap space堆内存溢出
 * </p>
 * 
 * <p>
 * 	解决手段：
 * 		eclipse memory analysis插件，打开项目路径下生成的内存堆存储快照
 * 
 *Thread stack中可以看到如下错误信息 
 *main
 *  at java.lang.OutOfMemoryError.<init>()V (OutOfMemoryError.java:48)
 *  at java.util.Arrays.copyOf([Ljava/lang/Object;ILjava/lang/Class;)[Ljava/lang/Object; (Arrays.java:3210)
 *  at java.util.Arrays.copyOf([Ljava/lang/Object;I)[Ljava/lang/Object; (Arrays.java:3181)
 *  at java.util.ArrayList.grow(I)V (ArrayList.java:265)
 *  at java.util.ArrayList.ensureExplicitCapacity(I)V (ArrayList.java:239)
 *  at java.util.ArrayList.ensureCapacityInternal(I)V (ArrayList.java:231)
 *  at java.util.ArrayList.add(Ljava/lang/Object;)Z (ArrayList.java:462)
 *  at com.yu.error.HeapOOM.main([Ljava/lang/String;)V (HeapOOM.java:34)
 * </p>
 */
public class HeapOOM {
	
	static class OOMObject {
		
	}
	public static void main(String[] args) {
		
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while(true) {
			list.add(new OOMObject());
		}
	}
}
