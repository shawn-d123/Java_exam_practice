import java.util.ArrayList;

public class ExamThemePrep_Q7 {
    public static void main(String[] args) {
        System.out.println(pointInCircle(new int[][]{{1,2},{4,8},{10,12}}));
        System.out.println(pointInRectangle(new int[][]{{3,0}, {2,2}, {9,1}, null}));
    }
    /*
     * Write a method called pointInCircle.
     *
     * The method is given a 2D array of integers where each row represents
     * a point (x, y).
     *
     * The circle M is defined as:
     *   Centre (h, k) = (3, 2)
     *   Radius r = 5
     *
     * Each point (x, y) must be classified as:
     *   1 -> Inside the circle      if (x-h)^2 + (y-k)^2 < r^2
     *   2 -> On the circle          if (x-h)^2 + (y-k)^2 == r^2
     *   3 -> Outside the circle     if (x-h)^2 + (y-k)^2 > r^2
     *
     * Invalid input rules:
     * - If the input array is null, return null
     * - If a row is invalid (null or not length 2), add -1
     *
     * Return:
     * - An ArrayList<Integer> of the same size as the input array,
     *   where each element is the classification of the corresponding point.
     *
     * Example:
     * Input:
     *   { {1,1}, {8,2}, {10,10} }
     *
     * Output:
     *   [1, 2, 3]
     *
     * Extra exam readiness:
     * - Use int arithmetic only (no Math.sqrt needed)
     * - Compare squared distances
     * - Do NOT modify the input array
     */
    public static ArrayList<Integer> pointInCircle(int[][] points) {
        
        double h = 3;
        double k = 2;
        double r = 5;
        
        ArrayList<Integer> result = new ArrayList<>();
        if(points == null){
            return null;
        }
        for(int i = 0; i < points.length; i++){
            //not valid
            if(points[i] == null || points[i].length != 2){
                result.add(-1);
            }
            // valid
            else{
                int x = points[i][0];
                int y = points[i][1];

                //calculate
                double calc = Math.pow((x-h),2) + Math.pow((y-k),2);
                
                // inside circle
                if(calc < Math.pow(r,2)){
                    result.add(1);
                } else if (calc ==  Math.pow(r,2)) {
                    result.add(2);
                }else{
                    result.add(3);
                }


            }
        }
        return result;
    }


    /*
     * Write a method called pointInRectangle.
     *
     * The method is given a 2D array of integers where each row represents
     * a point (x, y).
     *
     * The rectangle R is axis-aligned and defined by:
     *   Bottom-left corner: (xMin, yMin) = (2, -1)
     *   Top-right corner:   (xMax, yMax) = (8, 4)
     *
     * Each point (x, y) must be classified as:
     *   1 -> Inside the rectangle
     *   2 -> On the boundary of the rectangle
     *   3 -> Outside the rectangle
     *
     * Definitions:
     * - Inside:
     *     xMin < x < xMax AND yMin < y < yMax
     *
     * - On boundary:
     *     x == xMin OR x == xMax OR y == yMin OR y == yMax
     *     (but still within the rectangle's range)
     *
     * - Outside:
     *     Anything else
     *
     * Invalid input rules:
     * - If the input array is null, return null
     * - If a row is null or does not have length 2, add -1
     *
     * Return:
     * - An ArrayList<Integer> where each element corresponds to
     *   the classification of the input point.
     *
     * Example:
     * Input:
     *   { {3,0}, {2,2}, {9,1}, null }
     *
     * Output:
     *   [1, 2, 3, -1]
     *
     * Extra exam readiness:
     * - Be careful with boundary conditions (== vs < >)
     * - Handle ragged arrays safely
     */
    public static ArrayList<Integer> pointInRectangle(int[][] points) {

        int xmin = 2;
        int ymin = -1;
        int xmax = 8;
        int ymax = 4;


        ArrayList<Integer> result = new ArrayList<>();

        if(points == null){
            return null;
        }
        for(int i = 0; i < points.length; i++){
            if(points[i] == null || points[i].length != 2){
                result.add(-1);
            }
            // valid
            else{

                // check inside:xMin < x < xMax AND yMin < y < yMax
                if((xmin < points[i][0] && points[i][0] < xmax) &&  (ymin < points[i][1] && points[i][1] < ymax)){
                    result.add(1);
                }
                // check on Boundary: x == xMin OR x == xMax OR y == yMin OR y == yMax
                else if((points[i][0] == xmin || points[i][0] == xmax)
                        || (points[i][1] == ymin || points[i][1] == ymax)){
                    result.add(2);
                }
                else{
                    result.add(3);
                }
            }
        }
        return result;
    }


