import java.util.*;
// State as stack 

// <id, val> 
class Pair {
   Identifier id;
   Value val;
   
   Pair (Identifier id, Value v) {
     this.id = id;
     this.val = v;
   }
}

class State extends Stack<Pair> {
    public State( ) { }
    
    public State(Identifier id, Value val) {
        push(id, val);
    }

    // (1) Push function Implementation
    public State push(Identifier id, Value val) {
    	// Push Implementation
    	super.push(new Pair(id, val)); // ���ο� Pair �߰�
    	return this;
    }

    // (2) Pop function Implementation (Optional)
    public Pair pop() {
    	// Pop Implementation (Optional)
    	return super.pop();
    }
    
    // (3) Lookup function Implementation
    public int lookup (Identifier v) {
    	// lookup �Լ��� index�� �������Ƿ� �ϳ��� ���ư��� ���� v�� ���� index�� ã�´�.��
    	int index = -1;
    	for ( int i = 0; i < this.size(); i++ ) {
    		Pair p = this.get(i);
    		if ( p.id.equals(v) ) index = i;
    	}
    	return index;
       // Lookup Implementation
//    	return super.search(v);
    }

    // (4) Set Function Implementation
    public State set(Identifier id, Value val) {
    	// Set Implementation
    	for ( Pair p : this ) {
    		if ( p.id.equals( id ) ) p.val = val;
    	}
    	return this;
    }
    
    // (5) Get Function Implementation
    public Value get (Identifier id) {
    	// Get Implementation
    	// lookup�Լ��� �̿��� index�� �������� get�� �̿��� ���¤� �����´�.
    	int index = this.lookup(id);
    	
    	if ( index < 0 ) return null;
    	else {
    		Pair pair = this.get(index);
    		return pair.val;
    	}
//    	for ( Pair p : this ) {
//    		if ( p.id.equals( id ) ) return p.val;
//    	}
    }

}