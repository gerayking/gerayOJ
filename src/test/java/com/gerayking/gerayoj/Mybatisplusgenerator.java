package com.gerayking.gerayoj;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Arrays;

public class Mybatisplusgenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("gerayKing");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setServiceName("%sService");// 去除Service的I前缀
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);
        // 配置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/gojtest");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("709508");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("gerayoj");
        pc.setParent("com.gerayking");
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setController("controller");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        // 策略配置
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("contests","contests_notice",
                "contests_permissions",
                "contests_problems",
                "contests_registrants",
                "contests_submissions",
                "problems",
                "problems_tags",
                "submissions",
                "user_info");// 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel); // 类驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 属性驼峰命名
        strategy.setEntityLombokModel(true);// lombok
/*        strategy.setLogicDeleteFieldName("deleted");// 逻辑删除
        TableFill gmt_create = new TableFill("gmt_create", FieldFill.INSERT);// 自动填充
        TableFill gmt_modify = new TableFill("gmt_modify", FieldFill.INSERT_UPDATE);// 自动填充设置
        strategy.setTableFillList(Arrays.asList(gmt_create,gmt_modify));*/
        // 设置乐观锁
//        strategy.setVersionFieldName("version");
        strategy.setControllerMappingHyphenStyle(true);// 连接请求localhost:8080/hello
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
