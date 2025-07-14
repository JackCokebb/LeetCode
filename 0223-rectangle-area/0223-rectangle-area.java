class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int[] xs = new int[]{ax1, ax2, bx1, bx2};
        int[] ys = new int[]{ay1, ay2, by1, by2};

        Arrays.sort(xs);
        Arrays.sort(ys);
        int dup = 0;

        if ((((bx1 <= ax1 && bx1 <= ax2) && (bx2 <= ax1 && bx2 <= ax2)) || ((bx1 >= ax1 && bx1 >= ax2) && (bx2 >= ax1 && bx2 >= ax2))) || (((by1 <= ay1 && by1 <= ay2) && (by2 <= ay1 && by2 <= ay2)) || ((by1 >= ay1 && by1 >= ay2) && (by2 >= ay1 && by2 >= ay2)))) {
            
            dup = 0; 
        } else {
            
            dup = (xs[2] - xs[1]) * (ys[2] - ys[1]);
        }


        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - dup;
    }
}