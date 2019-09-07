package com.ysar.constant;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author shenwei
 * @Date 2019-09-05 14:48
 */
// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(new GlobalConfig()
                //生成文件的输出目录【默认 D 盘根目录】
                .setOutputDir(projectPath + "/src/main/java")
                //开启 ActiveRecord 模式   默认false
                .setActiveRecord(false)
                //开发人员名称
                .setAuthor("shenwei")
                //是否在xml中添加二级缓存配置  默认false
                .setEnableCache(false)
                //是否覆盖已有文件  默认false
                .setFileOverride(true)
                //是否打开输出目录  默认true
                .setOpen(true)
                //开启 swagger2 模式    默认false
                .setSwagger2(true)
                //时间类型对应策略  默认为java8 新的时间类型
                .setDateType(DateType.TIME_PACK)
                //.setIdType()      指定生成的主键的ID类型
                //开启 Kotlin 模式   默认false
                .setKotlin(false)
                /**
                 * 指定每一层文件生成的名称目标
                 */
                .setControllerName("%sController")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setEntityName("%sEntity")
                .setMapperName("%sEntityMapper")
                .setXmlName("%sEntityMapper")
                .setBaseColumnList(true)    //开启 baseColumnList     默认false   xml文件中的columnList
                .setBaseResultMap(true) //开启 BaseResultMap   默认false   xml文件中的ResultMap
        );

        // 数据源配置
        mpg.setDataSource(new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/ysar?allowMultiQueries=true&autoReconnect=true&useServerPreparedStmts=false&rewriteBatchedStatements=true&characterEncoding=UTF-8&useSSL=false")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456")
                .setDbType(DbType.MYSQL) // 设置数据库类型
        );

        // 包配置
        mpg.setPackageInfo(new PackageConfig()
                .setModuleName(scanner("模块名:"))   //父包模块名
                //.setPathInfo()  //路径配置信息
                .setParent("com.ysar.module")    //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .setController("controller")    //Controller包名
                .setService("service")   //Service包名
                .setServiceImpl("service.impl")   //Service Impl包名
                .setEntity("domain.entity")    //Entity包名
                .setMapper("mapper")    //Mapper包名
                .setXml("mapper.xml")   //Mapper XML包名
        );

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + mpg.getPackageInfo().getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("/templates/codegenerator/Entity.java");
//        templateConfig.setServiceImpl("/templates/codegenerator/ServiceImpl.java");
//        templateConfig.setService("/templates/codegenerator/Service.java");
//        templateConfig.setController("/templates/codegenerator/Controller.java");
//        templateConfig.setEntityKt("/templates/codegenerator/QueryDTO.java");
//        templateConfig.setEntityKt("/templates/codegenerator/DTO.java");
//        templateConfig.setMapper("/templates/codegenerator/Mapper.java");
//        templateConfig.setXml("/templates/codegenerator/Mapper.xml");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        mpg.setStrategy(new StrategyConfig()
                        .setCapitalMode(false)  //是否大写命名（默认 false）
                        .setSkipView(false)     //是否跳过视图（默认 false）
                        .setNaming(NamingStrategy.underline_to_camel)    //数据库表映射到实体的命名策略
                        .setColumnNaming(NamingStrategy.underline_to_camel)  //数据库表字段映射到实体的命名策略
                        .setTablePrefix("")   //表前缀
                        .setFieldPrefix("")       //字段前缀
                        //.setSuperEntityClass("com.ysar.common.domain.BaseDomain")  //自定义继承的Entity类全称，带包名
                        //.setSuperEntityColumns("id")    //自定义基础的Entity类，公共字段
                        .setInclude(scanner("表名, 多个英文逗号分割").split(","))   //需要包含的表名，允许正则表达式（与exclude二选一配置）
                        .setEntityColumnConstant(false)  //【实体】是否生成字段常量（默认 false）
                        .setEntityBuilderModel(false)    //【实体】是否为构建者模型（默认 false）
                        .setEntityLombokModel(true)     //【实体】是否为lombok模型（默认 false）
                        .setEntityBooleanColumnRemoveIsPrefix(false)     //Boolean类型字段是否移除is前缀（默认 false）
                        .setRestControllerStyle(true)   //生成 @RestController 控制器
                        .setControllerMappingHyphenStyle(true)  //驼峰转连字符
                        .setEntityTableFieldAnnotationEnable(true)  //是否生成实体时，生成字段注解（默认 false）
                //.setVersionFieldName()  //乐观锁属性名称
                //.setLogicDeleteFieldName()  //逻辑删除属性名称
                //.setTableFillList() //表填充字段
        );

        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}