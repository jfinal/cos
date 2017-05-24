package com.oreilly.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 装载文件的table
 * 
 * 上传文件时，使用相同name时只能获取到最后的一个。
 * 
 * 修改：当重复时，统一将key添加后缀`_N`如name_0
 * 
 * @author L.cm
 *
 */
class FileMap {
	
    private int index = 0;
    private LinkedHashMap<String, UploadedFile> map = new LinkedHashMap<String, UploadedFile>();

    /**
     * put
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public UploadedFile put(String key, UploadedFile value) {
        if (map.containsKey(key)) {
            key = key + "_" + (index++);
        }
        return map.put(key, value);
    }

    /**
     * get List by key
     * @param key 键
     * @return List
     */
    public UploadedFile get(String key) {
        return map.get(key);
    }

    /**
     * keys 此处需要还原为真实的大小,一个key一个
     * @return key 集合
     */
    public Enumeration<String> keys() {
    	return Collections.enumeration(map.keySet());
    }
    
    /**
     * jfinal 3.2 以及后续版本使用该方法来取出上传文件的文件名
     * 避免构造 Enumeration 对象
     */
    public Set<String> getFileNameSet() {
    	return map.keySet();
    }
}