    ///  realistic exam qs 7///
    /*
     * Question 7+ — pointInPolygon
     *
     * You are given:
     * - int[][] polygon : vertices of a simple polygon (x, y)
     * - int[][] points  : test points (x, y)
     *
     * The polygon:
     * - Has at least 3 vertices
     * - Vertices are ordered (CW or CCW)
     *
     * Classify each point as:
     *   1 -> Inside the polygon
     *   2 -> On the boundary
     *   3 -> Outside
     *
     * Use the ray-casting algorithm.
     *
     * Boundary rule:
     * - If a point lies exactly on any polygon edge, classify as 2.
     *
     * Invalid rules (EASY MARKS):
     * - If points is null -> return null
     * - If polygon is null or has < 3 valid vertices -> return -1 for every point
     * - If a point row is null or length != 2 -> add -1
     *
     * Return:
     * - ArrayList<Integer> of same size as points
     *
     * Hard part:
     * - Correct ray intersection logic
     * - Avoid double-counting edges
     *
     * Easy part (DON'T MISS THESE MARKS):
     * - Null checks
     * - Length checks
     * - Boundary detection
     */
    public static ArrayList<Integer> pointInPolygon(int[][] polygon, int[][] points) {

        // STEP 1: If points array itself is null, we cannot classify anything.
        if (points == null) {
            return null;
        }

        // STEP 2: Create the output list (same size as points).
        ArrayList<Integer> results = new ArrayList<Integer>();

        // STEP 3: Validate polygon first.
        // Polygon must exist and have at least 3 vertices, and every vertex row must be valid length 2.
        boolean polygonValid = isPolygonValid(polygon);

        // STEP 4: If polygon is invalid, every point is invalid (-1).
        if (!polygonValid) {
            for (int i = 0; i < points.length; i++) {
                results.add(-1);
            }
            return results;
        }

        // STEP 5: For each test point, classify it.
        for (int i = 0; i < points.length; i++) {

            // STEP 5A: Validate point row.
            if (points[i] == null || points[i].length != 2) {
                results.add(-1);
                continue; // move to next point
            }

            int px = points[i][0];
            int py = points[i][1];

            // STEP 5B: Boundary check first (easy marks + important).
            // If point lies on ANY edge of the polygon, answer must be 2.
            if (isPointOnAnyEdge(px, py, polygon)) {
                results.add(2);
                continue;
            }

            // STEP 5C: If not on boundary, use ray-casting to decide inside/outside.
            boolean inside = isInsideRayCasting(px, py, polygon);

            if (inside) {
                results.add(1);
            } else {
                results.add(3);
            }
        }

        return results;
    }

    /*
     * STEP A: Polygon validation helper.
     * - polygon must not be null
     * - must contain at least 3 vertices
     * - each vertex row must be non-null and length 2
     */
    private static boolean isPolygonValid(int[][] polygon) {
        if (polygon == null) {
            return false;
        }
        if (polygon.length < 3) {
            return false;
        }

        for (int i = 0; i < polygon.length; i++) {
            if (polygon[i] == null || polygon[i].length != 2) {
                return false;
            }
        }

        return true;
    }

