package com.software.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        return view;
    }

    protected static void listarDadosProdutos() {
        produtoDB.listar(listaProdutos);
        adapter.notifyDataSetChanged();
    }

}