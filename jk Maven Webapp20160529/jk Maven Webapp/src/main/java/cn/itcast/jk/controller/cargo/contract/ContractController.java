package cn.itcast.jk.controller.cargo.contract;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.*;
import cn.itcast.jk.service.*;

	@Controller
	public class ContractController  extends BaseController {
		 @Resource
		 ContractService contractService;
		 
		 //列表
		 
		 @RequestMapping("/cargo/contract/list.action")
		 public String list(Model model){ 
		    List<Contract> dataList = contractService.find(null);
		    model.addAttribute("dataList", dataList);   //将数据传递到页面 
		    return "/cargo/contract/jContractList.jsp";//转向页面
			 }
		 
		 //转向新增页面
		 @RequestMapping("/cargo/contract/tocreate.action")
		  public String tocreate(){
			   return "/cargo/contract/jContractCreate.jsp";
		  }
		  
		//新增保存
			@RequestMapping("/cargo/contract/insert.action")
			public String insert(Contract contract){
				contractService.insert(contract);
				return "redirect:/cargo/contract/list.action";
			}
		 //转向修改页面
		 @RequestMapping("/cargo/contract/toupdate.action")
			public String toupdate(String id,Model model){
			 Contract obj = contractService.get(id);
				model.addAttribute("obj", obj);
				return "/cargo/contract/jContractUpdate.jsp";
			}
		//修改保存
				@RequestMapping("/cargo/contract/update.action")
				public String update(Contract contract){
					contractService.update(contract);
					return "redirect:/cargo/contract/list.action";
				}
				
			
				//删除多个
				@RequestMapping("/cargo/contract/delete.action")
				public String delete(@RequestParam("id")String[] ids){
					contractService.delete(ids);
					return "redirect:/cargo/contract/list.action";
				}
				
				 //查看页面
				@RequestMapping("/cargo/contract/toview.action")
				public String toview(String id,Model model){
					Contract obj = contractService.get(id);
					model.addAttribute("obj", obj);
					return "/cargo/contract/jContractView.jsp";
					}
				
			
				@RequestMapping("/cargo/contract/submit.action")
				public String submit(String[] id){
					contractService.submit(id);
					return "redirect:/cargo/contract/list.action";
				}
				
				
				@RequestMapping("/cargo/contract/cancel.action")
				public String cancel(String[] id){
					contractService.cancel(id);
					return "redirect:/cargo/contract/list.action";
				}
		 }

	

