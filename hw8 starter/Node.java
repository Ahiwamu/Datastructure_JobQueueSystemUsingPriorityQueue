class Node {
  String name;
  int value; // คะแนนความสามารถ
  long timestamp; 
  boolean isAmerican; // ถือสัญชาติอเมริกาหรือไม่
  int salary; // ค่าจ้าง

  public Node(String name, int value, boolean isAmerican, int salary) {
      this.name = name;
      this.value = value;
      this.isAmerican = isAmerican;
      this.salary = salary;
  }

  public int getTotalAnnualSalary(){
    int salary = this.salary;
    if(!isAmerican) salary += 100000;
    return salary;
  }
    
  // This function will return true if Priority(thisNode) > Priority(otherNode)
  public boolean compare(Node other, boolean isMinHeap) {
    int ThisTotalSalaryYear = this.salary + (this.isAmerican? 0 : 100000);
    int OtherTotalSalaryYaer = other.salary + (other.isAmerican? 0 : 100000);
    // System.out.println("This : " + ThisTotalSalaryYear);
    // System.out.println("Other : " + OtherTotalSalaryYaer);
    if (this.value == other.value) {    //if this value == onther value compare totalsalaryYear
        if(ThisTotalSalaryYear < OtherTotalSalaryYaer) return true;   //if this total salary less than return true
        else if(ThisTotalSalaryYear == OtherTotalSalaryYaer){   //if this total salary is equal check timestamp
            if(this.timestamp < other.timestamp) return true;   //if this timestamp less than return true
            else return false;
        }
        else return false;
    }else {
        if (isMinHeap) {    //if minheap compare totalsalaryYear
            if(ThisTotalSalaryYear < OtherTotalSalaryYaer) return true;   //if this total salary less than return true
            else return false;
        }else{  //if maxheap compare value
            if(this.value > other.value) return true;   //if this value more than return true
            else return false;
        }
    }
  }

  public Node(){} // Dummy constructor, no need to edit

  @Override
  public String toString() {
      return "Name: " + name + 
             ", Value: " + Integer.toString(value) + 
             ", Salary: " + Integer.toString(salary) +
             ", IsAmerican: " + Boolean.toString(isAmerican) +
             ", Total Annual Salary: " + Integer.toString(getTotalAnnualSalary()) +
             ", Timestamp: " + Long.toString(timestamp);
  }
}