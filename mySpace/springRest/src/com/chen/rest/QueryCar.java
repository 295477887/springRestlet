package com.chen.rest;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjie
 * @version 1.0
 * @since 2017-02-09
 */
public class QueryCar extends ServerResource
{

    /**
     * get请求
     * 通过HttpServletRequest获取请求参数
     * */
    @Get("xml|json")
    public Representation getQueryCar()
    {
        HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String id = httprequest.getParameter("id");
        String name = httprequest.getParameter("name");
        System.out.println("id1="+id);
        System.out.println("name2="+name);
        Representation representation = new StringRepresentation("hello get");
        return 	representation;

    }
    /**
     * post请求
     * 通过Representation来获取请求参数
     * */
    @Post
    public Representation postQueryCar(Representation entity)
    {
        HttpServletRequest httprequest = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        Form form = new Form(entity);
        String id = form.getValues("id");
        String name = form.getFirstValue("name");
        System.out.println("id2="+id);
        System.out.println("name2="+name);
        Representation representation = new StringRepresentation("hello post");
        return 	representation;
    }

}
