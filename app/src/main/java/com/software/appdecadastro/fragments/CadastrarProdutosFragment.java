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
import com.software.appdecadastro.dataBase.ProdutoDB;
import com.software.appdecadastro.entities.Produto;

public class CadastrarProdutosFragment extends Fragment {

    EditText nomeProduto;
    EditText marca;
    EditText quantidade;
    EditText dataValidade;
    EditText preco;

    Button botaoSalvar;
    Button botaoCancelar;

    ProdutoDB produtoDB;

    public CadastrarProdutosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastrar_produtos, container, false);

        DBHelper db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);

        nomeProduto = view.findViewById(R.id.editTextNomeProduto);
        marca = view.findViewById(R.id.editTextMarca);
        quantidade = view.findViewById(R.id.editTextQuantidade);
        dataValidade = view.findViewById(R.id.editTextDataValidade);
        preco = view.findViewById(R.id.editTextPreco);
        botaoSalvar = view.findViewById(R.id.botaoSalvarProduto);
        botaoCancelar = view.findViewById(R.id.botaoCancelarProduto);

        acoesComponentes();

        return view;
    }

    private void limparCampos() {
        nomeProduto.setText("");
        marca.setText("");
        quantidade.setText("");
        dataValidade.setText("");
        preco.setText("");
    }

    private void acoesComponentes() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomeProduto.getText().toString().isEmpty() || marca.getText().toString().isEmpty() || quantidade.getText().toString().isEmpty() || dataValidade.getText().toString().isEmpty() || preco.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Produto Inválido!", Toast.LENGTH_LONG).show();
                } else {
                    Produto produto = new Produto();

                    produto.setNome(nomeProduto.getText().toString());
                    produto.setMarca(marca.getText().toString());
                    produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
                    produto.setDataValidade(dataValidade.getText().toString());
                    produto.setPreco(Float.parseFloat(preco.getText().toString()));

                    produtoDB.inserir(produto);
                    ListagemProdutosFragment.listarDadosProdutos();
                    limparCampos();
                    Toast.makeText(getActivity(), "Produto Salvo com Sucesso!", Toast.LENGTH_LONG);
                }
            }
        });

        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparCampos();
                Toast.makeText(getActivity(), "Operação Cancelada!", Toast.LENGTH_LONG);
                ListagemProdutosFragment.listarDadosProdutos();
            }
        });
    }

}