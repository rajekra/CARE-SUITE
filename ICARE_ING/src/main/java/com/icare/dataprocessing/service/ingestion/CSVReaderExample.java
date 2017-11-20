package com.icare.dataprocessing.service.ingestion;


import au.com.bytecode.opencsv.CSVReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;



import com.icare.dataprocessing.repository.impl.MasterDataRepositoryImpl;
import com.icare.dataprocessing.repository.intf.MasterDataRepositoryInf;

public class CSVReaderExample {

    public static void main(String[] args) throws ParseException, IOException {
    	System.out.println(getMemberAndDate());
    }
public static void tes() throws ParseException{
    	String[] members = {"502886879WA","501220072WA","501392415WA","502703310WA","502467082WA","501470246WA","501673983WA","500854602WA","503649270WA","501679321WA","503216258WA","503395375WA","500073535WA","503607867WA","501395626WA","500099926WA","500449152WA","503465089WA","502755624WA","501275246WA","501173310WA","501534782WA","500476322WA","503511056WA","501414567WA","500068942WA","501497422WA","500576583WA","503204006WA","501691122WA","500165272WA","500823858WA","502458081WA","500539104WA","501704594WA","501991191WA","502805531WA","500654422WA","501384732WA","500000573WA","500174244WA","502847226WA","500072452WA","503030823WA","500119901WA","502052602WA","503030577WA","500680456WA","501611775WA"};
    	String[] providers = {"1000000004","1000000005","1000000006","1000000007","1000000008","1000000009","1000000010"};
    	String[] memberDob = {"12/25/1961","4/27/1964","11/14/2000","8/27/1967","9/13/1999","10/24/1967","7/20/1971","2/24/1965","1/1/2000","5/26/1986","6/3/1983","2/3/1992","7/3/1987","3/19/1980","8/22/1980","11/27/1962","8/14/2000","2/2/1989","5/5/1980","8/22/1980","5/23/1980","7/3/1953","6/20/2006","10/1/1980","1/2/1980","10/8/1981","12/18/1959","9/25/2000","6/15/1956","5/3/1956","12/11/1957","12/31/1960","5/26/1986","3/27/1980","10/22/1965","11/18/1961","4/25/2000","11/15/1966","5/26/1986","2/25/1980","8/9/2005","8/15/2000","10/6/2000","1/12/1968","2/16/1966","1/30/1982","4/1/1980","12/15/1980","12/29/2000","4/23/1951"};
    	
    	Random random = new Random();
		int index;
		int index2;
		
		
        //String csvFile = "C:/Users/kandhasamyr/Downloads/Model_13_Datasource_2.CSV";
        String csvFile = "C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/MONGO_MASTER/COPD_UNSALTED.CSV";

        String header = "tcn,mbrIdentifier,blngNationalPrvdrIdntfr,admtDiagCd,patientBirthDate,admissionDate,dischargeDate,patientStatusLkpcd,de1,prncplDgnsCd,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24,patientGender,totalBilledAmount,drgCode,mdc";
        CSVReader reader = null;
        int count=0;
        try {
        	MasterDataRepositoryImpl repository = new MasterDataRepositoryImpl();
        	StringBuilder builder = new StringBuilder();
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            line = reader.readNext();
            File file = new File("C:\\Users\\kandhasamyr\\OneDrive - CNSI\\ICARE\\data\\MONGO_MASTER\\COPD_Final2.csv");
            BufferedWriter output = null;
            output = new BufferedWriter(new FileWriter(file));
            output.append(header+"\n");
            while ((line = reader.readNext()) != null) {
            	//if(count>44510)
            	{
            		index = random.nextInt(members.length);
                	index2 = random.nextInt(providers.length);
                	SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyyMMdd");
                	Date myDate = newDateFormat.parse(line[5]);
                	newDateFormat.applyPattern("MM/dd/yyyy");
                	String dischargeDate = newDateFormat.format(myDate);
                	int los = Integer.parseInt(line[2]);
                	Calendar  cal = Calendar.getInstance();
                	cal.setTime(myDate);
                	cal.add(Calendar.DATE, -los);
                	String admitDate = newDateFormat.format(cal.getTime());
                	String gender = line[58];
                	//System.out.println(gender);
                	if(gender.equals("1"))
                	{
                		gender = "M";
                	}
                	else{
                    	gender = "F";

                	}
                	String principleDiagCode = line[8];
                	String icd10principleDiagCode = repository.convertIcd9To10(principleDiagCode);
                	String drgCode = repository.getDrgForDiag(icd10principleDiagCode);
                	if(drgCode.equals(icd10principleDiagCode))
                	{
                		drgCode = "23";
                	}
                	String mdc = repository.getMdcId(drgCode);
                	String value = generateTcn()+ "," +members[index] + "," + providers[index2] + "," + line[3]+","+memberDob[index]+","+admitDate+","+dischargeDate+ "," + line[6]+"," + line[7]+"," + icd10principleDiagCode+"," + line[9]+"," + line[10]+"," + line[11]+"," + line[12]+"," + line[13]+"," + line[14]+"," + line[15]+"," + line[16]+"," + line[17]+"," + line[18]+"," + line[19]+"," + line[20]+"," + line[21]+"," + line[22]+"," + line[23]+"," + line[24]+"," + line[25]+"," + line[26]+"," + line[27]+"," + line[28]+"," + line[29]+"," + line[30]+"," + line[31]+"," + line[33]+"," + line[34]+"," + line[35]+"," + line[36]+"," + line[37]+"," + line[38]+"," + line[39]+"," + line[40]+"," + line[41]+"," + line[42]+"," + line[43]+"," + line[44]+"," + line[45]+"," + line[46]+"," + line[47]+"," + line[48]+"," + line[49]+"," + line[50]+"," + line[51]+"," + line[52]+"," + line[53]+"," + line[54]+"," + line[55]+"," + line[56]+","+gender+"," + line[59]+","+drgCode+","+mdc;
                	output.append(value+"\n");
                	output.flush();
                	System.out.println("=>"+count++);
            	}
            	//else
            	{
            		System.out.println(count++);
            	}
            }
            
            if ( output != null ) {
                output.close();
              }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
    public static String generateTcn()
	{
		return "1"+"1"+getJulianDay()+"0"+RandomStringUtils.random(5, false, true);
	}
	
	private static String getJulianDay()
	{
		return Year.now().format(DateTimeFormatter.ofPattern("uu")) +Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	}

	public static Map<Integer,String> getMemberAndDate() throws IOException
	{
		Map<Integer, String> data = new HashMap<Integer, String>();
        String csvFile = "C:/Users/kandhasamyr/OneDrive - CNSI/ICARE/data/MONGO_MASTER/COPD_PRDF_INP_X.CSV";
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        String[] line;
        line = reader.readNext();
        Integer count= new Integer(0);
        while ((line = reader.readNext()) != null) {
        	data.put(count++, (line[0]+"_"+ line[1]));
        }
        return data;
	}
}