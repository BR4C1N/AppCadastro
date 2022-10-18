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
import com.software.appdecadastro.dataBase.ClienteDB;
import com.software.appdecadastro.dataBase.DBHelper;
import com.software.appdecadastro.entities.Cliente;

public class CadastrarClientesFragment extends Fragment {

    EditText textNome;
    EditText textCPF;
    EditText textTelefone;
    EditText textEmail;

    Button botaoSalvar;
    Button botaoCancelar;

    ClienteDB clienteDB;

    public CadastrarClientesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastrar_clientes, container, false);

        DBHelper db = new DBHelper(getActivity());
        clienteDB = new ClienteDB(db);

        textNome = view.findViewById(R.id.editTextNomeCliente);
        textCPF = view.findViewById(R.id.editTextCPF);
        textTelefone = view.findViewById(R.id.editTextTelefoneCliente);
        textEmail = view.findViewById(R.id.editTextEmailCliente);
        botaoSalvar = view.findViewById(R.id.botaoSalvarCliente);
        botaoCancelar = view.findViewById(R.id.botaoCancelarCliente);

        acoesComponentes();

        return view;
    }

    private void limparCampos() {
        textNome.setText("");
        textCPF.setText("");
        textTelefone.setText("");
        textEmail.setText("");
    }

    private void acoesComponentes() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textNome.getText().toString().isEmpty() || textCPF.getText().toString().isEmpty() || textTelefone.getText().toString().isEmpty() || textEmail.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Cliente inválido!", Toast.LENGTH_LONG).show();
                } else {
                    Cliente cliente = new Cliente();

                    cliente.setNome(textNome.getText().toString());
                    cliente.setCPF(textCPF.getText().toString());
                    cliente.setTelefone(textTelefone.getText().toString());
                    cliente.setEmail(textEmail.getText().toString());

                    clienteDB.inserir(cliente);
                    ListagemClientesFragment.listarDadosClientes();
                    limparCampos();
                    Toast.makeText(getActivity(), "Cliente Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
                Toast.makeText(getActivity(), "Operação Cancelada!", Toast.LENGTH_LONG).show();
                ListagemClientesFragment.listarDadosClientes();
            }
        });
    }

}