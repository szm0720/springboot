package com.redis.normal.generatecode.modal;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "information_schema.columns")
@Data
public class Columns {
    @Column(name = "table_catalog")
    private String table_catalog;
    @Column(name = "table_schema")
    private String table_schema;
    @Column(name = "table_name")
    private String table_name;
    @Column(name = "column_name")
    private String column_name;
    @Column(name = "ordinal_position")
    private Long ordinal_position;
    @Column(name = "column_default")
    private String column_default;
    @Column(name = "is_nullable")
    private String is_nullable;
    @Column(name = "data_type")
    private String data_type;
    @Column(name = "character_maximum_length")
    private Long character_maximum_length;
    @Column(name = "character_octet_length")
    private Long character_octet_length ;
    @Column(name = "numeric_precision")
    private Long numeric_precision ;
    @Column(name = "numeric_scale")
    private Long numeric_scale ;
    @Column(name = "datetime_precision")
    private Long datetime_precision ;
    @Column(name = "character_set_name")
    private String character_set_name ;
    @Column(name = "collation_name")
    private String  collation_name;
    @Column(name = "column_type")
    private String column_type ;
    @Column(name = "column_key")
    private String  column_key;
    @Column(name = "extra")
    private String  extra;
    @Column(name = "privileges")
    private String  privileges;
    @Column(name = "column_comment")
    private String  column_comment;
}
