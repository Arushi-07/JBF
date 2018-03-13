package com.appiqo.jbf.views.fragments;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.appiqo.jbf.R;
import com.appiqo.jbf.helper.CustomTextView;
import com.appiqo.jbf.helper.LoginButtonFB;
import com.appiqo.jbf.views.activities.HomeHandler;
import com.appiqo.jbf.views.activities.LoginHandler;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.facebook.FacebookSdk.getApplicationContext;

public class SignIn extends Fragment {

    View view;
    TextView create;
    CustomTextView signIn;
    LoginButtonFB loginButton;
    CallbackManager callbackManager;

    RelativeLayout fbLoginLayout;

    public SignIn() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        AppEventsLogger.activateApp(getActivity());
        view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        init();


        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    getActivity().getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e) {
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Login Button Clicked", Toast.LENGTH_SHORT).show();

                facebookLogin(loginButton,callbackManager);


            }
        });
        fbLoginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Login Layout Clicked", Toast.LENGTH_SHORT).show();
                loginButton.performClick();
            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginHandler)getContext()).changeFragment("SignUp",new SignUp());
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeHandler.class));
            }
        });

        return view;
    }

    private void init() {
        create=(TextView)view.findViewById(R.id.acc);
        signIn=(CustomTextView)view.findViewById(R.id.signIn);
        loginButton = (LoginButtonFB) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile email");

        loginButton.setFragment(this);
        // Other app specific specialization

        callbackManager = CallbackManager.Factory.create();

        fbLoginLayout=(RelativeLayout)view.findViewById(R.id.fbLoginLayout);
    }


    public void facebookLogin(LoginButton login, CallbackManager callbackManager) {

        //  Toast.makeText(getContext(), "in facebook login", Toast.LENGTH_SHORT).show();
        login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {



            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(getContext(), "successful login", Toast.LENGTH_SHORT).show();
                if (AccessToken.getCurrentAccessToken() != null) {
                    GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            try {

                                Log.e("check", "response" + response.toString());
                                RequestData();

                                loginButton.setVisibility(View.INVISIBLE);




                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                       /* startActivity(new Intent(getActivity(), Home.class));*/

                                    }
                                },3000);




                               /* JSONObject json = response.getJSONObject();
                                if (json != null) {

                                    Toast.makeText(getContext(), "json not null", Toast.LENGTH_SHORT).show();



                                    editor.putString("email",json.getString("email"));
                                    editor.putString("dob",json.getString("birthday"));
                                   // editor.putString("profile_pic",json.getString("public_profile"));
                                    editor.apply();*/
                                    /*getActivity().startActivity(new Intent(getActivity(), Home.class));
                                    getActivity().finish();*/


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id name link");
                    request.setParameters(parameters);
                    request.executeAsync();
                }

            }

            @Override
            public void onCancel() {

                Toast.makeText(getContext(), "fb login cancelled", Toast.LENGTH_SHORT).show();
                ((LoginHandler)getContext()).changeFragment("SignIn",new SignIn());

            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getContext(), "Error in fb Login.Try Again", Toast.LENGTH_SHORT).show();
                ((LoginHandler)getContext()).changeFragment("SignIn",new SignIn());
            }
        });
    }

    private void RequestData()
    {
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object,GraphResponse response) {

                Log.e("check" ,"response = " + response);

                JSONObject json = response.getJSONObject();
                try {
                    if(json != null){
                        String text = "<b>Name :</b> "+json.getString("name")+"<br><br><b>Email :</b> "+json.getString("email")+"<br><br><b>Profile link :</b> "+json.getString("link");
                       /* save_value=text;
                        //detailsDialog.
                        profile.setProfileId(json.getString("id"));
                        info.setText("" + json.getString("name") + "\n"+ json.getString("email") + "\n");*/
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
