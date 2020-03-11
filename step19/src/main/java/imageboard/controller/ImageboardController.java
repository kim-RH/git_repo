package imageboard.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import imageboard.bean.ImageboardDTO;

@Controller
public class ImageboardController {
	
	@RequestMapping(value = "/imageboard/imageboardWriteForm")
	public String imageboardWriteForm() {
		return "imageboardWriteForm";
	}
	
	// 파라미터 MultipartFile img는 <input type="file" name="img"> 태그의 name과 일치해야 한다.
	@RequestMapping(value = "/imageboard/imageboardWrite", method = RequestMethod.POST)
	public ModelAndView imageboardWrite(MultipartFile img, HttpServletRequest request) {
		String filePath = "D:/Android_KimRoHwa/Spring/workspace/step19/src/main/webapp/storage";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		// 파일 복사
		try {
			//getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String imageId = request.getParameter("imageId");
		String imageName = request.getParameter("imageName");
		int imagePrice = Integer.parseInt(request.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(request.getParameter("imageQty"));
		String imageContent = request.getParameter("imageContent");
		
		ImageboardDTO dto = new ImageboardDTO();
		dto.setImageId(imageId);
		dto.setImageName(imageName);
		dto.setImagePrice(imagePrice);
		dto.setImageQty(imageQty);
		dto.setImageContent(imageContent);
		dto.setImage1(fileName);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("imageboardWrite");
		modelAndView.addObject("dto", dto);
		return modelAndView;
	}
	
}
