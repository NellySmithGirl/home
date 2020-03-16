//package com.song.util.generator;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Create {
//
//	public static final Logger logger = LoggerFactory.getLogger(Create.class);
//	public static void main(String[] args) {
//		Create ot=new Create();
//		ot.test();
//	}
//
//	public void test(){
//
//		// 数据库连接信息
//
//		String url = "jdbc:mysql://rm-wz90svnsmjc157h0oho.mysql.rds.aliyuncs.com:3306/modu_test?useUnicode=true&characterEncoding=utf8";
//
//		String MysqlUser = "root";
//		String mysqlPassword = "8a8b8c9D9E9F";
//
//		// 数据库及数据表名称
//		String database = "modu_test";
//		String table = "cl_borrow";
//		// 配置作者及Domain说明
//		String classAuthor = "linrongkai";
//		String functionName = "借款限制";
//
//
//		// 公共包路径 (例如 BaseDao、 BaseService、 BaseServiceImpl)
//		String commonName ="com.rongdu.cashloan.api";
//
//		String packageName ="com.rongdu.cashloan.api";
//		//文件夹名字
//		String moduleName = "Org";
//
//		//Mapper文件存储地址  默认在resources中
//		String batisName = "config/mappers";
//		String db="mysql";
//
//		//类名前缀
//		String classNamePrefix = "ClBorrow";
//
//		try {
//			MybatisGenerate.generateCode(db,url, MysqlUser, mysqlPassword, database, table,commonName,packageName,batisName,moduleName,classAuthor,functionName,classNamePrefix);
//		} catch (Exception e) {
//			logger.error(e.getMessage(),e);
//		}
//	}
//
//}
