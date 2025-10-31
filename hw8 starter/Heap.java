public class Heap {
  private Node[] heap;
  private int size;
  private int capacity;
  private boolean isMinHeap;
  private String name;
  private long timer;

  public Heap(boolean isMinHeap, int capacity, String name) {
      // Initialize the heap here
      // Don't forget that we will build the binary heap using...
      // ... the concept of "Complete binary tree based on the heapay implementation"
      // ... The 0 index will not be used, The index starts from 1 (remember?)
      this.isMinHeap = isMinHeap;
      this.capacity = capacity + 1;
      this.name = name;
      this.size = 0;
      this.timer = 0;
      this.heap = new Node[this.capacity];

  }

  public Node top(){
    return this.heap[1]; // FIX THIS
  }

  public void push(Node node){
      // Increase timer each time you push something into the Queue
      timer++;
      node.timestamp = timer; // Stamp the time number to the node
      
      // To do:
      // 1. Push the new node at the end of the array (via back pointer)
      if(size + 1 == capacity){ //if array is full
          this.capacity = this.capacity * 2 - 1; 
          Node[] newHeap = new Node[this.capacity];
          for(int i = 1; i < size; i++){
              newHeap[i] = heap[i]; 
            }
            heap = newHeap;
        }
        size++; //increase size
        heap[size] = node;  //set last node

        // 2. Sift (percolate) it up the heap
      //      * Check priority of the current node with its parent
      //      * Swap the current node if the priority is higher than the parent
      //      * Repeat the process until reaching the root or there is no swap (Pls use while loop)
        int i = size;   //set i is last index
        while (i > 1) { 
            int parent = i / 2;
            if (heap[i].compare(heap[parent], this.isMinHeap)) {    //compare with parent
                swap(i, parent);
                i = parent;
            } else break;
        }


      // 3. Increase the heap size
      
    
  }

  public Node pop(){
      
      // To do:
    if(this.isEmpty()){ //if empty
        return null; // FIX THIS
    }
    else{   //if not empty
        Node delete = this.top();  //set delete is top node
        for(int i = 2; i <= size; i++){ //shift all node to left
            swap(i, i-1);
        }
        this.heap[size] = null;
        size--; //decrease size

        int i = 1;
        while (true) {  //percolate down
            int left = 2 * i;
            int right = 2 * i + 1;
            int target = i;

            if (left <= size && heap[left].compare(heap[target], isMinHeap)) {  //if left node is more than parent 
                target = left;
            }
            if (right <= size && heap[right].compare(heap[target], isMinHeap)) {    //if right node is more than parent
                target = right;
            }

            if (target == i) break; //if dont swap break
            swap(i, target);
            i = target;
        }
        return delete;  //return delete node
    }
      // 1. Mark the root for return (Don't forget to return this node)
      // 2. Move the last node to the root (change pointer, set null)
      // 3. Decrease the heap size
      // 4. Sift (percolate) it down the heap
      //      * Check priority of the current node with both children
      //      * Swap the current node if the priority is lower than child
      //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)


  }

  private void swap(int i, int j) {
      Node temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
  }

  public void printArray() {
        // No need to fix this function
        System.out.printf("-----------------\n%s Heap:\n", name);
        if (isEmpty()) System.out.println("Empty Heap");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%d] %s\n", i, heap[i].toString());
        }
        System.out.print("-----------------\n");
    }

  public boolean isEmpty() {
      return size == 0;
  }
}
