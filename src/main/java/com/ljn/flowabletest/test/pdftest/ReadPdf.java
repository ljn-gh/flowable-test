package com.ljn.flowabletest.test.pdftest;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;

/**
 * @author lijianan
 * @date 2021-07-30 9:25
 * @description
 */
public class ReadPdf {
    @Test
    public void  test (){
        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载PDF文件
        doc.loadFromFile("file/SpirePDF.pdf");

        //doc.saveToFile("file/ToHTML.html", FileFormat.HTML);
        //创建StringBuilder实例
        StringBuilder sb = new StringBuilder();

        PdfPageBase page;
        //遍历PDF页面，获取每个页面的文本并添加到StringBuilder对象
        for(int i= 0;i<doc.getPages().getCount();i++){
            page = doc.getPages().get(i);
            /*sb.append(page.extractText(true));*/
            Point2D position = page.findText("姓名").getFinds()[0].getPosition();
           /* Rectangle2D.Double();*/
            page.extractText();
        }
        FileWriter writer;
        try {
            //将StringBuilder对象中的文本写入到文本文件
            writer = new FileWriter("file/ExtractText.txt");
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.close();
    }
}
