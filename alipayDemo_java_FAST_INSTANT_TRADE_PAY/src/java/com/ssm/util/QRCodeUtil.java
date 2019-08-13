package com.ssm.util;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码生成工具类
 * @author Administrator
 *
 */
public class QRCodeUtil {

	//图片存储磁盘路径
	private static String filePath="D:\\images";
	//生成的二维码图片名称
	private static String qrCodeName="alipay0001.jpg";
	
	/**
	 * 生成微信支付二维码图片
	 * @throws Exception 
	 */
	public static void getWeixinCode() throws Exception {
		//创建JSON操作对象
		JSONObject jb=new JSONObject();
		jb.put("authorName", "张三");//有这个属性会校验微信格式
		jb.put("name", "Tom");
		jb.put("age", 25);
		jb.put("phone", "15612345678");
		jb.put("message", "https://www.baidu.com");
		//生成json格式字符串
		String json=jb.toString();
		System.out.println(json);
		
		//设置矩阵宽 高
		int width=200;
		int height=200;
		//设置矩阵转码格式
		Map<EncodeHintType, Object> map=new HashMap<EncodeHintType, Object>();
		map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		//创建一个矩阵对象
		BitMatrix bit=new MultiFormatWriter().encode(json, BarcodeFormat.QR_CODE, width, height, map);
		//创建一个Path对象
		Path path=FileSystems.getDefault().getPath(filePath, qrCodeName);
		String suffix = qrCodeName.substring(qrCodeName.lastIndexOf(".") + 1);
		MatrixToImageWriter.writeToPath(bit, suffix, path);
		System.out.println("【成功生成】微信支付二维码图片");
	}

	/**
	 * 生成支付宝支付二维码图片
	 * @param qrCodeUrl
	 * @throws Exception
	 */
	public static void getAliCode(String qrCodeUrl) throws Exception {
		System.out.println(qrCodeUrl);
		// 设置矩阵宽 高
		int width = 200;
		int height = 200;
		// 设置矩阵转码格式
		Map<EncodeHintType, Object> map = new HashMap<EncodeHintType, Object>();
		map.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		// 创建一个矩阵对象
		BitMatrix bit = new MultiFormatWriter().encode(qrCodeUrl, BarcodeFormat.QR_CODE, width, height, map);
		// 创建一个Path对象
		Path path = FileSystems.getDefault().getPath(filePath, qrCodeName);
		String suffix = qrCodeName.substring(qrCodeName.lastIndexOf(".") + 1);
		MatrixToImageWriter.writeToPath(bit, suffix, path);
		System.out.println("【成功生成】支付宝付款二维码图片");
	}

}
