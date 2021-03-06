package quene;

import java.util.Random;

/**
 * @program: dataStructure
 * @description: 进行时间复杂度测试 random.nextInt(Integer.MAX_VALUE)指的是包含0,不包含Integer.MAX_VALUE个数,随机产生
 * @author: Join
 * @create: 2019-01-08 22:23
 **/
public class testQuene {

	public static void main(String[] args) {

		int opCount = 100000;

		queneImpl<Integer> arrayQueue = new queneImpl<Integer>();
		double time1 = testQueue(arrayQueue, opCount);
		System.out.println("ArrayQueue, time: " + time1 + " s");

		LoopQuene<Integer> loopQueue = new LoopQuene<Integer>();
		double time2 = testQueue(loopQueue, opCount);
		System.out.println("LoopQueue, time: " + time2 + " s");

	}

	// 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
	private static double testQueue(quene<Integer> queue, int opCount) {
		long startTime = System.nanoTime();
		Random random = new Random();
		for (int i = 0; i < opCount; i++) {
			queue.enQuene(random.nextInt(Integer.MAX_VALUE));
		}
		for (int i = 0; i < opCount; i++) {
			queue.deQuene();
		}
		long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}
}
