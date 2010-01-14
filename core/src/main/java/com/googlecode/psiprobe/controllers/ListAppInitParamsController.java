/*
 * Licensed under the GPL License.  You may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF
 * MERCHANTIBILITY AND FITNESS FOR A PARTICULAR PURPOSE.
 */
package com.googlecode.psiprobe.controllers;

import org.apache.catalina.Context;
import com.googlecode.psiprobe.tools.ApplicationUtils;
import com.googlecode.psiprobe.tools.SecurityUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Retrieves a list of context initialization parameters for a web application.
 * <p/>
 * Author: Andy Shapoval
 */
public class ListAppInitParamsController  extends ContextHandlerController {
    protected ModelAndView handleContext(String contextName, Context context,
                                         HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView(getViewName(), "appInitParams", ApplicationUtils.getApplicationInitParams(context));
        if (SecurityUtils.hasAttributeValueRole(getServletContext())) {
            mv.addObject("allowedToViewValues", Boolean.TRUE);
        }

        return mv;
    }
}