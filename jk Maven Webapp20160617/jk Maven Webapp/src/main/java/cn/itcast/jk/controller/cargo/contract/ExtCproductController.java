package cn.itcast.jk.controller.cargo.contract;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;

import java.util.*;

import cn.itcast.jk.service.*;


@Controller
public class ExtCproductController extends BaseController {
	@Resource
	 ExtCproductService extCproductService;
	@Resource
	 FactoryService  factoryService;
	 //转向新增页面
	 @RequestMapping("/cargo/extcproduct/tocreate.action")
	  public String tocreate(String contractProductId,Model model){                 //传递主表的id
		 model.addAttribute("contractProductId", contractProductId);
		 
		 //某个合同下的货物列表
		 Map paraMap = new HashMap();
		 paraMap.put("contractProductId", contractProductId);
		 List<ExtCproduct> dataList = extCproductService.find(paraMap);
		 model.addAttribute("dataList", dataList);
		 
		 //准备生产厂家的列表
		 List<Factory> factoryList = factoryService.getFactoryList();
		 model.addAttribute("factoryList", factoryList);
		
		 //准备分类下拉列表
		 List<SysCode> ctypeList = extCproductService.getCtypeList();
		 model.addAttribute("ctypeList", ctypeList);
		   return "/cargo/contract/jExtCproductCreate.jsp";    //货物的新增页面
	  }
	  
	//新增
		@RequestMapping("/cargo/extcproduct/insert.action")
		public String insert(ExtCproduct extCproduct, Model model){
			extCproductService.insert(extCproduct);
			model.addAttribute("contractProductId", extCproduct.getContractProductId());
			return "redirect:/cargo/extcproduct/tocreate.action";
		}
	 //转向修改页面
	 @RequestMapping("/cargo/extcproduct/toupdate.action")
		public String toupdate(String id,Model model){
		 ExtCproduct obj = extCproductService.get(id);
			model.addAttribute("obj", obj);
			
			//准备生产厂家的列表
			 List<Factory> factoryList = factoryService.getFactoryList();
			 model.addAttribute("factoryList", factoryList);
			
		 //准备分类下拉列表
			 List<SysCode> ctypeList = extCproductService.getCtypeList();
			 model.addAttribute("ctypeList", ctypeList);
			 
			return "/cargo/contract/jExtCproductUpdate.jsp";
		}
	//修改保存
			@RequestMapping("/cargo/extcproduct/update.action")
			public String update(ExtCproduct extCproduct){
				extCproductService.update(extCproduct);
				return "redirect:/cargo/extcproduct/tocreate.action";
			}
			
		
			//删除
			@RequestMapping("/cargo/extcproduct/deleteById.action")
			public String deleteById(String id,String contractProductId,Model model){
				extCproductService.deleteById(id);
				model.addAttribute("contractProductId", contractProductId);
				return "redirect:/cargo/extcproduct/tocreate.action";
			}
			
			 //查看页面
			@RequestMapping("/cargo/extcproduct/toview.action")
			public String toview(String id,Model model){
				ExtCproduct obj = extCproductService.get(id);
				model.addAttribute("obj", obj);
				return "/cargo/contract/jContractView.jsp";
				}
			
}
