package cn.itcast.jk.controller.cargo.contract;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;

import java.util.*;

import cn.itcast.jk.service.*;


@Controller
public class ContractProductController extends BaseController {
	@Resource
	 ContractProductService contractProductService;
	@Resource
	 FactoryService  factoryService;
	 //转向新增页面
	 @RequestMapping("/cargo/contractproduct/tocreate.action")
	  public String tocreate(String contractId,Model model){                 //传递主表的id
		 model.addAttribute("contractId", contractId);
		 
		 //某个合同下的货物列表
		 Map paraMap = new HashMap();
		 paraMap.put("contractId", contractId);
		 List<ContractProduct> dataList = contractProductService.find(paraMap);
		 model.addAttribute("dataList", dataList);
		 
		 //准备生产厂家的列表
		 List<Factory> factoryList = factoryService.getFactoryList();
		 model.addAttribute("factoryList", factoryList);
		
		   return "/cargo/contract/jContractProductCreate.jsp";    //货物的新增页面
	  }
	  
	//新增
		@RequestMapping("/cargo/contractproduct/insert.action")
		public String insert(ContractProduct contractProduct, Model model){
			contractProductService.insert(contractProduct);
			model.addAttribute("contractId", contractProduct.getContractId());
			return "redirect:/cargo/contractproduct/tocreate.action";
		}
		
	 //转向修改页面
	 @RequestMapping("/cargo/contractproduct/toupdate.action")
		public String toupdate(String id,Model model){
		 ContractProduct obj = contractProductService.get(id);
			model.addAttribute("obj", obj);
			
			//准备生产厂家的列表
			 List<Factory> factoryList = factoryService.getFactoryList();
			 model.addAttribute("factoryList", factoryList);
			
			return "/cargo/contract/jContractProductUpdate.jsp";
		}
	//修改保存
			@RequestMapping("/cargo/contractproduct/update.action")
			public String update(ContractProduct contractProduct){
				contractProductService.update(contractProduct);
				return "redirect:/cargo/contractproduct/tocreate.action";
			}
			
		
			//删除多个
			@RequestMapping("/cargo/contractproduct/deleteById.action")
			public String deleteById(String id,String contractId,Model model){
				contractProductService.deleteById(id);
				model.addAttribute("contractId", contractId);
				return "redirect:/cargo/contractproduct/tocreate.action";
			}
			
			 //查看页面
			@RequestMapping("/cargo/contractproduct/toview.action")
			public String toview(String id,Model model){
				ContractProduct obj = contractProductService.get(id);
				model.addAttribute("obj", obj);
				return "/cargo/contract/jContractView.jsp";
				}
			
}
