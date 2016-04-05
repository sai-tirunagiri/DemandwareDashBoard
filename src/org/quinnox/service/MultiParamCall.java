package org.quinnox.service;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.impl.ReportEngine;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.lowagie.text.pdf.codec.Base64.InputStream;

public class MultiParamCall {
public String getPathName() throws CoreException, UnsupportedEncodingException {
	String output = null;
 try {
  //String designFIle = "C:\\Users\\saiprasadt\\Desktop\\Projected(updated)\\Projected(updated)\\FileDashBoard\\WebContent\\report\\Folder.rptdesign";
	 String url = Thread.currentThread().getContextClassLoader().getResource("../WebContent/report/Folder.rptdesign").getFile();  
	 System.out.println("SOmething"+url);
	 String file = url.toString();  
		System.out.println("Response path"+file);
		
  //create engine config, start engine and platform
  EngineConfig config = new EngineConfig();
  Platform.startup();
  ReportEngine engine = new ReportEngine(config);
 
  //open the report design and create a new run task
  IReportRunnable reportDesign = engine.openReportDesign(file);
  IRunAndRenderTask runTask = engine.createRunAndRenderTask(reportDesign);
 
  //the multi-select values to use. This just needs to be Object[].
  String value = "/Demandware/Inbox/Test/";
  runTask.setParameterValue("RP_param", value);
 
  //set the render outputs
  HTMLRenderOption options = new HTMLRenderOption();	
  output = "./WebContent/out/out.html";
  options.setOutputFileName( output );
  options.setImageDirectory( "image" );
  options.setEmbeddable( false );
  runTask.setRenderOption(options);
  

  //run report, close the task, and destroy the engine.
  runTask.run();
  runTask.close();
  engine.destroy();
  
  if("./WebContent/out/out.html"!=null){
	  //return output;
  }
  
 }
 
 catch (EngineException e) {
  e.printStackTrace();
 } catch (BirtException e) {
  e.printStackTrace();
 }
return output;
}
}