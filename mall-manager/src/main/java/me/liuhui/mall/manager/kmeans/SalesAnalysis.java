package me.liuhui.mall.manager.kmeans;

import java.util.*;

/**
 * @author lin
 * @date 2023年04月12日 16:50
 */
public class SalesAnalysis {

    public static void main(String[] args) {
        // 商品销售数据
        double[][] salesData = {
                {101, 1, 11, 5000},
                {102, 1, 12, 4000},
                {103, 1, 1, 3000},
                {104, 2, 2, 5000},
                {105, 3, 3, 5000},
                {106, 4, 4, 1000},
                {107, 5, 4, 9000},
                {108, 1, 5, 10000},
                {109, 2, 1, 10000},
                {110, 4, 6, 2000},
                {120, 5, 6, 1000},
                {130, 2, 7, 1000},
                {140, 3, 8, 6000},
                {150, 2, 9, 1000},
                {160, 3, 10, 8000},
                {170, 3, 12, 9000},
                {180, 2, 3, 7000},
                {190, 2, 5, 1000},
                {200, 3, 1, 7500}
        };

        List<double[]> data = new ArrayList<>();
        for (double[] row : salesData) {
            data.add(row);
        }

        // 运行K-means算法
        KMeans kMeans = new KMeans(4, 100, data);
        List<List<double[]>> clusters = kMeans.run();

        // 输出簇中心和数据分类结果
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + i + " centroid: " + Arrays.toString(kMeans.getCentroids().get(i)));
            Set<double[]> set = new HashSet<>();
            for (double[] dataPoint : clusters.get(i)) {
                set.add(dataPoint);
                System.out.println("Data point " + Arrays.toString(dataPoint) + " in cluster " + i);
            }
        }
    }

}
