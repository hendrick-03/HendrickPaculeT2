package ac.mz.hendrickpaculet2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New1.
     */
    // TODO: Rename and change types and number of parameters
    public static New1 newInstance(String param1, String param2) {
        New1 fragment = new New1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new1, container, false);

        EditText id = view.findViewById(R.id.id);
        EditText marca = view.findViewById(R.id.marca_ed);
        EditText modelo = view.findViewById(R.id.modelo_ed);
        EditText numserie = view.findViewById(R.id.numero_de_serie_ed);
        EditText process = view.findViewById(R.id.processador_ed);
        EditText memoria = view.findViewById(R.id.memoria_ed);
        EditText ram = view.findViewById(R.id.ram_ed);
        EditText disc = view.findViewById(R.id.HDD_ed);

        Button gravar = view.findViewById(R.id.salvar_btn);
        Button listar = view.findViewById(R.id.listar);



        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        New2 new2 = new New2();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.new2, new2);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                });


            }
        });

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém o contexto da atividade ou fragmento
                Context context = view.getContext();

// Obtém os dados dos campos de texto
                String idText = id.getText().toString();
                String marcaText = marca.getText().toString();
                String modeloText = modelo.getText().toString();
                String numserieText = numserie.getText().toString();
                String processText = process.getText().toString();
                String memoriaText = memoria.getText().toString();
                String ramText = ram.getText().toString();
                String discText = disc.getText().toString();

// Cria uma string com os dados v
                String dadosComputador = "ID: " + idText +
                        "\nMarca: " + marcaText +
                        "\nModelo: " + modeloText +
                        "\nNúmero de Série: " + numserieText +
                        "\nProcessador: " + processText +
                        "\nMemória: " + memoriaText +
                        "\nRAM: " + ramText +
                        "\nDisco: " + discText +
                        "\n\n";

// Grava os dados no arquivo
                try {
                    FileOutputStream fos = context.openFileOutput("lista_de_computadores", Context.MODE_APPEND);
                    fos.write(dadosComputador.getBytes());
                    fos.close();
                    Toast.makeText(context, "Dados gravados com sucesso!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Erro ao gravar os dados.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;

    }
}