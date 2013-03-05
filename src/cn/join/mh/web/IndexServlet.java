package cn.join.mh.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.persist.dao.Mhpromotion;
import org.persist.dao.MhpromotionCategory;
import org.persist.dao.MhpromotionOnline;

import cn.join.mh.service.IndexService;
import cn.join.mh.service.IndexServiceImpl;
import cn.join.mh.vo.DetailResult;
import cn.join.mh.vo.Page;
import cn.join.mh.vo.Result;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IndexService service = new IndexServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//取分类
		List<MhpromotionCategory> mc = service.findCategory();
		
		if(mc!=null&&mc.size()>0){
			//取第一个分类的数据
			Page<MhpromotionOnline> page = new Page<MhpromotionOnline>();
			Integer pageNO = 1;
			if(request.getParameter("pageNo")!=null){
				pageNO = Integer.parseInt(request.getParameter("pageNo"));
				if(pageNO!=null){
					page.setPageNo(pageNO);
				}	
			}
			
			categoryId=request.getParameter("cid");
			if(categoryId==null){
				categoryId = mc.get(0).getId();
			}
			//method=category
			if(request.getParameter("method")!=null){
					
				if(request.getParameter("method").equals("category")){
					categoryId = request.getParameter("id");
				}else if(request.getParameter("method").equals("detail")){
					categoryId = request.getParameter("cid");
					if(request.getParameter("type")!=null&&request.getParameter("type").equals("hot")){
						DetailResult dr = new DetailResult();
						//取hot数据
						dr.setNow(service.getPromotionById(request.getParameter("id")));
						
						//因为是hot点击的详情，所以取一条非hot数据即可。
						page.setPageSize(1);
						Result<MhpromotionOnline> rs =  service.findPromotionPagination(categoryId, page);
						dr.setNxt(rs.getPage().getList().get(0).getMhpromotion());
						dr.setNowIndex(0);
						dr.setNxtIndex(1);
						dr.setCategoryId(categoryId);
					}
					//通过第一级页码，算数第二级页码，然后读取数据。参数应该为before/id/after
					//分页方式得到数据，每页是3条数据
					//如果是hot那么得到该分类的第一个
					
					
				}
			}
			request.setAttribute("rs", service.findPromotionPagination(categoryId, page));
			
			//取该栏目的HOT
				request.setAttribute("hot", service.getHotByCategoryId(categoryId));
		}
		
		request.setAttribute("category", mc);
		request.setAttribute("cid", categoryId);
		request.getRequestDispatcher("WEB-INF/pages/discount.jsp").forward(request, response);
	}

}
