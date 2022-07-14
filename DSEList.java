public class DSEList implements List {
	
	public Node head;
	private Node tail;
	public DSEList() {
		
	}
	public DSEList(Node head_) {
		if(head==null) {
			Node node=head_;
			head=tail=node;
			
		}
		else if(head.next==null) {
			Node node=head_;
			node.prev=head;
			head.next=node;
			node.next=null;
			tail=node;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Node node=head_;
			temp.next=node;
			node.prev=temp;
			node.next=null;
			tail=node;
		}
			
	
		
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) { // Copy constructor. 
		head=null;
		if(other.head==null)
			head=tail=null;
		else {
			head=new Node(null,null,other.head.getString());
			Node node=other.head.next;
			Node temp=head;
			while(node!=null) {
				temp.next=new Node(null,temp,node.getString());
				temp=temp.next;
				node=node.next;
			}
			tail=temp;
		}
	}
	
	@Override
	public boolean add(int index, String obj) {
		if(index<0 || index>size()) return false;
		else if(index==0) {
			if(head!=null) {
			Node node=new Node(null,null,obj);
			node.next=head;
			head.prev=node;
			head=node;
			return true;
			}
			else {
				Node node=new Node(null,null,obj);
				head=tail=node;
				return true;
			}
		}
		else if(index==size()) {
			add(obj);
		}
		else if(index>0 && index<size()) {
			Node temp=head;
			int i=0;
			while(i<index-1) {
				temp=temp.next;
				i++;
			}
			Node node=new Node(null,null,obj);
			node.next=temp.next;
			
			temp.next=node;
			return true;
		}
		return true;
	}
	@Override
	public boolean contains(String obj) {
		if(head==null) return false;
		else {
			if(head.getString().equals(obj)) {
				return true;
			}
			else if(tail.getString().equals(obj)) {
				return true;
			}
			else {
				Node temp=head;
				while(temp!=null) {
					if(temp.getString().equals(obj)) {
						return true;
					}
					temp=temp.next;
				}
			}
		}
		return false;
	}
	@Override
	public boolean remove(String obj) {
		if(head==null) return false;
		else if(head.getString().equals(obj)) {
			remove(0);
			return true;
		}
		else {
			
			Node temp=head;
			while(temp.next!=null) {
				if(temp.getString().equals(obj)) {
					break;
				}
				else {
					temp=temp.next;
				}
			}
			if(temp!=tail) {
			temp.prev.next=temp.next;
			return true;
			}
			else if(tail.getString().equals(obj)) {
				tail.prev.next=null;
				tail=tail.prev;
				return true;
			}
		}
		return false;
			
		}
	@Override
	public String remove(int index) {
		if(index<0 || index>size()) {
			return null;
		}
		else if(index==0) {
			if(head==null) return null;
			else {
				String s=head.getString();
				head=head.next;
				return s;
			}
		}
		else if(index==size()-1) {
			String s=tail.getString();
			tail=tail.prev;
			tail.next=null;
			return s;
		}
		else if(index>0 && index<size()-1) {
			Node temp=head;
			int i=0;
			while(i<index) {
				temp=temp.next;
				i++;
			}
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
		}
		return null;
	}
	@Override
	public String get(int index) {
		if(index<0 || index>size()) return null;
		else if(index==0) {
			if(head!=null)
			return head.getString();
			else return null;
		}
			
		else if(index==size()) {
			if(head==tail) {
			if(head!=null)
				return head.getString();
				else return null;
			}
			else return tail.getString();
		}
		else if(index>0 && index<size()) {
			if(head!=null && head.next!=null) {
			Node temp=head;
			int i=0;
			while(i<index) {
				temp=temp.next;
				i++;
			}
			return temp.getString();
			}
		}
		return null;
	}
	@Override
	public int indexOf(String token) {
		if(head==null) return -1;
		else if(head.getString().equals(token)) return 0;
		else {
		Node temp=head;
		int i=0;
		while(temp!=null) {
			if(temp.getString().equals(token)) {
				return i;
			}
			else {
				temp=temp.next;
				i++;
			}
		}
		return -1;
	}
	}
	@Override
	public boolean add(String obj) {
		if(head==null) {
			Node node=new Node(null,null,obj);
			head=tail=node;
			return true;
		}
		else if(head.next==null) {
			Node node=new Node(null,null,obj);
			node.prev=head;
			head.next=node;
			node.next=null;
			tail=node;
			return true;
		}
		else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			Node node=new Node(null,null,obj);
			temp.next=node;
			node.prev=temp;
			node.next=null;
			tail=node;
			return true;
		}
	}
	@Override
	public boolean isEmpty() {
		if(head==null) return true;
		else return false;
	}
	@Override
	public int size() {
		if(head==null) return 0;
		Node temp=head;
		int i=0;
		while(temp!=null) {
			i++;
			temp=temp.next;
		}
		return i;
	}
	public String toString() {
		Node temp=head;
		StringBuffer s=new StringBuffer();
		while(temp!=null) {
			 s.append(temp.getString());
			 s.append(" ");
			temp=temp.next;
		}
		return s.toString().trim();
		
	}
	}

