package class01;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code02_CountFiles {
	//深度遍历使用stack
	// 注意这个函数也会统计隐藏文件
	public static int getFileNumber(String folderPath) {
		File root = new File(folderPath);
		if (!root.isDirectory() && !root.isFile()) {
			return 0;
		}
		if (root.isFile()) {
			return 1;
		}
		Stack<File> stack = new Stack<>();
		stack.add(root);
		int files = 0;
		while (!stack.isEmpty()) {
			File folder = stack.pop();
			for (File next : folder.listFiles()) {
				if (next.isFile()) {
					files++;
				}
				if (next.isDirectory()) {
					stack.push(next);
				}
			}
		}
		return files;
	}
	//广度遍历使用队列
	// 注意这个函数也会统计隐藏文件
	public static int getFileNumber2(String folderPath) {
		File root = new File(folderPath);
		if (!root.isDirectory() && !root.isFile()) {
			return 0;
		}
		if (root.isFile()) {
			return 1;
		}

		Queue<File> queue = new LinkedList<>();
		queue.add(root);
		int files = 0;
		while (!queue.isEmpty()) {
			File folder = queue.poll();
			for (File next : folder.listFiles()) {
				if (next.isFile()) {
					files++;
				}
				if (next.isDirectory()) {
					queue.add(next);
				}
			}
		}
		return files;
	}
	public static void main(String[] args) {
		// 你可以自己更改目录
		String path = "E:\\2020简历";
		System.out.println(getFileNumber2(path));
	}

}
