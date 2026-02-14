import java.util.Arrays;

public class question_7_exam {

    // 4 vertices total
    // focal point is the last set: arr[arr.length -2] and arr[arr.length -3]

    public static void main(String[] args) {

            int[][] matrix = {
                    {0, 0, 6, 8, 1, 1, 2},
                    null,
                    {0, 0, 6, 8, 1, 1},
                    {0, 0, 6, 8, 1, 1, -2},
                    {0, 0, 6, 8, 1, 1, 0},
            };

        //    System.out.println(Arrays.deepToString(TriangleRotation(matrix)));
        System.out.println(Arrays.deepToString(TriangleScale(matrix)));
    }

    // actual exam question:
    public static double[][] TriangleRotation(int[][] triangles) {

        // Results has same number of rows as triangles,
        // but each row will be set to either:
        // - new double[]{-1.0} / {-2.0} / {-3.0}
        // - OR new double[6] for valid rotations
        double[][] results = new double[triangles.length][];

        for (int i = 0; i < triangles.length; i++) {

            // Test 1: null row
            if (triangles[i] == null) {
                results[i] = new double[]{-1.0};
                continue;
            }

            // Test 2: must be length 7
            if (triangles[i].length != 7) {
                results[i] = new double[]{-2.0};
                continue;
            }

            // Now safe to read angle at index 6
            int angle = triangles[i][6];

            // Test 3: angle range
            if (angle < 0 || angle > 360) {
                results[i] = new double[]{-3.0};
                continue;
            }

            // Test 4: rotate all 3 vertices around focal point (x3, y3)
            double theta = Math.toRadians(angle);

            double fx = triangles[i][4];
            double fy = triangles[i][5];

            // Create output row of size 6
            results[i] = new double[6];

            // Rotate (x1,y1)
            double x1 = triangles[i][0];
            double y1 = triangles[i][1];
            results[i][0] = ((x1 - fx) * Math.cos(theta) - (y1 - fy) * Math.sin(theta)) + fx;
            results[i][1] = ((x1 - fx) * Math.sin(theta) + (y1 - fy) * Math.cos(theta)) + fy;

            // Rotate (x2,y2)
            double x2 = triangles[i][2];
            double y2 = triangles[i][3];
            results[i][2] = ((x2 - fx) * Math.cos(theta) - (y2 - fy) * Math.sin(theta)) + fx;
            results[i][3] = ((x2 - fx) * Math.sin(theta) + (y2 - fy) * Math.cos(theta)) + fy;

            // Rotate (x3,y3) around itself -> stays the same (but still compute or just copy)
            double x3 = triangles[i][4];
            double y3 = triangles[i][5];
            results[i][4] = x3;
            results[i][5] = y3;
        }

        return results;
    }


    /*
     * QUESTION — Triangle Scaling
     *
     * Write a method:
     *
     *     public static double[][] TriangleScale(int[][] triangles)
     *
     * Each row of triangles contains:
     *     {x1, y1, x2, y2, x3, y3, scaleFactor}
     *
     * The focal point is always the third vertex (x3, y3).
     *
     * You must scale the triangle relative to the focal point.
     *
     * Scaling formula for a point (x, y):
     *
     *     scaledX = fx + (x - fx) * scaleFactor
     *     scaledY = fy + (y - fy) * scaleFactor
     *
     * VALIDATION RULES (apply in this order per row):
     *
     * 1) If triangles[i] == null
     *      -> results[i] = new double[]{-1.0}
     *
     * 2) If triangles[i].length != 7
     *      -> results[i] = new double[]{-2.0}
     *
     * 3) If scaleFactor <= 0
     *      -> results[i] = new double[]{-3.0}
     *
     * 4) Otherwise:
     *      -> return scaled coordinates as:
     *         {sx1, sy1, sx2, sy2, sx3, sy3}
     *
     * NOTES:
     * - Output must be a jagged double[][].
     * - Do NOT return early.
     * - Process every row.
     */

    public static double[][] TriangleScale(int[][] triangles){
        // format of triangles: {x1, y1, x2, y2, x3, y3, scaleFactor}

        double[][] result = new double[triangles.length][];

        for(int i = 0; i < triangles.length; i++) {
           if(triangles[i] == null) {
               result[i] = new double[]{-1.0};
           }else if(triangles[i].length != 7 ){
                result[i] = new double[]{-2.0};
           }
           else if(triangles[i][6] <= 0){
               result[i] = new double[]{-3.0};
           }
           // valid row
           else{
               // since row is valid we need to add an array of length 6 to result at each row
               result[i] = new double[6];

                double sf = triangles[i][6];
                double fx = triangles[i][4];
                double fy = triangles[i][5];

                // first vertex
                double x1 = fx + (triangles[i][0] - fx) * sf;
                double y1 = fy + (triangles[i][1] - fy) * sf;
                result[i][0] = x1;
                result[i][1] = y1;

                // second vertex
               double x2 = fx + (triangles[i][2] - fx) * sf;
               double y2 = fy + (triangles[i][3] - fy) * sf;
               result[i][2] = x2;
               result[i][3] = y2;

               //focal point vertex
                double x3 = fx + (triangles[i][4] - fx) * sf;
                double y3 = fy + (triangles[i][5] - fy) * sf;
                result[i][4] = x3;
                result[i][5] = y3;
           }
        }
        return result;
    }

    /*
     * QUESTION — Rectangle Reflection Across X-Axis
     *
     * Write a method:
     *
     *     public static double[][] RectangleReflect(int[][] rectangles)
     *
     * Each row contains 8 integers:
     *
     *     {x1, y1, x2, y2, x3, y3, x4, y4}
     *
     * You must reflect the rectangle across the X-axis.
     *
     * Reflection formula:
     *
     *     newX = x
     *     newY = -y
     *
     * VALIDATION RULES (apply in this order per row):
     *
     * 1) If rectangles[i] == null
     *      -> results[i] = new double[]{-1.0}
     *
     * 2) If rectangles[i].length != 8
     *      -> results[i] = new double[]{-2.0}
     *
     * 3) If ANY coordinate is outside the range [-500, 500]
     *      -> results[i] = new double[]{-3.0}
     *
     * 4) Otherwise:
     *      -> return reflected coordinates:
     *         {x1, -y1, x2, -y2, x3, -y3, x4, -y4}
     *
     * NOTES:
     * - Output must be jagged double[][].
     * - Do NOT return early.
     * - Process every row.
     */




}
