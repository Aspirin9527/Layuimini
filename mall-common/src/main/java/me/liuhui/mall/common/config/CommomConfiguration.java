package me.liuhui.mall.common.config;

import me.liuhui.mall.common.config.properties.FilePathProperties;
import me.liuhui.mall.common.image.ImageProcessor;
import me.liuhui.mall.common.image.impl.ImageProcessorImpl;
import me.liuhui.mall.common.search.ProductSearcher;
import me.liuhui.mall.common.service.FileService;
import me.liuhui.mall.common.service.impl.FileServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;


@EnableConfigurationProperties(FilePathProperties.class)
@Configuration
public class CommomConfiguration {

    private final FilePathProperties filePathProperties;

    public CommomConfiguration(FilePathProperties filePathProperties) {
        this.filePathProperties = filePathProperties;
    }

    @ConditionalOnClass(ElasticsearchRestTemplate.class)
    @Bean
    public ProductSearcher productSearcher() {
        return new ProductSearcher();
    }

    @ConditionalOnProperty(prefix = "image.processor", name = "path")
    @Bean
    public ImageProcessor imageProcessor() {
        return new ImageProcessorImpl();
    }

    @Bean
    public FileService fileService() {
        return new FileServiceImpl(filePathProperties);
    }
}
