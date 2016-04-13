package org.quinnox.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.impl.ReportEngine;
import org.eclipse.core.runtime.CoreException;
import org.quinnox.service.MultiParamCall;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String getFolderName;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String output = null;
		getFolderName = request.getParameter("mydropdown2");
		System.out.println(getFolderName);
		ServletContext servletContext = getServletContext();
		try {
			String absolutePathToIndexJSP = servletContext.getRealPath("/")
					+ "Folder.rptdesign";
			String outputFolder = servletContext.getRealPath("/") + "out";

			// create engine config, start engine and platform
			EngineConfig config = new EngineConfig();
			Platform.startup();
			ReportEngine engine = new ReportEngine(config);

			// open the report design and create a new run task
			IReportRunnable reportDesign = engine
					.openReportDesign(absolutePathToIndexJSP);
			IRunAndRenderTask runTask = engine
					.createRunAndRenderTask(reportDesign);

			// the multi-select values to use. This just needs to be Object[].
			String value = getFolderName;
			runTask.setParameterValue("RP_param", value);

			// set the render outputs
			HTMLRenderOption options = new HTMLRenderOption();
			output = outputFolder + "/out.html";

			options.setOutputFileName(output);
			options.setImageDirectory("image");
			options.setEmbeddable(false);
			runTask.setRenderOption(options);

			// run report, close the task, and destroy the engine.
			runTask.run();
			runTask.close();
			engine.destroy();

			if ("./WebContent/out/out.html" != null) {
				response.sendRedirect("ResultWithGraph.jsp");
			}
		}
		catch (EngineException e) {
			e.printStackTrace();
		} catch (BirtException e) {
			e.printStackTrace();
		}
	}

}
