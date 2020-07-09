package com.zeng.ssm.service;

import com.zeng.ssm.common.AbstractModel;
import com.zeng.ssm.common.ModelDao;
import com.zeng.ssm.common.ModelHandler;
import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.SystemColumnData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.*;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/batch/excel")
public class BatchExcelController {

    @Resource
    ModelDao modelDao;
    @Resource
    SystemColumnDataDao systemColumnDataDao;

    @RequestMapping(value="/baseExcel/{tableName}", method = RequestMethod.GET)
    public void getBaseTablelExcel (@PathVariable String tableName, HttpServletResponse response) throws Exception {

        tableName = camel2under(tableName);
        List<SystemColumnData> list = systemColumnDataDao.selectListByTableName(tableName);
        if (tableName.equals("material")) {
           tableName = "基础物料表";
            System.out.println(tableName);
       }else if (tableName.equals("energy")) {
           tableName = "基础能源表";
        }else if (tableName.equals("device")) {
           tableName = "基础设备表";
        }else if (tableName.equals("env_load")) {
           tableName = "基础环境负荷表";
        }else {
           return ;
       }
//        创建Excel对象
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
//        创建一个居中格式
        CellStyle style = sxssfWorkbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
//        创建Excel中的sheet对象
        SXSSFSheet sxssfSheet1 = sxssfWorkbook.createSheet(tableName);
//        创建sheet中的第一行
        SXSSFRow row = sxssfSheet1.createRow(0);
//        设置sheet中的默认列宽
        sxssfSheet1.setDefaultColumnWidth(30);
        int i=0; //单元格计数器
        for(SystemColumnData systemColumnData:list){
//           创建单元格
            Cell cell = row.createCell(i++);
//           设置单元格格式
            cell.setCellStyle(style);
            //如果字段是外键关联，则将其对应的表单独创建一个sheet，以供使用者选择
            if (systemColumnData.getColumnKey().equals("MUL")) {
                createSheet(sxssfWorkbook,systemColumnData,style);
//            将属性名放到上面创建的单元格中
                cell.setCellValue(systemColumnData.getColumnComment()+'\n'+"(请按照sheet中的说明填写编号)");
            }else {
//            将属性名放到上面创建的单元格中
                cell.setCellValue(systemColumnData.getColumnComment());//获取属性名
            }

        }
        try {
            response.setCharacterEncoding("UTF-8");
            //构建文件名
            String fileName = tableName+".xlsx";
            fileName= URLEncoder.encode(fileName,"UTF-8");
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

    public void createSheet (SXSSFWorkbook sxssfWorkbook,SystemColumnData systemColumnData,CellStyle cellStyle) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        获取数据库中表的英文名称（转换成下划线分割的形式）
        String tableName = systemColumnData.getColumnName().substring(0,systemColumnData.getColumnName().length()-2);
        tableName = camel2under(tableName);
//        获取表的中文名称
        String chineseTableName = systemColumnData.getColumnComment();
//        根据表名获取表的列字段
        List<SystemColumnData> list = systemColumnDataDao.selectListByTableName(tableName);
//        给sheet命名为中文
        SXSSFSheet sxssfSheet = sxssfWorkbook.createSheet(chineseTableName);
//        设置sheet中的默认列宽
        sxssfSheet.setDefaultColumnWidth(30);
        SXSSFRow row = sxssfSheet.createRow(0);
        int j=0;
        for (SystemColumnData temp :list) {
            Cell cell = row.createCell(j++);
//           设置单元格格式
            cell.setCellStyle(cellStyle);
            //如果字段是外键关联，则将其对应的表单独创建一个sheet，以供使用者选择
            if (temp.getColumnKey().equals("MUL")) {
                createSheet(sxssfWorkbook, temp, cellStyle);
//            将属性名放到上面创建的单元格中
                cell.setCellValue(temp.getColumnComment()+'\n'+"(请按照sheet查看对应编号的含义)");
            }else {
//            将属性名放到上面创建的单元格中
                cell.setCellValue(temp.getColumnComment());
            }
        }
//        根据外键字段找到对应的表然后拿到表中的数据
        List<AbstractModel> list0 = ModelHandler.getModelDaoInstance(systemColumnData.getColumnName().substring(0,systemColumnData.getColumnName().length()-2)).selectAll();
//        定义sheet的中每一行的编号
        int i=1;
//        对表中的每一组数据，进行创建一行Excel数据操作
        for (AbstractModel abstractModel:list0) {
//            创建sheet中的一行
            SXSSFRow row0 = sxssfSheet.createRow(i);
            row0.createCell(0).setCellValue(i);
//            获得一行记录中的所有字段的值，放到hashmap里面
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            Field[] declaredFields = abstractModel.getClass().getDeclaredFields();
//            System.out.println(declaredFields.length);
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(abstractModel)!=null?field.get(abstractModel).toString():null);
            }
//            定义每个cell的编号，便于为每个字段一个萝卜一个坑
            int k=1;
//            遍历linkedhashmap将数据填到对应的单元格中去
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String,String> entry = (Map.Entry) iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                Cell cell = row0.createCell(k);
//                设置单元格格式
                cell.setCellStyle(cellStyle);
                if (key.equals(list.get(k).getColumnName())) {
                    cell.setCellValue(value);
                }
                k++;
            }
            i++;
        }
    }

    /*
     * 功能：驼峰命名转下划线命名
     * 小写和大写紧挨一起的地方,加上分隔符,然后全部转小写
     */
    public static String camel2under(String c)
    {
        String separator = "_";
        c = c.replaceAll("([a-z])([A-Z])", "$1"+separator+"$2").toLowerCase();
        return c;
    }
    @RequestMapping(value="/sceneDataExcel", method = RequestMethod.GET)
    public void getSceneDataExcel (HttpServletResponse response) throws Exception {
        //定义Excel表名
        String tableName = "工艺场景表";
        //创建Excel文件
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook();
        //创建单元格格式
        CellStyle style = sxssfWorkbook.createCellStyle();
        //设置单元格居中
        style.setAlignment(HorizontalAlignment.CENTER);
//        创建Excel中的sheet对象
        SXSSFSheet sxssfSheet1 = sxssfWorkbook.createSheet(tableName);
//        创建sheet中的第一行
        SXSSFRow row = sxssfSheet1.createRow(0);
//        设置sheet中的默认列宽
        sxssfSheet1.setDefaultColumnWidth(30);
    }

    @RequestMapping(value="/baseTable", method = RequestMethod.POST)
    public List<AbstractModel> postBaseTablelExcel (@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {

        if (file==null) {
            return null;//未收到文件
        }
        String fileName = file.getOriginalFilename();
        String tableName = "";
        String className = "";
        if(!fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")){
            return null;
        }
        System.out.println(fileName);
        if (fileName.contains("基础物料")) {
            tableName = "material";
            className = "Material";
        }else if(fileName.contains("基础能源")) {
            tableName = "energy";
            className = "Energy";
        }else if(fileName.contains("基础设备")) {
            tableName = "device";
            className = "Device";
        }else if(fileName.contains("基础环境负荷")) {
            tableName = "env_load";
            className = "EnvLoad";
        }else {
            return null;
        }
//        根据表名字将表中所含的字段信息获取到
        List<SystemColumnData> columnDataList = systemColumnDataDao.selectListByTableName(tableName);
        //获取输入流
        InputStream inputStream = file.getInputStream();
        //创建读取工作簿
        Workbook workbook = WorkbookFactory.create(inputStream);
        //获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取总行
        int rows=sheet.getPhysicalNumberOfRows();
//        获取sheet的第一行的表头
        Row row0 = sheet.getRow(0);
//        定义存放sheet中2-n行的数据的list
        List<AbstractModel> list = new ArrayList<>();
//        如果sheet中有数据，则开始处理
        if(rows>2) {
            //获取单元格
            for (int i = 1; i < rows; i++) {
//                获取当前行的数据
                Row row = sheet.getRow(i);
//                根据反射获取当前数据代表的model类
                Class<AbstractModel> cc = (Class<AbstractModel>) Class.forName("com.zeng.ssm.model."+className);
//                根据类生成一个类的实例
                AbstractModel model = cc.newInstance();
//                Method[] methods = cc.getMethods();
//                j是每一行的列编号，编号从一开始应为model中并没有定义id这个属性，但是数据表中有这个字段
                int j=1;
//                定义属性名称，以便后面构建方法
                String fieldName="";
//                定义参数类型，以便构建方法的参数
                String paraType="java.lang.String";
//                System.out.println(row.getLastCellNum());
//                对每一列数据进行处理
                while (j<row0.getLastCellNum()) {
                    /*确保某个单元格的数据与字段信息能够对应上*/
                    String tempField = row0.getCell(j).getStringCellValue();
                    if (tempField.contains("(")) {
                        int a = tempField.indexOf("(");
                        tempField = tempField.substring(0,a-1);
                    }
                    for (SystemColumnData systemColumnData:columnDataList) {
                        if (systemColumnData.getColumnComment().equals(tempField)) {
                            fieldName = systemColumnData.getColumnName();
                            paraType = systemColumnData.getDataType();
                            break;
                        }
                    }
//                    根据属性名称构建方法名称,这里主要是set方法
                    String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
//                    将获取的数据库字段类型,将其转换成相应的Java数据类型
                    if(paraType.equals("varchar")) {
                        paraType = "java.lang.String";
//                    利用反射根据方法名称和方法的参数类型获取类的方法
                        Method m = cc.getDeclaredMethod(methodName,Class.forName(paraType));
//                    对model对象执行该方法,将cell中的值赋给model的属性
                        m.invoke(model,row.getCell(j)!=null?row.getCell(j).getStringCellValue():"");
                    }else if (paraType.equals("float")) {
                        paraType = "java.lang.Float";
//                    利用反射根据方法名称和方法的参数类型获取类的方法
                        Method m = cc.getDeclaredMethod(methodName,Class.forName(paraType));
//                    对model对象执行该方法,将cell中的值赋给model的属性
                        m.invoke(model,(float)row.getCell(j).getNumericCellValue());
                    }else if (paraType.equals("int")) {
                        paraType = "java.lang.Integer";
//                    利用反射根据方法名称和方法的参数类型获取类的方法
                        Method m = cc.getDeclaredMethod(methodName,Class.forName(paraType));
//                    对model对象执行该方法,将cell中的值赋给model的属性
                        m.invoke(model,(int)row.getCell(j).getNumericCellValue());
                    }
////                    利用反射根据方法名称和方法的参数类型获取类的方法
////                   Method m = cc.getDeclaredMethod(methodName,Class.forName(paraType));
////                    System.out.println(row.getCell(j).getStringCellValue());
////                    对model对象执行该方法,将cell中的值赋给model的属性
////                    m.invoke(model,row.getCell(j).getStringCellValue());
                    j++;
                }
//                返回输入的Excel的数据所构造的对象集合
                list.add(model);
            }
        }
//        根据类名获得表名
        tableName = className.substring(0,1).toLowerCase()+className.substring(1);
//        根据类名获得相应的dao
        modelDao = ModelHandler.getModelDaoInstance(tableName);
//        向数据库中插入数据
        for (AbstractModel temp:list) {
            this.modelDao.insert(temp);
        }
//        返回插入的对象集合
        return list;
    }

    @RequestMapping(value="/sceneData", method = RequestMethod.POST)
    public List<AbstractModel> postSceneDataExcel () {
        return null;
    }

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

}
