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
import com.software.appdecadastro.dataBase.FornecedorDB;
import com.software.appdecadastro.entities.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class ListagemFornecedoresFragment extends Fragment {

    ListView listaDados;
    static List<Fornecedor> listaForneceres;
    static ArrayAdapter adapter;

    static FornecedorDB fornecedorDB;

    public ListagemFornecedoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listagem_fornecedores, container, false);

        listaDados = view.findViewById(R.id.listViewFornecedores);

        DBHelper db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);

        listaForneceres = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaForneceres);
        listaDados.setAdapter(adapter);

        listarDadosFornecedores();

        return view;
    }

    protected static void listarDadosFornecedores() {
        fornecedorDB.listar(listaForneceres);
        adapter.notifyDataSetChanged();
    }

}