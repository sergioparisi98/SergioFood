package sergiofood.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    LayoutInflater mInflater;
    LinkedList<String> mWordList;

    public WordListAdapter(Context context,
                           LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create view from layout
        View mItemView = mInflater.inflate(
                R.layout.list_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        // Retrieve the data for that position
        String mCurrent = mWordList.get(position);
        // Add the data to the view
        holder.wordItemView.setText(mCurrent);
    }


    @Override
    public int getItemCount() {
        // Return the number of data items to display
        return mWordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView wordItemView;
        WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            // Get the layout
            wordItemView = itemView.findViewById(R.id.word);
            // Associate with this adapter
            this.mAdapter = adapter;
            // Add click listener, if desired
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO onclick
        }
    }
}
