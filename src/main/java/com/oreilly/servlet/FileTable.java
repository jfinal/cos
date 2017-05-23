package com.oreilly.servlet;

import java.util.Enumeration;
import java.util.Hashtable;

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
class FileTable {
	
    private int index = 0;
    private Hashtable<String, UploadedFile> table = new Hashtable<String, UploadedFile>();

    /**
     * put
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public UploadedFile put(String key, UploadedFile value) {
        if (table.containsKey(key)) {
            key = key + "_" + (index++);
        }
        return table.put(key, value);
    }

    /**
     * get List by key
     * @param key 键
     * @return List
     */
    public UploadedFile get(String key) {
        return table.get(key);
    }

    /**
     * keys 此处需要还原为真实的大小,一个key一个
     * @return key 集合
     */
    public Enumeration<String> keys() {
        return table.keys();
    }

}
