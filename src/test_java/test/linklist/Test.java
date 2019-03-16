package test_java.test.linklist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
	
	/**
	 * 测试链表的倒序
	 */
	@org.junit.Test	
	public void test(){
		
		/**
		 * 定义一个头节点
		 */
		Node head = new Node(-1); 
		
		/**
		 * 定义一个临时节点
		 */
		Node tempNode = head;
		/**
		 * 首先我们要有一个链表
		 */
		for(int i = 0; i < 3; i++) {
			Node node = new Node(i);
			tempNode.next = node;
			tempNode = node;
		}
		//Node [data=-1, next=Node [data=0, next=Node [data=1, next=Node [data=2, next=null]]]]
		System.out.println(head);
		
		/**
		 * 下面开始将单链表反转
		 */
		reload(head);
	}
	
	public void reload(Node head){
		
		Node result = null;
		
		Node nextNode = head;
		
		Node preNode = null;
		
		
		while(nextNode!= null) {
			result = nextNode.next;
			nextNode.next = preNode;
			preNode = nextNode;
			nextNode = result;
		}
		
		System.out.println(preNode);
		
	}
	
	
	@org.junit.Test
	public void testStack(){
		int i = 11111110;
		ArrayList<String> arr = new ArrayList<>();
		while(true){
			arr.add(String.valueOf(i++).intern());
		}
	}

}
