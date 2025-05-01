class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        Deque<Integer> studentQueue = new ArrayDeque<>();
        Deque<Integer> sandwichesStack = new ArrayDeque<>();

        for(int i = 0 ; i < students.length ; i++) {
            studentQueue.addLast(students[i]);
            sandwichesStack.addLast(sandwiches[i]);
        }

        while(!studentQueue.isEmpty()) {
        
            int currStudent = studentQueue.poll();
            int currSandwich = sandwichesStack.peek();

            if(currStudent == currSandwich) {
                sandwichesStack.poll();
            } else {
                List<Integer> dislikedStudents = new ArrayList<>();
                dislikedStudents.add(currStudent);

                while(!studentQueue.isEmpty()) {

                    if(studentQueue.peek() == currSandwich) {
                        studentQueue.addAll(dislikedStudents);
                        break;

                    } else {
                        dislikedStudents.add(studentQueue.poll());

                    }
                }

                if(studentQueue.isEmpty()) {
                    
                    return sandwichesStack.size();
                }
            }
        }

        return sandwichesStack.size();
    }
}