    /*
     * STEP B: Check if point is on ANY polygon edge.
     * Polygon edges are between vertex i and i+1, and last connects back to first.
     */
    private static boolean isPointOnAnyEdge(int px, int py, int[][] polygon) {

        for (int i = 0; i < polygon.length; i++) {

            int nextIndex = i + 1;
            if (nextIndex == polygon.length) {
                nextIndex = 0; // wrap around
            }

            int ax = polygon[i][0];
            int ay = polygon[i][1];
            int bx = polygon[nextIndex][0];
            int by = polygon[nextIndex][1];

            if (isPointOnSegment(px, py, ax, ay, bx, by)) {
                return true;
            }
        }

        return false;
    }

    /*
     * STEP C: Check if point P lies exactly on line segment AB.
     *
     * We do this using integer math (no floating point):
     * 1) Collinearity check using cross product:
     *    (B-A) x (P-A) == 0  (cross product equals 0 means same line)
     *
     * 2) Bounding box check:
     *    P's x between min(ax, bx) and max(ax, bx)
     *    P's y between min(ay, by) and max(ay, by)
     *
     * Use long to avoid overflow during multiplication.
     */
    private static boolean isPointOnSegment(int px, int py, int ax, int ay, int bx, int by) {

        long abx = (long) bx - ax;
        long aby = (long) by - ay;

        long apx = (long) px - ax;
        long apy = (long) py - ay;

        // Cross product (AB x AP)
        long cross = abx * apy - aby * apx;

        // If not collinear, it cannot be on the segment
        if (cross != 0) {
            return false;
        }

        // Bounding box check (P must be within rectangle that contains segment)
        int minX = Math.min(ax, bx);
        int maxX = Math.max(ax, bx);
        int minY = Math.min(ay, by);
        int maxY = Math.max(ay, by);

        if (px < minX || px > maxX) {
            return false;
        }
        if (py < minY || py > maxY) {
            return false;
        }

        return true;
    }

    /*
     * STEP D: Ray-casting algorithm (horizontal ray to the right).
     *
     * Idea:
     * - Shoot a ray from (px, py) to the right.
     * - Count how many edges cross that ray.
     * - If odd -> inside
     * - If even -> outside
     *
     * Important "exam gotcha":
     * - If the ray passes exactly through a vertex, you can double count.
     * - Standard fix:
     *     Count an edge only if (y1 > py) != (y2 > py)
     *   This includes edges that cross the ray, but avoids double counting vertices.
     *
     * We avoid floating point by comparing:
     *   px < x_intersection
     * using cross-multiplication.
     */
    private static boolean isInsideRayCasting(int px, int py, int[][] polygon) {

        int intersections = 0;

        for (int i = 0; i < polygon.length; i++) {

            int nextIndex = i + 1;
            if (nextIndex == polygon.length) {
                nextIndex = 0;
            }

            int x1 = polygon[i][0];
            int y1 = polygon[i][1];
            int x2 = polygon[nextIndex][0];
            int y2 = polygon[nextIndex][1];

            // Check if the edge crosses the horizontal line y = py
            boolean y1Above = y1 > py;
            boolean y2Above = y2 > py;

            // If both above or both below (or equal), it doesn't cross in the correct way
            if (y1Above == y2Above) {
                continue;
            }

            /*
             * Now we know the segment crosses the horizontal line somewhere.
             *
             * We need to know if that crossing is to the right of px.
             *
             * Typical formula:
             *   xIntersect = x1 + (py - y1) * (x2 - x1) / (y2 - y1)
             *
             * We avoid division with cross multiplication:
             * Compare px < xIntersect  <=>  (px - x1) * (y2 - y1) < (py - y1) * (x2 - x1)
             *
             * But be careful: (y2 - y1) can be negative, which flips inequality.
             * To avoid that, we can compute xIntersect as a double safely here,
             * because we already handled boundary cases earlier.
             *
             * Using double here is acceptable because it's not equality checking,
             * it's only a greater/less comparison.
             */
            double xIntersect = x1 + ((double) (py - y1) * (double) (x2 - x1)) / (double) (y2 - y1);

            if (xIntersect > px) {
                intersections++;
            }
        }

        // odd intersections => inside
        return (intersections % 2 == 1);
    }



}
