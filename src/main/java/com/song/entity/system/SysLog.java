package com.song.entity.system;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统操作日志实体
 * 
 * @author Nelly
 * @version 1.0.0
 * @date 2020-02-14 18:02:51
 */
@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 操作类型


     */
    private Integer type;

    /**
     * 操作内容


     */
    private String content;

    /**
     * 操作人
     */
    private Integer suId;

    /**
     * 操作时间


     */
    private Date creatTime;


}