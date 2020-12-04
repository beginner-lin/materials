package com.wangxiaolin.materials.Utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author wangxiaolin
 * @date 2019/12/28 - 17:51
 */
@Configuration
public class ResourceConfigAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String rootPath = getResourceBasePath();
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:/Users/Administrator/executeFile/materials/src/main/resources/static/upload/");
        String path = rootPath+"/src/main/resources/static/upload/";
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/upload/**").
                    addResourceLocations("file:"+path);
        }else{//linux和mac系统 可以根据逻辑再做处理
            registry.addResourceHandler("/upload/**").
                    addResourceLocations("file:"+path);
        }
        super.addResourceHandlers(registry);
    }
    private String getResourceBasePath() {
        // 获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            // nothing to do
        }
        if (path == null || !path.exists()) {
            path = new File("");
        }

        String pathStr = path.getAbsolutePath();
        // 如果是在eclipse中运行，则和target同级目录,如果是jar部署到服务器，则默认和jar包同级
        pathStr = pathStr.replace("\\target\\classes", "");

        return pathStr;
    }

}