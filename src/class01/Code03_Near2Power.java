package class01;

public class Code03_Near2Power {

	// 已知n是正数
	// 返回大于等于，且最接近n的，2的某次方的值
	public static final int tableSizeFor(int n) {
		n--; //-1是为了应对n正好是2的n次方
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;  //int就32位（1+2+4+8+16=32）
		return (n < 0) ? 1 : n + 1;//如果是负数，最接近的2的n次方是1
	}

	public static void main(String[] args) {
		int cap = 120;
		System.out.println(tableSizeFor(cap));
	}
}
