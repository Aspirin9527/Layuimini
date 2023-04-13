package me.liuhui.mall.manager.kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lin
 * @date 2023年04月13日 14:38
 */
public class TestTool {
    public static void main(String[] args) {

        // 读取商品数据
        List<DataPoint> dataPoints = readDataPointsFromFile("C:\\Users\\lin\\Desktop\\data.txt");

        // 进行KMeans聚类
        KMeansAlgorithm kMeansAlgorithm = new KMeansAlgorithm();
        List<Cluster> clusters =kMeansAlgorithm.kMeansClustering(dataPoints, 4);


        // 打印聚类结果
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ":");
            for (DataPoint dataPoint : clusters.get(i).getDataPoints()) {
                System.out.println(dataPoint.getGoods());
            }
            System.out.println("Centroid: " + clusters.get(i).getCentroid());
            System.out.println();
        }
    }


    private static List<DataPoint> readDataPointsFromFile(String filePath) {
        List<DataPoint> dataPoints = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double[] features = new double[3];
                features[0] = Double.parseDouble(values[0]); // 销量
                features[1] = Double.parseDouble(values[1]); // 定价
                features[2] = Double.parseDouble(values[2]); // 商品类别
                dataPoints.add(new DataPoint(values[3],features));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataPoints;

    }
}
