package com.xmy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xmy.service.TestService;

/**
 * 文件控制器
 * 
 * @author Adminstrator
 *
 */
@Controller
public class FileController {

	@Autowired
	private TestService testService;

	/**
	 * 多文件上传
	 * 
	 * @param multipartHttpServletRequest
	 * @return
	 */
	@RequestMapping(path = { "upload" }, method = { RequestMethod.POST })
	@ResponseBody
	public Map<Object, Object> upload(MultipartHttpServletRequest multipartHttpServletRequest) {

		Map<Object, Object> map = new HashMap<>();
		// 获取input type=file 的name 集合
		Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
		while (fileNames.hasNext()) {
			// 获取input name
			String next = fileNames.next();
			// 获取对应input name 的文件集合
			List<MultipartFile> files = multipartHttpServletRequest.getFiles(next);
			Iterator<MultipartFile> iterator = files.iterator();
			// 成功保存文件的文件名集合
			List<String> list = new ArrayList<>();
			while (iterator.hasNext()) {
				// 获取单个文件
				MultipartFile file = iterator.next();
				if (!file.isEmpty()) {
					String saveFile = testService.test(file.getName());
					list.add(saveFile);
				}
				// 远程方法调用保存文件
				// String saveFile = fileService.saveFile(file);
				System.out.println("FileController.upload()");
			}
			map.put("list", list);
			return map;
		}
		map.put("000", 000);
		return map;
	}

	/**
	 * 获取首页接口
	 * 
	 * @return
	 */
	@RequestMapping(path = { "", "/", "index" }, method = { RequestMethod.GET })
	public String index() {
		return "index";
	}

}
