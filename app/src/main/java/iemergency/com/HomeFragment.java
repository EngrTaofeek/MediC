package iemergency.com;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    
    private static final int REQUEST_CALL = 1;
    private TextView textview;
    private TextView textview1;
    private TextView textview2;
    private Button news_button;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //WebView webview = findViewById(R.id.webView);
        //View v=inflater.inflate(R.layout.fragment_home, container, false);




        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        textview = view.findViewById(R.id.edit_text);
        textview1 = view.findViewById(R.id.edit_text1);
        textview2= view.findViewById(R.id.edit_text2);
        ImageView imageView = view.findViewById(R.id.imagecall);
        ImageView imageView1 = view.findViewById(R.id.imagecal2);
        ImageView imageView2 = view.findViewById(R.id.imagecal3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCal2();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCal3();
            }
        });




        return view;
    }


    private void makePhoneCall() {
        String number = textview.getText().toString();
        if (number.trim().length()> 0){
            if (ContextCompat.checkSelfPermission(getContext(), 
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                
            }else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
            
        } else{
            Toast.makeText(getContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    private void makePhoneCal2() {
        String number1 = textview1.getText().toString();
        if (number1.trim().length()> 0) {
            if (ContextCompat.checkSelfPermission(getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number1;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else{
            Toast.makeText(getContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    private void makePhoneCal3() {
        String number2 = textview2.getText().toString();
        if (number2.trim().length()> 0) {
            if (ContextCompat.checkSelfPermission(getContext(),
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);

            } else {
                String dial = "tel:" + number2;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else{
            Toast.makeText(getContext(), "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else {
                Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
