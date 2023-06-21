package com.example.kitsuapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cadastro extends AppCompatActivity {

    private DbKitsu mydb;

    TextView nome;
    TextView email;
    TextView senha;
    TextView confirmar;
    Button btn;
    Cad cad;
    TextView texto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        nome = findViewById(R.id.txtnome);
        email = findViewById(R.id.txtemail);
        senha = findViewById(R.id.txtsenha);
        confirmar = findViewById(R.id.txtconfirmar);
        btn = findViewById(R.id.btnlogin);
        texto = findViewById(R.id.welcome_txt);

        mydb = new DbKitsu(this);

        // cad = (Cad) getIntent().getSerializableExtra(MainActivity.EXTRA_VALUE);
    }

    public void cadastrar(View view)
    {
        String nomes = nome.getText().toString();
        String emails = email.getText().toString();
        String senhas = senha.getText().toString();

        cad = new Cad(nomes, emails, senhas);

        System.out.println(cad);

        if (mydb.insertUsuario(cad)) {
            String message = ("Cadastro Realizado");
            texto.setText(message);
        } else {
            texto.setText("Cadastro Falhou");
        }
    }

    public void TelaPrincipal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


//        String nometexto = nome.getText().toString();
//
//        if(nometexto != null){
//            if (senha.getText().toString() == confirmar.getText().toString()) {
//
//                cad.set_nome(nome.getText().toString());
//                cad.set_email(email.getText().toString());
//                cad.set_senha(senha.getText().toString());
//
//                if (mydb.insertUsuario(cad))
//                {
//                    texto.setText("Foi Cadastrado!!");
//                }
//                else
//                {
//                    texto.setText("Não Cadastrado!!");
//                }
//            }
//            else
//            {
//                texto.setText("Else Chamado");
//            }
//        }
//        else
//        {
//            texto.setText("KKKKK!!");
//        }