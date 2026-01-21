import java.util.ArrayList;
public class Q7_cheatSheet_idk {


/*
==========================================================
Q7+ CHEAT SHEET — CIRCLE / GEOMETRY (EXAM STYLE)
==========================================================

FOCUS:
- Harder Question 7 style problems
- Geometry with circles
- 2D int arrays + ArrayList<Integer>
- NO helper methods
- FULLY copy–paste ready
- Heavy comments so you can identify patterns quickly

----------------------------------------------------------
CORE EXAM RULES (MEMORISE)
----------------------------------------------------------
✔ Use squared distance: (x-h)² + (y-k)²
✔ NEVER use Math.sqrt in exams
✔ Use long when squaring
✔ points == null → return null
✔ invalid row → add -1
✔ Do NOT modify input array
✔ Boundary checks before inside/outside

==========================================================
*/


    public class Main {

        /* ======================================================
           TEMPLATE 1 — POINT IN CIRCLE (MOST COMMON Q7)
           ======================================================

           Circle:
             Centre (h,k) = (3,2)
             Radius r = 5

           Classification:
             1 → inside
             2 → on circle
             3 → outside
             -1 → invalid row
        */
        public static ArrayList<Integer> pointInCircle(int[][] points) {

            if (points == null) return null;

            ArrayList<Integer> result = new ArrayList<Integer>();

            int h = 3;
            int k = 2;
            int r = 5;

            long r2 = (long) r * r;

            for (int i = 0; i < points.length; i++) {

                // Validate row
                if (points[i] == null || points[i].length != 2) {
                    result.add(-1);
                    continue;
                }

                int x = points[i][0];
                int y = points[i][1];

                long dx = (long) x - h;
                long dy = (long) y - k;

                long dist2 = dx * dx + dy * dy;

                if (dist2 < r2) {
                    result.add(1);      // inside
                } else if (dist2 == r2) {
                    result.add(2);      // on boundary
                } else {
                    result.add(3);      // outside
                }
            }

            return result;
        }

        /* ======================================================
           TEMPLATE 2 — ANNULUS (RING BETWEEN TWO CIRCLES)
           ======================================================

           Inner radius r1 = 3
           Outer radius r2 = 7

           Return:
             1 → inside inner circle
             2 → on inner circle
             3 → in ring
             4 → on outer circle
             5 → outside outer circle
        */
        public static ArrayList<Integer> pointInAnnulus(int[][] points) {

            if (points == null) return null;

            ArrayList<Integer> result = new ArrayList<Integer>();

            int h = 3;
            int k = 2;

            int r1 = 3;
            int r2 = 7;

            long r1_2 = (long) r1 * r1;
            long r2_2 = (long) r2 * r2;

            for (int i = 0; i < points.length; i++) {

                if (points[i] == null || points[i].length != 2) {
                    result.add(-1);
                    continue;
                }

                int x = points[i][0];
                int y = points[i][1];

                long dx = (long) x - h;
                long dy = (long) y - k;

                long dist2 = dx * dx + dy * dy;

                if (dist2 < r1_2) {
                    result.add(1);
                } else if (dist2 == r1_2) {
                    result.add(2);
                } else if (dist2 < r2_2) {
                    result.add(3);
                } else if (dist2 == r2_2) {
                    result.add(4);
                } else {
                    result.add(5);
                }
            }

            return result;
        }

        /* ======================================================
           TEMPLATE 3 — CLOSEST POINT TO CIRCLE BOUNDARY
           ======================================================

           Return int[]:
             result[0] → index of closest point
             result[1] → classification (1/2/3)

           Ignore invalid rows when searching.
           If all invalid → {-1, -1}
        */
        public static int[] closestPointToCircle(int[][] points) {

            if (points == null) return null;

            int h = 3;
            int k = 2;
            int r = 5;

            long r2 = (long) r * r;

            int bestIndex = -1;
            long bestDiff = Long.MAX_VALUE;
            int bestClass = -1;

            for (int i = 0; i < points.length; i++) {

                if (points[i] == null || points[i].length != 2) {
                    continue;
                }

                int x = points[i][0];
                int y = points[i][1];

                long dx = (long) x - h;
                long dy = (long) y - k;

                long dist2 = dx * dx + dy * dy;

                long diff = dist2 - r2;
                if (diff < 0) diff = -diff;

                int classification;
                if (dist2 < r2) classification = 1;
                else if (dist2 == r2) classification = 2;
                else classification = 3;

                if (diff < bestDiff) {
                    bestDiff = diff;
                    bestIndex = i;
                    bestClass = classification;
                }
            }

            if (bestIndex == -1) return new int[]{-1, -1};

            return new int[]{bestIndex, bestClass};
        }
    }
}


/*
==========================================================
EXAM RECOGNITION GUIDE (VERY IMPORTANT)
==========================================================

If you see:
✔ "Inside / On / Outside"
✔ Circle, distance, radius
✔ 2D array of points
✔ ArrayList<Integer> output

→ USE TEMPLATE 1

If you see:
✔ Two radii
✔ Ring / band / zone

→ USE TEMPLATE 2

If you see:
✔ "Closest point"
✔ "Minimum distance"
✔ "Tie-break by index"

→ USE TEMPLATE 3

==========================================================
FINAL EXAM TIP
==========================================================
When stuck:
1) Validate input
2) Compute dx, dy
3) Square distance
4) Compare with r²
5) Boundary BEFORE inside/outside
==========================================================

 */

