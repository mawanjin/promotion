package cn.join.mh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.persist.dao.MhpromotionCategory;
import org.persist.dao.MhpromotionOnline;

import cn.join.mh.service.DiscountDetailSevice;
import cn.join.mh.service.DiscountDetailSeviceImpl;
import cn.join.mh.service.IndexService;
import cn.join.mh.service.IndexServiceImpl;
import cn.join.mh.vo.DetailResult;
import cn.join.mh.vo.Page;
import cn.join.mh.vo.Result;

/**
 * Servlet implementation class IndexServlet
 */
public class DiscountDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IndexService service = new IndexServiceImpl();
	DiscountDetailSevice dservice = new DiscountDetailSeviceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId = null;
		
		Page _page = new Page();
		_page.setCount(Long.parseLong(request.getParameter("count")));
		_page.setPageCount(Integer.parseInt(request.getParameter("pageCount")));
		_page.setPageNo(Integer.parseInt(request.getParameter("pageNo")));
		_page.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		boolean first = false;
		
		//取分类
		List<MhpromotionCategory> mc = service.findCategory();
		
		if(mc!=null&&mc.size()>0){
			int index = 0;
			if(request.getParameter("index")!=null)
				index = Integer.parseInt(request.getParameter("index"));
			DetailResult dr = new DetailResult();
			categoryId = request.getParameter("cid");
			
			
			if(request.getParameter("type")!=null&&request.getParameter("type").equals("hot")){
				//取hot数据
				dr.setNow(service.getPromotionById(request.getParameter("id")));
				Page<MhpromotionOnline> page = new Page<MhpromotionOnline>();
				
				//因为是hot点击的详情，所以取一条非hot数据即可。
				page.setPageSize(1);
				Result<MhpromotionOnline> rs =  service.findPromotionPagination(categoryId, page);
				
				dr.setNxt(rs.getPage().getList().get(0).getMhpromotion());
				dr.setCategoryId(categoryId);
				
				dr.setNxtIndex(0);
				
			}else if(index==0){
				dr = dservice.get(categoryId, index,false);
				dr.setPre(service.getHotByCategoryId(categoryId));
				first = true;
			}else{
				boolean f = false;
				if(index==_page.getCount()-1)f=true;
				dr = dservice.get(categoryId, index,f);
			}
			
			//根据index计算页码
			if(index<_page.getPageSize()){
				_page.setPageNo(1);
			}else
				_page.setPageNo((index%_page.getPageSize()==0)?index/_page.getPageSize()+1:index/_page.getPageSize()+1);
			
			
			
			dr.setPage(_page);	
				
			request.setAttribute("rs", dr);
		}
		request.setAttribute("isFirst", first);
		request.setAttribute("category", mc);
		request.setAttribute("cid", categoryId);
		request.getRequestDispatcher("WEB-INF/pages/detail.jsp").forward(request, response);
	}
	
}
