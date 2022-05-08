package com.he.week10;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class NewListFragment extends Fragment {

    public interface OnNewsSelectedListener{void
    onNewsSelected(Bundle bundle);
}
    private OnNewsSelectedListener mOnNewsSelectedListener;

    public NewListFragment() {
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewsSelectedListener) {
            mOnNewsSelectedListener = (OnNewsSelectedListener) context;
        } else {
            throw new IllegalArgumentException("Activity must OnNewsSelected");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnNewsSelectedListener = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ret=inflater.inflate(R.layout.fragment_new_list,container,false);
        ListView listView=(ListView)ret.findViewById(R.id.news_list);
        listView.setOnItemClickListener(listener);
        if(listView!=null){
            ArrayList<String> data=new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                data.add("新闻标题"+((i<10)?"0"+i:i));
            }
            ArrayAdapter<String>mAdapter =new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);
            listView.setAdapter(mAdapter);
        }
        return ret;
    }

    private AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?>parent,View view,int position,long id){
            if(mOnNewsSelectedListener!=null){
                Bundle bundle=new Bundle();
                bundle.putInt("position",position);
                bundle.putLong("id",id);
                mOnNewsSelectedListener.onNewsSelected(bundle);
            }
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
