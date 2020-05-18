package com.develop.part.designpattern.simple;

import java.io.File;
import java.util.UUID;

import com.develop.part.designpattern.simple.entity.SimpleDrive;

public class FileSimpleDrive {
	public static void main(String[] args) throws Exception {
		//String path="D:/root";
		//traverse(path,null);
		//createMkdir(path,"root-3/root-3-1");
		//int count=1;
		//SimpleDrive simpleDrive = new SimpleDrive();
		
		String s="aaa/bbb";
		String s1="bbb";
		System.out.println(s1.split("/")[1]);
		System.out.println(s.split("/")[0]);
	}
	/**
	 * @throws Exception *
	 * @param @param path
	 * @param @param newMkdir    新文件夹的名称
	 * @return void    返回类型
	 * @throws
	 */
	public static void createMkdir(String path,String newMkdir) throws Exception {
		File newfile = new File(path+"/"+newMkdir);
		//如果文件目录不存在
		if(!newfile.exists()) {
			//如果文件目录创建成功
			if(newfile.mkdir()) {
				System.out.println(newfile.getAbsolutePath());
			}
		}else {
			System.out.println("文件目录已存在，不要重复创建");
			traverse(path,null);
		}
	}
	/**
	 * 文件目录遍历
	 * @param path
	 * @throws Exception
	 */
	public static void traverse(String path,String parent_id) throws Exception {
	    File file = new File(path);
	    //Map<String, Object> map = new HashMap<String, Object>();
	    if (file.exists()) {
	        File[] files = file.listFiles();
	        //判断文件目录是否为空
	        if (files.length == 0) {
	            return;
	        } else {
	            String k_id = UUID.randomUUID().toString();
	            for (File file2 : files) {
	            	//文件目录
	                if (file2.isDirectory()) {
	                    traverse(file2.getAbsolutePath(),parent_id);
	                    System.out.println(file2.getAbsolutePath());
	                    parent_id =  k_id;
	                }
	                //文件
	                else if (file2.isFile()){
	                	System.out.println(file2.getAbsolutePath());
	                }
	            }
	        }
	    } else {
	        System.out.println("文件不存在!");
	    }
	}
}
