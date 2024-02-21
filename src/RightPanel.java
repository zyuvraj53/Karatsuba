import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {

    private final int RIGHT_PANEL_WIDTH = 1200;
    private final int RIGHT_PANEL_HEIGHT = 800;

    private final int[] xPoints = {10, 20, 30, 40, 50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    private int[] yPointsSquared;
    private int[] yPointsPower1_58;

    int offset_x = 20;
    int offset_y = -20;

    RightPanel() {
        this.setPreferredSize(new Dimension(RIGHT_PANEL_WIDTH, RIGHT_PANEL_HEIGHT));
        this.setBackground(Color.gray);
        this.setLayout(null);

        // calculating the y points for the n^2 graph
        this.yPointsSquared = calculateSquare(this.xPoints);
        // normalizing the points to fit on the y-axis
        this.yPointsSquared = normalize(this.yPointsSquared);

        // calculating the y points for the n^1.58 graph
        this.yPointsPower1_58 = calculatePower1_58(this.xPoints);
        // normalizing the points to fit on the y-axis
        this.yPointsPower1_58 = normalize(this.yPointsPower1_58);

        for(int yPoint: yPointsPower1_58)
            System.out.println(yPoint);
    }

    public int[] calculateSquare(int[] xPoints){
        int[] yPointsSquared = new int[xPoints.length];
        for(int i = 0; i < xPoints.length; i++){
            yPointsSquared[i] = xPoints[i] * xPoints[i];
        }

        return yPointsSquared;
    }

    public int[] calculatePower1_58(int[] xPoints){
        int[] yPointsPower1_58 = new int[xPoints.length];
        for(int i = 0; i < xPoints.length; i++){
            yPointsPower1_58[i] = (int) Math.pow((double) this.xPoints[i], 1.58);
        }

        return yPointsPower1_58;
    }

    public int[] normalize(int[] arr){
        int[] normalizedArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            normalizedArr[i] = arr[i] / (RIGHT_PANEL_HEIGHT - 40);
        }

        return normalizedArr;
    }

    public int[] map(int[] arr){ // wrong logic, correct it
        int[] mappedArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            mappedArr[i] = (int) ((float) (1.0 / (arr[i])) * Math.pow((RIGHT_PANEL_HEIGHT + 0.0 - 40f), 2f));
        }

        return mappedArr;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(Color.BLACK);
        drawXAxis(g2D);
        drawYAxis(g2D);

        g2D.setStroke(new BasicStroke(3));
        drawXAxisPoints(g2D);
        drawYAxisPoints(g2D);

        g2D.setColor(new Color(125, 50, 255));
        g2D.setStroke(new BasicStroke(3));
        drawN2Points(g2D);
        g2D.setStroke(new BasicStroke(1));
        drawN2Graph(g2D);

        g2D.setColor(new Color(0, 255, 0));
        g2D.setStroke(new BasicStroke(3));
        drawN1_58Points(g2D);
        g2D.setStroke(new BasicStroke(1));
        drawN1_58Graph(g2D);
    }

    public void drawXAxis(Graphics2D g2D){
        g2D.drawLine(20, RIGHT_PANEL_HEIGHT - 20, RIGHT_PANEL_WIDTH - 20, RIGHT_PANEL_HEIGHT - 20); // x-axis
    }

    public void drawYAxis(Graphics2D g2D){
        g2D.drawLine(20, 20, 20, RIGHT_PANEL_HEIGHT - 20); // y-axis
    }

    public void drawXAxisPoints(Graphics2D g2D){
        for (int xPoint : this.xPoints) {

            // drawing points on x-axis
            g2D.drawLine(xPoint + offset_x,
                    RIGHT_PANEL_HEIGHT + offset_y,
                    xPoint + offset_x,
                    RIGHT_PANEL_HEIGHT + offset_y
            );
        }
    }

    public void drawYAxisPoints(Graphics2D g2D){
        int[] normalized = normalize(this.xPoints);
        for (int yPoint : normalized) {

            // drawing points on y-axis
            g2D.drawLine(offset_x,
                    RIGHT_PANEL_HEIGHT - yPoint + offset_y,
                        offset_x,
                    RIGHT_PANEL_HEIGHT - yPoint + offset_y
            );
        }
    }

    public void drawN2Points(Graphics2D g2D) {
        for(int i = 1; i < this.xPoints.length; i++) {
            // drawing the graph points
            g2D.drawLine(this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsSquared[i] + offset_y,
                    this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsSquared[i] + offset_y
            );
        }
    }

    public void drawN2Graph(Graphics2D g2D){
        for(int i = 1; i < this.xPoints.length; i++) {
            // drawing the graph points
            g2D.drawLine(this.xPoints[i - 1] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsSquared[i - 1] + offset_y,
                    this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsSquared[i] + offset_y
            );
        }
    }

    public void drawN1_58Points(Graphics2D g2D) {
        for(int i = 1; i < this.xPoints.length; i++) {
            // drawing the graph points
            g2D.drawLine(this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsPower1_58[i] + offset_y,
                    this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsPower1_58[i] + offset_y
            );
        }
    }

    public void drawN1_58Graph(Graphics2D g2D){
        for(int i = 1; i < this.xPoints.length; i++) {
            // drawing the graph points
            g2D.drawLine(this.xPoints[i - 1] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsPower1_58[i - 1] + offset_y,
                    this.xPoints[i] + offset_x,
                    RIGHT_PANEL_HEIGHT - this.yPointsPower1_58[i] + offset_y
            );
        }
    }
}
