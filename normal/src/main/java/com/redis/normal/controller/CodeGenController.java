package com.redis.normal.controller;


import com.google.common.base.Strings;
import com.google.common.io.ByteStreams;
import com.redis.normal.annotation.BusinessLog;
import com.redis.normal.generatecode.controller.BaseController;
import com.redis.normal.generatecode.mapper.TablesMapper;
import com.redis.normal.generatecode.modal.Columns;
import com.redis.normal.generatecode.modal.Tables;
import com.redis.normal.generatecode.services.ColumnsBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("codeGen")
@Api(description = "代码生成（系统内部使用）")
@Slf4j
//@ConditionalOnProperty(name = "swagger.enable",havingValue = "true")
public class CodeGenController extends BaseController<ColumnsBiz, Columns> {

    @Autowired
    TablesMapper tablesMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @ApiOperation(value="根据数据库表生成对应实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name="schema",value="数据库名称[例： firmiana_domain_customer ]",required=true,dataType="String",paramType="query"),
            @ApiImplicitParam(name="table",value="表名",required=true,dataType="String",paramType="query")
    })
    @BusinessLog(logInfo = "根据数据库表生成对应实体")
    @RequestMapping(value = "gen",method = {RequestMethod.POST})
    public void tableGen(String schema,String table, HttpServletResponse response)throws Exception{
        if(!log.isDebugEnabled() && !log.isInfoEnabled()){
            return;
        }
        Columns columns = new Columns();
        columns.setTable_schema(schema);
        columns.setTable_name(table);
        List<Columns> list = baseBiz.selectList(columns);

        Tables tb = new Tables();
        tb.setTableName(table);
        tb.setTableSchema(schema);
        tb = tablesMapper.selectOne(tb);

        File f = new File(camelName(table));

        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.newLine();
        bw.write("");bw.newLine();
        bw.write("package com.test.;");bw.newLine();
        bw.write("");bw.newLine();
        bw.write("import io.swagger.annotations.ApiModelProperty;");bw.newLine();
        bw.write("import javax.persistence.Column;");bw.newLine();
        bw.write("import javax.persistence.Id;");bw.newLine();
        bw.write("import javax.persistence.Table;");bw.newLine();
        bw.write("import java.util.Date;");bw.newLine();
        bw.write("import lombok.Data;");bw.newLine();
        bw.write("");bw.newLine();

        bw.write("/**");bw.newLine();
        bw.write(" * @Author: shimingming");bw.newLine();
        bw.write(" * @Date: " + sdf.format(new Date()));bw.newLine();
        bw.write(" * @Description: " + tb.getComment());bw.newLine();
        bw.write(" */");bw.newLine();


        bw.write("@Data");bw.newLine();
        bw.write("@Table(name = \""+ table.toLowerCase() +"\")");bw.newLine();

        String fileName = camelName(table);
        fileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);

        bw.write("public class "+ fileName + "{");bw.newLine();
        bw.write("");
        String name = null;
        String type = null;
        String commit = null;
        String required = null;
        for (Columns c: list){
            name = c.getColumn_name().toLowerCase();
            type = dateType(c.getData_type().toLowerCase());
            commit = replace(c.getColumn_comment());
            required = c.getIs_nullable();

            bw.newLine();
            String api = "	@ApiModelProperty(value = \"" + commit + "\",required=" + ("YES".equalsIgnoreCase(required)?"false":"true") +  ")";
            bw.write(api);
            bw.newLine();
            String col = "	@Column(name = \"" + name + "\")";
            bw.write(col);
            bw.newLine();
            String row ="	private " + type + " " + camelName(name) + ";";
            bw.write(row);
            bw.newLine();
            bw.write("");
        }
        bw.newLine();
        bw.write("}");


        bw.flush();
        bw.close();

        testDownload(response,f,fileName);
    }


    public void testDownload(HttpServletResponse res, File file, String fileName) {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        res.setContentType("application/octet-stream;");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName+".java;");

        try {
            ByteStreams.copy(new FileInputStream(file),res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                file.delete();
            } catch (Exception e) {
            }
        }
    }

    private String dateType(String type){
        switch (type){

            case "bigint":
                return "Long";
            case "int":
            case "tinyint":
                return "Integer";
            case "varchar":
            case "char":
                return "String";
            case "datetime":
            case "timestamp":
            case "date":
                return "Date";
            case "float":
            case "decimal":
                return "Double";
        }
        return "String";
    }

    private String replace(String src){
        if(Strings.isNullOrEmpty(src)){
            return "";
        }
        //替换中文
        return src.trim()
                .replaceAll("：",":")
                .replaceAll("）",")")
                .replaceAll("（","(")
                .replaceAll("；",";")
                .replaceAll("。",".")
                .replaceAll("，",",")
                .replaceAll("？","?");
    }

}
