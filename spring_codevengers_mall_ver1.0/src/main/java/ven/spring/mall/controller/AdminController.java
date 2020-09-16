package ven.spring.mall.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;
import ven.spring.mall.model.CategoryVO;
import ven.spring.mall.model.MallItemVO;
import ven.spring.mall.model.MallOrderListVO;
import ven.spring.mall.model.MallOrderVO;
import ven.spring.mall.model.ItemViewVO;
import ven.spring.mall.service.AdminService;
import ven.spring.mall.util.UploadFileUtil;

@Controller
@RequestMapping("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	AdminService adminService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 관리자 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("get index");
	}

	// 상품추가
	@RequestMapping(value = "/item/add_item", method = RequestMethod.GET)
	public void getItemAdd(Model model) throws Exception {
		logger.info("get item add");

		List<CategoryVO> category = null;
		category = adminService.category();
		// 작동방법확인해볼것
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품추가
	@RequestMapping(value = "/item/add_item", method = RequestMethod.POST)
	public String postItemAdd(MallItemVO mallItemVO, MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "images";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

			mallItemVO.setItem_picture(File.separator + "images" + ymdPath + File.separator + fileName);
			mallItemVO.setItem_thumbImg(
					File.separator + "images" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {
			fileName = File.separator + "images" + File.separator + "none.jpg";
			mallItemVO.setItem_picture(fileName);
			mallItemVO.setItem_thumbImg(fileName);

		}

		adminService.addItem(mallItemVO);
		return "redirect:/admin/index";
	}

	// 상품목록
	@RequestMapping(value = "/item/list", method = RequestMethod.GET)
	public void getItemList(Model model) throws Exception {
		logger.info("get item list");
		List<ItemViewVO> list = adminService.itemList();
		model.addAttribute("list", list);
	}

	// 상품조회
	@RequestMapping(value = "/item/view", method = RequestMethod.GET)
	public void getItemView(@RequestParam("n") int item_num, Model model) throws Exception {
		logger.info("get item view");

		ItemViewVO mallItem = adminService.itemView(item_num);
		model.addAttribute("mallItem", mallItem);
	}

	// 상품수정
	@RequestMapping(value = "/item/modify", method = RequestMethod.GET)
	public void getItemModify(@RequestParam("n") int item_num, Model model) throws Exception {
		logger.info("get item view");

		ItemViewVO mallItem = adminService.itemView(item_num);
		model.addAttribute("mallItem", mallItem);

		List<CategoryVO> category = null;
		category = adminService.category();
		// 작동방법확인해볼것
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	// 상품수정
	@RequestMapping(value = "/item/modify", method = RequestMethod.POST)
	public String postItemModify(MallItemVO mallItemVO, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post item modify");

		// 새로운 파일이 등록되었는지 확인
		if (file.getOriginalFilename()!= null && !file.getOriginalFilename().equals("")) {
			// 기존 파일을 삭제
			new File(uploadPath + req.getParameter("item_picture")).delete();
			new File(uploadPath + req.getParameter("item_thumbImg")).delete();

			// 새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "images";
			String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
			String fileName = UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
					ymdPath);

			mallItemVO.setItem_picture(File.separator + "images" + ymdPath + File.separator + fileName);
			mallItemVO.setItem_thumbImg(
					File.separator + "images" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		} else { // 새로운 파일이 등록되지 않았다면
			// 기존 이미지를 그대로 사용
			mallItemVO.setItem_picture(req.getParameter("item_picture"));
			mallItemVO.setItem_thumbImg(req.getParameter("item_thumbImg"));

		}

		adminService.itemModify(mallItemVO);

		return "redirect:/admin/index";
	}

	// 상품삭제
	@RequestMapping(value = "/item/delete", method = RequestMethod.POST)
	public String postItemDelete(@RequestParam("n") int item_num) throws Exception {
		logger.info("post item delete");
		adminService.itemDelete(item_num);
		return "redirect:/admin/index";
	}

	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/item/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res,@RequestParam MultipartFile upload) throws Exception {
		logger.info("post CKEditor img upload");

		// 랜덤 문자 생성
		UUID uid = UUID.randomUUID();

		OutputStream out = null;
		PrintWriter printWriter = null;

		// 인코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		try {

			String fileName = upload.getOriginalFilename(); // 파일 이름 가져오기
			byte[] bytes = upload.getBytes();

			// 업로드 경로
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;

			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			out.flush(); // out에 저장된 데이터를 전송하고 초기화

			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			String fileUrl = "/ckUpload/" + uid + "_" + fileName; // 작성화면

			// 업로드시 메시지 출력
			printWriter.println("<script type='text/javascript'>" + "window.parent.CKEDITOR.tools.callFunction("
					+ callback + ",'" + fileUrl + "','이미지를 업로드하였습니다.')" + "</script>");

			printWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return;
	}
	
	
	//주문목록
	@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		logger.info("get order list");
		
		List<MallOrderVO> mallOrderVO = adminService.orderList();
		model.addAttribute("mallOrderVO", mallOrderVO);
	}
	
	//주문 상세목록
	
	public void getOrderList(@RequestParam("n") String cor_id, MallOrderVO mallOrderVO, Model model) throws Exception {
		logger.info("get order view");
		
		mallOrderVO.setCor_id(cor_id);
		List<MallOrderListVO> mallOrderListVO = adminService.orderView(mallOrderVO);
		model.addAttribute("mallOrderListVO", mallOrderListVO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
