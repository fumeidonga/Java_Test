package test_java.test.linklist;

/**
 * 
 * 定义一个类，用来表示一个单向链表的节点
 * @author david
 *
 */
public class Node<T> {

	/**
	 * 当前节点数据
	 */
	public T data;
	
	/**
	 * 当前节点的下一个节点
	 */
	public Node next;
	
	public Node(T data){
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
	
}
