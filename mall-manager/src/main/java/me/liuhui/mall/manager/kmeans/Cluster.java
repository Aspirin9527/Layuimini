package me.liuhui.mall.manager.kmeans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lin
 * @date 2023年04月13日 15:14
 */
public class Cluster {
    private DataPoint centroid;
    private final List<DataPoint> dataPoints;

    public Cluster(DataPoint centroid) {
        this.centroid = centroid;
        this.dataPoints = new ArrayList<>();
    }

    public DataPoint getCentroid() {
        return centroid;
    }

    public void setCentroid(DataPoint centroid) {
        this.centroid = centroid;
    }

    public List<DataPoint> getDataPoints() {
        return dataPoints;
    }

    public void addDataPoint(DataPoint dataPoint) {
        dataPoints.add(dataPoint);
    }

    public void clearDataPoints() {
        dataPoints.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Centroid: ").append(centroid).append("\n");
        sb.append("Data points: [");
        for (int i = 0; i < dataPoints.size(); i++) {
            sb.append(dataPoints.get(i));
            if (i < dataPoints.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

