package com.jcode.myamazingviewpager.Controllers.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcode.myamazingviewpager.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment extends Fragment {
	// 1 - Create keys for our Bundle
	private static final String KEY_POSITION = "position";
	private static final String KEY_COLOR = "color";

	private int mPosition;
	private int mColor;

	private OnFragmentInteractionListener mListener;

	public PageFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param position Parameter 1.
	 * @param color Parameter 2.
	 * @return A new instance of fragment PageFragment.
	 */
	// 2 - Method that will create a new instance of PageFragment, and add data to its bundle.
	public static PageFragment newInstance(int position, int color) {
		PageFragment fragment = new PageFragment();
		Bundle args = new Bundle();
		args.putInt(KEY_POSITION, position);
		args.putInt(KEY_COLOR, color);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mPosition = getArguments().getInt(KEY_POSITION);
			mColor = getArguments().getInt(KEY_COLOR);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// 3 - Get layout of PageFragment
		View result = inflater.inflate(R.layout.fragment_page, container, false);

		// 4 - Get widgets from layout and serialise it
		LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
		TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);

		// 5 - Get data from Bundle (created in method newInstance)
		mPosition = getArguments().getInt(KEY_POSITION, -1);
		mColor = getArguments().getInt(KEY_COLOR, -1);

		// 6 - Update widgets with it
		rootView.setBackgroundColor(mColor);
		textView.setText("Page number "+mPosition);

		Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+mPosition);

		return result;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
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
