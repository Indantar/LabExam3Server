import org.json.*;
import sun.rmi.runtime.Log;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/loan-calculator")
public class LoanCalculator extends HttpServlet {
    /*public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inputString = request.getParameter("loanInputs");
        // Example input: { "amount": 100000, "rate": 5.5, "months": 360 };
        // Example String: String inputString = "{ \"amount\": 100000, \"rate\": 5.5, \"months\": 360 }";
        double loanAmount = 200000;
        double annualInterestRateInPercent = 5.5;
        long loanPeriodInMonths = 360;
        try {
            JSONObject inputValues = new JSONObject(inputString);
            loanAmount = inputValues.getDouble("amount");
            System.out.println("ONPOST");
            System.out.println("wertyuiytrewqertyuiytrewqerty"+loanAmount);
            annualInterestRateInPercent = inputValues.getDouble("rate");
            System.out.println(""+annualInterestRateInPercent);
            loanPeriodInMonths = inputValues.getLong("months");
            System.out.println(""+loanPeriodInMonths);
        } catch (Exception e) {  // NullPointerException and JSONException
            // Use default values assigned before the try block
        }
        PaymentInfo info = new PaymentInfo(loanAmount, annualInterestRateInPercent, loanPeriodInMonths);
        PrintWriter out = response.getWriter();
        out.println(new JSONObject(info));
    }*/
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String inputString = request.getParameter("Inputs");
        System.out.println("DOIN");
        int val1 = 0,val2 = 0,val3 = 0,val4 = 0,val5 = 0,Min = 100,Max = 0,Sum = 0;
        try {
            JSONObject inputValues = new JSONObject(inputString);
            val1 = Integer.parseInt(inputValues.getString("Vaalue 2"));
            val3 = Integer.parseInt(inputValues.getString("Value 3"));
            val4 = Integer.parseInt(inputValues.getString("Value 4"));
            val5 = Integer.parseInt(inputValues.getString("Value 5"));

        } catch (Exception e) {  // NullPointerException and JSONException
            // Use default values assigned before the try block
        }
        int[] values = {val1, val2, val3, val4, val5};
        Sum = val1+val2+val3+val4+val5;
        for(int x = 0;x <5;x++)
        {
            if(values[x] < Min)
                Min = values[x];
            if(values[x] > Max)
                Max = values[x];
        }
        //PaymentInfo info = new PaymentInfo(loanAmount, annualInterestRateInPercent, loanPeriodInMonths);
        HashMap output = new HashMap<>();
        output.put("Max",Max);
        output.put("Min",Min);
        output.put("Sum",Sum);
        PrintWriter out = response.getWriter();
        out.println(new JSONObject(output));
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
