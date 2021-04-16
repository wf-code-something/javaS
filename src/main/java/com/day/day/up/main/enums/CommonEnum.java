package com.day.day.up.main.enums;

/**
 * 公共枚举类定义
 *
 * @author wf
 */
public class CommonEnum {

    /**
     * PayLog 注解 操作类型定义
     */
    public enum OperatorType{
        /**
         * PayLog 注解 操作类型定义
         */
        ADD("add"),
        DELETE("delete"),
        UPDATE("update");

        private String value;

        OperatorType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum BizModuleEnum {
        /**
         * 功能枚举定义
         */
        DEMO_ADD("0001", "测试模块", "001", "新增测试模块", "测试模块计划"),
        DEMO_UPDATE("0001", "测试模块", "002", "修改测试模块", "测试模块计划"),
        DEMO_DELETE("0001", "测试模块", "003", "删除测试模块", "测试模块计划"),
        ;
        private String moduleCode;
        private String moduleName;
        private String funcCode;
        private String funcName;
        private String desc;

        /**
         * @param moduleCode 模块编码
         * @param moduleName 模块名称
         * @param funcCode  功能编码
         * @param funcName  功能名称
         * @param desc  描述
         */
        BizModuleEnum(String moduleCode,String moduleName, String funcCode,String funcName,String desc) {
            this.moduleCode = moduleCode;
            this.moduleName = moduleName;
            this.funcCode = funcCode;
            this.funcName = funcName;
            this.desc = desc;
        }

        public String getModuleCode() {
            return moduleCode;
        }

        public String getModuleName() {
            return moduleName;
        }

        public String getFuncCode() {
            return funcCode;
        }

        public String getFuncName() {
            return funcName;
        }

        public String getDesc() {
            return desc;
        }
    }
}
