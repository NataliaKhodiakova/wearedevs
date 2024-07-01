package com.raysono.wearedevs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Canvas canvas = objectMapper.readValue(new File("src/main/resources/coordinatesystem.json"), Canvas.class);

            int count = countPointsInLogo(canvas.getCoords());
            System.out.println("Number of points in the '100' logo: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countPointsInLogo(List<int[]> coordinates) {
        int count = 0;

        for (int[] coord : coordinates) {
            int x = coord[0];
            int y = coord[1];

            // Check if the point is in the "1"
            if (x >= 145 && x <= 165 && y >= 75 && y <= 225) {
                count++;
            }
            // Check if the point is in the first "0"
            else if (isPointInCircle(x, y, 250, 150, 75) && !isPointInCircle(x, y, 250, 150, 55)) {
                count++;
            }
            // Check if the point is in the second "0"
            else if (isPointInCircle(x, y, 410, 150, 75) && !isPointInCircle(x, y, 410, 150, 55)) {
                count++;
            }
        }

        return count;
    }


    private static boolean isPointInCircle(int x, int y, int centerX, int centerY, int radius) {
        int dx = x - centerX;
        int dy = y - centerY;
        return dx * dx + dy * dy <= radius * radius;
    }
}