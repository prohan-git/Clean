package com.example.kjpro.networkframesample.network.enyc;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/2 0002 11:09.
 *  E-mail:          prohankj@outlook.com
 *  Desc: 
 * </pre>            
 ****/
public class PostAction {
    @EncyptionAnno
    private String key;
    @EncyptionAnno
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

    public PostAction(String key, String pageNumber, String sortField) {
        this.key = key;
        this.pageNumber = pageNumber;
        this.sortField = sortField;
    }

}
