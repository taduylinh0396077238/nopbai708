package org.aptech.t2109e.springdemo.controller;
        import org.aptech.t2109e.springdemo.dto.PageDto;
        import org.aptech.t2109e.springdemo.dto.EmployeeDto;
        import org.aptech.t2109e.springdemo.service.EmployeeService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController extends BaseController{

        @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/findProductByName")
    public ResponseEntity<?> findProductByName
            (@RequestParam String productName, HttpServletRequest request){
        long startTime = System.currentTimeMillis();
        EmployeeDto employeeDto = employeeService.findByName(productName);
        long endTime = System.currentTimeMillis();
        System.err.println("time process = " + (endTime - startTime));
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping(value = "/product-list")
    public ModelAndView getProductList(HttpServletRequest request,
                                       @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                       @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        EmployeeDto criteria = new EmployeeDto();
        if (pageNumber == null || pageNumber < 0) {
            criteria.setPageNumber(commonProperties.getPageNumber());
        } else {
            criteria.setPageNumber(pageNumber);
        }
        if (pageSize == null || pageSize <= 0) {
            criteria.setPageSize(commonProperties.getPageSize());
        } else {
            criteria.setPageSize(pageSize);
        }

        ModelAndView view = new ModelAndView("jsp/product-list");
        PageDto<EmployeeDto> productPage = employeeService.getAll(criteria);

        view.addObject("products", productPage.getContent());
        view.addObject("pages", productPage);

        return view;
    }


    @GetMapping("/employee")
    public ModelAndView get(@RequestParam(required = false) long id, HttpServletRequest request){
        ModelAndView view = new ModelAndView("jsp/details");
        EmployeeDto employeeDto = employeeService.getById(id);
        view.addObject("employee", employeeDto);
        return view;
    }
}
