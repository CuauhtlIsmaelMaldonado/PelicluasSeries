package com.example.peliclasseries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button btnIngresar;
    EditText claveUsuLog,contraseña;
    ProgressBar progressBar;

    String claveUsuario="";
    String contraseñas="";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar=findViewById(R.id.btnIngresar);

        claveUsuLog=findViewById(R.id.claveUsuario);
        contraseña=findViewById(R.id.contraseña);
        progressBar=findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);

        Handler obHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg){
                super.handleMessage(msg);


                validaUsuario();


            }
        };


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                claveUsuario= claveUsuLog.getText().toString();
                contraseñas= contraseña.getText().toString();

                if(claveUsuLog.getText().toString().equals("") || contraseña.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"LLENA LOS CAMPOS", Toast.LENGTH_SHORT).show();

                }else{

                    progressBar.setVisibility(View.VISIBLE);

                    Runnable objRunnable = new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Thread.sleep(2500);

                            }catch (Exception ex){
                                ex.printStackTrace();
                            }

                            obHandler.sendEmptyMessage(0);
                        }
                    };
                    Thread objBgThread = new Thread(objRunnable);
                    objBgThread.start();

                }
            }
        });

    }
    public void validaUsuario(){

        progressBar.setVisibility(View.GONE);

        toastCorrecto();

        Intent intent = new Intent(this,Perfil_Usuario.class);

        // datos para el perfil //
        intent.putExtra("nombre",claveUsuario);

        startActivity(intent);

        overridePendingTransition(R.transition.in_left, R.transition.out_left);



    }
    public void toastCorrecto(){

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_ok,(ViewGroup) findViewById(R.id.custom_toast_ok));
        TextView txtMensaje = view.findViewById(R.id.mensajeOK);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.BOTTOM,0,200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}