public class JobQueueSystem {
    private Heap itQueue;
    private Heap marketingQueue;

    public JobQueueSystem(int maxSize) {
        itQueue = new Heap(false, maxSize, "IT Queue"); // maxHeap
        marketingQueue = new Heap(true, maxSize, "Marketing Queue"); // minHeap
    }

    // Add applicant to specified queue
    public void addApplicant(String queueType, String name, int skillLevel, boolean isAmerican, int salary) {
        Node applicant = new Node(name, skillLevel, isAmerican, salary);
        if ("IT".equalsIgnoreCase(queueType)) {
            itQueue.push(applicant);
        } else if ("Marketing".equalsIgnoreCase(queueType)) {
            marketingQueue.push(applicant);
        } else {
            System.out.println("Unknown queue type: " + queueType);
        }
    }

    // Hire applicant from specified queue
    public void hireApplicant(String queueType) {
        Heap queue = getQueue(queueType);
        if (queue == null) return;
        if (queue.isEmpty()) {
            System.out.println("The " + queueType.substring(0, 1).toUpperCase() + queueType.substring(1) + " Queue is empty");
            return;
        }
        System.out.println("Hire " + queueType.substring(0, 1).toUpperCase() + queueType.substring(1) + " Queue: " + queue.pop());
    }

    // Print specified queue
    public void printQueue(String queueType) {
        Heap queue = getQueue(queueType);
        if (queue == null) return;
        queue.printArray();
    }

    // Check if specified queue is empty
    public boolean isQueueEmpty(String queueType) {
        Heap queue = getQueue(queueType);
        return queue == null || queue.isEmpty();
    }

    // View top candidate in specified queue
    public Node viewTopCandidate(String queueType) {
        Heap queue = getQueue(queueType);
        if (queue == null) return null;
        if (queue.isEmpty()) {
            System.out.println("The " + queueType + " Queue is empty");
            return null;
        }
        return queue.top();
    }

    // Helper to get the correct queue
    private Heap getQueue(String queueType) {
        if ("IT".equalsIgnoreCase(queueType)) {
            return itQueue;
        } else if ("Marketing".equalsIgnoreCase(queueType)) {
            return marketingQueue;
        } else {
            System.out.println("Unknown queue type: " + queueType);
            return null;
        }
    }
}