/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : his

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-05-31 15:43:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for checkapply
-- ----------------------------
DROP TABLE IF EXISTS `checkapply`;
CREATE TABLE `checkapply` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `medicalid` int(9) NOT NULL COMMENT '病历ID',
  `registid` int(9) NOT NULL COMMENT '挂号ID',
  `itemid` int(9) NOT NULL COMMENT '项目ID',
  `name` varchar(64) NOT NULL COMMENT '项目名称',
  `objective` varchar(512) DEFAULT NULL COMMENT '目的要求',
  `position` varchar(64) DEFAULT NULL COMMENT '检查部位',
  `isurgent` int(1) DEFAULT '0' COMMENT '是否加急 1为加急 0为不加急',
  `num` int(3) DEFAULT NULL COMMENT '数量',
  `creationtime` datetime NOT NULL COMMENT '开立时间',
  `doctorid` int(9) DEFAULT NULL COMMENT '开立医生ID',
  `checooperid` int(9) NOT NULL COMMENT '检查人员ID',
  `resultoperid` int(9) NOT NULL COMMENT '结果录入人员ID',
  `checktime` datetime DEFAULT NULL COMMENT '检查时间',
  `result` varchar(512) DEFAULT NULL COMMENT '检查结果',
  `resulttime` datetime DEFAULT NULL COMMENT '结果时间',
  `state` int(9) DEFAULT NULL COMMENT '状态\r\n1-暂存 \r\n2-已开立\r\n3-已交费\r\n4-已登记\r\n5-执行完\r\n6-已退费\r\n0-已作废\r\n',
  `recordtype` int(1) NOT NULL COMMENT '记录类型\r\n1-检查\r\n2-检验\r\n3-处置\r\n',
  PRIMARY KEY (`id`),
  KEY `medicalid` (`medicalid`),
  KEY `registid` (`registid`),
  KEY `itemid` (`itemid`),
  KEY `doctorid` (`doctorid`),
  KEY `checooperid` (`checooperid`),
  KEY `resultoperid` (`resultoperid`),
  CONSTRAINT `checkapply_ibfk_1` FOREIGN KEY (`medicalid`) REFERENCES `medicalrecord` (`id`),
  CONSTRAINT `checkapply_ibfk_2` FOREIGN KEY (`registid`) REFERENCES `register` (`id`),
  CONSTRAINT `checkapply_ibfk_3` FOREIGN KEY (`itemid`) REFERENCES `fmeditem` (`id`),
  CONSTRAINT `checkapply_ibfk_4` FOREIGN KEY (`doctorid`) REFERENCES `user` (`id`),
  CONSTRAINT `checkapply_ibfk_5` FOREIGN KEY (`checooperid`) REFERENCES `user` (`id`),
  CONSTRAINT `checkapply_ibfk_6` FOREIGN KEY (`resultoperid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkapply
-- ----------------------------

-- ----------------------------
-- Table structure for checkrelation
-- ----------------------------
DROP TABLE IF EXISTS `checkrelation`;
CREATE TABLE `checkrelation` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `checkprojid` int(9) NOT NULL COMMENT '项目ID',
  `checktempid` int(9) NOT NULL COMMENT '申请模板ID',
  `position` varchar(64) DEFAULT NULL COMMENT '检查部位',
  PRIMARY KEY (`id`),
  KEY `CheckRelation_CheckProjID` (`checkprojid`),
  KEY `CheckRelation_CheckTempID` (`checktempid`),
  CONSTRAINT `CheckRelation_CheckProjID` FOREIGN KEY (`checkprojid`) REFERENCES `fmeditem` (`id`),
  CONSTRAINT `CheckRelation_CheckTempID` FOREIGN KEY (`checktempid`) REFERENCES `checktemplate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkrelation
-- ----------------------------

-- ----------------------------
-- Table structure for checktemplate
-- ----------------------------
DROP TABLE IF EXISTS `checktemplate`;
CREATE TABLE `checktemplate` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '名称',
  `userid` int(9) NOT NULL COMMENT '医生ID',
  `creationtime` datetime NOT NULL COMMENT '创建时间',
  `scope` char(4) DEFAULT NULL COMMENT '使用范围',
  `recordtype` int(1) NOT NULL COMMENT '记录类型1-检查\r\n2-检验\r\n3-处置\r\n',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `CheckTemplate_UserID` (`userid`),
  CONSTRAINT `CheckTemplate_UserID` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checktemplate
-- ----------------------------

-- ----------------------------
-- Table structure for constantitem
-- ----------------------------
DROP TABLE IF EXISTS `constantitem`;
CREATE TABLE `constantitem` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '自增长类型',
  `constanttypeid` int(9) NOT NULL COMMENT '所属常数类别ID 指向ConstantType(ID)',
  `contantcode` varchar(64) NOT NULL COMMENT '常数项编码',
  `constantname` varchar(64) NOT NULL COMMENT '常数项名称 如男、女等',
  `delmark` int(1) NOT NULL DEFAULT '1' COMMENT '1-正常',
  PRIMARY KEY (`id`),
  KEY `ConstantItem_ConstantTypeID` (`constanttypeid`),
  CONSTRAINT `ConstantItem_ConstantTypeID` FOREIGN KEY (`constanttypeid`) REFERENCES `constanttype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of constantitem
-- ----------------------------

-- ----------------------------
-- Table structure for constanttype
-- ----------------------------
DROP TABLE IF EXISTS `constanttype`;
CREATE TABLE `constanttype` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '自增长类型',
  `constanttypecode` varchar(64) NOT NULL COMMENT '常数类别编码 如DeptType',
  `constanttypename` varchar(64) NOT NULL COMMENT '常数类别名称 如性别等',
  `delmark` int(1) NOT NULL DEFAULT '1' COMMENT '删除标记 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of constanttype
-- ----------------------------
INSERT INTO `constanttype` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '自增长类型',
  `deptcode` varchar(64) NOT NULL COMMENT '科室编码 如：SJNK',
  `deptname` varchar(64) NOT NULL COMMENT '科室名称 如：神经内科',
  `deptcategoryid` int(9) DEFAULT NULL COMMENT '科室分类指向ConstantItem(ID)',
  `depttype` int(1) DEFAULT NULL COMMENT '科室类型 1-临床2-医技3-财务4-行政5-其它',
  `delmark` int(1) NOT NULL DEFAULT '1' COMMENT '1-正常0-已删除',
  PRIMARY KEY (`id`),
  KEY `Depatment_DeptCategoryID` (`deptcategoryid`),
  CONSTRAINT `Depatment_DeptCategoryID` FOREIGN KEY (`deptcategoryid`) REFERENCES `constantitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------

-- ----------------------------
-- Table structure for disease
-- ----------------------------
DROP TABLE IF EXISTS `disease`;
CREATE TABLE `disease` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `diseasecode` varchar(64) NOT NULL COMMENT '疾病助记编码',
  `diseasename` varchar(255) NOT NULL COMMENT '疾病名称',
  `diseaseicd` varchar(64) DEFAULT NULL COMMENT '国际ICD编码',
  `disecategoryid` int(9) NOT NULL COMMENT '疾病所属分类指向 DiseCategory(ID)',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `Disease_DiseCategoryID` (`disecategoryid`),
  CONSTRAINT `Disease_DiseCategoryID` FOREIGN KEY (`disecategoryid`) REFERENCES `disecategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disease
-- ----------------------------

-- ----------------------------
-- Table structure for disecategory
-- ----------------------------
DROP TABLE IF EXISTS `disecategory`;
CREATE TABLE `disecategory` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `dicacode` varchar(64) NOT NULL COMMENT '分类编码',
  `dicaname` varchar(64) NOT NULL COMMENT '分类名称',
  `sequenceno` int(3) DEFAULT NULL COMMENT '显示顺序号',
  `dicatype` int(1) NOT NULL COMMENT '疾病类型1-西医\r\n2-中医\r\n',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of disecategory
-- ----------------------------

-- ----------------------------
-- Table structure for drugs
-- ----------------------------
DROP TABLE IF EXISTS `drugs`;
CREATE TABLE `drugs` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `drugscode` char(14) NOT NULL COMMENT '药品编码',
  `drugsname` varchar(64) NOT NULL COMMENT '药品名称',
  `drugsformat` varchar(64) DEFAULT NULL COMMENT '药品规格',
  `drugsunit` varchar(64) DEFAULT NULL COMMENT '包装单位',
  `manufactuer` varchar(512) DEFAULT NULL COMMENT '生产厂家',
  `drugsdosageid` int(9) DEFAULT NULL COMMENT '药品剂型，外键指向constantitem',
  `drugstypeid` int(9) DEFAULT NULL COMMENT '药品类型，外键指向constantitem',
  `drugsprice` decimal(8,2) NOT NULL COMMENT '药品单价',
  `mnemoniccode` varchar(64) DEFAULT NULL COMMENT '拼音助记码',
  `creationdate` datetime NOT NULL COMMENT '创建时间',
  `lastupdatdate` datetime DEFAULT NULL COMMENT '最后修改时间',
  `deimark` int(1) NOT NULL COMMENT '删除标记,1-正常,0-已删除',
  PRIMARY KEY (`id`),
  KEY `drugsdosageid` (`drugsdosageid`),
  KEY `drugs_ibfk_2` (`drugstypeid`),
  CONSTRAINT `drugs_ibfk_1` FOREIGN KEY (`drugsdosageid`) REFERENCES `constantitem` (`id`) ON DELETE SET NULL,
  CONSTRAINT `drugs_ibfk_2` FOREIGN KEY (`drugstypeid`) REFERENCES `constantitem` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugs
-- ----------------------------

-- ----------------------------
-- Table structure for drugsdetailed
-- ----------------------------
DROP TABLE IF EXISTS `drugsdetailed`;
CREATE TABLE `drugsdetailed` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `drugstempid` int(9) NOT NULL COMMENT '成药模板ID/指向DrugsTemplate (ID)',
  `drugsid` int(9) NOT NULL COMMENT '药品ID/指向Drugs (ID)',
  `drugsusage` varchar(64) DEFAULT NULL COMMENT '用法',
  `dosage` varchar(64) DEFAULT NULL COMMENT '用量',
  `frequency` varchar(64) DEFAULT NULL COMMENT '频次',
  PRIMARY KEY (`id`),
  KEY `DrugsDetailed_DrugsTempID` (`drugstempid`),
  KEY `DrugsDetailed_DrugsID` (`drugsid`),
  CONSTRAINT `DrugsDetailed_DrugsID` FOREIGN KEY (`drugsid`) REFERENCES `drugs` (`id`),
  CONSTRAINT `DrugsDetailed_DrugsTempID` FOREIGN KEY (`drugstempid`) REFERENCES `drugstemplate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugsdetailed
-- ----------------------------

-- ----------------------------
-- Table structure for drugstemplate
-- ----------------------------
DROP TABLE IF EXISTS `drugstemplate`;
CREATE TABLE `drugstemplate` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '名称',
  `userid` int(9) NOT NULL COMMENT '医生ID/指向User(ID)',
  `creationtime` datetime NOT NULL COMMENT '创建时间',
  `scope` char(2) DEFAULT NULL COMMENT '使用范围/全院/科室/个人',
  `demark` int(1) NOT NULL DEFAULT '1' COMMENT '删除标记/1-正常\r\n/0-已删除\r\n',
  PRIMARY KEY (`id`),
  KEY `DrugsTemplate_UserID` (`userid`),
  CONSTRAINT `DrugsTemplate_UserID` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drugstemplate
-- ----------------------------

-- ----------------------------
-- Table structure for expenseclass
-- ----------------------------
DROP TABLE IF EXISTS `expenseclass`;
CREATE TABLE `expenseclass` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `expcode` varchar(64) NOT NULL COMMENT '费用科目编码',
  `expname` varchar(64) NOT NULL COMMENT '费用科目名称',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expenseclass
-- ----------------------------

-- ----------------------------
-- Table structure for fmeditem
-- ----------------------------
DROP TABLE IF EXISTS `fmeditem`;
CREATE TABLE `fmeditem` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `itemcode` varchar(64) NOT NULL COMMENT '项目编码',
  `itemname` varchar(64) NOT NULL COMMENT '项目名称',
  `format` varchar(64) DEFAULT NULL COMMENT '规格',
  `price` decimal(8,2) NOT NULL COMMENT '单价',
  `expclassid` int(9) DEFAULT NULL COMMENT '所属费用科目ID',
  `deptid` int(9) DEFAULT NULL COMMENT '执行科室ID',
  `mnemoniccode` varchar(64) DEFAULT NULL COMMENT '拼音助记码',
  `creationdate` datetime NOT NULL COMMENT '创建时间',
  `lastupdatedate` datetime DEFAULT NULL COMMENT '最后修改时间',
  `recordtype` int(1) NOT NULL COMMENT '项目类型 1-检查 2-检验 3-处置',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `FmedItem_ExpClassID` (`expclassid`),
  KEY `FmedItem_DeptID` (`deptid`),
  CONSTRAINT `FmedItem_DeptID` FOREIGN KEY (`deptid`) REFERENCES `department` (`id`),
  CONSTRAINT `FmedItem_ExpClassID` FOREIGN KEY (`expclassid`) REFERENCES `expenseclass` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fmeditem
-- ----------------------------

-- ----------------------------
-- Table structure for herbaldetailed
-- ----------------------------
DROP TABLE IF EXISTS `herbaldetailed`;
CREATE TABLE `herbaldetailed` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `herbalpresid` int(9) NOT NULL COMMENT '草药模板ID/指向HerbalPrescription (ID)',
  `herbalid` int(9) NOT NULL COMMENT '药品ID/指向Drugs(ID)',
  `dosage` varchar(64) DEFAULT NULL COMMENT '用量',
  `unit` varchar(64) DEFAULT NULL COMMENT '药品单位',
  `footnote` varchar(64) DEFAULT NULL COMMENT '脚注',
  PRIMARY KEY (`id`),
  KEY `herbalpresid` (`herbalpresid`),
  KEY `herbalid` (`herbalid`),
  CONSTRAINT `herbaldetailed_ibfk_1` FOREIGN KEY (`herbalpresid`) REFERENCES `herbalprescription` (`id`),
  CONSTRAINT `herbaldetailed_ibfk_2` FOREIGN KEY (`herbalid`) REFERENCES `drugs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of herbaldetailed
-- ----------------------------

-- ----------------------------
-- Table structure for herbalprescription
-- ----------------------------
DROP TABLE IF EXISTS `herbalprescription`;
CREATE TABLE `herbalprescription` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `medicalid` int(9) NOT NULL COMMENT '病历ID/指向MedicalRecord (ID)',
  `registid` int(9) NOT NULL COMMENT '挂号ID/指向Register(ID)',
  `docotrid` int(9) NOT NULL COMMENT '开立医生ID/指向User(ID)',
  `prescriptname` varchar(64) NOT NULL COMMENT '处方名称',
  `creationtime` datetime NOT NULL COMMENT '开立时间',
  `prescriptiotype` varchar(64) DEFAULT NULL COMMENT '处方类型/水煎煮/酒泡/打粉/制丸/装胶囊等',
  `paynumber` int(3) DEFAULT NULL COMMENT '付数',
  `frequency` varchar(64) DEFAULT NULL COMMENT '频次',
  `drugsusage` varchar(64) DEFAULT NULL COMMENT '用法/内服/外用',
  `therapy` varchar(512) DEFAULT NULL COMMENT '治法',
  `detailed` varchar(512) DEFAULT NULL COMMENT '治法详细',
  `advice` varchar(512) DEFAULT NULL COMMENT '医嘱',
  `state` int(1) DEFAULT NULL COMMENT '状态/1-暂存/\r\n2-已开立\r\n/3-已交费/\r\n4-已取药/\r\n5-已退药/\r\n6-已退费\r\n/0-已作废\r\n',
  PRIMARY KEY (`id`),
  KEY `HerbalPrescription_MedicalID` (`medicalid`),
  KEY `HerbalPrescription_DoctorID` (`docotrid`),
  KEY `HerbalPrescriptionRegistID` (`registid`),
  CONSTRAINT `HerbalPrescriptionRegistID` FOREIGN KEY (`registid`) REFERENCES `register` (`id`),
  CONSTRAINT `HerbalPrescription_DoctorID` FOREIGN KEY (`docotrid`) REFERENCES `user` (`id`),
  CONSTRAINT `HerbalPrescription_MedicalID` FOREIGN KEY (`medicalid`) REFERENCES `medicalrecord` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of herbalprescription
-- ----------------------------

-- ----------------------------
-- Table structure for herbaltempdetailed
-- ----------------------------
DROP TABLE IF EXISTS `herbaltempdetailed`;
CREATE TABLE `herbaltempdetailed` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `herbaltempid` int(9) NOT NULL COMMENT '草药模板ID/指向HerbalTemplate (ID)',
  `herbalid` int(9) NOT NULL COMMENT '药品ID/指向Drugs(ID)',
  `dosage` varchar(64) DEFAULT NULL COMMENT '用量',
  `unit` varchar(64) DEFAULT NULL COMMENT '药品单位',
  `Footnote` varbinary(64) DEFAULT NULL COMMENT '脚注',
  PRIMARY KEY (`id`),
  KEY `herbaltempid` (`herbaltempid`),
  KEY `herbalid` (`herbalid`),
  CONSTRAINT `herbaltempdetailed_ibfk_1` FOREIGN KEY (`herbaltempid`) REFERENCES `herbaltemplate` (`id`),
  CONSTRAINT `herbaltempdetailed_ibfk_2` FOREIGN KEY (`herbalid`) REFERENCES `drugs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of herbaltempdetailed
-- ----------------------------

-- ----------------------------
-- Table structure for herbaltemplate
-- ----------------------------
DROP TABLE IF EXISTS `herbaltemplate`;
CREATE TABLE `herbaltemplate` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '名称',
  `doctorid` int(9) NOT NULL COMMENT '医生ID/指向User(ID)',
  `creationtime` datetime NOT NULL COMMENT '创建时间',
  `prescriptiotype` varchar(64) DEFAULT NULL COMMENT '处方类型/水煎煮/酒泡/打粉/制丸/装胶囊等',
  `paynumber` int(3) DEFAULT NULL COMMENT '付数',
  `drugsusage` varchar(64) DEFAULT NULL COMMENT '用法',
  `therapy` varchar(512) DEFAULT NULL COMMENT '治法',
  `detailed` varchar(512) DEFAULT NULL COMMENT '治法详细',
  `advice` varchar(512) DEFAULT NULL COMMENT '医嘱',
  `scope` varchar(64) DEFAULT NULL COMMENT '使用范围/全院/科室/个人',
  `delmark` int(1) NOT NULL COMMENT '删除标记/1-正常 0-已删除',
  PRIMARY KEY (`id`),
  KEY `doctorid` (`doctorid`),
  CONSTRAINT `herbaltemplate_ibfk_1` FOREIGN KEY (`doctorid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of herbaltemplate
-- ----------------------------

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `invoicenum` varchar(64) NOT NULL COMMENT '发票号码',
  `money` decimal(8,2) NOT NULL COMMENT '发票金额',
  `state` int(1) NOT NULL COMMENT '发票状态/1-正常/2-作废/3-未打印/4-已打印/5-已重打/6-已补打/7-冲红',
  `creationtime` datetime NOT NULL COMMENT '收/退费',
  `userid` int(9) NOT NULL COMMENT '收/退费人员ID/指向User(ID)',
  `registid` int(9) DEFAULT NULL COMMENT '挂号ID/Register(ID)',
  `feetype` int(9) NOT NULL COMMENT '收费方式/指向ConstantItem(ID)',
  `back` varchar(64) DEFAULT NULL COMMENT '冲红发票号码',
  `dailystate` int(1) NOT NULL COMMENT '日结审核状态/0-未日结/1-已提交/2-已审核',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `registid` (`registid`),
  KEY `feetype` (`feetype`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`registid`) REFERENCES `register` (`id`),
  CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`feetype`) REFERENCES `constantitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoice
-- ----------------------------

-- ----------------------------
-- Table structure for medicaldisease
-- ----------------------------
DROP TABLE IF EXISTS `medicaldisease`;
CREATE TABLE `medicaldisease` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `medicalid` int(9) NOT NULL COMMENT '病历ID',
  `registid` int(9) NOT NULL COMMENT '挂号ID',
  `diseaseid` int(9) NOT NULL COMMENT '疾病ID',
  `diagnosetype` int(1) DEFAULT NULL COMMENT '诊断类型',
  `getsiskdate` datetime DEFAULT NULL COMMENT '发病日期',
  `diagnosecate` int(1) DEFAULT NULL COMMENT '诊断种类',
  PRIMARY KEY (`id`),
  KEY `medicalid` (`medicalid`),
  KEY `registid` (`registid`),
  KEY `diseaseid` (`diseaseid`),
  CONSTRAINT `medicaldisease_ibfk_1` FOREIGN KEY (`medicalid`) REFERENCES `medicalrecord` (`id`),
  CONSTRAINT `medicaldisease_ibfk_2` FOREIGN KEY (`registid`) REFERENCES `register` (`id`),
  CONSTRAINT `medicaldisease_ibfk_3` FOREIGN KEY (`diseaseid`) REFERENCES `disease` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicaldisease
-- ----------------------------

-- ----------------------------
-- Table structure for medicalrecord
-- ----------------------------
DROP TABLE IF EXISTS `medicalrecord`;
CREATE TABLE `medicalrecord` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `casenumber` varchar(64) NOT NULL COMMENT '病历号',
  `registid` int(9) NOT NULL COMMENT '挂号ID',
  `readme` varchar(512) DEFAULT NULL COMMENT '主诉',
  `present` varchar(512) DEFAULT NULL COMMENT '现病史',
  `presenttreat` varchar(512) DEFAULT NULL COMMENT '现病治疗情况',
  `history` varchar(512) DEFAULT NULL COMMENT '既往史',
  `allergy` varchar(512) DEFAULT NULL COMMENT '过敏史',
  `physique` varchar(512) DEFAULT NULL COMMENT '体格检查',
  `proposal` varchar(512) DEFAULT NULL COMMENT '检查建议',
  `careful` varchar(512) DEFAULT NULL COMMENT '注意事项',
  `checkresult` varchar(512) DEFAULT NULL COMMENT '检查结果',
  `diagnosis` varchar(512) DEFAULT NULL COMMENT '诊断结果',
  `handling` varchar(512) DEFAULT NULL COMMENT '处理意见',
  `casestate` int(1) DEFAULT NULL COMMENT '病历状态 1-暂存 2-已提交 3-诊毕',
  PRIMARY KEY (`id`),
  KEY `registid` (`registid`),
  CONSTRAINT `medicalrecord_ibfk_1` FOREIGN KEY (`registid`) REFERENCES `register` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicalrecord
-- ----------------------------

-- ----------------------------
-- Table structure for patiencosts
-- ----------------------------
DROP TABLE IF EXISTS `patiencosts`;
CREATE TABLE `patiencosts` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `registid` int(9) NOT NULL COMMENT '挂号ID/指向Register (ID)',
  `invoiceid` int(9) NOT NULL COMMENT '发票ID/指向invoice(ID)',
  `itemid` int(9) NOT NULL COMMENT '项目ID',
  `itemtype` int(1) NOT NULL COMMENT '项目类型/1-非药品/2-药品',
  `name` varchar(64) NOT NULL COMMENT '项目名称',
  `price` decimal(8,2) NOT NULL COMMENT '项目单价',
  `amount` decimal(8,2) NOT NULL COMMENT '数量',
  `deptid` int(9) NOT NULL COMMENT '执行科室ID/指向Department(ID)',
  `createtime` datetime NOT NULL COMMENT '开立时间',
  `createoperid` int(9) NOT NULL COMMENT '开立人员ID/指向User(ID)',
  `paytime` datetime NOT NULL COMMENT '收/退费时间',
  `registerid` int(9) NOT NULL COMMENT '收/退费人员ID/指向User(ID)',
  `feetype` int(9) NOT NULL COMMENT '收费方式/指向ConstantItem(ID)',
  `backid` int(9) DEFAULT NULL COMMENT '退费对应记录ID',
  PRIMARY KEY (`id`),
  KEY `registid` (`registid`),
  KEY `deptid` (`deptid`),
  KEY `createoperid` (`createoperid`),
  KEY `feetype` (`feetype`),
  KEY `invoiceid` (`invoiceid`),
  KEY `registerid` (`registerid`),
  CONSTRAINT `patiencosts_ibfk_1` FOREIGN KEY (`registid`) REFERENCES `register` (`id`),
  CONSTRAINT `patiencosts_ibfk_2` FOREIGN KEY (`deptid`) REFERENCES `department` (`id`),
  CONSTRAINT `patiencosts_ibfk_3` FOREIGN KEY (`createoperid`) REFERENCES `user` (`id`),
  CONSTRAINT `patiencosts_ibfk_4` FOREIGN KEY (`feetype`) REFERENCES `constantitem` (`id`),
  CONSTRAINT `patiencosts_ibfk_5` FOREIGN KEY (`invoiceid`) REFERENCES `invoice` (`id`),
  CONSTRAINT `patiencosts_ibfk_6` FOREIGN KEY (`registerid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patiencosts
-- ----------------------------

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `medicalid` int(9) NOT NULL COMMENT '病历ID/指向MedicalRecord (ID)',
  `registid` int(9) NOT NULL COMMENT '挂号ID/指向Register(ID)',
  `userid` int(9) NOT NULL COMMENT '开立医生ID/指向User(ID)',
  `prescriptionname` varchar(64) NOT NULL COMMENT '处方名称',
  `prescriptiontime` datetime NOT NULL COMMENT '开立时间',
  `prescriptionstate` int(1) NOT NULL COMMENT '处方状态1-暂存\r\n2-已开立\r\n0-已作废\r\n',
  PRIMARY KEY (`id`),
  KEY `Prescription_MedicalID` (`medicalid`),
  KEY `Prescription_UserID` (`userid`),
  KEY `registid` (`registid`),
  CONSTRAINT `Prescription_MedicalID` FOREIGN KEY (`medicalid`) REFERENCES `medicalrecord` (`id`),
  CONSTRAINT `Prescription_UserID` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`registid`) REFERENCES `register` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for prescriptiondetailed
-- ----------------------------
DROP TABLE IF EXISTS `prescriptiondetailed`;
CREATE TABLE `prescriptiondetailed` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `prescriptionid` int(9) NOT NULL COMMENT '成药处方ID',
  `drugsid` int(9) NOT NULL COMMENT '药品ID',
  `drugsusage` varchar(64) DEFAULT NULL COMMENT '用法',
  `dosage` varchar(64) DEFAULT NULL COMMENT '用量',
  `frequency` varchar(64) DEFAULT NULL COMMENT '频次',
  `amount` decimal(8,2) unsigned zerofill NOT NULL COMMENT 'Amount',
  `State` int(1) DEFAULT NULL COMMENT 'State2-已开立\r\n3-已交费\r\n4-已发药\r\n5-已退药\r\n6-已退费\r\n',
  PRIMARY KEY (`id`),
  KEY `PrescriptionDetailed_PrescriptionID` (`prescriptionid`),
  KEY `PrescriptionDetailed_DrugsID` (`drugsid`),
  CONSTRAINT `PrescriptionDetailed_DrugsID` FOREIGN KEY (`drugsid`) REFERENCES `drugs` (`id`),
  CONSTRAINT `PrescriptionDetailed_PrescriptionID` FOREIGN KEY (`prescriptionid`) REFERENCES `prescription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescriptiondetailed
-- ----------------------------

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '本次看诊状态,1-已挂号\r\n2-医生接诊\r\n3-看诊结束\r\n4-已退号',
  `casenumber` varchar(64) NOT NULL COMMENT '病历号',
  `realname` varchar(64) NOT NULL COMMENT '姓名',
  `gender` int(9) NOT NULL COMMENT '性别,指向ConstatntItem（ID）',
  `idnumber` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `agetype` char(1) DEFAULT NULL COMMENT '年龄类型,岁/月/天',
  `homeaddress` varchar(64) DEFAULT NULL COMMENT '家庭住址',
  `visitdate` date NOT NULL COMMENT '本次看诊日期',
  `noon` char(2) NOT NULL COMMENT '午别',
  `deptid` int(9) NOT NULL COMMENT '本次挂号科室ID,外键,指向Department(ID)',
  `userid` int(9) NOT NULL COMMENT '本次挂号医生ID,外键,指向User(ID)',
  `registLeid` int(9) NOT NULL COMMENT '本次挂号级别ID,外键,指向RegistLevel (ID)',
  `settleid` int(9) NOT NULL COMMENT '结算类别ID,外键,指向SettleCategory(ID)',
  `isbook` char(1) DEFAULT NULL COMMENT '病历本要否,是/否',
  `registtime` datetime NOT NULL COMMENT '挂号时间',
  `registerid` int(9) NOT NULL COMMENT '挂号员ID,外键,指向User(ID)',
  `visitstate` int(1) NOT NULL COMMENT '本次看诊状态,1-已挂号\r\n2-医生接诊\r\n3-看诊结束\r\n4-已退号',
  PRIMARY KEY (`id`),
  KEY `gender` (`gender`),
  KEY `deptid` (`deptid`),
  KEY `userid` (`userid`),
  KEY `registerid` (`registerid`),
  KEY `settleid` (`settleid`),
  KEY `registLeid` (`registLeid`),
  CONSTRAINT `register_ibfk_1` FOREIGN KEY (`gender`) REFERENCES `constantitem` (`id`),
  CONSTRAINT `register_ibfk_2` FOREIGN KEY (`deptid`) REFERENCES `department` (`id`),
  CONSTRAINT `register_ibfk_3` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `register_ibfk_4` FOREIGN KEY (`registerid`) REFERENCES `registlevel` (`id`),
  CONSTRAINT `register_ibfk_5` FOREIGN KEY (`settleid`) REFERENCES `user` (`id`),
  CONSTRAINT `register_ibfk_6` FOREIGN KEY (`registLeid`) REFERENCES `registlevel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of register
-- ----------------------------

-- ----------------------------
-- Table structure for registlevel
-- ----------------------------
DROP TABLE IF EXISTS `registlevel`;
CREATE TABLE `registlevel` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '自增长类型',
  `registcode` varchar(64) NOT NULL COMMENT '号别编码',
  `registname` varchar(64) NOT NULL COMMENT '号别名称',
  `sequenceno` int(3) DEFAULT NULL COMMENT '显示顺序号',
  `registfee` decimal(8,2) DEFAULT NULL COMMENT '挂号费',
  `registquota` int(3) DEFAULT NULL COMMENT '挂号限额',
  `delmark` int(1) NOT NULL DEFAULT '1' COMMENT '1-正常0-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registlevel
-- ----------------------------

-- ----------------------------
-- Table structure for registwork
-- ----------------------------
DROP TABLE IF EXISTS `registwork`;
CREATE TABLE `registwork` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `registerid` int(9) NOT NULL COMMENT '收费人员ID/指向User(ID)',
  `starttime` datetime NOT NULL COMMENT '日结起始时间',
  `endtime` datetime NOT NULL COMMENT '日结结束时间',
  PRIMARY KEY (`id`),
  KEY `registerid` (`registerid`),
  CONSTRAINT `registwork_ibfk_1` FOREIGN KEY (`registerid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registwork
-- ----------------------------

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `rulename` varchar(64) NOT NULL COMMENT '规则名称',
  `deptid` int(9) NOT NULL COMMENT '科室ID 指向Department(ID)',
  `userid` int(9) NOT NULL COMMENT '医生ID 指向User(ID)',
  `week` varchar(14) NOT NULL COMMENT '星期,14位1和0 组成的字符串，1代表有班 0代表无班 14位字符串从左到右依次表示表示星期1-星期日，每天两位表示上下午',
  `delmark` int(1) NOT NULL COMMENT '删除标记,1-正常0-已删除',
  PRIMARY KEY (`id`),
  KEY `deptid` (`deptid`),
  KEY `userid` (`userid`),
  CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`deptid`) REFERENCES `department` (`id`),
  CONSTRAINT `rule_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rule
-- ----------------------------

-- ----------------------------
-- Table structure for scheduling
-- ----------------------------
DROP TABLE IF EXISTS `scheduling`;
CREATE TABLE `scheduling` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `scheddate` date NOT NULL COMMENT '排班日期',
  `deptId` int(9) NOT NULL COMMENT '科室ID,指向Department(ID)',
  `userId` int(9) NOT NULL COMMENT '医生ID,指向User(ID)',
  `noon` varchar(255) NOT NULL COMMENT '午别,上午/下午',
  `ruleId` int(2) NOT NULL COMMENT '排班规则ID,指向Rule (ID)',
  PRIMARY KEY (`id`),
  KEY `deptId` (`deptId`),
  KEY `userId` (`userId`),
  KEY `ruleId` (`ruleId`),
  CONSTRAINT `scheduling_ibfk_1` FOREIGN KEY (`deptId`) REFERENCES `department` (`id`),
  CONSTRAINT `scheduling_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `scheduling_ibfk_3` FOREIGN KEY (`ruleId`) REFERENCES `rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheduling
-- ----------------------------

-- ----------------------------
-- Table structure for settlecategory
-- ----------------------------
DROP TABLE IF EXISTS `settlecategory`;
CREATE TABLE `settlecategory` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `settlecode` varchar(64) NOT NULL COMMENT '类别编码',
  `settlename` varchar(64) NOT NULL COMMENT '类别名称',
  `sequenceno` int(3) DEFAULT NULL COMMENT '显示顺序号',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of settlecategory
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '自增长类型',
  `username` varchar(64) NOT NULL COMMENT '登录名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `realname` varchar(64) NOT NULL COMMENT '真实姓名',
  `usertype` int(1) DEFAULT NULL COMMENT '用户类别\r\n1-医院管理员\r\n2-挂号收费员\r\n3-门诊医生\r\n4-医技医生\r\n5-药房操作员\r\n6-财务管理员\r\n',
  `doctitleid` int(9) DEFAULT NULL COMMENT '医生职称ID\r\n指向ConstatntItem（ID）',
  `isscheduling` char(1) DEFAULT NULL COMMENT '是否参与排班 是/否',
  `deptid` int(9) DEFAULT NULL COMMENT '所在科室ID\r\n指向Department(ID)',
  `registleid` int(9) DEFAULT NULL COMMENT '挂号级别ID\r\n指向RegistLevel (ID)',
  `delmark` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `User_DocTitleID` (`doctitleid`),
  KEY `User_DeptID` (`deptid`),
  KEY `User_RegisteLevelID` (`registleid`),
  CONSTRAINT `User_DeptID` FOREIGN KEY (`deptid`) REFERENCES `department` (`id`),
  CONSTRAINT `User_DocTitleID` FOREIGN KEY (`doctitleid`) REFERENCES `constantitem` (`id`),
  CONSTRAINT `User_RegisteLevelID` FOREIGN KEY (`registleid`) REFERENCES `registlevel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
