package android.mittelstand.de.mpze.fragments;

import android.app.Fragment;
import android.mittelstand.de.mpze.R;
import android.mittelstand.de.mpze.adapters.UserAdapter;
import android.mittelstand.de.mpze.data.User;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) rootView.findViewById(R.id.list_users);
        generateDummyData();
        return rootView;
    }

    private void generateDummyData(){
        ArrayList<User> dummyData= new ArrayList<>();
        dummyData.add(new User("Eugen Metzler", "arbeitet an der Android App"));
        dummyData.add(new User("Nils Maschmann", "programmiert MPZE"));
        dummyData.add(new User("Erich Brozmann","arbeitet"));
        UserAdapter adapter = new UserAdapter(getActivity(), dummyData);
        listView.setAdapter(adapter);
    }
}
