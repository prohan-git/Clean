package com.example.kjpro.networkframesample.network.encrypt;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/****
 * </pre> 
 *  Project_Name:    NetWorkFrameSample
 *  Copyright: 
 *  Version:         1.0.0.1
 *  Created:         Tijun on 2017/8/2 0002 15:53.
 *  E-mail:          prohankj@outlook.com
 *  Desc: 
 * </pre>            
 ****/
//@Retention(RUNTIME)

@Retention(RUNTIME)
@Target(FIELD)
public @interface EncyptAnno {
}
