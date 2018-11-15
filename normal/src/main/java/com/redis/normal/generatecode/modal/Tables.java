package com.redis.normal.generatecode.modal;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author:
 * @Date: 2018/5/2 17:31
 * @Description:
 */
@Table(name = "information_schema.tables")
@Data
public class Tables {
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "table_schema")
    private String tableSchema;
    @Column(name = "table_comment")
    private String comment;
}