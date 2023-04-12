package me.liuhui.mall.manager.kmeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lin
 * @date 2023年04月12日 16:49
 */
public class KMeans {
    private int k; // 簇的数量
    private int maxIterations; // 最大迭代次数
    private List<double[]> data; // 数据集
    private List<double[]> centroids; // 簇中心

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public List<double[]> getData() {
        return data;
    }

    public void setData(List<double[]> data) {
        this.data = data;
    }

    public List<double[]> getCentroids() {
        return centroids;
    }

    public void setCentroids(List<double[]> centroids) {
        this.centroids = centroids;
    }

    public KMeans(int k, int maxIterations, List<double[]> data) {
        this.k = k;
        this.maxIterations = maxIterations;
        this.data = data;
        this.centroids = initCentroids();
    }

    // 初始化簇中心
    private List<double[]> initCentroids() {
        List<double[]> centroids = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int index = random.nextInt(data.size());
            centroids.add(data.get(index));
        }
        return centroids;
    }

    // 计算两个向量之间的距离
    private double distance(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }

    // 根据簇中心对数据进行分类
    private int classify(double[] dataPoint) {
        int minIndex = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < centroids.size(); i++) {
            double[] centroid = centroids.get(i);
            double distance = distance(dataPoint, centroid);
            if (distance < minDistance) {
                minIndex = i;
                minDistance = distance;
            }
        }
        return minIndex;
    }

    // 更新簇中心
    private void updateCentroids(List<List<double[]>> clusters) {
        for (int i = 0; i < clusters.size(); i++) {
            List<double[]> cluster = clusters.get(i);
            double[] centroid = new double[data.get(0).length];
            for (int j = 0; j < cluster.size(); j++) {
                double[] dataPoint = cluster.get(j);
                for (int k = 0; k < dataPoint.length; k++) {
                    centroid[k] += dataPoint[k];
                }
            }
            for (int k = 0; k < centroid.length; k++) {
                centroid[k] /= cluster.size();
            }
            centroids.set(i, centroid);
        }
    }

    // 运行K-means算法
    public List<List<double[]>> run() {
        List<List<double[]>> clusters = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            clusters.add(new ArrayList<>());
        }

        for (int i = 0; i < maxIterations; i++) {
            for (int j = 0; j < data.size(); j++) {
                double[] dataPoint = data.get(j);
                int clusterIndex = classify(dataPoint);
                clusters.get(clusterIndex).add(dataPoint);
            }
            updateCentroids(clusters);
        }
        return clusters;
    }
}
