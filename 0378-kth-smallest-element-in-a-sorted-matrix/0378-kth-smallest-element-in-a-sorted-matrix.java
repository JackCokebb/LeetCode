class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        for (int i = 0 ; i < n ; i++) {
            pq.offer(new Tuple(0, i, matrix[i][0]));
        }
        for (int i = 0 ; i < k - 1 ; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) {
                continue;
            }
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.y][t.x + 1]));
        }

        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
}