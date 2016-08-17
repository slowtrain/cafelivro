package org.cafelivro.cmms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ibm.www.maximo.CreateMXWOResponseType;
import com.ibm.www.maximo.CreateMXWOType;
import com.ibm.www.maximo.MXDomainType;
import com.ibm.www.maximo.MXStringType;
import com.ibm.www.maximo.MXWO_WORKORDERType;
import com.ibm.www.maximo.WORKORDERKeyType;
import com.ibm.www.maximo.wsdl.MXWO.MXWO;
import com.ibm.www.maximo.wsdl.MXWO.MXWOLocator;
import com.ibm.www.maximo.wsdl.MXWO.MXWOPortTypeProxy;
import com.ibm.www.maximo.wsdl.MXWO.MXWOSOAP11BindingStub;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //MXWOSOAP11BindingStub stub = new MXWOSOAP11BindingStub(new URL("http://ayme:7001/meaweb/services/MXWO"),null);

                CreateMXWOType parameters=new CreateMXWOType();



                javax.json
                MXWO_WORKORDERType workorder =new MXWO_WORKORDERType();
                workorder.setWONUM(new MXStringType("CMMS001"));
                workorder.setSTATUS(new MXDomainType("APPR"));
                workorder.setSITEID(new MXStringType("BEDFORD"));
                MXWO_WORKORDERType [] types={workorder};
                parameters.setMXWOSet(types);

                //CreateMXWOResponseType retpar=stub.createMXWO(parameters);

                MXWOPortTypeProxy proxy=new MXWOPortTypeProxy();
                proxy.createMXWO(parameters);


//                WORKORDERKeyType[] wonum1=retpar.getWORKORDERMboKeySet();
//
//                System.out.println(wonum1.length);
//                for(int i=0;i<wonum1.length;i++){
//                    System.out.println(wonum1[i].getWONUM()+" - "+wonum1[i].getSITEID());
//                }



            }
        });

    }
}