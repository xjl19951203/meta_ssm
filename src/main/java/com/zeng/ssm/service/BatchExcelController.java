package com.zeng.ssm.service;

import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.SystemColumnData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/batch/excel")
public class BatchExcelController {
    @Resource
    SceneDataDao sceneDataDao;
    @Resource
    InputFrameDataDao inputFrameDataDao;
    @Resource
    MaterialDataDao materialDataDao;
    @Resource
    EnergyDataDao energyDataDao;
    @Resource
    DeviceDataDao deviceDataDao;
    @Resource
    KeyParameterDataDao keyParameterDataDao;
    @Resource
    FunctionUnitDataDao functionUnitDataDao;
    @Resource
    OutputFrameDataDao outputFrameDataDao;
    @Resource
    EnvLoadDataDao envLoadDataDao;
    @Resource
    OutputPartDataDao outputPartDataDao;
    @Resource
    MaterialDao materialDao;
    @Resource
    EnergyDao energyDao;
    @Resource
    DeviceDao deviceDao;
    @Resource
    EnvLoadDao envLoadDao;
    @Resource
    SystemTableDataDao systemTableDataDao;
    @Resource
    SystemColumnDataDao systemColumnDataDao;

//    @RequestMapping(value="/{tableName}", method = RequestMethod.GET)
//    public void getMatrialExcel (@PathVariable String tableName, HttpServletResponse response) throws Exception {
//
////        List<String> list = BatchAssist.getRemarksFromBaseTable(tableName);
//       
////        创建Excel对象
//        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
////        创建Excel中的sheet对象
//        SXSSFSheet sxssfSheet1 = sxssfWorkbook.createSheet( tableName+"表");
////        设置sheet中的默认列宽
////        sxssfSheet1.setDefaultColumnWidth(15);
////        创建sheet中的第一行
//        SXSSFRow row = sxssfSheet1.createRow(0);
//        List<String> list = systemTableDataDao.selectColumnsByTableName(tableName);
//        int i=0; //单元格计数器
////        for(Field f:fs){
////            //f为单个属性
//////           设置不可见的属性为可见的
////            f.setAccessible(true);
//////           创建单元格
////            Cell cell = row.createCell(i++);
//////            将属性名放到上面创建的单元格中
////            cell.setCellValue(f.getName());//获取属性名
////        }
//        ServletOutputStream out;
//        try {
//            //构造输出流
//            out = response.getOutputStream();
//            //构建文件名
//            String fileName = tableName+".xlsx";
//            response.reset();
//            response.setContentType("application/msexcel");
//            response.setHeader("Content-disposition", "attachment; filename="+fileName);
//            sxssfWorkbook.write(out);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

    @RequestMapping(value="/base/{tableName}", method = RequestMethod.GET)
    public void postBaseTablelExcel (@PathVariable String tableName, HttpServletResponse response) throws Exception {

//        List<String> list = systemTableDataDao.selectColumnsByTableName(tableName);
        List<SystemColumnData> list = systemColumnDataDao.selectListByTableName(tableName);
        if (tableName.equals("material")) {
           tableName = "基础物料表";
       }else if (tableName.equals("energy")) {
           tableName = "基础能源表";
        }else if (tableName.equals("device")) {
           tableName = "基础设备表";
        }else if (tableName.equals("envLoad")) {
           tableName = "基础环境负荷表";
        }else {
           return ;
       }
//        创建Excel对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
//        创建Excel中的sheet对象
        SXSSFSheet sxssfSheet1 = sxssfWorkbook.createSheet(tableName);
//        创建sheet中的第一行
        SXSSFRow row = sxssfSheet1.createRow(0);
//        设置sheet中的默认列宽
        sxssfSheet1.setDefaultColumnWidth(25);
        CellStyle style = sxssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        int i=0; //单元格计数器
        for(SystemColumnData systemColumnData:list){
//           创建单元格
            Cell cell = row.createCell(i++);
//           设置单元格格式
            cell.setCellStyle(style);
//            将属性名放到上面创建的单元格中
            cell.setCellValue(systemColumnData.getColumnComment());//获取属性名
            if (systemColumnData.getColumnKey()=="MUL") {
                String sheetName = systemColumnData.getColumnName();
                SXSSFSheet sxssfSheet2 = sxssfWorkbook.createSheet(tableName);
            }
//            System.out.println(str);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            //构建文件名
            String fileName = tableName+".xlsx";
            fileName= URLEncoder.encode(fileName);
            System.out.println(fileName);
            //构造输出流
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/msexcel;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment; filename="+fileName);
            sxssfWorkbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/{tableName}", method = RequestMethod.GET)
    public void postOtherExcel (@PathVariable String tableName, HttpServletResponse response) throws Exception {

        List<String> list = systemTableDataDao.selectColumnsByTableName(tableName);
//        创建Excel对象
//        创建Excel对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
//        创建Excel中的sheet对象
        SXSSFSheet sxssfSheet1 = sxssfWorkbook.createSheet(tableName);
//        创建sheet中的第一行
        SXSSFRow row = sxssfSheet1.createRow(0);
//        设置sheet中的默认列宽
        sxssfSheet1.setDefaultColumnWidth(25);
        CellStyle style = sxssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        int i=0; //单元格计数器
        for(String str:list){
//           创建单元格
            Cell cell = row.createCell(i++);
//           设置单元格格式
            cell.setCellStyle(style);
//            将属性名放到上面创建的单元格中
            cell.setCellValue(str);//获取属性名
//            System.out.println(str);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            //构建文件名
            String fileName = tableName+".xlsx";
            fileName= URLEncoder.encode(fileName);
            System.out.println(fileName);
            //构造输出流
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/msexcel;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment; filename="+fileName);
            sxssfWorkbook.write(out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
