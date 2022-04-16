package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan
@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "hello world!");
        return "basic/text-basic";
    }

    @GetMapping("/text-escape")
    public String textEscape(Model model) {
        model.addAttribute("data", "<br>Spring</br>");
        return "basic/text-escape";
    }

    @GetMapping("/text-unescape")
    public String textUnescape(Model model) {
        model.addAttribute("data", "<br>Spring</br>");
        return "basic/text-unescape";
    }

    @GetMapping("/variable-object")
    public String variableObject(Model model) {
        User userA = new User("userA", 20);
        User userB = new User("userB", 30);
        model.addAttribute("userA", userA);

        return "basic/variable-object";
    }

    @GetMapping("/variable-map")
    public String variableMap(Model model) {
        User userA = new User("userA", 20);
        User userB = new User("userB", 30);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("userA", userA);
        userMap.put("userB", userB);
        model.addAttribute("userMap", userMap);

        return "basic/variable-map";
    }

    @GetMapping("/variable-list")
    public String variableList(Model model) {
        User userA = new User("userA", 20);
        User userB = new User("userB", 30);

        List<User> userList = new ArrayList<>();
        userList.add(userA);
        userList.add(userB);
        model.addAttribute("userList", userList);

        return "basic/variable-list";
    }

    @GetMapping("/basic-objects")
    public String basicObjects(HttpSession httpSession) {
        httpSession.setAttribute("mySession", "hello session!");
        return "basic/basic-objects";
    }



    // 만약, 빈의 이름을 정해주지 않으면
    // 내부 클래스이므로 basicController.HelloBean으로 등록된다.
    // 따라서, helloBean으로 이름을 임의 지정해야 한다.
    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            System.out.println(this.getClass());
            return "Hello" + data;
        }
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    @GetMapping("/literals")
    public String literals(Model model) {
        model.addAttribute("data", "spring!");
        return "basic/literals";
    }

    @GetMapping("/operations")
    public String operations(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "spring!");
        return "basic/operations";
    }

    @GetMapping("/attributes")
    public String attributes() {
        return "basic/attributes";
    }

    @GetMapping("/each")
    public String each(Model model) {

        User userA = new User("userA", 10);
        User userB = new User("userB", 20);
        User userC = new User("userC", 30);
        User userD = new User("userD", 40);
        User userE = new User("userE", 50);
        User userF = new User("userF", 60);

        List<User> users = new ArrayList<>();

        users.add(userA);
        users.add(userB);
        users.add(userC);
        users.add(userD);
        users.add(userE);
        users.add(userF);

        model.addAttribute("users", users);
        return "basic/each";
    }

    @GetMapping("/conditions")
    public String conditions(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);
        User userC = new User("userC", 30);
        User userD = new User("userD", 40);
        User userE = new User("userE", 50);
        User userF = new User("userF", 60);

        List<User> users = new ArrayList<>();

        users.add(userA);
        users.add(userB);
        users.add(userC);
        users.add(userD);
        users.add(userE);
        users.add(userF);

        model.addAttribute("users", users);
        return "basic/conditions";
    }

    @GetMapping("comments")
    public String comments(Model model) {
        model.addAttribute("data", "hello spring!");
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);
        User userC = new User("userC", 30);
        User userD = new User("userD", 40);
        User userE = new User("userE", 50);
        User userF = new User("userF", 60);

        List<User> users = new ArrayList<>();

        users.add(userA);
        users.add(userB);
        users.add(userC);
        users.add(userD);
        users.add(userE);
        users.add(userF);

        model.addAttribute("users", users);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 20));
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);
        User userC = new User("userC", 30);
        User userD = new User("userD", 40);
        User userE = new User("userE", 50);
        User userF = new User("userF", 60);

        List<User> users = new ArrayList<>();

        users.add(userA);
        users.add(userB);
        users.add(userC);
        users.add(userD);
        users.add(userE);
        users.add(userF);
        model.addAttribute("users", users);

        return "basic/javascript";
    }

    @GetMapping("/fragment")
    public String fragment() {
        return "template/fragment/fragmentMain";
    }


    @Data
    static class User {
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }
}
