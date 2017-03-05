package project.derivatives.controller;

//import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import project.derivatives.calculationEngine.Calculator;
import project.derivatives.calculationEngine.DayCountConv;
import project.derivatives.calculationEngine.FuturesCalculator;
import project.derivatives.calculationEngine.OptionsCalculator;
import project.derivatives.calculationEngine.PricingModel;

@Controller
@SessionAttributes("username") //not yet sure if this will work
public class PricingController {
		
	
	@RequestMapping(value="/pricesummary")
	public ModelAndView test7(HttpServletRequest request, HttpServletResponse response) throws IOException{
	/*	if(request.getParameter("contractType").equals(ContractType.Options)){
			if(request.getParameter("priceData")!=null){
				ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
				try {
					FileItem file =(FileItem) upload.parseRequest(request);
					if (file.getContentType().endsWith("txt")){
						file.write(new File("/git_portfolio/src/main/webapp/resources/"+file.getName()));
						System.out.println("Successful");
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
			
			return new ModelAndView("pricesummary");
	}*/		double intrate=0;
			double maturity=0;
			String dayConv =null;
			double spot=0;
			double fPrice=0;
			String Price=null;
			ModelAndView model=null;
			double income=0;
			double daystip=0;
			double incR=0;
			double yied=0;
			double stockPrice=0;
			double strikePrice=0;
			double manualVol=0;
			double marketPrice=0;
			String opType=null;
			ArrayList<Double>greeks = new ArrayList<Double>();
		if(request.getParameter("contractType").length()!=4){
				if(request.getParameter("dayConv").length()!=4){
					if (request.getParameter("contractType").equals("Futures")){
						if(request.getParameter("incomeDetail").equals("yes")){
							try{
								intrate=Double.parseDouble(request.getParameter("rate"));
								maturity = Double.parseDouble(request.getParameter("daysToExp"));
								dayConv = request.getParameter("dayConv");
								spot= Double.parseDouble(request.getParameter("spotPrice"));
								income=Double.parseDouble(request.getParameter("inc"));
								daystip=Double.parseDouble(request.getParameter("daysToIncPay"));
								incR=Double.parseDouble(request.getParameter("intRateInc"));
								if(!dayConv.equals("none")){
									Calculator calc= new FuturesCalculator(intrate,maturity,DayCountConv.valueOf(dayConv),spot,true,false,income, incR, daystip);
									fPrice=calc.calcFutures();
									DecimalFormat format = new DecimalFormat("0.00");
									Price=format.format(fPrice);
									model = new ModelAndView("pricesummary");
									model.addObject("pricey", Price); }
							}catch(Exception e){System.out.println(e.toString());}
						}
						else if(request.getParameter("yieldDetail").equals("yes")){
							try{
								intrate=Double.parseDouble(request.getParameter("rate"));
								maturity = Double.parseDouble(request.getParameter("daysToExp"));
								dayConv = request.getParameter("dayConv");
								spot= Double.parseDouble(request.getParameter("spotPrice"));
								yied=Double.parseDouble(request.getParameter("yld"));
								if(!dayConv.equals("none")){
									Calculator calc= new FuturesCalculator(intrate,maturity,DayCountConv.valueOf(dayConv),spot,false,true, yied);
									fPrice=calc.calcFutures();
									DecimalFormat format = new DecimalFormat("0.00");
									Price=format.format(fPrice);
									model = new ModelAndView("pricesummary");
									model.addObject("pricey", "The Future Price of Contract is "+ Price); 
									
								}
							}catch(Exception e){e.printStackTrace();}
						}
						
						
						else{
							try{
							intrate=Double.parseDouble(request.getParameter("rate"));
							maturity = Double.parseDouble(request.getParameter("daysToExp"));
							dayConv = request.getParameter("dayConv");
							spot= Double.parseDouble(request.getParameter("spotPrice"));
							
							if(!dayConv.equals("none")){
								Calculator calc= new FuturesCalculator(intrate,maturity,DayCountConv.valueOf(dayConv),spot,false,false);
								fPrice=calc.calcFutures();
								DecimalFormat format = new DecimalFormat("0.00");
								Price=format.format(fPrice);
								model = new ModelAndView("pricesummary");
								model.addObject("pricey", Price); 
								
							}
							
							//continue from here
							}catch(Exception e){
								
							}
						}
							}
					else if (request.getParameter("contractType").equals("Options")){
						if(!request.getParameter("optionType").equals("none")){
							try{
								intrate=Double.parseDouble(request.getParameter("rate"));
								maturity = Double.parseDouble(request.getParameter("daysToExp"));
								dayConv = request.getParameter("dayConv");
								stockPrice=Double.parseDouble(request.getParameter("stockPrice"));
								strikePrice=Double.parseDouble(request.getParameter("strikePrice"));
								manualVol=Double.parseDouble(request.getParameter("manualVol"));
							
								opType=request.getParameter("optionType");
								
						if(!(request.getParameter("priceModel").equals("none"))){
							switch(request.getParameter("vol")){
							case "manual":
								manualVol=Double.parseDouble(request.getParameter("manualVol"));
								Calculator calc2= new OptionsCalculator(intrate,maturity, DayCountConv.valueOf(dayConv),
													PricingModel.valueOf(request.getParameter("priceModel")), stockPrice, 
													strikePrice,manualVol,false); 
								DecimalFormat format = new DecimalFormat("0.000");
								greeks=calc2.calcOptions();
								
								model = new ModelAndView("pricesummary");
								model.addObject("calle",format.format(greeks.get(0))); 
								model.addObject("pute", format.format(greeks.get(1)));
								model.addObject("deltac",format.format(greeks.get(2))); 
								model.addObject("deltap", format.format(greeks.get(3)));
								model.addObject("gamma", format.format(greeks.get(4))); 
								model.addObject("vega", format.format(greeks.get(5))); 
								model.addObject("thetac",format.format(greeks.get(6))); 
								model.addObject("thetap",format.format(greeks.get(7))); 
								model.addObject("rhoc", format.format(greeks.get(8)));
								model.addObject("rhop", format.format(greeks.get(9))); 
								
								break;
							case "historical":
								break;
							case "implied":
								break;
							default:
								
							}
						}else{}
					}catch(Exception e){}
					}else{}
							
					
				
			}
			
			
		}
			
	
		
		
		
	}
		return model;
}
}
