package com.example.ele_me.util;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;  
import java.lang.annotation.RetentionPolicy;  

/** 
 * Use this annotation to mark the fields of your Activity as being injectable. 
 * <p> 
 * See the {@link Injector} class for more details of how this operates. 
 */  
@Target({ ElementType.FIELD })  
@Retention(RetentionPolicy.RUNTIME)  
public @interface InjectView {  
    /** 
     * The resource id of the View to find and inject. 
     */  
    public int value();  
}  