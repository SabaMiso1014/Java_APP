// クラス名
class app {
	public static void main(String[] args) {
		// Hello World
		System.out.println("Hello World!");

		// 変数
		double num = 3.14;
		System.out.println(num);

		// 定数
		final String GREETING_MSG = "こんにちは、世界！";
		System.out.println(GREETING_MSG);

		/* データ型
		byte b = -128;
		short s = 32767;
		int i1 = 1_380; 　// 桁区切り記号「_」も利用可（Java SE 7以降）
		int i2 = 010;   　// 8進数（0～）
		int i3 = 0xFF;  　// 16進数（0x～）
		int i4 = 0b0010;　// 2進数（0b～。JavaSE 7以降）
		long l = 100;
		 */

		// 型変換
		long l = 50;
		int i = (int)l;
		System.out.println(1+i);

		// 演算子
		int x = 1;
		int y = x++;
		System.out.println("yは" + y);   // 結果：yは1
		int a = 1;
		int b = ++a;
		System.out.println("bは" + b);   // 結果：bは2

		// IF文
		int val = 10;
		if (val == 10) {
			System.out.println("変数valは10です"); // 結果：変数valは10です
		}

		// For文
		for (int i = 0; i < 5; i++) {
			System.out.print(i + "/");
		}   // 結果：0/1/2/3/4/

		// While文
		int val = 0;
		while (val < 5) {
			System.out.print(val + "/");
			val++;
		} // 結果：0/1/2/3/4/

		// do While文
		int val = 7;
		do {
			System.out.print(val + "/");
			val++;
		} while(val < 5); // 結果：7/

		// Switch文
		int val = 3;
		switch (val) {
			case 1:
				System.out.println("変数valは1です");
				break;
			case 2:
				System.out.println("変数valは2です");
				break;
			case 3:
				System.out.println("変数valは3です");
				break;
			default:
				System.out.println("変数valは1、2、3いずれでもありません");
				break;
		} // 結果：変数valは3です
	}
}