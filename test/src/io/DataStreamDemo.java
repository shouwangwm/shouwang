package io;

import java.io.*;
/**
 * ��������������������� 
 * @author: weiming
 * @date: 2017��2��14��
 */
public class DataStreamDemo {
	public static void main(String[] args) {
		String path = "conf/DataStreamDemo.txt";
		Member[] members = { new Member("Justin", 90), new Member("momor", 95), new Member("Bush", 88) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));

			for (Member member : members) {
				// д��UTF�ַ���
				dataOutputStream.writeUTF(member.getName());
				// д��int����
				dataOutputStream.writeInt(member.getAge());
				
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
				members[i] = new Member(name, score);
			}

			// �ر���
			dataInputStream.close();

			// ��ʾ��ԭ�������
			for (Member member : members) {
				System.out.printf("%s\t%d%n", member.getName(), member.getAge());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}