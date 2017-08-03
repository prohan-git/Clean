package com.example.kjpro.networkframesample.network.requestBody;

import com.example.kjpro.networkframesample.network.encrypt.EncyptAnno;
import com.example.kjpro.networkframesample.network.encrypt.ParentRequestBody;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/2 0002 11:09.
 *  E-mail:          prohankj@outlook.com
 *  Desc:            调用父类的init可返回加密后的Map类型参数
 * </pre>            
 ****/
public class PostRequestBody extends ParentRequestBody {
    @EncyptAnno
    private String key;
    @EncyptAnno
    private String pageNumber;
    private String sortField;

    public void setKey(String key) {
        this.key = key;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public PostRequestBody(String key, String pageNumber, String sortField) {
        this.key = key;
        this.pageNumber = pageNumber;
        this.sortField = sortField;
    }
}
