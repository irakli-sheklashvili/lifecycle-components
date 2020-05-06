package lifecycle.example.fragmentfromonclick

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*
import lifecycle.example.R
import lifecycle.example.dialog.Dialog
import lifecycle.example.fragmentfromxml.PresenterAttachedFromXml

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentAttachedOnClick : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        lifecycle.addObserver(PresenterAttachedOnClick())
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedOnClick onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        dialog.setOnClickListener {
            Dialog().show(fragmentManager!!, "DialogTag")
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
