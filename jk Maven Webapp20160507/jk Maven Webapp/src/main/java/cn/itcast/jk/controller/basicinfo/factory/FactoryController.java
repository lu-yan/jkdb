package cn.itcast.jk.controller.basicinfo.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;


@Controller
public class FactoryController extends BaseController {
	 @Resource
	 FactoryService factoryService;
	 
	 //列表
	 
	 @RequestMapping("/basicinfo/factory/List.action")
	 public String List(Model model){ 
	    List<Factory> dataList = factoryService.find(null);
	    model.addAttribute("dataList", dataList);   //将数据传递到页面
	    
	    return "basicinfo/factory/jFactoryList.jsp";//转向页面
		 }
	 }
