package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        // "/response/hello" -> 뷰의 논리 이름이 됨.
        return "/response/hello";
    }

    // 절대 권장하지 않는 방법 ^^
    // 컨트롤러의 경로 이름과 뷰의 논리 이름이 일치하면 아무것도 반환을 안해도 (void)
    // response/hello -> 이게 논리적 뷰 이름으로 요청이 되어버림
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
