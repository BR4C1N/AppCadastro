package com.software.appdecadastro.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.software.appdecadastro.R;

public class SecondActivity extends AppCompatActivity {

    Button botaoListagem;
    Button botaoCadastrar;
    Button botaoVoltar;

    Integer tipoOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tipoOperacao = getIntent().getIntExtra("operacao", -1);

        botaoListagem = findViewById(R.id.botaoListagem);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoVoltar = findViewById(R.id.botaoVoltar);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (tipoOperacao) {
            case -1: {
                onBackPressed();
                break;
            }

            case 0: {
                transaction.add(R.id.fragmentoPrincipal, );
                break;
            }

            case 1: {
                transaction.add(R.id.fragmentoPrincipal, );
                break;
            }

            case 2: {
                transaction.add(R.id.fragmentoPrincipal, );
                break;
            }
        }

        transaction.commit();

        acoesComponentes();
    }

    private void acoesComponentes() {
        botaoListagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (tipoOperacao) {
                    case 0: {
                        break;
                    }

                    case 1: {
                        break;
                    }

                    case 2: {
                        break;
                    }
                }
            }
        });

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (tipoOperacao) {
                    case 0: {
                        break;
                    }

                    case 1: {
                        break;
                    }

                    case 2: {
                        break;
                    }
                }
            }
        });

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}