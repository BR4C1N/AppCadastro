package com.software.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.software.appdecadastro.R;
import com.software.appdecadastro.dataBase.DBHelper;
import com.software.appdecadastro.dataBase.FornecedorDB;
import com.software.appdecadastro.entities.Fornecedor;

public class CadastrarFornecedoresFragment extends Fragment {

    EditText textNomeFantasia;
    EditText textCNPJ;
    EditText textTelefone;
    EditText textEmail;

    Button botaoSalvar;
    Button botaoCancelar;

    FornecedorDB fornecedorDB;

    public CadastrarFornecedoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastrar_fornecedores, container, false);

        DBHelper db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);

        textNomeFantasia = view.findViewById(R.id.editTextNomeFantasia);
        textCNPJ = view.findViewById(R.id.editTextCNPJ);
        textTelefone = view.findViewById(R.id.editTextTelefoneFornecedor);
        textEmail = view.findViewById(R.id.editTextEmailFornecedor);
        botaoSalvar = view.findViewById(R.id.botaoSalvarFornecedor);
        botaoCancelar = view.findViewById(R.id.botaoCancelarFornecedor);

        acoesComponentes();

        return view;
    }

    private void limparCampos() {
        textNomeFantasia.setText("");
        textCNPJ.setText("");
        textTelefone.setText("");
        textEmail.setText("");
    }

    private void acoesComponentes() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textNomeFantasia.getText().toString().isEmpty() || textCNPJ.getText().toString().isEmpty() || textTelefone.getText().toString().isEmpty() || textEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Fornecedor Inválido!", Toast.LENGTH_LONG).show();
                } else {
                    Fornecedor fornecedor = new Fornecedor();

                    fornecedor.setNomeFantasia(textNomeFantasia.getText().toString());
                    fornecedor.setCNPJ(textCNPJ.getText().toString());
                    fornecedor.setTelefone(textTelefone.getText().toString());
                    fornecedor.setEmail(textEmail.getText().toString());

                    fornecedorDB.inserir(fornecedor);
                    ListagemFornecedoresFragment.listarDadosFornecedores();
                    limparCampos();
                    Toast.makeText(getActivity(), "Fornecedor Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
                Toast.makeText(getActivity(), "Operação Cancelada!", Toast.LENGTH_LONG);
                ListagemFornecedoresFragment.listarDadosFornecedores();
            }
        });
    }

}