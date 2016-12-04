package bresiu.com.crossfadetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bresiu on 04-12-2016
 */

public class FragmentOne extends Fragment {
	String[] myDataset = {
			"AbstractList",
			"AbstractSequentialList",
			"ArrayList",
			"AttributeList",
			"CopyOnWriteArrayList",
			"LinkedList",
			"RoleList",
			"RoleUnresolvedList",
			"Stack",
			"Vector",
			"AbstractList",
			"AbstractSequentialList",
			"ArrayList",
			"AttributeList",
			"CopyOnWriteArrayList",
			"LinkedList",
			"RoleList",
			"RoleUnresolvedList",
			"Stack",
			"Vector",
			"AbstractList",
			"AbstractSequentialList",
			"ArrayList",
			"AttributeList",
			"CopyOnWriteArrayList",
			"LinkedList",
			"RoleList",
			"RoleUnresolvedList",
			"Stack",
			"Vector"
	};

	public static FragmentOne getInstance() {
		return new FragmentOne();
	}

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_one, container, false);

		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		recyclerView.setHasFixedSize(true);

		// use a linear layout manager
		RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);

		// specify an adapter (see also next example)
		RecyclerView.Adapter adapter = new MyAdapter(myDataset);
		recyclerView.setAdapter(adapter);
		View clickableView = view.findViewById(R.id.clickableView);
		clickableView.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
				ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
				ft.replace(R.id.activity_main, FragmentTwo.getInstance(), "fragmentTwo");
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		return view;
	}
}
