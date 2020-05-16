package com.sxt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.sxt.pojo.GoodsView;

public class ViewUtil {
	//生成饼状图
	/**
	 * 饼状图
	 */
	public static void pieChar(HttpServletRequest request, HttpServletResponse response,List<GoodsView> goodsViews)
			throws ServletException, IOException {
			//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		    ChartFactory.setChartTheme(standardChartTheme); 
		    
			FileOutputStream fos_jpg = null;
		try { 
			DefaultPieDataset dataset2=new DefaultPieDataset();  
			//遍历集合
			for(GoodsView g:goodsViews){
				dataset2.setValue(g.getGoodsName(),g.getTotalNum());  
			}
	        JFreeChart chart2=ChartFactory.createPieChart3D  
	                ("按商品名称统计", dataset2, true, true,false);  
	        
	        //处理chart
	        PiePlot3D piePlot=(PiePlot3D)chart2.getPlot();  //获取绘画区对象  
	        piePlot.setLabelFont(new Font("宋体", 0, 12));  
	        piePlot.setCircular(true);   //设置饼图是圆的（true），还是椭圆的（false）；  
	        piePlot.setBaseSectionOutlinePaint(Color.WHITE);  
	        piePlot.setSectionOutlinesVisible(true);  
	        StandardPieSectionLabelGenerator standardPie=new StandardPieSectionLabelGenerator  
	                ("{0}:({1},{2})", NumberFormat.getNumberInstance(),NumberFormat.getPercentInstance());  
	        piePlot.setLabelGenerator(standardPie);  //相应的数据显示  
	        piePlot.setNoDataMessage("无数据显示");  
	        //设置透明度，0.5F为半透明，1为不透明，0为全透明     
	        piePlot.setForegroundAlpha(0.7F);   
	        piePlot.setLabelGap(0.02D);  
	        String managerFileName="";  
         
            managerFileName = ServletUtilities.saveChartAsPNG(chart2, 1000, 500, null,  
                    request.getSession());  
            String graphURL = request.getServletContext().getRealPath("upload")+"\\"+managerFileName;
            request.setAttribute("xPicName", managerFileName);
           
            fos_jpg = new FileOutputStream(graphURL);
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart2, 400, 300, null);
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
        	if(fos_jpg!=null)
        		fos_jpg.close();
        }

	}
	//生成柱状图
	public static void barChar(HttpServletRequest request, HttpServletResponse response,List<GoodsView> goodsViews)
			throws ServletException, IOException {
		// 1. 得到数据
		CategoryDataset dataset = getDataSet(goodsViews);
		// 2. 构造chart
		JFreeChart chart = ChartFactory.createBarChart3D(
				"按商品名称统计", // 图表标题
				"商品名称", // 目录轴的显示标签--横轴
				"数量", // 数值轴的显示标签--纵轴
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、
				true, // 是否显示图例(对于简单的柱状图必须
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		// 3. 处理chart中文显示问题
		processChart(chart);

		// 4. chart输出图片
		writeChartAsImage(chart,request);
	}
	/**
	 * 获取一个演示用的组合数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet(List<GoodsView> goodsViews) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(GoodsView goodsView:goodsViews){
			dataset.addValue(goodsView.getTotalNum(), goodsView.getGoodsName(),goodsView.getGoodsName());
		}
		return dataset;
	}

	/**
	 * 解决图表汉字显示问题
	 * 
	 * @param chart
	 */
	private static void processChart(JFreeChart chart) {
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		ValueAxis rAxis = plot.getRangeAxis();
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
		rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
		// renderer.setItemLabelGenerator(new LabelGenerator(0.0));
		// renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 12));
		// renderer.setItemLabelsVisible(true);
	}

	/**
	 * 输出图片
	 * 
	 * @param chart
	 */
	private static void writeChartAsImage(JFreeChart chart,HttpServletRequest request) {
		FileOutputStream fos_jpg = null;
		try {
			String xBarName="xBarName.jpg";
			String graphURL = request.getServletContext().getRealPath("upload")+"\\"+xBarName;
			request.setAttribute("xBarName", xBarName);
			fos_jpg = new FileOutputStream(graphURL);
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}
	}
}
