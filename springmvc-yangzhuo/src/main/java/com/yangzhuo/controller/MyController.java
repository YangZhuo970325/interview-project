package com.yangzhuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    /**
     * DispatcherServlet:前端控制器
     * 用户请求到前端控制器，他就相当于mvc模式中的c，dispatcherServlet是整个流程控制的中心，由他调用其他组件处理用户请求
     * dispatcherServlet的存在降低了组件之间的耦合性
     *
     * 面试题1：SpringMVC的三大组件：HandlerMapping/HandlerAdapt/ViewResolver
     * 1. HandlerMapping:处理器映射器
     * 负责根据用户请求找到handler即处理器，SpringMVC提供了不同的映射器实现不同的映射方式，例如：配置文件方式，实现接口方式，注解方式等
     * 2. HandlerAdapter:处理器适配器
     * 通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行
     * 3. View Resolver:视图解析器
     * 负责将结果生成View视图。首先根据逻辑视图名解析成物理视图名，即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户
     *
     *
     *
     */
    @RequestMapping(value = {"/first-controller", "/second-controller"}, method = RequestMethod.GET)
    public String firstController() {
        System.out.println("firstController");
        return "first";
    }
}
