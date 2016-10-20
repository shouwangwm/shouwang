package io;

import java.io.*;

public class DataStreamDemo2 {
	public static void main(String[] args) {
		String path = "conf/DataStreamDemo2.txt";
		Member2[] members = { new Member2("Justin", 90, "yi", 1), new Member2("momor", 95,"er", 2), new Member2("Bush", 88, "san", 3) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));

			for (Member2 member : members) {
				// д��UTF�ַ���
				dataOutputStream.writeUTF(member.getName());
				// д��int����
				dataOutputStream.writeInt(member.getAge());
				
				dataOutputStream.writeUTF(member.getClassName());
				dataOutputStream.writeInt(member.getClassNum());
			}

			// ����������Ŀ�ĵ�
			dataOutputStream.flush();
			// �ر���
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(new FileInputStream(path));

			// �������ݲ���ԭΪ����
			for (int i = 0; i < members.length; i++) {
				// ����UTF�ַ���
				String name = dataInputStream.readUTF();
				// ����int����
				int score = dataInputStream.readInt();
				
				String className = dataInputStream.readUTF();
				
				int classNum = dataInputStream.readInt();
				/**д��Ͷ�ȡ��˳�����һ��,className�������ȡ�ᱨ�� */
//				String className = dataInputStream.readUTF();
				members[i] = new Member2(name, score, className, classNum);
			}

			// �ر���
			dataInputStream.close();

			// ��ʾ��ԭ�������
			for (Member2 member : members) {
				System.out.println(member);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}