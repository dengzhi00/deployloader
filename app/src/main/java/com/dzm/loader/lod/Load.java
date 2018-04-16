package com.dzm.loader.lod;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author 邓治民
 *         data 2018/4/16 下午2:50
 */

class Load {

    private ClassLoader loader;
    private Enumeration<URL> configs = null;

    Load() {
        //初始化加载器
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (null != cl) {
            loader = cl;
        } else {
            loader = ClassLoader.getSystemClassLoader();
        }
    }
    //获取URL
    URL initLoad(String location) {
        if (configs == null) {
            try {
                if (loader == null)
                    configs = ClassLoader.getSystemResources(location);
                else
                    configs = loader.getResources(location);
            } catch (IOException x) {
                x.printStackTrace();
            }
        }
        return configs.nextElement();
    }

    ClassLoader getLoader() {
        return loader;
    }
}
