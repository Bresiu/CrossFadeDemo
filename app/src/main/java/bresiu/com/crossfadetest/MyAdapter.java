package bresiu.com.crossfadetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Bresiu on 04-12-2016
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private String[] mDataset;

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(String[] myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
		return new ViewHolder(v);
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.mTextView.setText(mDataset[position]);
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override public int getItemCount() {
		return mDataset.length;
	}

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView mTextView;

		public ViewHolder(View v) {
			super(v);
			mTextView = (TextView) v.findViewById(R.id.info_text);
		}
	}
}

