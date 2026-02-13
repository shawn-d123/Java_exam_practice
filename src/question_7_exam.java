public class question_7_exam {

    // 4 vertices total
    // focal point is the last set: arr[arr.length -2] and arr[arr.length -3]

    public static void main(String[] args) {


    }

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


}
