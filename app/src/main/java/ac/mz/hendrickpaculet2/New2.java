package ac.mz.hendrickpaculet2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link New2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class New2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public New2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment New2.
     */
    // TODO: Rename and change types and number of parameters
    public static New2 newInstance(String param1, String param2) {
        New2 fragment = new New2();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new2, container, false);

        ListView listView = view.findViewById(R.id.list_view);

        List<String> dataList = loadListFromInternalStorage("lista_de_computadores");
        CustomAdapter adapter = new CustomAdapter(dataList, requireContext());
        listView.setAdapter(adapter);

        return view;
    }

    private List<String> loadListFromInternalStorage(String fileName) {
        List<String> dataList = new ArrayList<>();
        List<String> existingDataList = new ArrayList<>();

        try {
            FileInputStream fis = requireContext().openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = reader.readLine()) != null) {
                // Verificar se a linha contém um processador acima do Core i5
                if (line.contains("Core i") && line.contains("i5")) {
                    existingDataList.add(line); // Adicionar os novos dados à lista existente
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return existingDataList; // Retornar a lista completa (dados existentes + novos dados)
    }
}
