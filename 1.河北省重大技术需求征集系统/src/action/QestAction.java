package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.QuestServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.BasisInformation;


@SuppressWarnings("serial")
public class QestAction extends ActionSupport implements ModelDriven<BasisInformation>
{
	
	private BasisInformation basis=new BasisInformation();
	
	private List<BasisInformation> list;
	
	public BasisInformation getModel()
	{
		// TODO Auto-generated method stub
		System.out.println("####");
		return basis;
	}
	//QuestService注入
	private QuestServiceImpl questService;
	public void setQuestService(QuestServiceImpl questService)
	{
		this.questService = questService;
	}
	public String execute()
	{
		List<BasisInformation> all = questService.findAll();
		System.out.println("BBBB");
    	if (!all.isEmpty()) {
    		ServletActionContext.getRequest().getSession().setAttribute("listB", all);
    	}
		return SUCCESS;
	}
	public String xssh()
	{
		List<BasisInformation> all = questService.findXSSH();
		System.out.println("CCCC");
    	if (!all.isEmpty()) {
    		ServletActionContext.getRequest().getSession().setAttribute("listC", all);
    	}
		return SUCCESS;
	}
	public String jssh()
	{
		List<BasisInformation> all = questService.findJSSH();
		System.out.println("DDDD");
    	if (!all.isEmpty()) {
    		ServletActionContext.getRequest().getSession().setAttribute("list", all);
    	}
		return SUCCESS;
	}
	public String xs()
	{
		BasisInformation b=questService.find(basis);
		try
    	{
    		b.setState("2");
    		questService.saveOrUpdate(b);
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tip","审核完成!");
    		return "success";
    	}
    	catch (Exception e)
    	{
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tip","失败!");
    		return "input";
    	}
	}
	public String js()
	{
		BasisInformation b=questService.find(basis);
		try
    	{
    		b.setState("4");
    		questService.saveOrUpdate(b);
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tip","审核完成!");
    		return "success";
    	}
    	catch (Exception e)
    	{
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tip","失败!");
    		return "input";
    	}
	}
	public String add()
    {
    	System.out.println(basis.getNo());
    	try
    	{
    		questService.add(basis);
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tipS","提交成功!");
    		return "success";
    	}
    	catch (Exception e)
    	{
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tipS","失败!");
    		return "input";
    	}
   
    }
	public String execute1()
	{
		List<BasisInformation> all = questService.findByNo(basis.getNo());
    	if (!all.isEmpty()) {
    		ServletActionContext.getRequest().getSession().setAttribute("listD", all);
    	}
		return SUCCESS;
	}
	public String zhcx()
	{
		return SUCCESS;
	}
	public String search()
	{
		list=questService.findBySearch(basis);
		return SUCCESS;
	}
	public List<BasisInformation> getList()
	{
		return list;
	}
	public void setList(List<BasisInformation> list)
	{
		this.list = list;
	}

}
