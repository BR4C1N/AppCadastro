package com.software.appdecadastro.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.software.appdecadastro.R;
import com.software.appdecadastro.dataBase.DBHelper;
import com.software.appdecadastro.dataBase.ProdutoDB;
import com.software.appdecadastro.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListagemProdutosFragment extends Fragment {

    ListView listaDados;
    static List<Produto> listaProdutos;
    static ArrayAdapter adapter;

    static ProdutoDB produtoDB;

    public ListagemProdutosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listagem_produtos, container, false);

        listaDados = view.findViewById(R.id.listViewProdutos);

        DBHelper db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);

        listaProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutos);
        listaDados.setAdapter(adapter);

        listarDadosProdutos();
        acoesComponentes();

        return view;
    }

    private void acoesComponentes() {
        listaDados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Deseja realmente remover?")
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int j) {
                                produtoDB.remover(listaProdutos.get(i).getId());

                                listarDadosProdutos();
                                Toast.makeText(getActivity(), "Removido com Sucesso!", Toast.LENGTH_LONG);
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .create().show();

                return (false);
            }
        });
    }

    protected static void listarDadosProdutos() {
        produtoDB.listar(listaProdutos);
        adapter.notifyDataSetChanged();
    }

}