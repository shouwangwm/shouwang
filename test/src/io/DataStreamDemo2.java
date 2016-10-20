package io;

import java.io.*;

public class DataStreamDemo2 {
	public static void main(String[] args) {
		String path = "conf/DataStreamDemo2.txt";
		Member2[] members = { new Member2("Justin", 90, "yi", 1), new Member2("momor", 95,"er", 2), new Member2("Bush", 88, "san", 3) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));

			for (Member2 member : members) {
				// 写入UTF字符串
				dataOutputStream.writeUTF(member.getName());
				// 写入int数据
				dataOutputStream.writeInt(member.getAge());
				
				dataOutputStream.writeUTF(member.getClassName());
				dataOutputStream.writeInt(member.getClassNum());
			}

			// 所有数据至目的地
			dataOutputStream.flush();
			// 关闭流
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));

			// 读出数据并还原为对象
			for (int i = 0; i < members.length; i++) {
				// 读出UTF字符串
				String name = dataInputStream.readUTF();
				// 读出int数据
				int score = dataInputStream.readInt();
				
				String className = dataInputStream.readUTF();
				
				int classNum = dataInputStream.readInt();
				/**写入和读取和顺序必须一致,className放在最后取会报错 */
//				String className = dataInputStream.readUTF();
				members[i] = new Member2(name, score, className, classNum);
			}

			// 关闭流
			dataInputStream.close();

			// 显示还原后的数据
			for (Member2 member : members) {
				System.out.println(member);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}