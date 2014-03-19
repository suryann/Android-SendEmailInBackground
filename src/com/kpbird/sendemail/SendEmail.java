package com.kpbird.sendemail;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class SendEmail extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	
    	Mail m = new Mail("<USER EMAIL>", "<PASSWORD>"); 
        String[] toArr = {"<EMAIL-1>", "<EMAIL-2>"}; 
        m.setTo(toArr); 
        m.setFrom("<EMAIL>"); 
        m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device."); 
        m.setBody("Email body"); 
        try { 
          m.addAttachment("/sdcard/bday.jpg"); 
          if(m.send()) { 
            Toast.makeText(this, "Email was sent successfully.", Toast.LENGTH_LONG).show(); 
          } else { 
            Toast.makeText(this, "Email was not sent.", Toast.LENGTH_LONG).show(); 
          } 
        } catch(Exception e) { 
          Log.e("MailApp", "Could not send email", e); 
        } 
    }
}