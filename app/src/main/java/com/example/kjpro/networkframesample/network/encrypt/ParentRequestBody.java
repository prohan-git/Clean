package com.example.kjpro.networkframesample.network.encrypt;

import java.util.Map;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/3 0003 9:58.
 *  E-mail:          prohankj@outlook.com
 *  Desc: 
 * </pre>            
 ****/
public class ParentRequestBody {
    /**
     * 将RequeBody转换为Map类型，可用于QueryMap请求
     *
     * @return 加密后的Api
     */
    public Map<String, String> init() {
        return EncryptionAnnoUtil.getEncry(this);
    }
}
