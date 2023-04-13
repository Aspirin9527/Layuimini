package me.liuhui.mall.manager.kmeans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**算法
 * @author lin
 * @date 2023年04月13日 14:37
 */
@Component
public class KMeansAlgorithm {

    //最大迭代次数
    private static final int MAX_NUM_ITERATIONS = 1000;

    //最小中心距离阈值
    private static final double MIN_DISTANCE_CHANGE_THRESHOLD = 0.01;
    /**
     * KMeans聚类算法
     */
    public List<Cluster> kMeansClustering(List<DataPoint> dataPoints, int numClusters) {
        // 初始化簇心
        List<Cluster> clusters = initializeClusters(dataPoints, numClusters);

        // 迭代计算聚类
        int iteration = 0;
        while (iteration < MAX_NUM_ITERATIONS) {
            // 将所有数据点分配到最近的簇中
            assignDataPointsToClusters(dataPoints, clusters);

            // 计算每个簇的新聚类中心
            boolean isConverged = updateClusterCentroids(clusters);

            if (isConverged) {
                break;
            }

            iteration++;
        }

        return clusters;
    }

    /**
     * 初始化簇心
     */
    private List<Cluster> initializeClusters(List<DataPoint> dataPoints, int numClusters) {
        List<Cluster> clusters = new ArrayList<>();

        // 随机选择numClusters个数据点作为初始簇心
        List<Integer> selectedDataPointIndices = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numClusters; i++) {
            int randomIndex = random.nextInt(dataPoints.size());
            while (selectedDataPointIndices.contains(randomIndex)) {
                randomIndex = random.nextInt(dataPoints.size());
            }
            selectedDataPointIndices.add(randomIndex);
            clusters.add(new Cluster(dataPoints.get(randomIndex)));
        }

        return clusters;
    }

    /**
     * 将所有数据点分配到最近的簇中
     */
    private void assignDataPointsToClusters(List<DataPoint> dataPoints, List<Cluster> clusters) {
        for (Cluster cluster : clusters) {
            cluster.clearDataPoints();
        }

        for (DataPoint dataPoint : dataPoints) {
            double minDistance = Double.MAX_VALUE;
            Cluster nearestCluster = null;
            for (Cluster cluster : clusters) {
                double distance = calculateDistance(dataPoint, cluster.getCentroid());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestCluster = cluster;
                }
            }
            nearestCluster.addDataPoint(dataPoint);
        }
    }

    /**
     * 计算每个簇的新聚类中心
     */
    private boolean updateClusterCentroids(List<Cluster> clusters) {
        boolean isConverged = true;

        for (Cluster cluster : clusters) {
            DataPoint oldCentroid = cluster.getCentroid();
            DataPoint newCentroid = calculateCentroid(cluster.getDataPoints());

            // 如果聚类中心的距离变化量小于阈值，则认为算法已经收敛
            double distanceChange = calculateDistance(oldCentroid, newCentroid);
            if (distanceChange > MIN_DISTANCE_CHANGE_THRESHOLD) {
                isConverged = false;
            }

            cluster.setCentroid(newCentroid);
        }

        return isConverged;
    }

    /**
     * 计算欧几里得距离
     */
    private double calculateDistance(DataPoint dataPoint1, DataPoint dataPoint2) {
        double[] features1 = dataPoint1.getFeatures();
        double[] features2 = dataPoint2.getFeatures();
        double distanceSquared = 0;
        for (int i = 0; i < features1.length; i++) {
            distanceSquared += Math.pow(features1[i] - features2[i], 2);
        }
        return Math.sqrt(distanceSquared);
    }

    /**
     * 计算聚类中心
     */
    private DataPoint calculateCentroid(List<DataPoint> dataPoints) {
        double[] centroidFeatures = new double[dataPoints.get(0).getFeatures().length];
        for (DataPoint dataPoint : dataPoints) {
            double[] features = dataPoint.getFeatures();
            for (int i = 0; i < features.length; i++) {
                centroidFeatures[i] += features[i];
            }
        }
        for (int i = 0; i < centroidFeatures.length; i++) {
            centroidFeatures[i] /= dataPoints.size();
        }
        return new DataPoint(centroidFeatures);
    }


}
