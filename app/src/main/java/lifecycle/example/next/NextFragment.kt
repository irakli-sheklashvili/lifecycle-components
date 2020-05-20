package lifecycle.example.next

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_next.*
import lifecycle.example.R
import lifecycle.example.dialog.DialogFragment

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NextFragment : DaggerFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        lifecycle.addObserver(NextPresenter())
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onCreateView")
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        dialog.setOnClickListener {
            DialogFragment().show(fragmentManager!!, "DialogTag")
        }
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onDetach")
    }
}
