package com.software.appdecadastro.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.software.appdecadastro.R;
import com.software.appdecadastro.dataBase.ClienteDB;
import com.software.appdecadastro.dataBase.DBHelper;
import com.software.appdecadastro.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListagemClientesFragment extends Fragment {

    ListView listaDados;
    static List<Cliente> listaClientes;
    static ArrayAdapter adapter;

    static ClienteDB clienteDB;

    public ListagemClientesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listagem_clientes, container, false);

        listaDados = (ListView) view.findViewById(R.id.listViewClientes);

        DBHelper db = new DBHelper(getActivity());
        clienteDB = new ClienteDB(db);

        listaClientes = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaClientes);
        listaDados.setAdapter(adapter);

        listarDadosClientes();

        return view;
    }

    protected static void listarDadosClientes() {
        clienteDB.listar(listaClientes);
        adapter.notifyDataSetChanged();
    }

}