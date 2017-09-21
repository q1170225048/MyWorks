package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import service.UserServiceImpl;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entity.Info;
import entity.Qx;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<Info> {
    //模型驱动使用的对象
	private String result;
	private String code;
    public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}
	private Info user=new Info();
    public Info getModel(){
        return user;
        
        
    }
    // 注入UserService
    private UserServiceImpl userService ;
    /**
     * @param userService the userService to set  00
     */
    @Resource
    public void setUserServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
        System.out.println("****");
    }

    /**
     * 登陆
     */
    public String login(){
    	List<Info> all = userService.findAll();
    	System.out.println("LLL");
    	if (!all.isEmpty()) {
    		ServletActionContext.getRequest().getSession().setAttribute("listA", all);
    	}
        Info existUser=userService.login(user);
        if(existUser==null){
            //登陆失败
        	HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tipMessage","登陆失败：用户名或密码错误用户未激活！");
            return LOGIN;
        }else {
            //登陆成功
            //将用户的信息存入session中
        	System.out.println(existUser.getShenfen());
            Qx qx=userService.findBySF(existUser.getShenfen());
            ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
            
            ServletActionContext.getRequest().getSession().setAttribute("qx", qx);
            //页面跳转
            return "loginSuccess";
        }

    }
    public String checkUserName() {  
        String warnMsg = "";  
        Info a = userService.getByNo(this.user.getNo());  
        if (a == null)  
            warnMsg = "该用户可用";  
        else  
            warnMsg = "该用户已经存在";  
  
        result = warnMsg;//向jsp页面传递一个result值  
    
        return SUCCESS;  
    }  
    public String add()
    {
    	System.out.println(user.getNo());
    	try
    	{
    		userService.add(user);
    		return "success";
    	}
    	catch (Exception e)
    	{
    		return "input";
    	}
   
    }
    public String passChange()
    {
    	Info a = userService.getByNo(this.user.getNo());
    	try
    	{
    		a.setPwd(user.getPwd());
    		userService.saveOrUpdate(a);
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tipMessage","修改成功!");
    		return "success";
    	}
    	catch (Exception e)
    	{
    		HttpServletRequest request = ServletActionContext.getRequest(); 
        	request.setAttribute("tipMessage","修改失败!");
    		return "input";
    	}
    }

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	

}