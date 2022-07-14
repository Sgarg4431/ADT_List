public class DSEListGeneric<T> implements ListGeneric<T> {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;
	public DSEListGeneric() {
		
	}
	public DSEListGeneric(NodeGeneric<T> head_) {
		if(head==null) {
			NodeGeneric<T> NodeGeneric=head_;
			head=tail=NodeGeneric;
			
		}
		else if(head.next==null) {
			NodeGeneric<T> NodeGeneric=head_;
			NodeGeneric.prev=head;
			head.next=NodeGeneric;
			NodeGeneric.next=null;
			tail=NodeGeneric;
		}
		else {
			NodeGeneric<T> temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			NodeGeneric<T> NodeGeneric=head_;
			temp.next=NodeGeneric;
			NodeGeneric.prev=temp;
			NodeGeneric.next=null;
			tail=NodeGeneric;
		}
			
	
		
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric other) { // Copy constructor. 
		head=null;
		if(other.head==null)
			head=tail=null;
		else {
			head=new NodeGeneric(null,null,other.head.get());
			NodeGeneric<T> NodeGeneric=other.head.next;
			NodeGeneric<T> temp=head;
			while(NodeGeneric!=null) {
				temp.next=new NodeGeneric<T>(null,temp,NodeGeneric.get());
				temp=temp.next;
				NodeGeneric=NodeGeneric.next;
			}
			tail=temp;
		}
	}
	
	@Override
	public boolean add(int index, T obj) {
		if(index<0 || index>size()) return false;
		else if(index==0) {
			if(head!=null) {
			NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
			NodeGeneric.next=head;
			head.prev=NodeGeneric;
			head=NodeGeneric;
			return true;
			}
			else {
				NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
				head=tail=NodeGeneric;
				return true;
			}
		}
		else if(index==size()) {
			add(obj);
		}
		else if(index>0 && index<size()) {
			NodeGeneric<T> temp=head;
			int i=0;
			while(i<index-1) {
				temp=temp.next;
				i++;
			}
			NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
			NodeGeneric.next=temp.next;
			
			temp.next=NodeGeneric;
			return true;
		}
		return true;
	}
	@Override
	public boolean contains(T obj) {
		if(head==null) return false;
		else {
			if(head.get().equals(obj)) {
				return true;
			}
			else if(tail.get().equals(obj)) {
				return true;
			}
			else {
				NodeGeneric<T> temp=head;
				while(temp!=null) {
					if(temp.get().equals(obj)) {
						return true;
					}
					temp=temp.next;
				}
			}
		}
		return false;
	}
	@Override
	public boolean remove(T obj) {
		if(head==null) return false;
		else if(head.get().equals(obj)) {
			remove(0);
			return true;
		}
		else {
			
			NodeGeneric<T> temp=head;
			while(temp.next!=null) {
				if(temp.get().equals(obj)) {
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
			else if(tail.get().equals(obj)) {
				tail.prev.next=null;
				tail=tail.prev;
				return true;
			}
		}
		return false;
			
		}
	@Override
	public T remove(int index) {
		if(index<0 || index>size()) {
			return null;
		}
		else if(index==0) {
			if(head==null) return null;
			else {
				T s=head.get();
				head=head.next;
				return s;
			}
		}
		else if(index==size()-1) {
			T s=tail.get();
			tail=tail.prev;
			tail.next=null;
			return s;
		}
		else if(index>0 && index<size()-1) {
			NodeGeneric<T> temp=head;
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
	public T get(int index) {
		if(index<0 || index>size()) return null;
		else if(index==0) {
			if(head!=null)
			return head.get();
			else return null;
		}
			
		else if(index==size()) {
			if(head==tail) {
			if(head!=null)
				return head.get();
				else return null;
			}
			else return tail.get();
		}
		else if(index>0 && index<size()) {
			if(head!=null && head.next!=null) {
			NodeGeneric<T> temp=head;
			int i=0;
			while(i<index) {
				temp=temp.next;
				i++;
			}
			return temp.get();
			}
		}
		return null;
	}
	@Override
	public int indexOf(T token) {
		if(head==null) return -1;
		else if(head.get().equals(token)) return 0;
		else {
		NodeGeneric<T> temp=head;
		int i=0;
		while(temp!=null) {
			if(temp.get().equals(token)) {
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
	public boolean add(T obj) {
		if(head==null) {
			NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
			head=tail=NodeGeneric;
			return true;
		}
		else if(head.next==null) {
			NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
			NodeGeneric.prev=head;
			head.next=NodeGeneric;
			NodeGeneric.next=null;
			tail=NodeGeneric;
			return true;
		}
		else {
			NodeGeneric<T> temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			NodeGeneric<T> NodeGeneric=new NodeGeneric<T>(null,null,obj);
			temp.next=NodeGeneric;
			NodeGeneric.prev=temp;
			NodeGeneric.next=null;
			tail=NodeGeneric;
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
		NodeGeneric<T> temp=head;
		int i=0;
		while(temp!=null) {
			i++;
			temp=temp.next;
		}
		return i;
	}
	public String toString() {
		NodeGeneric<T> temp=head;
		StringBuffer s=new StringBuffer();
		while(temp!=null) {
			 s.append(temp.get());
			 s.append(" ");
			temp=temp.next;
		}
		return s.toString().trim();
		
	}
	}


